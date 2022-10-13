package DBHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

//import model.Employee;
import service.Package;
//import utility.JdbcUtility;
import utility.cstudy_util;
//import utility.JdbcUtility;

public class TravelAgency implements Package {

	public int AddPackage(String details)  {

		int status=0;
		try
		{
			
   //to connect with DB
	Connection connection=	cstudy_util.connect();
	String[] str=details.split(",");
	String pckgId=str[0];
	String src=str[1];
	String dest=str[2];
	int fare=Integer.parseInt(str[3]);
	int days=Integer.parseInt(str[4]);
	double discount=0;
	if(days<=5)
	{
		discount=0;
	}
	else if(days<=8)
	{
		discount=0.03*(fare*days);
	}
	else if(days<=10)
	{
		discount=0.05*(fare*days);
	}
	else
	{
		discount=0.07*(fare*days);
	}
	double amount=(((fare*days)-discount)*0.12)+(fare*days)-discount;
	int pckgcost=(int) amount;
	int count=0;
		//Creating statement object
	Statement s=	connection.createStatement(); 
	// PreparedStatement ps=prepareStatement(String sqlQuery)throws SQL exception
	//Create table Employee(emp_id int primary key, emp_name varchar(40), emp_phone bigint, emp_salary real, emp_address varchar(40));
  if(pckgId.charAt(3)=='/' && pckgId.length()==7)
  {
	PreparedStatement      ps=       connection.prepareStatement("insert into tourPackage values(?,?,?,?,?)");
	ps.setString(1, pckgId);
	ps.setString(2, src);
	ps.setString(3,dest);
	ps.setInt(4, days);
	ps.setInt(5, pckgcost);
	
		status=ps.executeUpdate();
		count+=1;
		System.out.println("Package "+count+ "Added");
  }
  else
	  System.out.println("Invalid package ID!!!!");
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		
		return status;
	}
	public int deletePckgById(String pckgId) {
		// TODO Auto-generated method stub
		try
		{
    Connection connection=	cstudy_util.connect();
   //  PreparedStatement ps= connection.prepareStatement("delete from Employee where emp_id=?");
    PreparedStatement ps= connection.prepareStatement("select * from tourPackage where package_id=?", ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
    ps.setString(1, pckgId);
    ResultSet rs=ps.executeQuery();
    // ps.executeUpdate();
    while(rs.next())
    {
    	rs.deleteRow();
    }
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return 0;
       
	}
	public void extractMinDaysPackage() {
		// TODO Auto-generated method stub
		try
		{
    Connection connection=	cstudy_util.connect();
 // PreparedStatement ps=prepareStatement(String sqlQuery)throws SQL exception
   //  PreparedStatement ps= connection.prepareStatement("delete from Employee where emp_id=?");
    PreparedStatement ps= connection.prepareStatement("select * from tourPackage order by no_of_days", ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
 //   ps.setString(1,"select MIN(no_of_days) from tourPackage");
    ResultSet rs=ps.executeQuery();
    int flag = 0,no=0;
    
    while(rs.next()) {
    	if(flag==0) {
    		no=rs.getInt(4);
    		flag=1;
    	}
    	if(rs.getInt(4)==no) {
    System.out.println(rs.getObject(1)+", "+rs.getObject(2)+", "+rs.getObject(3)+", "+rs.getObject(4)+", "+rs.getObject(5));
    }
		}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	

}
