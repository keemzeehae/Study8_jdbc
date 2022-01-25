package com.jihye.s1.region;

public class RegionTest {

	public static void main(String[] args) {
		//region package 내에 있는 것만 test
	
		RegionController rc = new RegionController();
		try {
			rc.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
