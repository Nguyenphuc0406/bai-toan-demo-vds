package com.example.demo.repository;

import com.example.demo.entity.Master;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterRepository extends JpaRepository<Master, Integer> {
    Master findByMasterId(int masterId);
}
