package Parker;

public class Parker {
	public void charge(Vehicle m,int h){
        System.out.println(m.cal()*h);
    }

    public static void main(String args[]){
        Parker p1 =new Parker();

        Vehicle v1 =new car_1();
        p1.charge(v1,3);
    }

}
