package Players;

public class Players {
    private static int count;

    public static Players create(){
        count=1;
        Players p =null;
        while (count<=11){
            p =new Players();
            count++;
            System.out.println("创建了一个运动员对象");
        }
        System.out.println("已经创建了11个对象");
        return p;
    }

    public static void main(String args[]){
        Players.create();

    }

}
