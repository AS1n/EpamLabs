package com.netcracker.edu.backend.lab2.repository;

import com.netcracker.edu.backend.lab2.entity.ResEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntityRepository extends
        CrudRepository<ResEntity, Long>
{
}
