package pan.eduard.Practice1.repository;
import java.util.logging.Logger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
@Repository
public class RepoB {
    public RepoB() {
    }
    Logger log = Logger.getLogger(RepoB.class.getName());
    public String getMessageFromDb() {
        return "This message selected from database";
    }
    public void methodRepoB(){
        log.info("class {RepoB} method called");

    }
}