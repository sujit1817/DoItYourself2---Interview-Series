//Java Concepts
/*Static and instance variable in java*/
class Employee {
    static String companyName = "Infosys";
    int salary;
}

public class Main
{
	public static void main(String[] args) {
		Employee e1 = new Employee();
		Employee e2 = new Employee();
		System.out.println(e1.companyName); 
		e1.companyName = "TCS";
		e1.salary=500;
		System.out.println("e1 companyName : "+e1.companyName+ " and salary "+e1.salary);
		//companyName is static variable so it remains same for both
		//
		System.out.println("e2 companyName : "+e2.companyName+ " and salary "+e2.salary);//0 salary
		//as salary was not shared acrorss all objects as it was instance variable not static variable
		
		Employee.companyName = "Capgemini";
		e2.salary=600;
		System.out.println("e1 companyName : "+e1.companyName+ " and salary "+e1.salary);
		System.out.println("e2 companyName : "+e2.companyName+ " and salary "+e2.salary);//0 salary
	    // here if we change static variable then it will be updated among all objects. class level
	    // but instance is not shared among all the objects. 
	    //so upon updating instance variable it was not updated for all
	    //Each Employee object has its own salary
	    
	}
	
}
/*
Infosys
e1 companyName : TCS and salary 500
e2 companyName : TCS and salary 0
e1 companyName : Capgemini and salary 500
e2 companyName : Capgemini and salary 600
  */
