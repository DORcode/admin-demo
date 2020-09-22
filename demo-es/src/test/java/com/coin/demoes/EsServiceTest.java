package com.coin.demoes;

import com.coin.base.config.JacksonUtil;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.util.*;

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

    @Test
    void insertAttachments() {
        Map<String, Object> map = new HashMap<>();
        map.put("title", "台湾海峡");
        map.put("author", "张江江");
        // map.put("content", "中地一二三四五六七八九十中秋节要到了，国庆也要到了，中秋和国庆节在一天，一个世纪只有四次");
        List<Map<String, Object>> attachs = new ArrayList<Map<String, Object>>();
        String file1 = "C:\\Users\\shenzhanwang\\Documents\\gitignore_global.txt";
        Map<String, Object> attach1 = new HashMap<>();
        attach1.put("filename", "gitignore_global.txt");
        attach1.put("data", getFileStr(file1));
        Map<String, Object> attach2 = new HashMap<>();
        String file2 = "C:\\Users\\shenzhanwang\\Documents\\数据管理平台.docx";
        attach2.put("filename", "数据管理平台.docx");
        attach2.put("data", getFileStr(file2));
        Map<String, Object> attach3 = new HashMap<>();
        String file3 = "C:\\Users\\shenzhanwang\\Downloads\\建立三维数字长江模型的关键技术探讨_牛瑞卿.pdf";
        attach3.put("filename", "建立三维数字长江模型的关键技术探讨_牛瑞卿.pdf");
        attach3.put("data", getFileStr(file3));
        Map<String, Object> attach4 = new HashMap<>();
        String file4 = "F:\\阿里巴巴Java开发手册（华山版）.pdf";
        attach4.put("filename", "阿里巴巴Java开发手册（华山版）.pdf");
        attach4.put("data", getFileStr(file4));

        Map<String, Object> attach5 = new HashMap<>();
        String file5 = "F:\\企业级大数据构建方案：背景、实施、技术与应用.pptx";
        attach5.put("filename", "企业级大数据构建方案：背景、实施、技术与应用.pptx");
        attach5.put("data", getFileStr(file5));

        Map<String, Object> attach6 = new HashMap<>();
        String file6 = "C:\\Users\\shenzhanwang\\Downloads\\一种基于ELK框架的地理信息动态时空数据获取与挖掘方法_吴嘉琪.pdf";
        attach6.put("filename", "一种基于ELK框架的地理信息动态时空数据获取与挖掘方法_吴嘉琪.pdf");
        attach6.put("data", getFileStr(file6));



//        attachs.add(attach1);
//        attachs.add(attach2);
//        attachs.add(attach3);
//        attachs.add(attach4);
//        attachs.add(attach5);
        attachs.add(attach6);


        map.put("attachments", attachs);
        System.out.println("JacksonUtil.toJSONString(map) = " + JacksonUtil.toJSONString(map));

        esService.insertDoc("my-index-00002", "attachment", map);

    }

    public String getFileStr(String imgFile) {//将文件转化为字节数组字符串，并对其进行Base64编码处理
        InputStream in = null;
        byte[] data = null;
        //读取文件字节数组
        try {
            in = new FileInputStream(imgFile);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // System.out.println("encoder = " + encoder.encode(data));
        try {
            System.out.println("new String(Base64.getMimeDecoder().decode(data)) = " + new String(Base64.getDecoder().decode(Base64.getEncoder().encodeToString(data)), "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return Base64.getEncoder().encodeToString(data);//返回Base64编码过的字节数组字符串
    }

    @Test
    void search() {
        esService.search("my-index-00002", 0, 1, "信息", "attachments.attachment.content", "<span class=\"aa\">", "</span>", "attachments.attachment.content");
    }

    @Test
    void pdf() {
        String path = "C:\\Users\\shenzhanwang\\Downloads\\340-2017-G4A1-永久-0067.pdf";

        try (PDDocument document = PDDocument.load(new File(path))) {

            document.getClass();
            System.out.println("\"获取pdf内容\" = " + "获取pdf内容");
            if(!document.isEncrypted()) {
                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
                stripper.setSortByPosition(true);
                PDFTextStripper tStripper = new PDFTextStripper();

                String pdfFileInText = tStripper.getText(document);

                String[] lines = pdfFileInText.split("\\r?\\n");
                for(String line : lines) {
                    System.out.println(line);
                }

            }

        } catch (InvalidPasswordException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}