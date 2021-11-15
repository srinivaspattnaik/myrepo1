import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DisplayTable 
{
	public static void main(String arg[]) {
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/wave15","root","Password@123");
			
			Statement statementObj=conn.createStatement();
			ResultSet rs=statementObj.executeQuery("select * from Employee");
			
			//ArrayList<Employee> employeeList=new ArrayList<Employee>();
			
			while(rs.next())
			{
				//Employee employee=new Employee();
				//employee.setEmployeeId(rs.getInt(1));
				System.out.printf("%-10s",rs.getString(1));
				System.out.printf("%-10s",rs.getString(2));
				System.out.printf("%-10s",rs.getString(3));
				System.out.printf("%-10s",rs.getString(4));
				System.out.printf("%-30s",rs.getString(5));
				System.out.printf("%-15s",rs.getString(6));
				System.out.printf("%-18s",rs.getString(7));
				System.out.println(rs.getString(8));
				//employeeList.add(employee);
			}
			
			System.out.println("Enter Key to clear screen");
			String s=new Scanner(System.in).next();
			
			try {
			final String os = System.getProperty("os.name");  
				if (os.contains("Windows"))  
				{  
					Runtime.getRuntime().exec("cls");  
				}  
			}  
			catch(final Exception e){  
			e.printStackTrace();  
			}  
			
			System.out.println("I am in top");
			
			statementObj.close();
			conn.close();
		}
		catch(ClassNotFoundException ce){
		System.out.println("Exception Arised:"+ce);
		}
		catch(SQLException se){
		System.out.println("Exception Arised:"+se);
		}
		
	}
}
