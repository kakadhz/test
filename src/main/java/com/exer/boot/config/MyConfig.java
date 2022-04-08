package com.exer.boot.config;

import com.exer.boot.bean.User;
import org.slf4j.impl.StaticMDCBinder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
/*
* @Configuration标明是一个配置类，@Bean给容器添加组件，配置类本身也是组件，默认是单例
*  proxyBeanMethods默认是true，Full模式，保证调用@Bean修饰的方法返回是单例
*  proxyBeanMethods=false Lite模式 保证调用@Bean修饰的方法返回是新创建的
*   组件依赖必须Full模式依赖
*
*
* */
@Configuration(proxyBeanMethods = true)
@Import(StaticMDCBinder.class)//给容器中创建自动创建组件，
public class MyConfig {
    @Bean("user")//给容器中添加组件，以方法名作为组件的id。返回类型就是组件类型，，返回的值就是组件在容器中的实例
    public User user01(){
        User user = new User();
        return user;
    }
}
