package com.netcracker.edu.backend.lab2.repository;

import com.netcracker.edu.backend.lab2.entity.NumEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NumEntityRepository  extends
        CrudRepository<NumEntity, Long> {

    Optional<NumEntity> findByNum(Long num);

}
