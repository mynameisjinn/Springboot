package com.study.springboothyejin.repository;

import com.study.springboothyejin.web.dto.EmpDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeRepository {

    public int saveEmployee(EmpDto employee);
}
