package Entities;

public class StudentScore {
	private int sdnum;
	private int sjnum;
	private int sjscore;
	public int getSdnum() {
		return sdnum;
	}
	public void setSdnum(int sdnum) {
		this.sdnum = sdnum;
	}
	public int getSjnum() {
		return sjnum;
	}
	public void setSjnum(int sjnum) {
		this.sjnum = sjnum;
	}
	public int getSjscore() {
		return sjscore;
	}
	public void setSjscore(int sjscore) {
		this.sjscore = sjscore;
	}
	
	public StudentScore(int sdnum,int sjnum,int sjscore) {
		// TODO Auto-generated constructor stub
		this.sdnum = sdnum;
		this.sjnum = sjnum;
		this.sjscore = sjscore;
	}
	
	public StudentScore() {
		// TODO Auto-generated constructor stub
	}
	
}
