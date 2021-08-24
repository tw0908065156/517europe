package cn.tedu.aeurope;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.tedu.aeurope.mapper")
public class AeuropeApplication {

	public static void main(String[] args) {
		SpringApplication.run(AeuropeApplication.class, args);
	}

}
