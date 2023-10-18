package pan.eduard.Practice1;


import org.springframework.boot.SpringApplication;

import java.util.logging.Logger;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pan.eduard.Practice1.service.ServiceA;

@SpringBootApplication
public class PracticeApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(PracticeApplication.class, args);
		Logger log = Logger.getLogger(ServiceA.class.getName());

	}

}
