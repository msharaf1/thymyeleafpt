package com.msx.thymyeleafpt.repositories;

import com.msx.thymyeleafpt.models.Dojo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DojoRepository extends CrudRepository<Dojo, Long> {
    List<Dojo> findAll();

    Optional<Dojo> findById(Long id);

//    Optional<Dojo> findByName(String name);

//    List<Dojo> byName(String name);


    @Override
    void delete(Dojo dojo);

    @Override
    long count();
}
