package Cola;

public class SalariedEmployee extends ColaEmployee{
    double salary;
    public SalariedEmployee(){
        super();
    }

    public SalariedEmployee(String name, int year ,int month, int day, double salary){
        super(name,year,month,day);
        this.salary=salary;
    }

    public double getSalary(int month){
        if(month==this.month)
            salary+=100;
        return salary;
    }
}
