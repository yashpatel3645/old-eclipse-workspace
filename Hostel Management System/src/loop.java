import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class loop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i;
		for(i=61;i<=90;i++)
		{
			try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","System","yash");
			Statement st = con.createStatement();
			int rs = st.executeUpdate("update yashdb.room set status=2 where roomid='"+i+"')");

			}
			catch(Exception ep)
			{
				
			}
	}

}
}
