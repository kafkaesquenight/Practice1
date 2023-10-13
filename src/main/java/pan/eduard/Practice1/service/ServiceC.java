package pan.eduard.Practice1.service;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import pan.eduard.Practice1.repository.RepoC;
import org.springframework.stereotype.Service;
@Service
public class ServiceC {
    @Autowired
    private ServiceB serviceB;
    @Autowired
    private RepoC repoC;
    Logger log = Logger.getLogger(ServiceC.class.getName());

    public void methodServiceC(){
        log.info("class {ServiceC} method called");
        serviceB.methodServiceB();
        repoC.methodRepoC();
    }
}
