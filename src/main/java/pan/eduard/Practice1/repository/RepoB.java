package pan.eduard.Practice1.repository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
@Repository
@Slf4j
public class RepoB implements RepositoryClass{
    public RepoB() {
    }
    public String getMessageFromDb() {
        return "This message selected from database";
    }
    public void methodRepoB(){
        log.info("class {RepoB} method called");

    }
    @Override
    public void doSmthg() {
        log.info("doSmth");
    }
}