package Cola;

public class SalesEmployee extends ColaEmployee{
    double sales;
    double rate;

    public SalesEmployee() {
        super();
    }

    public SalesEmployee(String name,int year, int month ,int day,double sales,double rate) {
        this.name=name;
        this.year=year;
        this.month=month;
        this.day=day;
        this.sales=sales;
        this.rate=rate;

    }


    @Override
    public double getSalary(int month) {
        if (month==this.month){
            return sales*rate+100;
        }
        return sales*rate;
    }

}
