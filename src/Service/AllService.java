package Service;

import Dao.StudentDao;
import Dao.StudentScoreDao;
import Dao.SubjectDao;
import Entities.Student;
import Entities.StudentScore;
import Entities.Subject;

public class AllService {
	StudentDao sd = new StudentDao();
	StudentScoreDao ssd = new StudentScoreDao();
	SubjectDao sjd = new SubjectDao();
	
	public void insertStudent(String name){
		Student sdEntity = new Student(name);
		sd.insert(sdEntity);
	}
	
	public void insertStudentScore(int sdnum, int sjnum, int sjscore ) {
		StudentScore ssEntity = new StudentScore(sdnum, sjnum, sjscore);
		ssd.insert(ssEntity);
	}
	
	public void insertSubject(String sjname) {
		Subject sj = new Subject(sjname);
		sjd.insert(sj.getSjname());
	}
	
	public void updateStudent(String name, String beforeName) {
		Student student = new Student(name);
		sd.update(student, beforeName);
	}
	
	public void updateStudentScore(int sdnum, int sjnum, int beforeScore, int newScore ) {
		StudentScore ss = new StudentScore(sdnum, sjnum, beforeScore);
		ssd.update(ss, newScore);
	}
	
	public void updateSubject(String sjname) {
		sjd.update(sjname);
	}
	
	public void deleteStudent(String name) {
		Student sdEntity = new Student(name);
		sd.delete(sdEntity);
	}
	
	public void deleteStudentScore(int sdnum, int sjnum, int sjscore) {
		StudentScore ssEntity = new StudentScore();
		ssd.delete(ssEntity);
	}
	
	public void deleteSubject(String sjname) {
		sjd.delete(sjname);
	}
	
	public void viewAllStudent() {
		sd.selectAll();
	}
	
	public void viewAllScore() {
		ssd.selectAll();
	}
	
	public void viewAllSubject() {
		sjd.selectAll();
	}
	
	public boolean checkSdnumSjnumSame(int sdnum, int sjnum) { //같은 학번과 같은 과목번호가 중복되면 true 중복되지 않으면 false 반환
		boolean check = ssd.checkSdnumSjnumSame(sdnum, sjnum);
		return check;
	}
	
}
