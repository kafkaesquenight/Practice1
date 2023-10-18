package pan.eduard.Practice1.service;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import pan.eduard.Practice1.repository.RepoA;
import org.springframework.stereotype.Service;
@Service
public class ServiceA {
    Logger log = Logger.getLogger(ServiceA.class.getName());
    @Value("${attribute.value:this is default}")
    private String attribute;
    private RepoA repoA;
    @Value("class {ServiceA} method called")
    private String serviceAMsg;
    public void methodServiceA(){
        log.info(serviceAMsg);
        repoA.methodRepoA();
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }
    public ServiceA(){
        log.info(serviceAMsg);
    }
    @Autowired
    public ServiceA(RepoA repoA) {
        log.info(serviceAMsg);
        repoA.methodRepoA();
    }
}