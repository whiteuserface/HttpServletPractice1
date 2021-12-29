package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Entities.StudentScore;

public class StudentScoreDao {
	
	StudentDao sd = new StudentDao();
	
	public void insert(StudentScore ss) {
		StudentScoreDao ssd = new StudentScoreDao();
		Connection con = null;
		PreparedStatement ps = null;
		
		sd.findDriver();
		con = sd.connectionSet();
		String sql = "insert into student_score(sdnum,sjnum,sjscore) values (?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, ss.getSdnum());
			ps.setInt(2, ss.getSjnum());
			ps.setInt(3, ss.getSjscore());
			ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delete(StudentScore ss) {
		StudentScoreDao ssd = new StudentScoreDao();
		Connection con = null;
		PreparedStatement ps = null;
		sd.findDriver();
		con = sd.connectionSet();
		String sql = "delete from student_score where sdnum=?, sjnum=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, ss.getSdnum());
			ps.setInt(2, ss.getSjnum());
			ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(StudentScore ss, int newScore) {
		StudentScoreDao ssd = new StudentScoreDao();
		Connection con = null;
		PreparedStatement ps = null;
		sd.findDriver();
		con = sd.connectionSet();
		String sql = "update studentscore set score=? where sdnum=?,sjnum=?";
		try {
		ps = con.prepareStatement(sql);
		ps.setInt(1, newScore);
		ps.setInt(2, ss.getSdnum());
		ps.setInt(3, ss.getSjnum());
		ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void selectAll() {
		StudentScoreDao sdd= new StudentScoreDao();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		sd.findDriver();
		con=sd.connectionSet();
		String sql = "select * from studentscore";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getInt(2));
				System.out.println(rs.getInt(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean checkSdnumSjnumSame(int sdnum, int sjnum) {
		boolean check = false;
		StudentScoreDao sdd = new StudentScoreDao();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		sd.findDriver();
		con = sd.connectionSet();
		String sql = "select sdnum, sjnum from student_score where sdnum=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, sdnum);
			rs = ps.executeQuery();
			while(rs.next()) {
				int tmpSdnum = rs.getInt(1);
				int tmpSjnum = rs.getInt(2);
				if(tmpSdnum == sdnum && tmpSjnum == sjnum) {
					check = true;
					return check;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}
}
