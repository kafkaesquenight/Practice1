package pan.eduard.Practice1.repository;
import java.util.logging.Logger;
import org.springframework.stereotype.Repository;

@Repository
public class RepoC {
    Logger log = Logger.getLogger(RepoC.class.getName());
    public void methodRepoC(){
        log.info("class {RepoC} method called");
    }
}