package pan.eduard.Practice1.service;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import pan.eduard.Practice1.repository.RepoA;
import org.springframework.stereotype.Service;


@Service
public class ServiceA {
    Logger log = Logger.getLogger(ServiceA.class.getName());
    @Autowired
    private RepoA repoA;
    public void methodServiceA(){
        log.info("class {ServiceA} method called");
        repoA.methodRepoA();
    }
}