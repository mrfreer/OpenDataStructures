import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * Created by David on 2/26/2017.
 */
public class Node {

    Node next, prev;
    Node head;
    Node tail;
    int n = 0, x;

    public Node(){

    }
    public Node(int x){
        this.x = x;

    }
    int push(int x){
        Node u = new Node();
        u.x = x;
        u.next = head;
        head = u;
        if(n == 0)
            tail = u;
        n++;
        return x;
    }

    Node pop(){
        if(n == 0)  return null;
        Node x = head;
        head = head.next;
        if(--n == 0)    tail = null;
        return x;
    }

    Node remove(){
        if(n == 0) return null;
        Node x = head;
        head = head.next;
        if(--n == 0)   tail = null;
        return x;
    }

    boolean add(Node x){
        Node u = new Node();
        u = x;
        if(n == 0)
            head = u;
        else
            tail.next = u;
        tail = u;
        n++;
        return true;
    }

    boolean hasNext(){
        if(head.next == null)
            return false;
        else
            return true;
    }

    public String toString(){
        return "" + x;
    }



    public void printList(Node traverse){
        while(traverse != null){
            System.out.println(traverse.x + " printing");
            traverse = traverse.next;
        }
    }

    public static void main(String[] args) {
        Node a = new Node();
        a.add(new Node(3));

        a.push(11);
        a.push(12);
        Node b = new Node(13);
        a.add(b);
        new Node().printList(a.head);
        while(a.hasNext()){
            System.out.println(a.pop());
        }
        System.out.println(a.pop());
    }
}
