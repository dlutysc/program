import java.util.ArrayList;
import java.util.Scanner;

/**
 * 华为机试：线性插值
 */
class Measure{
    int num;
    int val;
    Measure(int num, int val){
        this.num = num;
        this.val = val;
    }
}
public class InsertValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[][] arr = new int[m][2];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < 2; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            ArrayList<Measure> list = new ArrayList<>();
            list.add(new Measure(arr[0][0], arr[0][1]));
            for (int i = 1; i < m; i++) {
                int preNum = arr[i - 1][0], preVal = arr[i - 1][1];
                int curNum = arr[i][0], curVal = arr[i][1];
                if (curNum - preNum != 1 && curNum - preNum != 0){ //编号缺失
                    int dist = curNum - preNum;
                    if (i >= 2){
                        int ppNum = arr[i - 2][0];
                        if (ppNum == preNum){
                            preVal = list.get(list.size() - 1).val;
                        }
                    }
                    for (int j = 1; j < dist; j++) {
                        int val = preVal + ((curVal - preVal) / (curNum - preNum)) * j;
                        int num = preNum + j;
                        list.add(new Measure(num, val));
                    }
                    list.add(new Measure(curNum, curVal));
                }else if (curNum == preNum){ //编号相等
                    continue;
                }else {
                    list.add(new Measure(curNum, curVal));
                }
            }
            for(Measure item : list){
                System.out.println(item.num + " " + item.val);
            }
        }

    }
}
