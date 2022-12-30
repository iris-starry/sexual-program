package info.vo;

import java.util.ArrayList;

public class StudentDAO {
	ArrayList<StudentVO> stuvoList = new ArrayList<StudentVO>();
	
	public void insert(StudentVO svo) {
		stuvoList.add(svo);
	}
	
	public ArrayList<StudentVO> select(){
		return stuvoList;
	}
	
	public void delete(int row) {
		stuvoList.remove(row);
	}
}
