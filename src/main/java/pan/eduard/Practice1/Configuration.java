package pan.eduard.Practice1;

import pan.eduard.Practice1.service.ServiceA;
import pan.eduard.Practice1.service.ServiceB;
import pan.eduard.Practice1.service.ServiceC;
import pan.eduard.Practice1.service.ServiceD;
import org.springframework.context.annotation.Bean;
@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean("serviceAFromConfiguration")
    public ServiceA getServiceA(){
        ServiceA serviceA = new ServiceA();
        return serviceA;
    }

    @Bean("serviceBFromConfiguration")
    public ServiceB getServiceB(){
        ServiceB serviceB = new ServiceB();
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
