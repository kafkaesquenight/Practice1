package pan.eduard.Practice1.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class RepoC implements RepositoryClass{
    public void methodRepoC(){
        log.info("class {RepoC} method called");
    }
    public String getMessageFromDb() {
        return "This message selected from database";
    }
    @Override
    public void doSmthg() {
        log.info("doSmth");
    }
}