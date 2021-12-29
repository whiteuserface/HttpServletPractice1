package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SubjectDao {
	
	StudentDao sd = new StudentDao();
	
	protected void findDriver(){
		sd.findDriver();
	}
	
	protected Connection connectionSet() {
		Connection con = null; 
		con = sd.connectionSet();
		return con;
	}
	
	public void insert(String sjname) {
		SubjectDao sd = new SubjectDao();
		Connection con = null;
		PreparedStatement ps = null;
		sd.findDriver();
		con = sd.connectionSet();
		String sql = "insert into subject(sjnum, sjname) values (sjnum_seq.nextval, ?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, sjname);
			ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			if(ps != null) {
				try {
					ps.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public void update(String sjname) {
		
		SubjectDao sd = new SubjectDao();
		Connection con = null;
		PreparedStatement ps = null;
		sd.findDriver();
		sd.connectionSet();
		String sql = "update subject set sjname where sjname=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, sjname);
			ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			if(ps != null) {
				try {
					ps.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void delete(String sjname) {
		SubjectDao sd = new SubjectDao();
		PreparedStatement ps = null;
		Connection con = null;
		sd.findDriver();
		con = sd.connectionSet();
		String sql = "delete from subject where sjname=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, sjname);
			ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			if(ps != null) {
				try {
					ps.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void selectAll() {
		SubjectDao sd = new SubjectDao();
		PreparedStatement ps = null;
		Connection con = null;
		ResultSet rs = null;
		sd.findDriver();
		con = sd.connectionSet();
		String sql = "select * from subject";
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
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			if(ps != null) {
				try {
					ps.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			if(rs != null) {
				try {
					rs.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	
	
}
