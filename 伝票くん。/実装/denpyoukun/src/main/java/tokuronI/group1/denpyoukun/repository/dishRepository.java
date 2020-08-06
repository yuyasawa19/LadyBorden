package tokuronI.group1.denpyoukun.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tokuronI.group1.denpyoukun.entity.dish;

@Repository

public interface dishRepository extends CrudRepository<dish, Long> {
}
