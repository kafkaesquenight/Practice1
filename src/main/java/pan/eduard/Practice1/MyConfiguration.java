package pan.eduard.Practice1;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import pan.eduard.Practice1.service.ServiceA;
import pan.eduard.Practice1.service.ServiceB;
import pan.eduard.Practice1.service.ServiceC;
import pan.eduard.Practice1.service.ServiceD;
import pan.eduard.Practice1.repository.RepoA;
import pan.eduard.Practice1.repository.RepoB;
import pan.eduard.Practice1.repository.RepoC;
import org.springframework.context.annotation.Bean;
@Configuration
public class MyConfiguration {
    @Bean("serviceAFromConfiguration")
    @Primary
    public ServiceA getServiceA(){
        ServiceA serviceA = new ServiceA(new RepoA());
        serviceA.setAttribute("FIRST attribute from Configuration class");
        return serviceA;
    }


    @Bean("serviceCFromConfiguration")
    public ServiceC getServiceC(){
        ServiceC serviceC = new ServiceC(new ServiceB(new ServiceA(new RepoA()), new RepoB()), new RepoC());
        return serviceC;
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public ServiceD getServiceD(){
        ServiceD serviceD = new ServiceD(new ServiceC(new ServiceB(new ServiceA(new RepoA()), new RepoB()), new RepoC()));
        return serviceD;
    }

}
