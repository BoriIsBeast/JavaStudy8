package com.iu.s1.employees;

import java.util.List;



public class EmployeeView {
	public void view(EmployeeDTO employeeDTO) {
		System.out.print(employeeDTO.getEmployee_id()+"\t");
		System.out.print(employeeDTO.getFirst_name()+"\t");
		System.out.print(employeeDTO.getLast_name()+"\t");
		System.out.println(employeeDTO.getEmail()+"\t");
		System.out.println(employeeDTO.getPhone_number()+"\t");
		System.out.println(employeeDTO.getHire_date()+"\t");
		System.out.println(employeeDTO.getJob_id()+"\t");
		System.out.println(employeeDTO.getSalary()+"\t");
		System.out.println(employeeDTO.getManager_id()+"\t");
		System.out.println(employeeDTO.getDepartment_id()+"\t");
		System.out.println("----------------------------------------------------");
		
		
	}
	
	
	
	
	public void view(List<EmployeeDTO> ar) {
		//모두 출력
		for(int i = 0; i<ar.size();i++) {
			
			this.view(ar.get(i));
			System.out.println("----------------------------------------------------");
			
		}
		
		
		
	}
}

