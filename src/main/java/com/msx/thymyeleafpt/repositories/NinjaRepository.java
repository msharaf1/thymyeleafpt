package com.msx.thymyeleafpt.repositories;

import com.msx.thymyeleafpt.models.Ninja;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long> {
    List<Ninja> findAll();
    Optional<Ninja> findById(Long id);
    long count();
}
