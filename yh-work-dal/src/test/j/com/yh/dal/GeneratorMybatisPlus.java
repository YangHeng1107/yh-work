package com.yh.dal;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * mybatis-plus 自动生成类
 */
@Slf4j
public class GeneratorMybatisPlus {

    @Test
    public void generateActivityCode() {
        String packageName = "com.yh.dal";
        boolean serviceNameStartWithI = false;//user -> UserService, 设置成true: user -> IUserService

        String dbUrl = "jdbc:mysql://127.0.0.1:3306/system?useSSL=false";
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig
                .setUrl(dbUrl)
                .setUsername("root")
                .setPassword("123")
                .setDriverName("com.mysql.jdbc.Driver");

        generateByTables(serviceNameStartWithI,dataSourceConfig, packageName, "user_info");
    }


    private void generateByTables(boolean serviceNameStartWithI, DataSourceConfig dataSourceConfig, String packageName, String... tableNames) {


        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig
                .setEntityBooleanColumnRemoveIsPrefix(true)
                .setCapitalMode(true)
                .setEntityLombokModel(true)
                .setNaming(NamingStrategy.underline_to_camel)
                .setInclude(tableNames);//修改替换成你需要的表名，多个表名传数组
        GlobalConfig config = new GlobalConfig();
        config.setActiveRecord(false)
                .setDateType(DateType.ONLY_DATE)
                .setAuthor("v-yangheng.ea")
                .setOutputDir("./src/main/java")
                .setFileOverride(true)
        .setOpen(false)
        ;

        if (!serviceNameStartWithI) {
            config.setServiceName("%sManager");
            config.setServiceImplName("%sManagerImpl");
            config.setEntityName("%sPo");
        }


        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return   "./src/main/resources/mybatis/mappers/" + tableInfo.getEntityName() + "Mapper.xml";
            }
        });

        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                this.setMap(map);
            }
        };

        /**
         * 可指定代码生成模板路径
         */
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setController(null);
        templateConfig.setXml(null);
        cfg.setFileOutConfigList(focList);
        new AutoGenerator().setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setTemplate(templateConfig)
                .setCfg(cfg)
                .setPackageInfo(
                        new PackageConfig()
                                .setParent(packageName)
                                .setMapper("mapper")
                                .setEntity("entity")
                                .setService("manager")
                                .setServiceImpl("manager.impl")
                                .setEntity("entity.mysql")
                                // .setController(null)
                                // .setMapper("mapper.activity")
                                // .setXml("mapper.activity")
                                //
                ).execute();

    }


    public static void main(String[] args) {
        log.info(System.getProperty("user.dir"));
    }
}