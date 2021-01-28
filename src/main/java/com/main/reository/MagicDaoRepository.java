package com.main.reository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.entity.EmployeeEntity;

public interface MagicDaoRepository extends JpaRepository<EmployeeEntity, Integer> {
	Optional<EmployeeEntity> findByEmailIdAndPassword(String email, String pass);

	Optional<EmployeeEntity> findByEmailId(String email);
}
