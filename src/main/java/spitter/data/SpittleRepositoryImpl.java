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
                .mapToObj(i -> new Spittle(Long.valueOf(i), "msg " + i, new Date(), Double.valueOf(i), Double.valueOf(i)))
                .collect(Collectors.toList());
    }
}
