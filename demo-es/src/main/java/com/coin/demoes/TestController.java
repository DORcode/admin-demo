package com.coin.demoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName Controller
 * @Description: TODO
 * @Author kh
 * @Date 2020-09-18 14:13
 * @Version V1.0
 **/
@Controller
public class TestController {
    @Autowired
    EsService esService;

    @RequestMapping("test")
    @ResponseBody
    public long test() {
        String property = "{\n" +
                "      \"properties\": {\n" +
                "        \"content\": {\n" +
                "          \"type\": \"text\",\n" +
                "          \"fields\": {\n" +
                "            \"ik_max_analyzer\": {\n" +
                "              \"type\": \"text\",\n" +
                "              \"analyzer\": \"ik_max_word\"\n" +
                "            },\n" +
                "            \"ik_smart_analyzer\": {\n" +
                "              \"type\": \"text\",\n" +
                "              \"analyzer\": \"ik_smart\"\n" +
                "            }\n" +
                "          }\n" +
                "        },\n" +
                "        \"create_time\": {\n" +
                "          \"type\": \"date\"\n" +
                "        },\n" +
                "        \"id\": {\n" +
                "          \"type\": \"integer\"\n" +
                "        }\n" +
                "      }\n" +
                "    }";
        long start = System.currentTimeMillis();
        for(int i = 0; i< 10000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        esService.createIndex("test-code", property);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        System.out.println("(System.currentTimeMillis() - start) = " + (System.currentTimeMillis() - start));
        return System.currentTimeMillis() - start;
    }

}
