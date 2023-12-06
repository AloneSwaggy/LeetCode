//import java.util.HashMap;
//
///**
// * @author admin
// * @version 1.0.0
// * @ClassName Test0924.java
// * @Description TODO
// * @createTime 2023年09月24日 13:13:00
// */
//public class Test0924 {
//    class Node{
//        Node prev, next;
//        int key, value;
//
//        Node(int key, int value){
//            this.key = key;
//            this.value = value;
//        }
//    }
//    private HashMap<Integer,Node> cache = new HashMap<>();
//    private int capacity;
//    private Node dummy = new Node(0, 0);
//
//    public LRUCache(int capacity) {
//        this.capacity = capacity;
//        dummy.prev = dummy;
//        dummy.next = dummy;
//    }
//
//    public int get(int key) {
//        Node node = cache.get(key);
//        if(node == null){
//            return -1;
//    }
//        moveToHead(node);
//        return node.value;
//    }
//
//    public void put(int key, int value) {
//        Node node = cache.get(key);
//        if(node != null){
//            node.value = value;
//            moveToHead(node);
//    }   else {
//            Node newNode = new Node(key, value);
//            cache.put(key, newNode);
//            addToHead(newNode);
//            if(cache.size() > capacity){
//                Node tail = dummy.prev;
//                cache.remove(tail.key);
//                remove(tail);
//            }
//        }
//    }
//
//    private void addToHead(Node node){
//        node.prev = dummy;
//        node.next = dummy.next;
//        dummy.next.prev = node;
//        dummy.next = node;
//    }
//
//    private void remove(Node node){
//        node.prev.next = node.next;
//        node.next.prev = node.prev;
//    }
//
//    private void moveToHead(Node node){
//        remove(node);
//        addToHead(node);
//    }
//}
