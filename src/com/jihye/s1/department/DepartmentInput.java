package com.jihye.s1.department;

import java.util.Scanner;

public class DepartmentInput {
	
	private Scanner sc;
	
	public DepartmentInput () {
		sc = new Scanner(System.in);
		
	}
	public DepartmentDTO setDelete() {
		DepartmentDTO departmentDTO = new DepartmentDTO();
		System.out.println("삭제할 DEPARTMENT ID를 입력하세요");
		departmentDTO.setDepartment_id(sc.nextInt());
		
		return departmentDTO;
	}
	
	//insert
	public DepartmentDTO setInsert() {
		
		DepartmentDTO departmentDTO = new DepartmentDTO();
		System.out.println("DEPARTMENT NAME을 입력하세요");
		departmentDTO.setDepartment_name(sc.next());
		System.out.println("MANAGER ID를 입력하세요");
		departmentDTO.setManager_id(sc.nextInt());
		System.out.println("LOCATION ID를 입력하세요");
		departmentDTO.setLocation_id(sc.nextInt());
	
		return departmentDTO;
	}

}
