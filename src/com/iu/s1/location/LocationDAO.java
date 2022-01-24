package com.iu.s1.location;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.iu.s1.department.DepartmentDTO;
import com.iu.s1.util.DBConnector;

public class LocationDAO {
	
	private DBConnector dbConnector;
	
	public LocationDAO(){
		dbConnector = new DBConnector();		

	}
	//부서번호로 조회
	
	public LocationDTO getOne(LocationDTO dep) throws Exception {

		LocationDTO locationDTO = null;
		
		//1. DB에 로그인
		Connection con = dbConnector.getConnect();

		//2. sql Query문 작성
		String sql = "SELECT * FROM LOCATIONS WHERE LOCATION_ID = ? " ;
		
		//3. 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		//4. ? 세팅  // 패스!
		st.setInt(1, dep.getLocation_id());
		
		//5. 최종 전송 후 결과 처리
		ResultSet rs = st.executeQuery();

		while(rs.next()) {
			
		 locationDTO = new LocationDTO();
			
			locationDTO.setLocation_id(rs.getInt("location_id"));
			locationDTO.setStreet_address(rs.getString("street_address"));
			locationDTO.setPostal_code(rs.getString("postal_code"));
			locationDTO.setState_province(rs.getString("state_province"));
			locationDTO.setCity(rs.getString("City"));
			locationDTO.setCountry_id(rs.getString("country_id"));
			
			
			
		}//while끝
		//6. 자원 해제
		rs.close();
		st.close();
		con.close();
	
		return locationDTO;
	}
	
	
	
	
	
	
	
	
	//전체 조회
	public List<LocationDTO> getList() throws Exception {

		ArrayList<LocationDTO> ar = new ArrayList<>(); 
		
		//1. DB에 로그인
		Connection con = dbConnector.getConnect();

		//2. sql Query문 작성
		String sql = "SELECT * FROM LOCATIONS";
		
		//3. 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		//4. ? 세팅  // 패스!

		//5. 최종 전송 후 결과 처리
		ResultSet rs = st.executeQuery();

		while(rs.next()) {
			
			LocationDTO locationDTO = new LocationDTO();
			
			locationDTO.setLocation_id(rs.getInt("location_id"));
			locationDTO.setStreet_address(rs.getString("street_address"));
			locationDTO.setPostal_code(rs.getString("postal_code"));
			locationDTO.setState_province(rs.getString("state_province"));
			locationDTO.setCity(rs.getString("City"));
			locationDTO.setCountry_id(rs.getString("country_id"));
			
			ar.add(locationDTO);
			
		}//while끝
		//6. 자원 해제
		rs.close();
		st.close();
		con.close();
	
		return ar;
	}
}
