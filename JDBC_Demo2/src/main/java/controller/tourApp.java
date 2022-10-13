package controller;

import DBHandler.TravelAgency;
import service.Package;

public class tourApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Package tservice=new TravelAgency();
		
//			tservice.AddPackage("989/CdM,Pune,Mumbai,3000,5");
//			tservice.AddPackage("123/BMS,Bangalore,Kanpur,4000,8");
//			tservice.AddPackage("456/CHM,Kolkata,Mumbai,3000,3");
//			tservice.AddPackage("989//CdHM,Hyd,Delhi,5000,9");
//			tservice.AddPackage("777CdHM,Pune,Dubai,7000,15");
//			tservice.deletePckgById("555/MUM");
//			tservice.AddPackage("444/OYE,Chandigarh,Delhi,4500,6");
//		 tservice.AddPackage("111/OCB,Chandigarh,Delhi,4500,6");
//		 tservice.AddPackage("222/OCD,Jammu,Hyd,4500,7");
//		 tservice.AddPackage("333/DEO,Chennai,Delhi,4500,11");
//		 tservice.AddPackage("555/MUM,,Delhi,4500,20");
		 tservice.AddPackage("499/CHM,delhi,pune,5000,3");
			tservice.extractMinDaysPackage();
	}

}
