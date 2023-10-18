package pan.eduard.Practice1.service;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import pan.eduard.Practice1.repository.RepoB;
import org.springframework.stereotype.Service;


@Service
public class ServiceB {
    Logger log = Logger.getLogger(ServiceC.class.getName());
    private ServiceA serviceA;

    private RepoB repoB;
    private String attribute;
    @Value("class {ServiceB} method called")
    private String methodBMsg;
    @Autowired
    public ServiceB(RepoB repoB){
        log.info(methodBMsg);
        this.repoB = repoB;
    }
    public ServiceB() {
        log.info(methodBMsg);
    }
    public void methodServiceB(){
        log.info("Attribute:" + attribute + ' ' + methodBMsg);
        serviceA.methodServiceA();
        repoB.methodRepoB();
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(@Value("${attribute.value:this is default}") String attribute) {
        this.attribute = attribute;
    }


}