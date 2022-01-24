package com.iu.s1.start;

import com.iu.s1.department.DepartmentController;

public class StartSub {
	public static void main(String[] args) {
		
		FrontController frontController = new FrontController();
		
		try {
			frontController.mainStart();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
