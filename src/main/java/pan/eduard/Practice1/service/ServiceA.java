package pan.eduard.Practice1.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pan.eduard.Practice1.repository.RepositoryClass;


@Service
@Slf4j
public class ServiceA{

    private RepositoryClass repoA;

    @Value("${attribute.value:this is default}")
    private String attribute;
    @Autowired
    public ServiceA(RepositoryClass repoA) {
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