import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CRUDDemo 
{
	
	public static Employee getEmployee(Connection conn,int employeeId)throws SQLException
	{
		PreparedStatement psmt=conn.prepareStatement("select * from Employee order by employeeId");
		psmt.setInt(1, employeeId);
		ResultSet rs=psmt.executeQuery();
		
		Employee employee=null;
		while(rs.next())
		{
			employee=new Employee();
			employee.setEmployeeId(rs.getInt(1));
			employee.setEmployeeName(rs.getString(2));
			employee.setSalary(rs.getInt(3));
			employee.setCity(rs.getString(4));
			employee.setEmailid(rs.getString(5));
			employee.setMobileno(rs.getString(6));
			employee.setAddress(rs.getString(7));
			employee.setDepartmentid(rs.getInt(8));
		}
				
		psmt.close();
		return employee;	
	}
	
	/*public static Employee updateEmployee(Connection conn,int employeeId)throws SQLException
	{
		
	}*/
	
	//update employee set employeename=?,salary=?,city=?,emailid=?,mobileno=?,address=?,departmentid=? where employeeid=?
	/*System.out.println("Do You wish to Change EmployeeName(Y/N)");
	if(choice=='Y') {
	employee.setEmployeeName(scannerObj.next());
	}*/
	
	
	public static int insertData(Connection conn,Employee employee)throws SQLException
	{
		PreparedStatement psmt=conn.prepareStatement("insert into employee values(?,?,?,?,?,?,?,?)");
		
		psmt.setInt(1, employee.getEmployeeId());
		psmt.setString(2, employee.getEmployeeName());
		psmt.setInt(3,employee.getSalary());
		psmt.setString(4,employee.getCity());
		psmt.setString(5, employee.getEmailid());
		psmt.setString(6, employee.getMobileno());
		psmt.setString(7, employee.getAddress());
		psmt.setInt(8, employee.getDepartmentid());
		
		int row_eff=psmt.executeUpdate();
		psmt.close();
		
		return row_eff;
		
	}
	
	public static int insertData(Connection conn,int employeeid)throws SQLException
	{
		PreparedStatement psmt=conn.prepareStatement("delete from Employee where employeeid=?");		
		psmt.setInt(1, employeeid);
		int row_eff=psmt.executeUpdate();
		psmt.close();
		return row_eff;
	}
	
	public static void main(String arg[])
	{
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/wave15","root","Password@123");
		
			Employee employee=new Employee();
			employee.initialize();
			
			int roweff=CRUDDemo.insertData(conn, employee);
			
			if(roweff>0)
				System.out.println("Row Inserted");
			else
				System.out.println("Error Occured");
			
		}
		catch(Exception e)
		{
			System.out.println("Exception Raised:"+e);
		}
		
	}
}
