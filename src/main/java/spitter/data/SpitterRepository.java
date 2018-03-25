package spitter.data;

import spitter.Spitter;

/**
 * The repository that contains spitters.
 *
 * @author dchernyshov
 */
public interface SpitterRepository {
    Spitter save(Spitter spitter);
}
