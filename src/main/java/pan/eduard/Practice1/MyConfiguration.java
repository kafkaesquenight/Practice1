package pan.eduard.Practice1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

@Configuration
@ComponentScan(basePackages = "pan")
public class MyConfiguration {
    private static Logger logger = LoggerFactory.getLogger(MyConfiguration.class);
    @Value("${value.from.application:default}:")
    private String value;

}
