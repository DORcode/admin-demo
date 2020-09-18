package com.coin.demoes;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @ClassName EsServiceTest
 * @Description: TODO
 * @Author kh
 * @Date 2020-09-16 17:47
 * @Version V1.0
 **/
@SpringBootTest
class EsServiceTest {

    @Autowired
    EsService esService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createIndex() throws Exception {
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


        esService.createIndex("test-code", property);
    }

    Object object = new Object();
    @Test
    void parallel() throws InterruptedException {
        Thread.sleep(10000);
        for(int i = 0; i< 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {

                        try {

                                //System.out.println("System.currentTimeMillis() = " + System.currentTimeMillis());
                                createIndex();


                        } catch (Exception e) {
                            e.printStackTrace();
                            System.out.println("e1 = " + e);
                        }
                    }
            }).start();
        }
    }

    @Test
    void existsIndex() {
    }

    @Test
    void deleteIndex() throws Exception {

        esService.deleteIndex("test-code");
    }


//    Map<String,Object> properties = Maps.newHashMap();
//    Map<String,Object> propertie = Maps.newHashMap();
//            propertie.put("type","text");
//            propertie.put("index",true);
//            propertie.put("analyzer","ik_max_word");
//            properties.put("field_name",propertie);
//
//    XContentBuilder builder = JsonXContent.contentBuilder();
//            builder.startObject()
//                    .startObject("mappings")
//                            .startObject("index_name")
//                                .field("properties",properties)
//                            .endObject()
//                        .endObject()
//                        .startObject("settings")
//                            .field("number_of_shards",3)
//                            .field("number_of_replicas",1)
//                        .endObject()
//                    .endObject();
}