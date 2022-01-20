package com.jihye.s1.department;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DepartmentController {
	
	private DepartmentDAO departmentDAO;
	private DepartmentView departmentView;
	private Scanner sc;
	
	public DepartmentController() {
		departmentDAO = new DepartmentDAO();
		departmentView = new DepartmentView();
		sc = new Scanner(System.in);
		
	}

	public void start() throws Exception {
		
		boolean flag = true;
		
		while(flag) {
			
			System.out.println("1. 부서 리스트 출력");
			System.out.println("2. 부서 번호 검색");
			System.out.println("3. 나가기");
			System.out.println("번호를 입력하세요.");
			int select = sc.nextInt();
			List<DepartmentDTO> ar = departmentDAO.getList();
			switch (select) {
			case 1:
				departmentView.view(ar);
				break;
			case 2:
				System.out.println("검색할 부서 번호를 입력하세요.");
				DepartmentDTO departmentDTO = null;
				departmentDTO.setDepartment_id(sc.nextInt());
				departmentDTO = departmentDAO.getOne(departmentDTO);
				
				for(int i=0;i<ar.size();i++) {
					if (departmentDTO.equals(ar.get(i).getDepartment_id())){
						departmentDTO = ar.get(i);
						break;
					}
					
				}
				break;
			default :
			
				flag = false;
			}
			
			
			
		}
	}
}
