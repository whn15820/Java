package Notebook;

public class Notebook {
	String color;
	int cpu;
	public Notebook(String color, int cpu) {
		super();
		this.color = color;
		this.cpu = cpu;
	}
	public Notebook() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Notebook [color=" + color + ", cpu=" + cpu + "]";
	}
	
	

}
