package pan.eduard.Practice1.service;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import pan.eduard.Practice1.repository.RepoB;
import org.springframework.stereotype.Service;

@Service
public class ServiceB {
    @Autowired
    private ServiceA serviceA;
    @Autowired
    private RepoB repoB;
    Logger log = Logger.getLogger(ServiceB.class.getName());

    public void methodServiceB(){
        log.info("class {ServiceB} method called");
        serviceA.methodServiceA();
        repoB.methodRepoB();
    }
}