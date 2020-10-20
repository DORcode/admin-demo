package com.coin.shiro.util;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.converts.OracleTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName GeneratorUtil
 * @Description: TODO
 * @Author kh
 * @Date 2020/1/16 8:27
 * @Version V1.0
 **/
@Mapper
public class GeneratorUtil {
    private static String OUTPUT_JAVA = "f://generator/demo/src/main/java";
    private static String OUTPUT_RES = "f://generator/demo/src/main/resources";
    private static String PARENTPACKAGE = "com.cjsjy.info.web";
    private static String PARENTPACKAGEPATH = "/com/cjsjy/info/web/";
    private static String UTILPACKAGE = "com.cjsjy.info" + ".util";
    private static DbType DB_TYPE = null;
    private static String DB_DRIVER = "";
    private static String DB_URL= "";
    private static String DB_UM = "";
    private static String DB_PWD = "";
    private static ITypeConvert TYPE_CONVERT = null;
    private static GlobalConfig gc;
    public static void main(String[] args) {
        gc = new GlobalConfig();
        mysql();

    }

    public static void oracle(GlobalConfig gc) {
        DB_TYPE = DbType.ORACLE;
        DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
        DB_URL= "jdbc:oracle:thin:@...:1521:ORCL";
        DB_UM = "GM_BEIJING";
        DB_PWD = "GM_BEIJING";
        TYPE_CONVERT = new OracleTypeConvert() {
            @Override
            public IColumnType processTypeConvert(GlobalConfig gc, String fieldType) {
                /*if(fieldType.contains("")) {
                    return DbColumnType.BOOLEAN;
                }*/
                return super.processTypeConvert(gc, fieldType);
            }
        };
        generate();
    }

    public static void mysql() {
        DB_TYPE = DbType.MYSQL;
        DB_DRIVER = "com.mysql.cj.jdbc.Driver";
        DB_URL= "jdbc:mysql://10..172.:3306/info_publish?serverTimezone=UTC";
        DB_UM = "root";
        DB_PWD = "123456";
        TYPE_CONVERT = new MySqlTypeConvert() {
            @Override
            public IColumnType processTypeConvert(GlobalConfig gc, String fieldType) {
                /*if(fieldType.contains("")) {
                    return DbColumnType.BOOLEAN;
                }*/
                return super.processTypeConvert(gc, fieldType);
            }
        };
        generate();
    }

    private static void generate() {
        AutoGenerator ac = new AutoGenerator();


        gc.setOutputDir(OUTPUT_JAVA);
        gc.setFileOverride(true);
        // gc.setActiveRecord(true);
        gc.setEnableCache(false);
        gc.setBaseResultMap(true);
        gc.setBaseColumnList(true);
        gc.setAuthor("kh");
        gc.setControllerName("%sCotroller");
        gc.setServiceImplName("%sServiceImpl");
        gc.setServiceName("%sService");
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        ac.setGlobalConfig(gc);

        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DB_TYPE);
        dsc.setUrl(DB_URL);
        dsc.setDriverName(DB_DRIVER);
        dsc.setUsername(DB_UM);
        dsc.setPassword(DB_PWD);
        dsc.setTypeConvert(TYPE_CONVERT);
        ac.setDataSource(dsc);

        PackageConfig pc = new PackageConfig();
        pc.setParent(PARENTPACKAGE);
        // pc.setModuleName("api");
        pc.setController("controller");
        pc.setEntity("entity");
        pc.setService("service");
        pc.setMapper("mapper");
        // pc.setXml("mapper");
        ac.setPackageInfo(pc);

        StrategyConfig sc = new StrategyConfig();
        sc.setRestControllerStyle(true);
        sc.setControllerMappingHyphenStyle(false);
        sc.setCapitalMode(false);

        sc.setEntityLombokModel(true);
        sc.setNaming(NamingStrategy.underline_to_camel);
        sc.setColumnNaming(NamingStrategy.underline_to_camel);
        sc.setInclude(new String[] {});
        sc.setExclude(new String[] {});
        // sc.setEntityTableFieldAnnotationEnable(true);
        // sc.setInclude("sys_dict");
        // sc.setSuperControllerClass();
        // sc.setSuperEntityClass();
        // sc.setSuperMapperClass();
        // sc.setSuperServiceClass();
        // sc.setSuperServiceImplClass();
        ac.setStrategy(sc);

        TemplateConfig tc = new TemplateConfig();
        tc.setController("template/controller.java");
        tc.setServiceImpl("template/serviceImpl.java");
        tc.setService("template/service.java");
        tc.setMapper("template/mapper.java");
        tc.setXml(null);
        tc.setEntity("template/entity.java");
        ac.setTemplate(tc);

        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("controllerFirstName", "api");
                map.put("utilpackage", UTILPACKAGE);
                map.put("parentpackage", PARENTPACKAGE);
                this.setMap(map);
            }
        };

        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("template/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return OUTPUT_RES + "/mapper/" + tableInfo.getEntityName() + "Mapper.xml";
            }
        });

        focList.add(new FileOutConfig("template/entitypo.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return OUTPUT_JAVA + PARENTPACKAGEPATH + "/po/" + tableInfo.getEntityName() + "Po.java";
            }
        });

        focList.add(new FileOutConfig("template/entityvo.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return OUTPUT_JAVA + PARENTPACKAGEPATH + "/vo/" + tableInfo.getEntityName() + "Vo.java";
            }
        });

        focList.add(new FileOutConfig("template/entitydto.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return OUTPUT_JAVA + PARENTPACKAGEPATH + "/dto/" + tableInfo.getEntityName() + "Dto.java";
            }
        });
        cfg.setFileOutConfigList(focList);
        ac.setCfg(cfg);

        ac.setTemplateEngine(new FreemarkerTemplateEngine());
        ac.execute();
    }
}
