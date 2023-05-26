package cn.bdqn.sptparent.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.bdqn.sptparent.mybatisplus.mapper")
public class SptparentMybatisplusApplication {

    public static void main(String[] args) {
        SpringApplication.run(SptparentMybatisplusApplication.class, args);
    }

}
