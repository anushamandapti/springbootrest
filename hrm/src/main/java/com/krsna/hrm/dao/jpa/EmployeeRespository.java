package com.krsna.hrm.dao.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.krsna.hrm.domain.Employee;

@Repository
public interface EmployeeRespository extends CrudRepository<Employee, Integer>{

}
