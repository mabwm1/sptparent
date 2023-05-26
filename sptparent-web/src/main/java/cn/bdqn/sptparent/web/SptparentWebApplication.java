package cn.bdqn.sptparent.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@MapperScan("cn.bdqn.sptparent.dao")
@ComponentScan("cn.bdqn.sptparent")
public class SptparentWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SptparentWebApplication.class, args);
    }

}
