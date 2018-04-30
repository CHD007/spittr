package spitter.data;

import spitter.domain.Spitter;

/**
 * The repository that contains spitters.
 *
 * @author dchernyshov
 */
public interface SpitterRepository {
    Spitter save(Spitter spitter);

    Spitter findByUserName(String userName);
}
