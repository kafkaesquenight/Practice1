package pan.eduard.Practice1.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.DataFormatException;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;


@Service
@Slf4j
public class ServiceD {
    private ServiceC serviceC;
    @Value("MyBeanAttribute")
    private String attribute;

    @Autowired
    public ServiceD(ServiceC serviceC){
        this.serviceC = serviceC;
    }

    public String getAttribute() {
        return attribute;
    }
    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public void methodServiceD(){
        log.info("Attribute:" + attribute + ' ' + "Class ServiceD method called");
        serviceC.methodServiceC();
        try {
            log.info("Exception Service C:" + serviceC.throwError());
        } catch (DataFormatException e){
            log.error("threw");
        }
    }
    private void init() {
        System.out.println("method called before init");
        Assert.notNull(serviceC, "Service C not null");

    }
    private void destroy() {
        System.out.println("method called after all");
        serviceC = null;

    }
    @PostConstruct
    public void postConstruct() {
        log.info("Bean initialized using @PostConstruct method");
    }

    @PreDestroy
    public void preDestroy() throws IOException {
        log.info("@PreDestroy method called");
        if(serviceC == null){
            Files.deleteIfExists((Path) serviceC);
        }
    }



}