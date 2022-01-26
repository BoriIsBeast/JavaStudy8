package com.iu.s1.employees;

import java.util.List;
import java.util.Scanner;

public class EmployeeController {//DAO와 DV를 연결

	private EmployeeDAO employeeDAO;
	private EmployeeView employeeView;
	private Scanner sc;
	
	public EmployeeController() {
		
		employeeDAO = new EmployeeDAO();
		employeeView = new EmployeeView();
		sc = new Scanner(System.in);
		
	}
	
	
	public void start() throws Exception {//list 불러와서 출력했던것
		boolean flag = true;
		
		while(flag) {
			System.out.println("1. 부서 리스트 출력");
			System.out.println("2. 부서 번 호 검색");
			System.out.println("3. 나    가    기");
			int select = sc.nextInt();
			
			switch(select) {
			case 1:
				List<EmployeeDTO> ar =employeeDAO.getList();
				employeeView.view(ar);
				
				break;
				
			case 2:
				System.out.println("검색할 사원의 번호를 입력하세요");
				EmployeeDTO employeeDTO = new EmployeeDTO();
				employeeDTO.setEmployee_id(sc.nextInt());
				
				employeeDTO = employeeDAO.getOne(employeeDTO);
				//null이 아니면 출력
				//null이면 검색에 실패하였습니다.
				employeeView.view(employeeDTO);
				
				
					
					System.out.println(employeeDTO.getEmployee_id());
					System.out.println(employeeDTO.getFirst_name());
					System.out.println(employeeDTO.getLast_name());
					System.out.println(employeeDTO.getEmail());
					System.out.println(employeeDTO.getPhone_number());
					System.out.println(employeeDTO.getHire_date());
					System.out.println(employeeDTO.getJob_id());
					System.out.println(employeeDTO.getSalary());
				
				
				break;
				
			default:
				flag = false;
			
			}//switch
			
		}//while
		
		
	}
	
}
