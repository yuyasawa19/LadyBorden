package tokuronI.group1.denpyoukun.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tokuronI.group1.denpyoukun.entity.Request;

@Repository

public interface requestRepository extends CrudRepository<Request, Long> {

    Iterable<Request> findByName(String name);

}
