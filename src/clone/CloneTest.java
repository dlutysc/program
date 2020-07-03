package clone;

public class CloneTest {
    public static void main(String[] args) {
        try {
            Person p1 = new Person("Hao LUO", 33, new Car("Benz", 300));
            Person p2 = MyUtil.clone(p1);   // 深度克隆
            Person p3 = (Person) p1.clone();
            p2.getCar().setBrand("BYD");
            p2.setAge(20);
            p3.setAge(35);
            // 修改克隆的Person对象p2关联的汽车对象的品牌属性
            // 原来的Person对象p1关联的汽车不会受到任何影响
            // 因为在克隆Person对象时其关联的汽车对象也被克隆了
            System.out.println(p1);
            System.out.println(p3);
        } catch (Exception e) {
            e.printStackTrace();
        }

        int n = 5;
        System.out.println(1 << n);
    }
}
