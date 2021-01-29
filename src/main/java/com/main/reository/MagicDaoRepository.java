package com.main.reository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.main.entity.EmployeeEntity;

public interface MagicDaoRepository extends JpaRepository<EmployeeEntity, Integer> {
	List<EmployeeEntity> findAllByOrderByEmployeeNameAsc();

	Optional<EmployeeEntity> findByEmailIdAndPassword(String email, String pass);

	Optional<EmployeeEntity> findByEmailId(String email);

	Optional<EmployeeEntity> findByemployeeName(String employeeName);

	List<EmployeeEntity> findAllByOrderByEmployeeNameDesc();

	List<EmployeeEntity> findAllByOrderByEmailIdAsc();

	List<EmployeeEntity> findAllByOrderByEmailIdDesc();

	@Query("SELECT p FROM EmployeeEntity p WHERE CONCAT(p.employeeName, p.emailId) LIKE %?1%")
	public List<EmployeeEntity> search(String search);
}
