package com.iu.s1.location;

import java.util.List;

import com.iu.s1.department.DepartmentDTO;



public class LocationView {
	
	public void view(LocationDTO locationDTO) {
		System.out.print(locationDTO.getLocation_id()+"\t");
		System.out.print(locationDTO.getStreet_address()+"\t");
		System.out.print(locationDTO.getPostal_code()+"\t");
		System.out.print(locationDTO.getState_province()+"\t");
		System.out.print(locationDTO.getCity()+"\t");
		System.out.println(locationDTO.getCountry_id()+"\t");
		System.out.println("----------------------------------------------------");
		
		
	}
		
		
		public void view(List<LocationDTO> ar) {
			
			for(int i = 0; i<ar.size();i++) {
				
				System.out.print(ar.get(i).getLocation_id()+"\t");
				System.out.print(ar.get(i).getStreet_address()+"\t");
				System.out.print(ar.get(i).getPostal_code()+"\t");
				System.out.print(ar.get(i).getState_province()+"\t");
				System.out.print(ar.get(i).getCity()+"\t");
				System.out.println(ar.get(i).getCountry_id()+"\t");
				System.out.println("---------------------------------------------------------------");
				
			}
			
			
			
		}
	
}

