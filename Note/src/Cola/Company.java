package Cola;

public class Company {
    static void getSalary(int month,ColaEmployee c){
        System.out.println(month+"月"+c.name+"该员工的工资是:"+c.getSalary(month));
    }

}
