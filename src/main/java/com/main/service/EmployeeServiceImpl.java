package com.main.service;

import java.io.IOException;
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

	@Override
	public List<EmployeeDTO> search(String search) {
		List<EmployeeDTO> employeeDtoList = new ArrayList<>();
		List<EmployeeEntity> employeeEntity = magicDaoRepository.search(search);
		EmployeeDTO employeeDTO = null;
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
	public boolean register(EmployeeDTO employeeDto) {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		BeanUtils.copyProperties(employeeDto, employeeEntity);
		try {
			employeeEntity.setTphoto(employeeDto.getFile().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		magicDaoRepository.save(employeeEntity);
		return true;
	}

	@Override
	public EmployeeDTO show(int employee_id) {
		Optional<EmployeeEntity> optional = magicDaoRepository.findById(employee_id);
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
	public boolean update(int employeeId, String empName, String emailId, String password, int salary) {
		Optional<EmployeeEntity> optional = magicDaoRepository.findById(employeeId);
		EmployeeEntity employeeEntity = optional.get();
		employeeEntity.setEmployeeName(empName);
		employeeEntity.setEmailId(emailId);
		employeeEntity.setPassword(password);
		employeeEntity.setSalary(salary);
		magicDaoRepository.save(employeeEntity);
		return true;
	}

	@Override
	public void delete(int employee_id) {
		Optional<EmployeeEntity> optional = magicDaoRepository.findById(employee_id);
		EmployeeEntity employeeEntity = optional.get();
		magicDaoRepository.delete(employeeEntity);
	}

	@Override
	public List<EmployeeDTO> sortAsc() {
		List<EmployeeDTO> employeeDtoList = new ArrayList<>();
		List<EmployeeEntity> employeeEntity = magicDaoRepository.findAllByOrderByEmployeeNameAsc();
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
	public List<EmployeeDTO> sortDesc() {
		List<EmployeeDTO> employeeDtoList = new ArrayList<>();
		List<EmployeeEntity> employeeEntity = magicDaoRepository.findAllByOrderByEmployeeNameDesc();
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
	public List<EmployeeDTO> sortEmailAsc() {
		List<EmployeeDTO> employeeDtoList = new ArrayList<>();
		List<EmployeeEntity> employeeEntity = magicDaoRepository.findAllByOrderByEmailIdAsc();
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
	public List<EmployeeDTO> sortEmailDesc() {
		List<EmployeeDTO> employeeDtoList = new ArrayList<>();
		List<EmployeeEntity> employeeEntity = magicDaoRepository.findAllByOrderByEmailIdDesc();
		if (employeeEntity.size() > 0) {
			for (EmployeeEntity employee : employeeEntity) {
				EmployeeDTO employeeDto = new EmployeeDTO();
				BeanUtils.copyProperties(employee, employeeDto);
				employeeDtoList.add(employeeDto);
			}

		}
		return employeeDtoList;
	}

}
