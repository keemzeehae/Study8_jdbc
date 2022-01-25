package com.jihye.s1.region;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.jihye.s1.util.DBConnector;

public class RegionDAO {
	private DBConnector dbConnector;

	public RegionDAO() {
		dbConnector = new DBConnector();
		
	}
	
	//대륙정보 수정 setupdate, name 수정 5번을 south pole
	public int setUpdate (RegionDTO regionDTO) throws Exception {
		Connection con = dbConnector.getConnect();
		String sql = "UPDATE REGIONS SET REGION_NAME =? WHERE REGION_ID = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, regionDTO.getRegion_name());
		st.setLong(2, regionDTO.getRegion_id());
		
		int result = st.executeUpdate();
		//oracle 에서 query로 변경을 해주면 결과 창에 1 행 삽입/변경/삭제 되었습니다 이런식으로 나오니까
		//여기서 int로 결과값을 받아주는 것!
	
		st.close();
		con.close();
		
		return result;
		
		
	}
	
	
	
	//대륙정보 삭제
	public int setDelete(RegionDTO regionDTO) throws Exception {
		Connection con = dbConnector.getConnect();
//		con.setAutoCommit(false);
		
		String sql = "DELETE REGIONS WHERE REGION_ID = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setLong(1, regionDTO.getRegion_id());
		int result = st.executeUpdate();
		
//		con.setAutoCommit(true);
		
		st.close();
		con.close();
		
		return result;
		
	}
	//대륙정보 추가
	public int setInsert(RegionDTO regionDTO) throws Exception {
		//1. db 연결
		Connection con = dbConnector.getConnect();
		
		//java는 기본으로 auto commit임 
		//auto commit 해제
		con.setAutoCommit(false);
		
		//2. sql문 생성
		String sql = "INSERT INTO REGIONS (REGION_ID, REGION_NAME) VALUES (?,?)";
		//3. 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		//4. ? 셋팅 
		st.setLong(1, regionDTO.getRegion_id());
		st.setString(2, regionDTO.getRegion_name());
		//5. 최종 전송 후 결과 처리
		int result = st.executeUpdate();
		
		//auto commit으로 재설정
		con.setAutoCommit(true);
		
		//6. close 연결된 자원을 해제
		st.close();
		con.close();
		
		return result;
		
	}
}

