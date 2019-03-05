package Project;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;


public class Registration 
{
	
	PreparedStatement pstm;
	Connection con=	Createconnection.createConnection();
	public void insertDetails()  throws Exception
	{
		 Scanner s=new Scanner(System.in);
		 
		// System.out.println("Enter employee id");
		 //int eid=s.nextInt();
		 
		 System.out.println("Enter First Name");
		 String firstName=s.nextLine();
		 
		 System.out.println("Enter Last Name");
		 String lastName=s.nextLine();
		 
		 System.out.println("Enter DOB");
		 String dob=s.nextLine();
		 
		 System.out.println("Enter Gender");
		 String gender=s.nextLine();
		 
		 System.out.println("Enter Email ID");
		 String email_id=s.nextLine();
		 
		 System.out.println("Enter Password");
	     String pass=s.nextLine();
	     
	     System.out.println("Re-enter your Password");
		 String conf_pass=s.nextLine();
		 
		 System.out.println("Enter Phone Number");
		 String phone_number=s.nextLine();
		 
		 System.out.println("Enter Address");
		 String address=s.nextLine();
		 
		 System.out.println("Enter Skill Set");
		 String skills=s.nextLine();
		 
		 System.out.println("Enter Designation");
		 String designation=s.nextLine();
		 
		 System.out.println("Enter Salary");
		 int salary=s.nextInt();
		try
		{
			String query = " insert into employee (First_Name, Last_Name, DOB, Gender, Email_Id,Pass,Conf_Pass, Phone_Number, Address,Skills,Designation, Salary)"
			        + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			 
			// create the mysql insert preparedstatement
			
		      pstm = con.prepareStatement(query);
		    //  pstm.setInt(1,eid);
		      pstm.setString (1, firstName);
		      pstm.setString (2, lastName);
		      pstm.setDate(3, java.sql.Date.valueOf(dob));
		      pstm.setString(4,gender);
		      pstm.setString(5, email_id);
		      pstm.setString (6, pass);
		      pstm.setString (7, conf_pass);
		      pstm.setString(8,phone_number);
		      pstm.setString(9,address);
		      pstm.setString(10,skills);
		      pstm.setString(11,designation); 
		      pstm.setInt(12, salary);
		   

		      // execute the preparedstatement
		      pstm.execute();
		      
		      con.close();
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	

}
