package tokuronI.group1.denpyoukun.repository;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tokuronI.group1.denpyoukun.entity.Dish;

@Repository

public interface dishRepository extends CrudRepository<Dish, Long> {

    Optional<Dish> findByCategoryAndPlan(String category, Date date);
}
