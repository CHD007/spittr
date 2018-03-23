package spitter.data;

import spitter.Spittle;

import java.util.List;

/**
 * The repository that contains spittles.
 *
 * @author dchernyshov
 */
public interface SpittleRepository {

    /**
     * Find spittles in repository
     *
     * @param max   max id of returned spittles
     * @param count count of returned spittles
     * @return      list of spittles
     */
    List<Spittle> findSpittles(long max, int count);

    /**
     * Find spittle by id
     *
     * @param spittleId id of spittle to be found
     * @return spittle by id
     */
    Spittle findOne(long spittleId);
}
