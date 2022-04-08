package com.exer.boot.config;

import com.exer.boot.bean.User;
import org.slf4j.impl.StaticMDCBinder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan("com.exer.boot")
public class MainApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(MainApp.class, args);//返回IOC容器
        String[] names = run.getBeanDefinitionNames();//返回容器中的组件
        for (String name :
                names) {
            System.out.println(name);
        }
        User user = run.getBean(User.class);
        User user1 = run.getBean(User.class);
        System.out.println(user==user1);
        MyConfig bean = run.getBean(MyConfig.class);
        User user2 = bean.user01();
        User user3 = bean.user01();
        System.out.println(user2==user3);

        String[] type = run.getBeanNamesForType(StaticMDCBinder.class);
        for (String s:type){
            System.out.println(s);
        }

        Object bean1 = run.getBean(StaticMDCBinder.class);
        System.out.println(bean1);
    }
}
