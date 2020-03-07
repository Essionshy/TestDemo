package com.tingyu.singleton;

import java.io.IOException;
import java.util.Properties;

/**
 * 单例 饿汉式之静态代码块
 * 适用于构造带有参数的实例，参数是通过配置文件的方式来获取的情况下
 */

public class Singleton03 {
    private String info;
    public static Singleton03 instance;
    private Singleton03(String info){
        this.info=info;
    }

    /*
        静态代码块，动态加载配置文件信息
     */
    static{
        Properties properties=new Properties();
        try {
            properties.load(Singleton03.class.getClassLoader().getResourceAsStream("singleton.properties"));
            String info1 = properties.getProperty("info");
            instance=new Singleton03(info1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Singleton03{" +
                "info='" + info + '\'' +
                '}';
    }
}
