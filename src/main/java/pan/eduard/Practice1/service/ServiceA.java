package pan.eduard.Practice1.service;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pan.eduard.Practice1.repository.RepositoryClass;


@Service
public class ServiceA{
    Logger log = Logger.getLogger(ServiceA.class.getName());

    private RepositoryClass repoA;

    @Value("${attribute.value:this is default}")
    private String attribute;
    public ServiceA(){
        log.info("class {ServiceA} method called");
    }
    @Autowired
    public ServiceA(RepositoryClass repoA) {
        log.info("class {ServiceA} method called");
        this.repoA = repoA;

    }
    public void methodServiceA(){
        log.info("Attribute:" + attribute + ' ' + "Class ServiceA method called");
        repoA.doSmthg();
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }



}