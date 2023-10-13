package pan.eduard.Practice1.repository;
import java.util.logging.Logger;
import org.springframework.stereotype.Repository;
@Repository
public class RepoA {
    public RepoA() {
    }
    Logger log = Logger.getLogger(RepoA.class.getName());

    public void methodRepoA(){
        log.info("class {RepoA} method called");
    }
}