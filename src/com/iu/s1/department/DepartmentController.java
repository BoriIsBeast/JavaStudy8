package com.iu.s1.department;

import java.util.List;
import java.util.Scanner;

public class DepartmentController {//DAO와 DV를 연결

	private DepartmentDAO departmentDAO;
	private DepartmentView departmentView;
	private Scanner sc;
	
	public DepartmentController() {
		
		departmentDAO = new DepartmentDAO();
		departmentView = new DepartmentView();
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
				List<DepartmentDTO> ar =departmentDAO.getList();
				departmentView.view(ar);
				
				break;
				
			case 2:
				System.out.println("검색할 부서의 번호를 입력하세요");
				DepartmentDTO departmentDTO = new DepartmentDTO();
				departmentDTO.setDepartment_id(sc.nextInt());
				
				departmentDTO = departmentDAO.getOne(departmentDTO);
				//null이 아니면 출력
				//null이면 검색에 실패하였습니다.
				departmentView.view(departmentDTO);
				
				
					
					System.out.println(departmentDTO.getDepartment_id());
					System.out.println(departmentDTO.getDepartment_name());
					System.out.println(departmentDTO.getLocation_id());
					System.out.println(departmentDTO.getManager_id());
				
				
				break;
				
			default:
				flag = false;
			
			}//switch
			
		}//while
		
		
	}
	
}
