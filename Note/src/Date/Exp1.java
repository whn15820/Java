package Date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Exp1 {
    public  static void main(String args[]){
        Date now =new Date();
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-mm-dd");
        String nowStr =sdf.format(now);
        System.out.println(nowStr);
    }

}
