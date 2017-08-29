package Cola;

public abstract class ColaEmployee {
    String name;
    int year;
    int month;
    int day;
    public ColaEmployee() {
        super();
    }

    public ColaEmployee(String name,int year,int month ,int day) {
        super();
        this.name=name;
        this.year=year;
        this.month=month;
        this.day=day;
    }

     abstract double getSalary(int month);

}
