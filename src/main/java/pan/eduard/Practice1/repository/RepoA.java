package pan.eduard.Practice1.repository;
import java.util.logging.Logger;
import org.springframework.stereotype.Repository;
@Repository
public class RepoA implements RepositoryClass{
    public RepoA() {
    }
    public String getMessageFromDb() {
        return "This message selected from database";
    }
    Logger log = Logger.getLogger(RepoA.class.getName());

    public void methodRepoA(){
        log.info("class {RepoA} method called");
    }
    @Override
    public void doSmthg() {
        log.info("doSmth");
    }
}