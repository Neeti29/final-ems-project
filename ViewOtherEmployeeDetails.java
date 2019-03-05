package Project;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;


public class ViewOtherEmployeeDetails
{
	Statement stm;
	try
		{
			Connection con=	Createconnection.createConnection();
			stmt=con.createStatement();  
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