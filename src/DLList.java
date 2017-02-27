/**
 * Created by David on 2/26/2017.
 */

public class DLList{
    Node dummy;
    Node next, prev;
    Node head;
    Node tail;
    int n = 0;

    public DLList(){
        dummy = new Node();
        dummy.next = dummy;
        dummy.prev = dummy;
        dummy.n = 0;
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

    public void printList(Node traverse){
        while(traverse != null){
            System.out.println(traverse.x + " printing");
            traverse = traverse.next;
        }
    }

    Node getNode(int i){
        Node p = null;
        if(i < n / 2){
            p = dummy.next;
            for(int j = 0; j < i; j++)
                p = p.next;
        }else {
            p = dummy;
            for(int j = n; j > i; j--)
                p = p.prev;
        }
        return p;
    }

    int get(int i){
        return getNode(i).x;
    }

    int set(int i, Node x){
        Node u = getNode(i);
        Node y = new Node();
        y.x = u.x;
        u = x;
        return y.x;
    }

    void remove(Node w){
        w.prev.next = w.next;
        w.next.prev = w.prev;
        n--;
    }

    Node remove(int i){
        Node w = getNode(i);
        remove(w);
        return w;
    }

    Node addBefore(Node w, Node x){
        Node u = new Node();
        u = x;
        u.prev = w.prev;
        u.next = w;
        u.next.prev = u;
        u.prev.next = u;
        System.out.println(n + " size");
        return u;
    }

    void add(int i, Node x){
        addBefore(getNode(i), x);
        printList(head);
    }

    Node pop(){
        if(n == 0)  return null;
        Node x = head;
        head = head.next;
        if(--n == 0)    tail = null;
        return x;
    }

    boolean hasNext(){
        if(head.next == null)
            return false;
        else
            return true;
    }


    public static void main(String[] args) {
        DLList myList = new DLList();
        Node a = new Node();
        a.x = 10;
        myList.add(0, a);
        myList.push(11);
        myList.push(12);
        myList.push(44);
        myList.add(2,a);
        myList.printList(myList.head);
        System.out.println(myList.get(2));

    }

}
