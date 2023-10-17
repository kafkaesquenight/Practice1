package pan.eduard.Practice1.service;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import pan.eduard.Practice1.repository.RepoB;
import org.springframework.stereotype.Service;


@Service
public class ServiceB {
    Logger log = Logger.getLogger(ServiceC.class.getName());
    private ServiceA serviceA;
    private RepoB repoB;

    public void methodServiceB(){
        log.info("class {ServiceB} method called");
        serviceA.methodServiceA();
        repoB.methodRepoB();
    }
    @Autowired
    public ServiceB(RepoB repoB){
        log.info("class {ServiceB} method called");
        this.repoB = repoB;

    }
    public ServiceB() {
        log.info("class {ServiceB} method called");
    }
}