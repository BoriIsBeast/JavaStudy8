package com.iu.s1.Region;

public class RegionTest {
	public static void main(String[] args) {
		//Region Packagee 내에 있는것만 Test
		
	RegionController regionController = new RegionController();
	
	try {
		regionController.start();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	}
}
