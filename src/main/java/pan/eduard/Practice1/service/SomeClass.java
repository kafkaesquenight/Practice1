package pan.eduard.Practice1.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;
@Slf4j
@Service
public class SomeClass implements Runnable{
    @Override
    public void run() {
        log.info("start call runnable method");
        Stream.iterate(0, n -> n + 1).limit(10).forEach(x -> {
            log.info("making operation with id: " + x);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        log.info("end call runnable method");
    }
}
