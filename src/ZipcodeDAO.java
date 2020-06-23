import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ZipcodeDAO {
	private Connection conn = null;
	
	public ZipcodeDAO() {
		// TODO Auto-generated constructor stub
		// 데이터 연결
		String url = "jdbc:mysql://localhost:3306/project";
		String user = "root";
		String password = "123456";
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("드라이버 로딩 완료");
			conn = DriverManager.getConnection(url, user, password);
	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("[에러] : " + e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("[에러] : " + e.getMessage());
		} 
		
	}
	
	public ArrayList<String> allSido(){
		// sido 데이터 검색
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<String> datas =  new ArrayList<String>();
		try {
			String sql = "select distinct sido from zipcode";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				datas.add(rs.getString("sido"));
			}
		} catch(SQLException e) {
			System.out.println("[에러] : " + e.getMessage());
		}finally {
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
			if(rs!=null) try {rs.close();} catch(SQLException e) {}
		}
		return datas;
	}
	
	public ArrayList<String> allGugun(String sido){
		// sido 데이터 검색
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<String> datas =  new ArrayList<String>();
		try {
			String sql = "select distinct gugun from zipcode where sido like ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, sido + "%");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				datas.add(rs.getString("gugun"));
			}
		} catch(SQLException e) {
			System.out.println("[에러] : " + e.getMessage());
		}finally {
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
			if(rs!=null) try {rs.close();} catch(SQLException e) {}
		}
		return datas;
	}
	
	public ArrayList<String> allDong(String gugun){
		// sido 데이터 검색
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<String> datas =  new ArrayList<String>();
		try {
			String sql = "select distinct dong from zipcode where gugun like ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, gugun + "%");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				datas.add(rs.getString("dong"));
			}
		} catch(SQLException e) {
			System.out.println("[에러] : " + e.getMessage());
		}finally {
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
			if(rs!=null) try {rs.close();} catch(SQLException e) {}
		}
		return datas;
	}
}
