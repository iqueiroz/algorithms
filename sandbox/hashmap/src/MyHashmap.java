import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MyHashmap {
    private static final int BUCKET_SIZE = 32;
    private final LinkedList<MyNode> buckets[];

    public MyHashmap() {
        buckets = new LinkedList[BUCKET_SIZE];
        for(int i=0; i<BUCKET_SIZE; i++)
            buckets[i] = new LinkedList<MyNode>();
    }

    public void put(MyKey key, MyValue value) {
        LinkedList<MyNode> linkedList = this.getBucketLinkedList(key);
        linkedList.add(new MyNode(key, value));
    }
 
    public MyValue get(MyKey key) {
        LinkedList<MyNode> linkedList = this.getBucketLinkedList(key);
        for (MyNode myNode : linkedList) {
            if(myNode.getKey().equals(key))
                return myNode.getValue();
        }
        throw new NoSuchElementException("Could not find the specified key");
    }

    private int getBucketIndex(MyKey key) {
        int bucketIx = Math.abs(key.hashCode()) % BUCKET_SIZE;
        return bucketIx;
    }

    private LinkedList<MyNode> getBucketLinkedList(MyKey key) {
        int bucketIx = this.getBucketIndex(key);
        return this.buckets[bucketIx];
    }
}
