package pan.eduard.Practice1.service;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Logger;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.Assert;
import org.springframework.stereotype.Service;
import pan.eduard.Practice1.repository.RepositoryClass;

@Service
public class ServiceC {
    Logger log = Logger.getLogger(ServiceC.class.getName());
    private ServiceB serviceB;
    private RepositoryClass repoC;
    @Value("MyBeanAttribute")
    private String attribute;
    @Autowired
    public ServiceC(@Qualifier("MyCustomBeanB") ServiceB serviceB, RepositoryClass repoC){
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
        repoC.doSmthg();
    }
    private void init() {
        System.out.println("this method called before init method");
        Assert.notNull(serviceB, "Service B is null");
        Assert.notNull(repoC, "repoC is null");
        Assert.hasText(attribute, "attribute is empty");
    }

    private void destroy() {
        System.out.println("method called after all");
        serviceB = null;
        repoC = null;
        attribute = null;
    }
    @PostConstruct
    public void postConstruct() {
        log.info("Bean initialized using @PostConstruct method");
    }

    @PreDestroy
    public void preDestroy() throws IOException {
        log.info("@PreDestroy method called");
        if(serviceB == null){
            Files.deleteIfExists((Path) serviceB);
        }
    }
}
