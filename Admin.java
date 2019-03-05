package Project;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;


public class Admin 
{
	
	PreparedStatement pstm;
	Statement stm;
	Connection con=	Createconnection.createConnection();
	Scanner s=new Scanner(System.in);
	
	void modifications() throws Exception
	{
		//stmt = con.createStatement();
		con.setAutoCommit(false);
		
		try
		{
			
			String sqlUpdate="UPDATE Department " + "SET Dept_Name=?" + "WHERE D_Id = ?";
			pstm=con.prepareStatement(sqlUpdate);
			
			Scanner s=new Scanner(System.in);
			
			System.out.println("Enter Department ID:");
			int deptId=s.nextInt();  
			
			
			System.out.println("Enter new Department");
			String dept_name =s.nextLine(); 
			
			pstm.setString(2, dept_name);
			pstm.setInt(1,deptId);
			
			int rowAffected=pstm.executeUpdate();
			System.out.println("Row Affected" + rowAffected);
			System.out.println("Updated Successfully");
			
			//Delete Operation
			
			//int i3= stmt.executeUpdate("Delete from Project where D_Id = 12");
			String sqlDelete = "DELETE FROM Project where D_ID = ?";
            pstm = con.prepareStatement(sqlDelete);
			
			
			pstm.setInt(1, deptId);
			int del = pstm.executeUpdate();
			System.out.println("Number of deleted records: " + del);
			System.out.println("The Employee is released from the Project");
			
			con.commit();
			
			System.out.println(" Success !!");
			
		}
		catch(Exception e)
		{
			
			try
			{
				con.rollback();
				System.out.println(" Failed,please try again !");
			}
			
			catch(Exception ex)
			{
				System.out.println(ex);
			}
		}
		
		pstm.close();
		con.close();
		System.out.println("Connection is closed");
		
	}
	
	void updateDesignation() throws Exception
	{
		try{
			Connection con=	Createconnection.createConnection();
			Statement stmt=con.createStatement();  
			
			System.out.println("Enter employee id");
			String empId=s.nextLine();
			
			System.out.println("Enter new Employee Designation");
		    String newDesg=s.nextLine();

			ResultSet rs=stmt.executeQuery("Select Salary from employee where E_Id="+empId);
			while(rs.next())
			{
				int sal=rs.getInt("Salary");
			}
			
			int updatedSal=sal+(sal*20)/100;
			String sqlUpdate="UPDATE employee " + "SET Salary =updatedSal and Designation=newDesg" + "WHERE E_Id = empId";  
			pstm=con.prepareStatement(sqlUpdate);
			pstm.setInt(12,updatedSal);
			
			System.out.println("Salary updated for the Employee and employee gets prompoted");
			
			con.close();
		}
		
		catch
		{
			System.out.println(e.getMessage());
		}
		
	/*	System.out.println("Enter employee id");
		String empId=s.nextLine();
		int sal;
		
		int salary="Select Salary from employee where E_Id="+empId;
		rs.get
		
		System.out.println("Enter new Employee Designation");
		String desg=s.nextLine();
		
		
			int updatedSal=Salary+(Salary*20)/100;
			String sqlUpdate="UPDATE employee " + "SET Salary =updatedSal and Designation=desg" + "WHERE E_Id = empId";  */
	}
	
	void viewEmployeeDetails() throws Exception
	{
		try
		{
			Connection con=	Createconnection.createConnection();
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("Select * from employee e INNER JOIN department d on e.E_Id=d.E_Id");
			System.out.println("Neeti"+stmt);
			while(rs.next())
			{
				/*System.out.println(rs.getInt(1)+ " " +rs.getString(2)+ " " + rs.getString(3) + " " + rs.getDate(4) + " "+ rs.getCharacterStream(5) + " "+rs.getString(6)+ " " +rs.getString(7)+ " "+ rs.getString(8)+ " "+rs.getInt(9)+ " "+rs.getBlob(10));  */
				
				System.out.println(rs.getInt("E_Id")+ " " +rs.getString("First_Name")+ " " + rs.getString("Dept_Name"));
			}
			con.close();
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}

