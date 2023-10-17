package pan.eduard.Practice1.service;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import pan.eduard.Practice1.repository.RepoC;
import org.springframework.stereotype.Service;
@Service
public class ServiceC {
    Logger log = Logger.getLogger(ServiceC.class.getName());
    private ServiceB serviceB;
    private RepoC repoC;

    public void methodServiceC(){
        log.info("class {ServiceC} method called");
        serviceB.methodServiceB();
        repoC.methodRepoC();
    }
    @Autowired
    public ServiceC(ServiceB serviceB, RepoC repoC){
        log.info("class {ServiceC} method called");
        this.serviceB = serviceB;
        this.repoC = repoC;

    }
    public ServiceC() {
        log.info("class {ServiceC} method called");
    }
}
