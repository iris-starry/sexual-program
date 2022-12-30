package info.vo;

public class StudentVO {
	private int School_number; //학번
	private String name;//성명
	private int School_year;//학년
	private int School_class;//반
	private int Korean;//국어
	private int English; //영어
	private int Mathematics; //수학
	private int Science; //과학
	private int total; //총점
	private double average; //평균
	
	public StudentVO() {
		
	}
	//생성자 
	public StudentVO(int school_number, String name, int school_year, int school_class, int korean, int english,
			int mathematics, int science) {
		super();
		School_number = school_number;
		this.name = name;
		School_year = school_year;
		School_class = school_class;
		Korean = korean;
		English = english;
		Mathematics = mathematics;
		Science = science;
	}
	
	public int getSchool_number() {
		return School_number;
	}
	public void setSchool_number(int school_number) {
		School_number = school_number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSchool_year() {
		return School_year;
	}
	public void setSchool_year(int school_year) {
		School_year = school_year;
	}
	public int getSchool_class() {
		return School_class;
	}
	public void setSchool_class(int school_class) {
		School_class = school_class;
	}
	public int getKorean() {
		return Korean;
	}
	public void setKorean(int korean) {
		Korean = korean;
		
	}
	public int getEnglish() {
		return English;
	}
	public void setEnglish(int english) {
		English = english;
		
	}
	public int getMathematics() {
		return Mathematics;
	}
	public void setMathematics(int mathematics) {
		Mathematics = mathematics;
		
	}
	public int getScience() {
		return Science;
		
	}
	public void setScience(int science) {
		Science = science;
		
	}
	
	public int getTotal() {
		return total;
	}
	public void setTotal() {
		this.total = Korean+English+Mathematics+Science;
	}
	public double getAverage() {
		return average;
	}
	public void setAverage() {
		this.average = total/4.0;
	}
	@Override
	public String toString() {
		return "StudentVO [School_number=" + School_number + ", name=" + name + ", School_year=" + School_year
				+ ", School_class=" + School_class + ", Korean=" + Korean + ", English=" + English + ", Mathematics="
				+ Mathematics + ", Science=" + Science + "]";
	}
	
	
	
	
	
}
