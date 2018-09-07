package com.atkison.atkison2018.repository;

import com.atkison.atkison2018.models.Reserved;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReserveRepository extends JpaRepository<Reserved, Integer> {
}
