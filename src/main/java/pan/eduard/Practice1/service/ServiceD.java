package pan.eduard.Practice1.service;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;


@Service
public class ServiceD {
    Logger log = Logger.getLogger(ServiceD.class.getName());
    private ServiceC serviceC;
    @Value("MyBeanAttribute")
    private String attribute;

    @Autowired
    public ServiceD(ServiceC serviceC){
        log.info("class {ServiceD} method called");
        this.serviceC = serviceC;

    }
    public ServiceD() {
        log.info("class {ServiceD} method called");
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
    }
    private void init() {
        System.out.println("method called before init");
        Assert.notNull(serviceC, "Service C not null");

    }

    private void destroy() {
        System.out.println("method called after all");
        serviceC = null;

    }


}