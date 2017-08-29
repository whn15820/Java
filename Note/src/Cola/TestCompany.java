package Cola;

public class TestCompany {
    public static void main(String[] args) {
        SalariedEmployee c1 = new SalariedEmployee("´ó°×", 1995, 5, 5, 5000);
        HourlyEmployee c2 = new HourlyEmployee("Ð¡Áù", 1996, 10, 1, 12, 170);
        Company.getSalary(2,c1);
        Company.getSalary(2,c2);
    }

}
