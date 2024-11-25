package api.azure.msv_redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MsvRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsvRedisApplication.class, args);
	}

}
