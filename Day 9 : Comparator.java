Comparable vs Comparator

1. Comparable (Natural Sorting DNSO)

use when class has one natural sorting order
and sorting logic is inside the class

Sort employee By IdAssignmentPolicy

class Employee implements Comparable<Employee> {
	int id;
	String name;
	
	Employee(int id, String name){
		this.id = id;
		this.name = name;
	}
	
	@Override
	public int compareTo(Employee e){
		return this.id - e.id; //ascending order by id
	}
	
	@Override
	public String toString(){
		return id+ " " +name;
	}
	
	
}

public class Main{
	public static void main(String args[]){
		List<Employee> list = new ArrayList<>();
		list.add(new Employee(3, "A"));
		list.add(new Employee(1, "B"));
		list.add(new Employee(2, "C"));
		
		Collections.sort(list);
		System.out.println(list);
	}
}

2️. Comparator (Custom / Multiple Sorting)
When to use?

When multiple sorting strategies are needed

When you cannot modify the class

class NameComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee e1, Employee e2) {
        return e1.name.compareTo(e2.name);
    }
}
Collections.sort(list, new NameComparator());
System.out.println(list);

Collections.sort(list, (e1, e2) -> e1.name.compareTo(e2.name));
Collections.sort(list, (e1, e2) -> e2.id - e1.id);

| Result | Meaning                |
| ------ | ---------------------- |
| `< 0`  | e1 comes **before** e2 |
| `0`    | equal                  |
| `> 0`  | e1 comes **after** e2  |


🧠 Quick Memory Trick
e1.compareTo(e2) → Ascending
e2.compareTo(e1) → Descending
