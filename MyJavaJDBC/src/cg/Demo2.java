package cg;
import java.sql.*;

public class Demo2 {

	public static void main(String[] args)throws SQLException {
		//Load driver
		try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
			}
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="hr";
		String pass="hr";
		Connection con=DriverManager.getConnection(url,user,pass); 
		System.out.println("Connected");
		Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//used to pass sql queries
		ResultSet rs=st.executeQuery("select * from account");
		rs.afterLast();//moves the cursor after last record
		while(rs.previous())
		{
			int a_id=rs.getInt("aid");
			long mobile=rs.getLong("mobileno");
			String ah=rs.getString(3);
			double bal=rs.getDouble(4);
			System.out.println("======================================================================");
			System.out.println(" Account Id: "+a_id+" | Mobile: "+mobile+" | Name: "+ah+" | Balance: "+bal);
			System.out.println("======================================================================");
		}
		con.close();
	}

}
