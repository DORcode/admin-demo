package com.coin.demoes;

import com.coin.base.config.JacksonUtil;
import com.coin.demoes.es.config.RestClientTemplate;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.reindex.DeleteByQueryRequest;
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

    @Autowired
    RestClientTemplate restClientTemplate;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void deleteData() {
        DeleteByQueryRequest deleteByQueryRequest = new DeleteByQueryRequest("single-index-00001");

        deleteByQueryRequest.setQuery(new MatchQueryBuilder("attachment.content", "数据"));
        restClientTemplate.execute(client -> {
            return client.deleteByQuery(deleteByQueryRequest, RequestOptions.DEFAULT);
        });
    }

    @Test
    void search2() {
        QueryBuilders.boolQuery().should(QueryBuilders.matchQuery("", "")).should(QueryBuilders.termQuery("", ""));

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

        esService.insertDoc("single-index-00001", "singleattachment", map);

    }

    @Test
    void insertAttachment() {
        Map<String, Object> map = new HashMap<>();
        map.put("title", "台湾海峡");
        map.put("author", "张江江");
        // map.put("content", "中地一二三四五六七八九十中秋节要到了，国庆也要到了，中秋和国庆节在一天，一个世纪只有四次");
        List<Map<String, Object>> attachs = new ArrayList<Map<String, Object>>();
        String file1 = "C:\\Users\\shenzhanwang\\Documents\\gitignore_global.txt";
        Map<String, Object> attach1 = new HashMap<>();
        attach1.put("title", "gitignore_global.txt");
        attach1.put("type", "file");
        attach1.put("data", getFileStr(file1));
        Map<String, Object> attach2 = new HashMap<>();
        String file2 = "C:\\Users\\shenzhanwang\\Documents\\数据管理平台.docx";
        attach2.put("title", "数据管理平台.docx");
        attach2.put("type", "file");
        attach2.put("data", getFileStr(file2));
        Map<String, Object> attach3 = new HashMap<>();
        String file3 = "C:\\Users\\shenzhanwang\\Downloads\\建立三维数字长江模型的关键技术探讨_牛瑞卿.pdf";
        attach3.put("title", "建立三维数字长江模型的关键技术探讨_牛瑞卿.pdf");
        attach3.put("type", "file");
        attach3.put("data", getFileStr(file3));
        Map<String, Object> attach4 = new HashMap<>();
        String file4 = "F:\\阿里巴巴Java开发手册（华山版）.pdf";
        attach4.put("title", "阿里巴巴Java开发手册（华山版）.pdf");
        attach4.put("type", "file");
        attach4.put("data", getFileStr(file4));

        Map<String, Object> attach5 = new HashMap<>();
        String file5 = "F:\\企业级大数据构建方案：背景、实施、技术与应用.pptx";
        attach5.put("title", "企业级大数据构建方案：背景、实施、技术与应用.pptx");
        attach5.put("type", "file");
        attach5.put("data", getFileStr(file5));

        Map<String, Object> attach6 = new HashMap<>();
        String file6 = "C:\\Users\\shenzhanwang\\Downloads\\一种基于ELK框架的地理信息动态时空数据获取与挖掘方法_吴嘉琪.pdf";
        attach6.put("title", "一种基于ELK框架的地理信息动态时空数据获取与挖掘方法_吴嘉琪.pdf");
        attach6.put("type", "file");
        attach6.put("data", getFileStr(file6));



//        attachs.add(attach1);
//        attachs.add(attach2);
//        attachs.add(attach3);
//        attachs.add(attach4);
//        attachs.add(attach5);
        attachs.add(attach5);


        map.put("attachments", attachs);
        System.out.println("JacksonUtil.toJSONString(map) = " + JacksonUtil.toJSONString(attach6));

        esService.insertDoc("single-index-00001", "singleattachment", attach1);

    }

    @Test
    void insertArtical() {
        Map<String, Object> map = new HashMap<>();
        map.put("title", "台湾海峡");
        map.put("author", "张江江");
        // map.put("content", "中地一二三四五六七八九十中秋节要到了，国庆也要到了，中秋和国庆节在一天，一个世纪只有四次");
        List<Map<String, Object>> attachs = new ArrayList<Map<String, Object>>();
        String file1 = "C:\\Users\\shenzhanwang\\Documents\\gitignore_global.txt";
        Map<String, Object> attach1 = new HashMap<>();
        attach1.put("filename", "gitignore_global.txt");
        Map<String, Object> attach2 = new HashMap<>();
        String file2 = "C:\\Users\\shenzhanwang\\Documents\\数据管理平台.docx";
        attach2.put("title", "数据管理平台");
        Map<String, Object> attach3 = new HashMap<>();
        String file3 = "C:\\Users\\shenzhanwang\\Downloads\\建立三维数字长江模型的关键技术探讨_牛瑞卿.pdf";
        attach3.put("filename", "建立三维数字长江模型的关键技术探讨_牛瑞卿.pdf");
        Map<String, Object> attach4 = new HashMap<>();
        String file4 = "F:\\阿里巴巴Java开发手册（华山版）.pdf";
        attach4.put("filename", "阿里巴巴Java开发手册（华山版）.pdf");

        Map<String, Object> attach5 = new HashMap<>();
        String file5 = "F:\\企业级大数据构建方案：背景、实施、技术与应用.pptx";
        attach5.put("filename", "企业级大数据构建方案：背景、实施、技术与应用.pptx");

        Map<String, Object> attach6 = new HashMap<>();
        String file6 = "C:\\Users\\shenzhanwang\\Downloads\\一种基于ELK框架的地理信息动态时空数据获取与挖掘方法_吴嘉琪.pdf";
        attach6.put("title", "一种基于ELK框架的地理信息动态时空数据获取与挖掘方法_吴嘉琪7");
        attach6.put("type", "artical");
        attach6.put("content", getContent(file6));



//        attachs.add(attach1);
//        attachs.add(attach2);
//        attachs.add(attach3);
//        attachs.add(attach4);
//        attachs.add(attach5);
        attachs.add(attach6);


        map.put("attachments", attachs);
        System.out.println("JacksonUtil.toJSONString(map) = " + JacksonUtil.toJSONString(attach6));

        esService.insertDoc("single-index-00001", attach6);

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

    String getContent(String path) {
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
                return pdfFileInText;

            } else {
                System.out.println("\"加密了\" = " + "加密了");
            }

        } catch (InvalidPasswordException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
        return "";
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

            } else {
                System.out.println("\"加密了\" = " + "加密了");
            }

        } catch (InvalidPasswordException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    @Test
    public void pdf2() throws IOException, TikaException {
        //选择要提取的文件
        File file = new File("C:\\Users\\shenzhanwang\\Downloads\\340-2017-G4A1-永久-0067.pdf");

        //获取并打印文件内容
        Tika tika = new Tika();
        String filecontent = tika.parseToString(file);
        System.out.println("Extracted Content: " + filecontent);
    }
}