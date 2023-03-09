package com.energy.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.energy.demo.taiff.Taiff;

public interface TaiffRepo extends JpaRepository<Taiff, String> {
	
	@Query("SELECT u FROM Taiff u WHERE u.taiff_type = ?1")
	Taiff findByTaiffType(String taiff_type);

}
