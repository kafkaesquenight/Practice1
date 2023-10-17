package pan.eduard.Practice1.service;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ServiceD {
    Logger log = Logger.getLogger(ServiceD.class.getName());
    private ServiceC serviceC;
    public void methodServiceD(){
        log.info("class {ServiceD} method called");
        serviceC.methodServiceC();
    }
    @Autowired
    public ServiceD(ServiceC serviceC){
        log.info("class {ServiceD} method called");
        this.serviceC = serviceC;

    }
    public ServiceD() {
        log.info("class {ServiceD} method called");
    }

}