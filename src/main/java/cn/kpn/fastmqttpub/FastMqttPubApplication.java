package cn.kpn.fastmqttpub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class FastMqttPubApplication {

	public static void main(String[] args) {
		SpringApplication.run(FastMqttPubApplication.class, args);
	}

}
