package pan.eduard.Practice1;

import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import pan.eduard.Practice1.service.ServiceA;
import pan.eduard.Practice1.service.ServiceB;
import pan.eduard.Practice1.service.ServiceC;
import pan.eduard.Practice1.service.ServiceD;
import org.springframework.context.annotation.Bean;
@PropertySource(value = "classpath:myprops.properties")
@org.springframework.context.annotation.Configuration
@Import(ServiceA.class)
public class Configuration {
    @Bean("serviceAFromConfiguration")
    @Primary
    public ServiceA getServiceA(){
        ServiceA serviceA = new ServiceA();
        serviceA.setAttribute("FIRST attribute from Configuration class");
        return serviceA;
    }

    @Bean("serviceBFromConfiguration")
    public ServiceB getServiceB(){
        ServiceB serviceB = new ServiceB();
        serviceB.setAttribute("SECOND attribute from Configuration class");
        return serviceB;
    }

    @Bean("serviceCFromConfiguration")
    public ServiceC getServiceC(){
        ServiceC serviceC = new ServiceC();
        return serviceC;
    }

    @Bean("serviceDFromConfiguration")
    public ServiceD getServiceD(){
        ServiceD serviceD = new ServiceD();
        return serviceD;
    }

}
