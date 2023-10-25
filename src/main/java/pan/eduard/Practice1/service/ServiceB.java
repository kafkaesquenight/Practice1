package pan.eduard.Practice1.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pan.eduard.Practice1.repository.RepositoryClass;

@Primary
@Service("MyCustomBeanB")
@Slf4j
public class ServiceB {
    private ServiceA serviceA;

    private RepositoryClass repoB;
    private String attribute;
    @Value("class {ServiceB} method called")
    private String methodBMsg;
    @Autowired
    public ServiceB(ServiceA serviceA,@Qualifier("repoB") RepositoryClass repoB){
        this.serviceA = serviceA;
        this.repoB = repoB;
    }
    public void methodServiceB(){
        log.info("Attribute:" + attribute + ' ' + methodBMsg);
        serviceA.methodServiceA();
        repoB.doSmthg();
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(@Value("${attribute.value:this is default}") String attribute) {
        this.attribute = attribute;
    }


}