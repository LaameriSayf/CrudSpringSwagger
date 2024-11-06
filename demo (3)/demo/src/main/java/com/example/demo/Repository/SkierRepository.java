package com.example.demo.Repository;

import com.example.demo.entity.Skier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkierRepository extends JpaRepository<Skier,Long> {
}
