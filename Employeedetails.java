package Project;
import java.util.Scanner;
public class Employeedetails {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Scanner s=new Scanner(System.in);
	
		System.out.println("Welcome to EMPLOYEE MANAGEMENT SYSTEM");
		
		System.out.println("Enter the User Role");
		String role=s.nextLine();
		
		
		switch(role)
		{
			case "Employee":
			{
				System.out.println("Employee Login");
				Registration rObj=new Registration();
				rObj.insertDetails();
				rObj.viewOtherEmployeeDetails();
				break;
			}
				
			case "Admin":
			{
				System.out.println("Admin Login");
				Admin aObj=new Admin();
				System.out.println("Enter Choices");
				int ch=s.nextInt();
				
				switch(ch)
				{
					case 1:
					{
						System.out.println("Press 1 for Viewing Employee Details");
						aObj.viewEmployeeDetails();
						break;
					}
					
					case 2:
					{
						System.out.println("Press 2 for Modifications");
						aObj.modifications();
						break;
					}
					
					case 3:
					{
						System.out.println("Press 3 for Updating the designation of an Employee");
						aObj.updateDesignation();
						break;
					}
				}
				
			}
			
			
		}
		 
		
		/*System.out.println("Enter your Choice");
		int choice=s.nextInt();
		int bh=s.nextInt();
		switch(choice)
		{
		case 1:
		{
			System.out.println("Press 1 for User login");
			Registration iObj=new Registration();
			iObj.insertDetails();
			break;
		}
		
	   case 2:
		{
			System.out.println("Press 2 for  Admin login");
			Admin aobj=new Admin();
			switch(bh)
			{
			case 3:
			{
			 System.out.println("press 3 to  add new employee");
			 aobj.insertDetails();
			 break;
			}
			case 4:
			{
				System.out.println("press 4 for delete employee data");
				aobj.modifications();
				break;
			}
			case 5:
			{
				System.out.println("press 5 for update");
				aobj.modifications();
				break;
			}
			
			}
		}
		}*/
	
	/*	Registration iObj=new Registration();
		iObj.insertDetails();
*/
		
	/*	Fetchdata fObj=new Fetchdata();
		fObj.readEmployeeDetails();*/
		
	//	Admin aObj=new Admin();
		
//		aObj.updateDesignation();
		
		
		
		
	}

}
