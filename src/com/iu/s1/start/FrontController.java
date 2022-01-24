package com.iu.s1.start;

import java.util.Scanner;

import com.iu.s1.department.DepartmentController;
import com.iu.s1.employees.EmployeeController;

public class FrontController {//모든 컨트롤러 연결

	private Scanner sc;
	private DepartmentController departmentController;
	private LocationController locationController;
	private EmployeeController employeeController;
	
	public FrontController() {
		sc = new Scanner(System.in);
		departmentController = new DepartmentController();
		locationController 
		//Employee Controller
	}
	
	public void mainStart() throws Exception {
		boolean flag = true;
		
		while(flag) {
			System.out.println("1. 직 원  관 리");
			System.out.println("2. 부 서  관 리");
			System.out.println("3. 지 역  관 리");
			System.out.println("4. 프로그램 종료");
			
			int select = sc.nextInt();
			switch(select) {
			case 1:
				//employeeController의 start 메서드 호출
				break;
			case 2:
				departmentController.start(); 
				break;
			case 3:
				//LocationController의 start 메서드 호출
				break;
				
				default:
					flag = false;
			
			
			}//switch
			
			
			
		}
	}
}

