package lab2.common;

public class Person {
	private String name;
	public Person() {
		this.name = "N/A";
	}
	public Person(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public String toString() {
		return "\nName: " + name;
	}
}
