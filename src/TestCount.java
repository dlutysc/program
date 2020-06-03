
import java.util.*;
public class TestCount{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int num = sc.nextInt();
            StringBuilder res = new StringBuilder();
            while(num != 0){
                if(num % 2 == 0){
                    num = (num - 2) / 2;
                    res.insert(0, "3");
                }else{
                    num = (num - 1) / 2;
                    res.insert(0, "2");
                }
            }
            System.out.println(res);
        }
    }
}

