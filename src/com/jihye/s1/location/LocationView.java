package com.jihye.s1.location;

import java.util.List;

public class LocationView {
	
	//location table에 있는 카테고리 어떤 타입을 가지고 오면 됨
	public void view(List<LocationDTO> ar) {
		
		for(int i=0;i<ar.size();i++) {
			System.out.print(ar.get(i).getLocation_id()+"\t");
			System.out.print(ar.get(i).getStreet_address()+"\t");
			System.out.print(ar.get(i).getPostal_code()+"\t");
			System.out.print(ar.get(i).getCity()+"\t");
			System.out.print(ar.get(i).getState_province()+"\t");
			System.out.println(ar.get(i).getCountry_id());
			System.out.println("--------------------------------------------------------------------------------");
		}
		
	}

}
