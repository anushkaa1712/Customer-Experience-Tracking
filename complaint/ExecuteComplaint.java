
//To Do => Implement the below code in Project's Main method before Execution of the Project.
//ExecuteComplaint ec = new ExecuteComplaint();
//	ec.executeComp();

package complaint;

import complaint.Complaint;
import java.sql.SQLException;
import java.util.Scanner;

public class ExecuteComplaint {
	
	//Execution code for Complaint Module
	void executeComp() throws SQLException {
		Scanner sc = new Scanner(System.in);
		Complaint c = new Complaint();
		
		int select;
		do {
			System.out.println("1.Register Complaint");
			System.out.println("2.View Compliant");
			System.out.println("Select No.: ");
			select = sc.nextInt();
			
			if(select == 1 || select == 2) {
				System.out.println("Enter Your Customer Id: ");
				int custId = sc.nextInt();
				
				switch(select) {
				case 1:
					
					System.out.println("Describe Your Complaint: ");
					String desc = sc.nextLine();
					c.regComp(custId, desc);
					break;
					
				case 2:
					c.viewComp(custId);
					break;
				
					}
				}
			else {
				System.out.println("Select Valid Number");
			}
			}while(select != 0);
	}
	
}
