package com.jihye.s1.start;

import java.util.Scanner;

import com.jihye.s1.department.DepartmentController;
import com.jihye.s1.employee.EmployeeController;
import com.jihye.s1.location.LocationController;

public class FrontController {
	
	private Scanner sc;
	private DepartmentController departmentController;
	private LocationController locationController;
	private EmployeeController employeeController;
	//locationController 와야하고 EmployeeController 도 와야함
	
	public FrontController() {
		sc = new Scanner(System.in);
		departmentController = new DepartmentController();
		locationController = new LocationController();
		employeeController = new EmployeeController();
	} 
	
	public void mainStart() throws Exception{
		boolean flag = true;
		
		while(flag) {
			System.out.println("1. 직원 관리");
			System.out.println("2. 부서 관리");
			System.out.println("3. 지역 관리");
			System.out.println("4. 프로그램 종료");
			int select = sc.nextInt();
			
			switch (select) {
			case 1 :
				employeeController.start();
				//내가 만들어서 호출해주기 employeeController의 start 메서드 호출
				break;
			case 2 :
				departmentController.start(); 
				break;
			case 3 :
				locationController.start();
				//내가 만들기 locationController의 start 메서드 호출
				break;
			default :
				flag = false;
			}
		}
	}

}
