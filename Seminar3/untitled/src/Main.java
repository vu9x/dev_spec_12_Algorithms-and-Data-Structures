import javax.xml.crypto.Data;
import java.util.Date;

class sList{
    Node head;
    class Node{
        int value;
        Node next;
    }

    void push_front(int value){
        Node node = new Node();
        node.value = value;

        node.next = head;
        head = node;
    }

    void pop_front(){
        if(head != null) {
            head = head.next;
        }
    }

    void push_back(int value){
        Node node = new Node();
        node.value = value;

        if(head == null){
            head = node;
        }else{
            Node cur = head;
            while(cur.next != null){
                cur = cur.next;
            }
            cur.next = node;
        }
    }

    void pop_back(){
        if(head != null) {
            if(head.next == null) {
                head = null;
            }else {
                Node cur = head;
                while (cur.next.next != null) {
                    cur = cur.next;
                }
                cur.next = null;
            }
        }
    }

    void print(){
        System.out.println("Однонаправленный список");
        Node cur = head;
        while(cur != null){
            System.out.printf("%d, ", cur.value);
            cur = cur.next;
        }
    }

    boolean contains(int value){
        Node cur = head;
        while(cur != null){
            if(cur.value == value){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public void reverse(){
        if (head != null && head.next != null){
            reverse(head.next, head);
        }
    }
    private void reverse (Node currentNode, Node previousNode){
        if(currentNode.next == null){
            head = currentNode;
        } else {
            reverse(currentNode.next, currentNode);
        }

        currentNode.next = previousNode;
        previousNode.next = null;
    }
}
class dList{
    Node head;
    Node tail;
    class Node{
        int value;
        Node next;
        Node prev;
    }

    void push_front(int value){
        Node node = new Node();
        node.value = value;

        if(head == null){
            tail = node;
        }else {
            node.next = head;
            head.prev = node;
        }
        head = node;
    }

    void pop_front(){
        if(head != null) {
            if(head.next == null){
                head = null;
                tail = null;
            }else {
                head = head.next;
                head.prev = null;
            }
        }
    }

    void push_back(int value){
        Node node = new Node();
        node.value = value;

        if(tail == null){
            head = node;
        }else {
            node.prev = tail;
            tail.next = node;
        }
        tail = node;
    }

    void pop_back(){
        if(tail != null) {
            if(tail.prev == null){
                tail = null;
                head = null;
            }else {
                tail = tail.prev;
                tail.next = null;
            }
        }
    }

    void print(){
        System.out.println("Двунаправленный список");
        Node cur = head;
        while(cur != null){
            System.out.printf("%d, ", cur.value);
            cur = cur.next;
        }
        System.out.println();
    }

    boolean contains(int value){
        Node cur = head;
        while(cur != null){
            if(cur.value == value){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    void sort(){
        boolean ok;
        do{
            ok = false;
            Node node = head;
            while(node != null){
                if(node.next != null){
                    if(node.value > node.next.value){
                        ok = true;

                        Node before = node.prev;
                        Node cur = node;
                        Node next = node.next;
                        Node after = next.next;

                        cur.prev = next;
                        cur.next = after;
                        next.prev = before;
                        next.next = cur;

                        if(before != null) {
                            before.next = next;
                        }else{
                            head = next;
                        }
                        if(after != null) {
                            after.prev = cur;
                        }else{
                            tail = cur;
                        }
                    }
                }
                node = node.next;
            }
        }while(ok);
    }

    public void reverse(){
        Node currentNode = head;
        while (currentNode != null){
            Node next = currentNode.next;
            Node previous = currentNode.prev;

            // Разворот листа
            currentNode.next = previous;
            currentNode.prev = next;

            // Изменение head и tail местами
            if (previous == null){
                tail = currentNode;
            }
            if (next == null){
                head = currentNode;
            }

            // продолжение иттерации
            currentNode = next;
        }
    }
}
public class Main {
    public static void main(String[] args) {
        dList list = new dList();
        for(int i=10; i<=15; i++)
            list.push_front(i);
        for(int i=10; i>=5; i--)
            list.push_front(i);
        list.print();
        list.reverse();
        list.print();

        sList nList = new sList();
        for(int i=10; i<=15; i++)
            nList.push_front(i);
        for(int i=10; i>=5; i--)
            nList.push_front(i);
        nList.print();
        nList.reverse();
        nList.print();
    }
}