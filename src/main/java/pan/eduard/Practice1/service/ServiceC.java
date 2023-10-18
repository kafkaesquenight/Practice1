package pan.eduard.Practice1.service;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import pan.eduard.Practice1.repository.RepoC;
import org.springframework.stereotype.Service;
@Service
public class ServiceC {
    Logger log = Logger.getLogger(ServiceC.class.getName());
    private ServiceB serviceB;
    private RepoC repoC;
    @Value("MyBeanAttribute")
    private String attribute;
    @Autowired
    public ServiceC(ServiceB serviceB, RepoC repoC){
        log.info("class {ServiceC} method called");
        this.serviceB = serviceB;
        this.repoC = repoC;

    }
    public ServiceC() {
        log.info("class {ServiceC} method called");
    }
    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public void methodServiceC(){
        log.info("Attribute:" + attribute + ' ' + "Class ServiceC method called");
        serviceB.methodServiceB();
        repoC.methodRepoC();
    }

}
