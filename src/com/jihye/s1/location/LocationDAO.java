package com.jihye.s1.location;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jihye.s1.util.DBConnector;

public class LocationDAO {
	
	//1. DB에 로그인
	private DBConnector dbConnector;
	
	public LocationDAO() {
		dbConnector = new DBConnector();
	}
	//지역 번호로 조회
	public LocationDTO getOne(LocationDTO loc) throws Exception {
		LocationDTO locationDTO = null;
		
		//1. db 로그인
		Connection con = dbConnector.getConnect();
		//2. query문 작성
		String sql = "SELECT * FROM LOCATIONS WHERE LOCATION_ID = ?";
		//3. QUERY문 미리 전송해서 DB가 준비
		PreparedStatement st = con.prepareStatement(sql);
		//4. ? 값을 세팅
		//st.set데이터타입(int index, 값); 
		// index 는 ?의 순서번호
		//그러나 oralce은 1번 부터 시작
		st.setInt(1, loc.getLocation_id());
		
		//5. 최종전송 후 결과 처리
		ResultSet rs = st.executeQuery();
		//1. row가 있거나 없거나
		if(rs.next()) {
			//데이터가 있을때
			locationDTO = new LocationDTO();
			locationDTO.setLocation_id(rs.getInt("location_id"));
			locationDTO.setStreet_address(rs.getString("street_address"));
			locationDTO.setPostal_code(rs.getString("postal_code"));
			locationDTO.setCity(rs.getString("city"));
			locationDTO.setState_province(rs.getString("state_province"));
			locationDTO.setCountry_id(rs.getString("country_id"));
			
			
		}
		rs.close();
		st.close();
		con.close();
		
		return locationDTO;
		
	}
	
	public List<LocationDTO> getList() throws Exception {
		ArrayList<LocationDTO> ar = new ArrayList<>();
		
		Connection con = dbConnector.getConnect();
		
		//2. Sql Query 문 작성
		String sql ="SELECT * FROM LOCATIONS";
		//3. Query문 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		
		
		//4. ? 세팅 통과
		
		//5. 최종 전송 후 결과 처리
		ResultSet rs= st.executeQuery();
		
		//cursor가 한줄 읽는 메서드 next() 리턴은 데이터가 있으면 true, 없으면 false
		while(rs.next()) {
			LocationDTO locationDTO = new LocationDTO();
			locationDTO.setLocation_id(rs.getInt("location_id"));
			locationDTO.setStreet_address(rs.getString("street_address"));
			locationDTO.setPostal_code(rs.getString("postal_code"));
			locationDTO.setCity(rs.getString("city"));
			locationDTO.setState_province(rs.getString("state_province"));
			locationDTO.setCountry_id(rs.getString("country_id"));
			
			ar.add(locationDTO);
			
			
		}
		//6. 자원 해제
		
		rs.close();
		st.close();
		con.close();
		return ar;
	}
	

}
