package com.iu.s1.Region;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.iu.s1.util.DBConnector;

public class RegionDAO {

	private DBConnector dbConnector;

	public RegionDAO() {

		dbConnector = new DBConnector();

	}
	
	//대륙정보 수정 setUpdate, name 수정
	public int setUpdate(RegionDTO reg) throws Exception {
		Connection con = dbConnector.getConnect();
		
		String sql = "update regions set Region_name = ? where region_id = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, reg.getRegion_name());
		st.setLong(2, reg.getRegion_id());
		
		int result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
		
		
		
		
		
	}
	
	
	//대륙정보 삭제
	public int setDelete(RegionDTO reg) throws Exception {
		Connection con = dbConnector.getConnect();
		
		String sql = "delete Regions where Region_id = ?";
				
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setLong(1, reg.getRegion_id());
		
		int result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}

	//대륙정보 추가
	public int setInsert(RegionDTO reg) throws Exception {
		//1. DB 연결
		Connection con = dbConnector.getConnect();
		
		//java는 기본적으로 auto commit 임
		
		//auto commit 해제
		con.setAutoCommit(false);
		
		//2. sql query문 작성
		String sql = "insert into regions (region_id,region_name) values (?,?)";
		//3. 미리 보내기
		PreparedStatement st = con.prepareStatement(sql);
		//4. ? 세팅
		st.setLong(1,reg.getRegion_id());
		st.setString(2, reg.getRegion_name());
		
		//5. 최종 전송 후 결과 처리
		int result =st.executeUpdate();

		//auto commit 으로 재설정
		con.setAutoCommit(true);
		
		
		//6. 자원 해제
		st.close();
		con.close();
		
		return result;




	}

	//검색조회
	//전체조회


}
