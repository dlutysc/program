class A{
    int a;
}

class B{
    int b;
}
public class RefelectTest {
    // This method creates an instance of class whose name is
    // passed as a string 'c'.
    public static void fun(String c)  throws InstantiationException,
            IllegalAccessException, ClassNotFoundException
    {
        // Create an object of type 'c'
        Object obj = Class.forName(c).newInstance();

        // This is to print type of object created
        System.out.println("Object created for class:"
                + obj.getClass().getName());
    }

    // Driver code that calls main()
    public static void main(String[] args) throws InstantiationException,
            IllegalAccessException, ClassNotFoundException
    {
        fun("A");
    }
}
