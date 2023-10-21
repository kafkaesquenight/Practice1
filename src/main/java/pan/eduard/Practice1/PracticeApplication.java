package pan.eduard.Practice1;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
@SpringBootApplication
@Slf4j
public class PracticeApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(PracticeApplication.class, args);

	}

}
