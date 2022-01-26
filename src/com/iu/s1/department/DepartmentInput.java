package com.iu.s1.department;

import java.util.Scanner;

import com.iu.s1.Region.RegionDTO;

public class DepartmentInput {
	private Scanner sc;
	public DepartmentInput() {
		sc = new Scanner(System.in);
		
		
	}
	
	public DepartmentDTO setDelete() {
		DepartmentDTO departmentDTO = new DepartmentDTO();
		
		System.out.println("삭제할 Department_ID 입력 ");
		departmentDTO.setDepartment_id(sc.nextInt());
		
		return departmentDTO;
	}
	public DepartmentDTO setInsert(){
		DepartmentDTO departmentDTO = new DepartmentDTO();
		System.out.println("입력할 Department_ID 입력 ");
		departmentDTO.setDepartment_id(sc.nextInt());
		System.out.println("입력할 Department_NAME 입력 ");
		departmentDTO.setDepartment_name(sc.next());
		
		return departmentDTO;
	}

}
