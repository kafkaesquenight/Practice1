package pan.eduard.Practice1.service;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import pan.eduard.Practice1.repository.RepoA;
import org.springframework.stereotype.Service;
@Service
public class ServiceA {
    Logger log = Logger.getLogger(ServiceA.class.getName());

    private RepoA repoA;

    @Value("${attribute.value:this is default}")
    private String attribute;
    public ServiceA(){
        log.info("class {ServiceA} method called");
    }
    @Autowired
    public ServiceA(RepoA repoA) {
        log.info("class {ServiceA} method called");
        repoA.methodRepoA();
    }
    public void methodServiceA(){
        log.info("Attribute:" + attribute + ' ' + "Class ServiceA method called");
        repoA.methodRepoA();
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }


}