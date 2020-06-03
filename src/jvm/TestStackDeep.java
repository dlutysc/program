package jvm;

public class TestStackDeep {
    private static int count = 0;
    public static void recursion(){
        ++count;
        recursion();
    }
    public static void main(String[] args) {
        try {
            recursion();
        }catch (Throwable e){
            System.out.println(count);
            e.printStackTrace();
        }
    }
}
