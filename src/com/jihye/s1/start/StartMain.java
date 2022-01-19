package com.jihye.s1.start;

import java.util.List;

import com.jihye.s1.department.DepartmentDAO;
import com.jihye.s1.department.DepartmentDTO;
import com.jihye.s1.department.DepartmentView;
import com.jihye.s1.util.DBConnector;

public class StartMain {

	public static void main(String[] args) {
		System.out.println("DB연동 test 시작");
		
		DepartmentDAO departmentDAO = new DepartmentDAO();
		DepartmentView departmentView = new DepartmentView();
		try {
			List<DepartmentDTO> ar = departmentDAO.getList();
			departmentView.view(ar);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("DB연동 test 끝");

	}

}
