package pan.eduard.Practice1.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
@Repository
@Slf4j
public class RepoA implements RepositoryClass{
    public RepoA() {
    }
    public String getMessageFromDb() {
        return "This message selected from database";
    }

    public void methodRepoA(){
        log.info("class {RepoA} method called");
    }
    @Override
    public void doSmthg() {
        log.info("doSmth");
    }
}