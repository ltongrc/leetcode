import java.util.HashMap;
import java.util.Map;
public class LRUCache{
    public static void main (String[] args){
        LRUCache lru = new LRUCache(1);
        lru.set(2,1);
        System.out.println(lru.get(2));
    }
    private class Node{
        int key;
        int val;
        Node pre = null;
        Node next = null;
        Node(int key, int val){
            this.key = key;
            this.val = val;    
        }
    }

    private int capacity;
    private Node head = null;
    private Node tail = null;
    private Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<Integer, Node>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }

        Node node = map.get(key);
        // reflect "recently used"
        moveToTail(node);
        return node.val;
    }

    public void set(int key, int value) {
        if(!map.containsKey(key)){
            // if current size has reached the capacity,
            // we should remove the least used item in the first place
            if(map.size()==capacity){
                Node oldHead = head;
                Node newHead = head.next;
                head = newHead;
                oldHead.next = null;
                if(head != null){
                    head.pre = null;
                }
                map.remove(oldHead.key);
            }

            Node node = new Node(key, value);
            if(head == null){
                head = node;
                tail = node;
            } else{
                node.pre = tail;
                tail.next = node;
                tail = node;
            }
            map.put(key,node);
        } else {
            Node node = map.get(key);
            moveToTail(node);
            node.val = value;
        }
    }

    public void moveToTail(Node node){
        Node preNode = node.pre;
        Node nextNode = node.next;
        if(nextNode!=null){
            if(preNode == null){ // if the node is the header
                head = nextNode;
            } else {
                preNode.next = nextNode;
            }

            nextNode.pre = preNode;
            node.pre = tail;
            tail.next = node;
            tail = node;
            node.next = null;
        }
    }

}
