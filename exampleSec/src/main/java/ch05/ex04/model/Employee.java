package ch05.ex04.model; 

public class Employee extends Person {
	private static final long serialVersionUID = 1L;
	int  empID ;

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	} 
}
