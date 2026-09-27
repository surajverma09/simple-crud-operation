package in.myproject.simpleCrudOperation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class SimpleCrudOperationApplication {

	public static void main(String[] args) {
		System.out.println("hello world");
		SpringApplication.run(SimpleCrudOperationApplication.class, args);
		System.out.println("hello world");
	}
}
