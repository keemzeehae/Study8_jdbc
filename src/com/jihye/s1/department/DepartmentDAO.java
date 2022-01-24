package com.jihye.s1.department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jihye.s1.util.DBConnector;

public class DepartmentDAO {
	
	//DAO : Data Access Object
	private DBConnector dbConnector;
	
	public DepartmentDAO() {
		dbConnector = new DBConnector();
	}
	
	//부서정보, 부서에 근무하는 사원들의 정보
	public void getDEP_EMPLIST() throws Exception {
		Connection con = dbConnector.getConnect();
		
		String sql = "SELECT D.*, E.* "
				+ "FROM DEPARTMENTS D "
				+ "    INNER JOIN "
				+ "    EMPLOYEES E "
				+ "    ON(D.DEPARTMENT_ID = E.DEPARTMENT_ID)";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			
			
		}
		
		
	}
	
	//부서번호로 조회
	public DepartmentDTO getOne(DepartmentDTO dep) throws Exception {
		//초기값
		DepartmentDTO departmentDTO = null;
		
		
		//1. DB 로그인 
		Connection con = dbConnector.getConnect();
		//2. SQL Query 문 작성
		String sql = "SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID = ?" ;
		//3. Query문 미리 전송해서 DB가 준비
		PreparedStatement st = con.prepareStatement(sql);
		//4. ? 값을 세팅
		//st.set데이터타입(int index-> 물음표 갯수, 값); 
		//index는 ? 순서번호
		//그러나 oracle은 1번 부터 시작 ?
		st.setInt(1, dep.getDepartment_id());
		//5. 최종 전송 후 결과 처리
		ResultSet rs = st.executeQuery();
		//한개의 row가 있거나 없거나 커서가 맨처음부터 읽어봐야지 
		//한개의 row가 있는지 없는지 알 수 있음
		if(rs.next()) {
			//데이터가 있을 때 
			departmentDTO = new DepartmentDTO();
			departmentDTO.setDepartment_id(rs.getInt("department_id"));
			departmentDTO.setDepartment_name(rs.getString("department_name"));
			departmentDTO.setManager_id(rs.getInt("manager_id"));
			departmentDTO.setLocation_id(rs.getInt("location_id"));
			
			//departmentDTO = new DepartmentDTO();
//			departmentDTO.setDepartment_id(rs.getInt(0));??
//			departmentDTO.setDepartment_name(rs.getString(1));
//			departmentDTO.setManager_id(rs.getInt(2));
//			departmentDTO.setLocation_id(rs.getInt(3));
			
		}
		
		//6. 자원해제
		rs.close();
		st.close();
		con.close();
		return departmentDTO;
	}

	
	
	//전체조회
	public List<DepartmentDTO> getList() throws Exception {
		ArrayList<DepartmentDTO> ar = new ArrayList<>();
		
		//SELECT * FROM DEPARTMENTS;
		//1. DB로그인
		Connection con =dbConnector.getConnect();
		
		//2. SQL Query문 작성
		//Java에서는 ""안에 ; 이거 안씀 sql 문법 빼줘야함
		String sql = "SELECT * FROM DEPARTMENTS";
		
		//3. 작성한 SQL Query 미리 전송 preparedstatement
		PreparedStatement st = con.prepareStatement(sql);
		
		//4. ? 값을 세팅, 없으면 pass (통과) 
		
		//5. 최종 전송 후 결과 처리 
		ResultSet rs = st.executeQuery();
		
		//cursor가 한줄 읽는 메서드 next()리턴은 데이터가 있으면 true, 없으면 false
		while(rs.next()) {
			DepartmentDTO departmentDTO = new DepartmentDTO();
			departmentDTO.setDepartment_name(rs.getString("department_name"));
			departmentDTO.setDepartment_id(rs.getInt("department_id"));
			departmentDTO.setManager_id(rs.getInt("manager_id"));
			departmentDTO.setLocation_id(rs.getInt("location_id"));
			
			ar.add(departmentDTO);
			//6. 외부 연결 해제
			//연결된 순서의 역순
			
			
		}
		rs.close();
		st.close();
		con.close();
		return ar;
		
	}

}
