package pan.eduard.Practice1.service;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.DataFormatException;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.Assert;
import org.springframework.stereotype.Service;
import pan.eduard.Practice1.repository.RepositoryClass;

@Service
@Slf4j
public class ServiceC {

    private ServiceB serviceB;
    private RepositoryClass repoC;
    @Value("MyBeanAttribute")
    private String attribute;
    @Autowired
    public ServiceC(@Qualifier("MyCustomBeanB") ServiceB serviceB, RepositoryClass repoC){
        this.serviceB = serviceB;
        this.repoC = repoC;

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

    public String throwError() throws DataFormatException {
        throw new DataFormatException("new Exception");
    }
}
