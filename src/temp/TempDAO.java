package temp;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TempDAO {
	private static TempDAO tempDAO=null;
	private String url ="jdbc:oracle:thin:@192.168.0.11:1521:orcl";
	private String DBID="MJ";
	private String DBPW="0413";
	private TempDAO() {
		//1. 드라이버 로딩
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static TempDAO getInstance() {
		
		if(tempDAO==null) {
			tempDAO = new TempDAO();
		}
		return tempDAO;
	}
	public void insert(TempVO vo) throws SQLException {
		//2.연결객체 얻어오기
		Connection con = DriverManager.getConnection(url,DBID,DBPW);
		//3.SQL문장 (insert문)
		String SQL="INSERT INTO SIGNUP(ID,PASS,NAME,TEL,ADDR) VALUES(?,?,?,?,?)";
		//4.전송객체 얻어오기(PreparedStatement)+? 지정까지
		PreparedStatement st = con.prepareStatement(SQL);
		//5.전송()
		st.setString(1,vo.getId());
		st.setString(2,vo.getPass());
		st.setString(3,vo.getName());
		st.setString(4,vo.getTel());
		st.setString(5,vo.getAddr());
		
		st.executeUpdate();
		
		//6.닫기
		st.close();
		con.close();
	}
	/*
	 * 메소드명	: login
	 * 매개변수	: TempVO
	 * 리턴형  	: boolean
	 * 역할 		: 아이디와 패스워드를 받아서 해당 데이터를 존재하는지 확인 후 boolean return
	 */
	public boolean login(TempVO vo) throws SQLException {
		Connection con = DriverManager.getConnection(url,DBID,DBPW);
		String SQL="SELECT id,pass FROM signup WHERE id = ? AND pass = ?";
		//4.전송객체 얻어오기(PreparedStatement)+? 지정까지
		PreparedStatement st = con.prepareStatement(SQL);
		st.setString(1, vo.getId());
		st.setString(2, vo.getPass());
		int result = st.executeUpdate();
		//5.전송()
		st.close();
		con.close();
		
		if(result == 1)
			return true;
		else
			return false;
	}

}
