import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
public class SQLEx {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			System.out.println("driver accepted");
			Connection con=DriverManager.getConnection("jdbc:sqlserver://localhost\\sqlexpress;database=niitproject","sa","sa@123");
			//Connection con=DriverManager.getConnection("JDBC:ODBC:bb");
			System.out.println("Vanakkam");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from student");
			
			int numCols=rs.getMetaData().getColumnCount();
			System.out.println("Total colums:"+numCols);
			
			String[] colNames=new String[numCols+1];
			
			for(int i=0;i<numCols;i++)
			{
				colNames[i]=rs.getMetaData().getColumnName(i+1);
				System.out.println("col names "+colNames[i]);
			}
			
			for(int i=1;i<=numCols;i++)
			{
				colNames[i]=rs.getMetaData().getColumnName(i);
				System.out.println("col names "+colNames[i]);
			}

			while(rs.next())
			{
				System.out.print("  "+rs.getInt(1));
				System.out.print(" "+rs.getString(2));
				System.out.println("  "+rs.getInt(3));
			}
			rs.close();
			st.close();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println("error :"+e.toString());
		}

	}
}

