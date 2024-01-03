package pan.eduard.Practice1.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.Callable;
import java.util.stream.Stream;

@Slf4j
@Service
public class AnotherClass implements Callable {
    @Override
    public Integer call() {
        Integer sum = Stream.iterate(0, n -> n + 1).limit(10).reduce(0, (x, y) -> {
            log.info("making operation with " + x + " and " + y);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
    }
    return x + y;
        });
        return sum;
    }
}
