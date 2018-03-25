package spitter.data;

import org.springframework.stereotype.Component;
import spitter.Spitter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class SpitterRepositoryImpl implements SpitterRepository {
    private List<Spitter> spitters;

    public SpitterRepositoryImpl() {
        spitters = new ArrayList<>();
    }

    @Override
    public Spitter save(Spitter spitter) {
        spitter.setId((long)spitters.size());
        spitters.add(spitter);
        return spitter;
    }

    @Override
    public Spitter findByUserName(String userName) {
        Optional<Spitter> first = spitters.stream()
                .filter(u -> u.getUserName().equals(userName))
                .findFirst();
        return first.get();
    }
}
