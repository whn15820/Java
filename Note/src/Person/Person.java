package Person;

 public class Person {
	String name;
	double height;
	double weight;
	
	
	public Person(String name, double height, double weight) {
		super();
		this.name = name;
		this.height = height;
		this.weight = weight;
	}
	

	public void sayHello(){
		System.out.println("hello, my name is "+name);
	}
	
}
