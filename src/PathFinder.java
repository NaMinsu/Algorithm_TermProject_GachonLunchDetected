import java.sql.*;

public class PathFinder {
	private String startPoint;
	private String destination;
	private Food recommanded;
	private RoadMap map;
	
	public PathFinder(String start, Food f) {
		startPoint = start;
		recommanded = f;
		map = new RoadMap();
		
		// open database
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/timeLocker_DB";
			String user = "root", password = "zmfhzjm0";
			con = DriverManager.getConnection(url, user, password);
			System.out.println(con);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// main operation
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = null;
			String sql = "select store_location from store where store_location_no = "
					+ "'" + recommanded.getStore_id() + "'";
			rs = stmt.executeQuery(sql);
			
			if (rs.next())
				destination = rs.getString(1);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		// close database
		try {
			if (con != null && !con.isClosed())
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// close database
		try {
			if (con != null && !con.isClosed())
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String[] findShortestWay() {
		map.setStartAndEnd(startPoint, destination);
		String[] result = map.dijkstra();
		
		return result;
	}
}
