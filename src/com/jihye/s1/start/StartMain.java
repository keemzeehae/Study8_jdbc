package com.jihye.s1.start;

import java.util.List;

import com.jihye.s1.department.DepartmentController;
import com.jihye.s1.department.DepartmentDAO;
import com.jihye.s1.department.DepartmentDTO;
import com.jihye.s1.department.DepartmentView;
import com.jihye.s1.location.LocationDAO;
import com.jihye.s1.location.LocationDTO;
import com.jihye.s1.location.LocationView;
import com.jihye.s1.region.RegionDAO;
import com.jihye.s1.region.RegionDTO;
import com.jihye.s1.util.DBConnector;

public class StartMain {

	public static void main(String[] args) {
		System.out.println("DB연동 test 시작");
		FrontController frontController = new FrontController();
		
		try {
			frontController.mainStart();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		System.out.println("DB연동 test 끝");

	}

}
