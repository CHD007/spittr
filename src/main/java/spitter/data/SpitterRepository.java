package spitter.data;

import org.springframework.data.jpa.repository.JpaRepository;
import spitter.domain.Spitter;

/**
 * The repository that contains spitters.
 *
 * @author dchernyshov
 */
public interface SpitterRepository extends JpaRepository<Spitter, Long> {
    Spitter findByUserName(String userName);
}
