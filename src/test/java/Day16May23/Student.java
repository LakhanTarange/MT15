package Day16May23;

public class Student {
	Student() {
		System.out.println("user defined 0 argument constructor....");
	}

	Student(int age) {
		System.out.println("user defined 1 argument constructor....");
	}

	Student(int age, String name) {
		System.out.println("user defined 2 argument constructor....");
	}

	static {
		System.out.println("Static block#1");
	}
	static {
		System.out.println("Static block#2");
	}

	{
		System.out.println("instance block");
	}

	int age;
	protected String name;

	void learning() {
		System.out.println("Students learn");
	}

	boolean getResult()

	{
		return true;
	}

	public static void main(String[] args) {
		Student s = new Student(20);

	}
}
