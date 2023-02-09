package com.acc.accenfarm.repository;

import com.acc.accenfarm.model.Chicken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IChickenRepository extends JpaRepository<Chicken, Integer> {
}
