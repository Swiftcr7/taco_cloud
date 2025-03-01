package sia.taco_cloud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sia.taco_cloud.model.TacoOrder;


@Repository
public interface OrderRepository extends CrudRepository<TacoOrder, Long> {
}
