public class MyNode{
    private final MyKey key;
    private final MyValue value;


    MyNode(MyKey key, MyValue value){
        this.key = key;
        this.value = value;
    }

    public MyKey getKey() {
        return key;
    }

    public MyValue getValue() {
        return value;
    }
}