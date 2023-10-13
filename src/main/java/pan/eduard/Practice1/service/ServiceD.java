package pan.eduard.Practice1.service;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pan.eduard.Practice1.repository.RepoC;

@Service
public class ServiceD {
    @Autowired
    private ServiceC serviceC;

    Logger log = Logger.getLogger(ServiceD.class.getName());

    public void methodServiceD(){
        log.info("class {ServiceD} method called");
        serviceC.methodServiceC();
    }

}