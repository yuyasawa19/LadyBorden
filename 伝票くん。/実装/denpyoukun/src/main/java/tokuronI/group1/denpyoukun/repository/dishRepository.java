package tokuronI.group1.denpyoukun.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tokuronI.group1.denpyoukun.entity.Dish;

@Repository

public interface DishRepository extends CrudRepository<Dish, Long> {
}
