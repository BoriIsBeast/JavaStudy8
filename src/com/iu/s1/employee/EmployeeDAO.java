package com.iu.s1.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.iu.s1.util.DBConnector;

public class EmployeeDAO {

	private DBConnector dbConnector;

	public EmployeeDAO() {//생성자
		dbConnector = new DBConnector();


	}

public EmployeeDTO getOne(EmployeeDTO dep) throws Exception {
		
	EmployeeDTO employeeDTO = null;
		
		//1. DB에 로그인
		Connection con = dbConnector.getConnect();
	
		//2. sql Query문 작성
		
		String sql = "SELECT * FROM Employees WHERE Employee_id = ? " ;
		
		//3. Query문 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		//4. ? 값을 세팅 (생략가능)
		//st.set데이터타입(int index, 값); 
		// index 는 ?의 순서번호
		//그러나 oracle은 1번부터 시작
		st.setInt(1, dep.getEmployee_id());
		
		//5. 최종 전송 후 결과 처리
		ResultSet rs =st.executeQuery();
		//1 row가 있거나 없거나
		if(rs.next()) {
			//데이터가 있을 때
			employeeDTO = new EmployeeDTO();
			employeeDTO.setEmployee_id(rs.getInt("employee_id"));
			employeeDTO.setFirst_name(rs.getString("first_name"));
			employeeDTO.setLast_name(rs.getString("last_name"));
			employeeDTO.setEmail(rs.getString("email"));
			employeeDTO.setPhone_number(rs.getString("phone_number"));
			employeeDTO.setHire_date(rs.getString("hire_date"));
			employeeDTO.setJob_id(rs.getString("job_id"));
			employeeDTO.setSalary(rs.getInt("salary"));
			employeeDTO.setCommission_pct(rs.getDouble("commission_pct"));
			employeeDTO.setManager_id(rs.getInt("manager_id"));
			employeeDTO.setDepartment_id(rs.getInt("department_id"));
			
		}
			
		
		//6. 자원 해제
		rs.close();
		st.close();
		con.close();
		
		return employeeDTO;
	}

	public List<EmployeeDTO> getList() throws Exception {//보낼때는 linkedList가 될 수 있으므로 가급적 list 타입으로 보낼것!
		ArrayList<EmployeeDTO> ar = new ArrayList<>();
		
		//SELECT * FROM DEPARTMENTS;
		//1. DB 로그인
		Connection con = dbConnector.getConnect();

		//2. SQL Query 문 작성
		//   JAVA에서는 끝에 ; 제외
		String sql = "SELECT * FROM Employees";
		
		//3. 작성한 SQL Query 미리 전송
		 PreparedStatement st = con.prepareStatement(sql);
		 
		 //4. ?값을 세팅, 없으면 통과
		 
		 //5. 최종 전송 후 결과 처리
		 ResultSet rs = st.executeQuery();
		 
		 //cursor가 한줄 읽는 메서드 next() 리턴은 데이터가 있으면 true, 없으면 false
		 while (rs.next()) {
			
			 
			EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO = new EmployeeDTO();
			employeeDTO.setEmployee_id(rs.getInt("employee_id"));
			employeeDTO.setFirst_name(rs.getString("first_name"));
			employeeDTO.setLast_name(rs.getString("last_name"));
			employeeDTO.setEmail(rs.getString("Email"));
			employeeDTO.setPhone_number(rs.getString("Phone_number"));
			employeeDTO.setHire_date(rs.getString("Hire_date"));
			employeeDTO.setJob_id(rs.getString("Job_id"));
			employeeDTO.setSalary(rs.getInt("salary"));
			employeeDTO.setCommission_pct(rs.getDouble("Commission_pct"));
			employeeDTO.setManager_id(rs.getInt("Manager_id"));
			employeeDTO.setDepartment_id(rs.getInt("Department_id"));
			 
			//arrayList
			ar.add(employeeDTO);
			
			
			
		}
		 //6. 외부 연결 해제
		 //	  연결된 순서의 역순
		 rs.close();
		 st.close();
		 con.close();
		 return ar;
	}
}