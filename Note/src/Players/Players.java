package Players;

public class Players {
    private static int count;

    public static Players create(){
        count=1;
        Players p =null;
        while (count<=11){
            p =new Players();
            count++;
            System.out.println("������һ���˶�Ա����");
        }
        System.out.println("�Ѿ�������11������");
        return p;
    }

    public static void main(String args[]){
        Players.create();

    }

}
