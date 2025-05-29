package ru.random_walk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication(scanBasePackages = "ru.random_walk", exclude = { DataSourceAutoConfiguration.class })
@ConfigurationPropertiesScan
public class LoadTestsDataGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoadTestsDataGeneratorApplication.class, args);
	}

}
