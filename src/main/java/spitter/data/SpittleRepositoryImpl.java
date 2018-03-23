package spitter.data;

import org.springframework.stereotype.Component;
import spitter.Spittle;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class SpittleRepositoryImpl implements SpittleRepository {
    @Override
    public List<Spittle> findSpittles(long max, int count) {
        return createSpittlesList(count);
    }

    private List<Spittle> createSpittlesList(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> new Spittle((long) i, "msg " + i, new Date(), (double) i, (double) i))
                .collect(Collectors.toList());
    }

    @Override
    public Spittle findOne(long spittleId) {
        return new Spittle(spittleId, "hello", new Date(), 0.0, 0.0);
    }
}
