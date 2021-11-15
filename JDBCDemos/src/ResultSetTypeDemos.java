import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetTypeDemos 
{
	public static void main(String arg[])
	{
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/wave15","root","Password@123");
			
			Statement statementObj=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
			ResultSet rs=statementObj.executeQuery("select * from Employee");
			
			while(rs.next())
			{
				System.out.print(rs.getString(1)+"\t");
				System.out.print(rs.getString(2)+"\t");
				System.out.print(rs.getString(3)+"\t");
				System.out.print(rs.getString(4)+"\t");
				System.out.print(rs.getString(5)+"\t");
				System.out.print(rs.getString(6)+"\t");
				System.out.print(rs.getString(7)+"\t");
				System.out.println(rs.getString(8));
				
			}
			
			System.out.println("\n==============================================\n");
			
			while(rs.previous())
			{
				System.out.print(rs.getString(1)+"\t");
				System.out.print(rs.getString(2)+"\t");
				System.out.print(rs.getString(3)+"\t");
				System.out.print(rs.getString(4)+"\t");
				System.out.print(rs.getString(5)+"\t");
				System.out.print(rs.getString(6)+"\t");
				System.out.print(rs.getString(7)+"\t");
				System.out.println(rs.getString(8));
				
			}
			
			rs.moveToInsertRow();
			rs.updateInt(1, 1005);
			rs.updateString(2,"Karthik");
			rs.updateInt(3,39000);
			rs.updateString(4,"Hyderabad");
			rs.updateString(5,"karthik@gmail.com");
			rs.updateString(6,"9981215656");
			rs.updateString(7,"Ameerpet");
			rs.updateInt(8,1002);
			rs.insertRow();
			
			
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
