package com.jihye.s1.department;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DepartmentController {

	private DepartmentDAO departmentDAO;
	private DepartmentView departmentView;
	private DepartmentInput departmentInput;
	private Scanner sc;

	public DepartmentController() {
		departmentDAO = new DepartmentDAO();
		departmentView = new DepartmentView();
		departmentInput = new DepartmentInput();
		sc = new Scanner(System.in);

	}

	public void start() throws Exception {

		boolean flag = true;

		while (flag) {

			System.out.println("1. 부서 리스트 출력");
			System.out.println("2. 부서 번호 검색");
			System.out.println("3. 부서 추가");
			System.out.println("4. 부서 삭제");
			System.out.println("5. 나가기");
			System.out.println("번호를 입력하세요.");
			int select = sc.nextInt();
			DepartmentDTO departmentDTO = null;
			int result = 0;
			String message = null;
			switch (select) {
			case 1:
				List<DepartmentDTO> ar = departmentDAO.getList();
				departmentView.view(ar);
				break;
			case 2:
				System.out.println("검색할 부서 번호를 입력하세요.");
				departmentDTO.setDepartment_id(sc.nextInt());
				departmentDTO = departmentDAO.getOne(departmentDTO);
				departmentView.view(departmentDTO);

				break;
			case 3:
				departmentDTO = departmentInput.setInsert();
				result = departmentDAO.setInsert(departmentDTO);
				message = "Fail";
				if (result > 0) {
					message = "Success";
				}
				departmentView.view(message);
				break;
			case 4:
				departmentDTO = departmentInput.setDelete();
				result = departmentDAO.setDelete(departmentDTO);
				message = "Delete Fail";
				if (result > 0) {
					message = "Delete Success";

				}
				departmentView.view(message);
				break;
			default:

				flag = false;
			}

		}
	}
}
