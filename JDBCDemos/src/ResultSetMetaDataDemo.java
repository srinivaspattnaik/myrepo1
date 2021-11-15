import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetMetaDataDemo 
{
	public static void main(String arg[])
	{
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/wave15","root","Password@123");
			
			Statement statementObj=conn.createStatement();
			ResultSet rs=statementObj.executeQuery("select * from Employee");
			
			ResultSetMetaData rsmd=rs.getMetaData();
			
			int noOfColumns=rsmd.getColumnCount();
			
			for(int colIndex=1;colIndex<=noOfColumns;colIndex++)
			{
				System.out.print(rsmd.getColumnTypeName(colIndex)+"\t");
			}
			
			System.out.println();
			
			for(int colIndex=1;colIndex<=noOfColumns;colIndex++)
			{
				System.out.print(rsmd.getColumnName(colIndex)+"\t");
			}
			
			System.out.println();
			
			while(rs.next())
			{
				for(int colIndex=1;colIndex<=noOfColumns;colIndex++)
				{
					if(rsmd.getColumnTypeName(colIndex).equals("INT"))
						System.out.print(rs.getInt(colIndex)+"\t");
					else
						System.out.print(rs.getString(colIndex)+"\t");
				}
				System.out.println();
			}
			
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
