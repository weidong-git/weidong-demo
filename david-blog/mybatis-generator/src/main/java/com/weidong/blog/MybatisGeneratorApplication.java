package com.weidong.blog;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MybatisGeneratorApplication {

    private void generator() throws Exception{

        List<String> warnings = new ArrayList<String>();
        //指定 逆向工程配置文件
        ClassLoader classLoader = getClass().getClassLoader();
        File configFile = new File(classLoader.getResource("generator-config.xml").getFile());
        System.out.println(configFile.getPath());
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(true);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
                callback, warnings);
        myBatisGenerator.generate(null);

    }
    public static void main(String[] args) {
        try {
            MybatisGeneratorApplication mybatisGeneratorApplication = new MybatisGeneratorApplication();
            mybatisGeneratorApplication.generator();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
