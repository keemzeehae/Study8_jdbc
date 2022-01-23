package com.jihye.s1.location;

import java.util.List;

public class LocationView {
	
	public void view(LocationDTO locationDTO) {
		System.out.print(locationDTO.getLocation_id()+"\t");
		System.out.print(locationDTO.getStreet_address()+"\t");
		System.out.print(locationDTO.getPostal_code()+"\t");
		System.out.print(locationDTO.getCity()+"\t");
		System.out.print(locationDTO.getState_province()+"\t");
		System.out.println(locationDTO.getCountry_id());
		
		
	}
	
	//location table에 있는 카테고리 어떤 타입을 가지고 오면 됨
	public void view(List<LocationDTO> ar) {
		
		for(int i=0;i<ar.size();i++) {
			this.view(ar.get(i));
			System.out.println("--------------------------------------------------------------------------------");
		}
		
	
	}

}
