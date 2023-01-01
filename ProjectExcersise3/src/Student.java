
public class Student {
	
	int ID;
	String fName;
	String lName;
	int Type;
	
	//Grades
	double Midterm;
	double final_exam;
	double Research_paper;
	double presentation;
	
	
	public Student(int iD, String fName, String lName, int type, double midterm, double final_exam,
			double research_paper, double presentation) {
		super();
		ID = iD;
		this.fName = fName;
		this.lName = lName;
		Type = type;
		Midterm = midterm;
		this.final_exam = final_exam;
		Research_paper = research_paper;
		this.presentation = presentation;
	}


	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}


	public String getfName() {
		return fName;
	}


	public void setfName(String fName) {
		this.fName = fName;
	}


	public String getlName() {
		return lName;
	}


	public void setlName(String lName) {
		this.lName = lName;
	}


	public int getType() {
		return Type;
	}


	public void setType(int type) {
		Type = type;
	}


	public double getMidterm() {
		return Midterm;
	}


	public void setMidterm(double midterm) {
		Midterm = midterm;
	}


	public double getFinal_exam() {
		return final_exam;
	}


	public void setFinal_exam(double final_exam) {
		this.final_exam = final_exam;
	}


	public double getResearch_paper() {
		return Research_paper;
	}


	public void setResearch_paper(double research_paper) {
		Research_paper = research_paper;
	}


	public double getPresentation() {
		return presentation;
	}


	public void setPresentation(double presentation) {
		this.presentation = presentation;
	}


	@Override
	public String toString() {
		return "Student [ID=" + ID + ", fName=" + fName + ", lName=" + lName + ", Type=" + Type + ", Midterm=" + Midterm
				+ ", final_exam=" + final_exam + ", Research_paper=" + Research_paper + ", presentation=" + presentation
				+ "]";
	}
	
	
	
}
