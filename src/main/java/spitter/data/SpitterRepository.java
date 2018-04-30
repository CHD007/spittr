package spitter.data;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import spitter.domain.Spitter;

/**
 * The repository that contains spitters.
 *
 * @author dchernyshov
 */
public interface SpitterRepository extends JpaRepository<Spitter, Long> {
    /**
     * Find spitter by username.
     *
     * To check that return value is cached and this method calls only once turn on hibernate sql log
     * and check that it goes to database only once.
     *
     * @param userName username of spitter to be find
     * @return spitter by username
     */
    @Cacheable("spittleCache")
    Spitter findByUserName(String userName);
}
