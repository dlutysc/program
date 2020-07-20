package common;

public class ListNode implements Cloneable{
    public int val; //加上public，才能在其他包里访问ListNode得val属性，不加的话只能在包内访问

    public ListNode next = null;
    public ListNode(){};
    public ListNode(int val){
        this.val = val;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}
