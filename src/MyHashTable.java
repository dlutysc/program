import java.util.LinkedList;
import java.util.List;

public class MyHashTable<T> {
    private List<T>[] theLists;
    private static final int DEFAULT_SIZE = 101;

    public MyHashTable(){
        this(DEFAULT_SIZE);
    }
    public MyHashTable(int size){
        theLists = new LinkedList[nextPrime(size)];
        for (int i = 0; i < theLists.length; i++) {
            theLists[i] = new LinkedList<>();
        }
    }

    public void insert(T x){
        List<T> whichList = theLists[myHash(x)];
        while (!whichList.contains(x)){
            whichList.add(x);
        }
    }
    public boolean contains(T x){
        List<T> whichList = theLists[myHash(x)];
        return whichList.contains(x);
    }
    public void remove(T x){
        List<T> whichList = theLists[myHash(x)];
        if (whichList.contains(x)){
            whichList.remove(x);
        }
    }
    public int myHash(T x){
        return 0;
    }
    private int nextPrime(int n){
        if (n % 2 == 0){
            return n + 1;
        }
        while (true){
            if (!isPrime(n)){
                n += 2;
            }else {
                return n;
            }
        }
    }

    private boolean isPrime(int n){
        if (n == 2 || n == 3){
            return true;
        }
        if (n == 1 || n % 2 == 0){
            return false;
        }
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }
}
