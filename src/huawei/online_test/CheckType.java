package huawei.online_test;

public class CheckType {
    public static void main(String[] args) {
        System.out.println(getType(1));
        System.out.println(getType(1.0));
        System.out.println((short)(10/10.2));
        System.out.println(getType((short)(10/10.2*2)));
        System.out.println(getType('我'));
        System.out.println(Integer.class.getSimpleName());
        System.out.println(Integer.class.getName());
    }
    static String getType(Object obj){
        return obj.getClass().getName();
    }
}
