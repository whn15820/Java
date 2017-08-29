package Cola;

public class HourlyEmployee extends ColaEmployee{
    double hourSalary;
    int hour;

    public HourlyEmployee() {
        super();
    }

    public HourlyEmployee(String name,int year,int month,int day, double hourSalary,int hour) {
        super(name,year,month,day);
        this.hourSalary=hourSalary;
        this.hour=hour;
    }

    public double getSalary(int month){
        double salary=0;
        if(hour<=160){
            salary=hourSalary*salary;
        }
        else
        {
            salary=160*hourSalary+(hour-160)*hourSalary*1.5;
        }

        if(month==this.month){
            salary+=100;
        }
        return salary;
    }

}
