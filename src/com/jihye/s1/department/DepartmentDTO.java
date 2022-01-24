package com.jihye.s1.department;

import java.util.List;

import com.jihye.s1.employee.EmployeeDTO;

public class DepartmentDTO {
	
	private Integer department_id;
	private String department_name;
	private Integer manager_id;
	private Integer location_id;
	private List<EmployeeDTO> employeeDTOs; //부서는 사원을 여러명(n명) 가지고 있다
	
	public Integer getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(Integer department_id) {
		this.department_id = department_id;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	public Integer getManager_id() {
		return manager_id;
	}
	public void setManager_id(Integer manager_id) {
		this.manager_id = manager_id;
	}
	public Integer getLocation_id() {
		return location_id;
	}
	public void setLocation_id(Integer location_id) {
		this.location_id = location_id;
	}

}
