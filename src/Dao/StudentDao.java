package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Entities.Student;

public class StudentDao {
	
	private ArrayList<String> DataBaseIdPwUrl(){
		
		ArrayList<String> databaseInfo = new ArrayList<>();
		String dbId = "c##tester";
		String dbPw = "1234";
		String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		
		databaseInfo.add(dbUrl);
		databaseInfo.add(dbId);
		databaseInfo.add(dbPw);
		
		return databaseInfo;
	
	}
	
	protected void findDriver() {
		
		try {	
		Class.forName("oracle.jdbc.OracleDriver");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	protected Connection connectionSet() {
		StudentDao sdthis = new StudentDao();
		Connection con = null;
		ArrayList<String> inputInfo = new ArrayList<>();
		Entities.Student sd = new Entities.Student();
		inputInfo = sdthis.DataBaseIdPwUrl();
		try {
			con = DriverManager.getConnection(inputInfo.get(0),inputInfo.get(1),inputInfo.get(2));			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public void insert(Entities.Student student) {
		StudentDao sd = new StudentDao();
		sd.findDriver();
		Connection con = sd.connectionSet();
		PreparedStatement ps = null;
		String sql = "insert into student (sdnum, name) values (studentnum_seq.nextval, ?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, student.getName());
			ps.executeUpdate();			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delete(Entities.Student student) {
		StudentDao sd = new StudentDao();
		sd.findDriver();
		Connection con = sd.connectionSet();
		PreparedStatement ps = null;
		String sql = "delete from student where name=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, student.getName());
			ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(Entities.Student student, String beforeName) {
		StudentDao sd = new StudentDao();
		sd.findDriver();
		Connection con = sd.connectionSet();
		PreparedStatement ps = null;
		String sql = "update student set name=? where name=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, student.getName());
			ps.setString(2, beforeName);
			ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selectAll() {
		StudentDao sd = new StudentDao();
		sd.findDriver();
		Connection con = sd.connectionSet();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from student";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
