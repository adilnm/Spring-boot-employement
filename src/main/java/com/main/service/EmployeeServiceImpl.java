package com.main.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.dto.EmployeeDTO;
import com.main.entity.EmployeeEntity;
import com.main.reository.MagicDaoRepository;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private MagicDaoRepository magicDaoRepository;

	@Override
	public EmployeeDTO authenticate(String emailId, String password) {
		Optional<EmployeeEntity> optional = magicDaoRepository.findByEmailIdAndPassword(emailId, password);
		EmployeeDTO employeeDTO = null;
		if (optional.isPresent()) { // check if the query returns some data or not
			EmployeeEntity employeeEntity = optional.get();
			employeeDTO = new EmployeeDTO();
			BeanUtils.copyProperties(employeeEntity, employeeDTO);
			return employeeDTO;
		} else {
			return employeeDTO;
		}
	}

	@Override
	public List<EmployeeDTO> findAllEmployees() {
		List<EmployeeDTO> employeeDtoList = new ArrayList<>();
		List<EmployeeEntity> employeeEntity = magicDaoRepository.findAll();
		if (employeeEntity.size() > 0) {
			for (EmployeeEntity employee : employeeEntity) {
				EmployeeDTO employeeDto = new EmployeeDTO();
				BeanUtils.copyProperties(employee, employeeDto);
				employeeDtoList.add(employeeDto);
			}

		}

		return employeeDtoList;
	}

	@Override
	public EmployeeDTO forget(String emailId) {
		Optional<EmployeeEntity> optional = magicDaoRepository.findByEmailId(emailId);
		EmployeeDTO employeeDTO = null;
		if (optional.isPresent()) { // check if the query returns some data or not
			EmployeeEntity employeeEntity = optional.get();
			employeeDTO = new EmployeeDTO();
			BeanUtils.copyProperties(employeeEntity, employeeDTO);
			return employeeDTO;
		} else {
			return employeeDTO;
		}
	}

}
