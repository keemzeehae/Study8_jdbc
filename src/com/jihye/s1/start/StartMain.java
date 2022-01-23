package com.jihye.s1.start;

import java.util.List;

import com.jihye.s1.department.DepartmentController;
import com.jihye.s1.department.DepartmentDAO;
import com.jihye.s1.department.DepartmentDTO;
import com.jihye.s1.department.DepartmentView;
import com.jihye.s1.location.LocationDAO;
import com.jihye.s1.location.LocationDTO;
import com.jihye.s1.location.LocationView;
import com.jihye.s1.util.DBConnector;

public class StartMain {

	public static void main(String[] args) throws Exception {
		System.out.println("DB연동 test 시작");
		FrontController frontController = new FrontController();
		frontController.mainStart();
//		LocationDAO locationDAO = new LocationDAO();
//		LocationView locationView = new LocationView();
//		
//		try {
//			List<LocationDTO> ar = locationDAO.getList();
//			locationView.view(ar);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		'--------------------Department test-------------------------------'
		DepartmentDAO departmentDAO = new DepartmentDAO();
//		DepartmentView departmentView = new DepartmentView(); //선언 객체 생성 = new 생성자호출() 중복선언이 안되는 이유는 찾아갈때 주소가 헷갈려서 
//		try {
//			DepartmentDTO departmentDTO = new DepartmentDTO();
//			departmentDTO.setDepartment_id(20);
//			departmentDTO = departmentDAO.getOne(departmentDTO);
//			DepartmentDTO departmentDTO = departmentDAO.getOne(20);
//			System.out.println(departmentDTO.getDepartment_name());
//			List<DepartmentDTO> ar = departmentDAO.getList();
//			departmentView.view(ar);
//		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//			DepartmentController dpController = new DepartmentController();
//			try {
//				dpController.start();
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		
		
		
		System.out.println("DB연동 test 끝");

	}

}
