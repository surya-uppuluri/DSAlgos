package surya.practice.geeks.linkedList;

import java.util.Scanner;
import java.util.Stack;

class GFG {

    public static void po(Object o){
        System.out.println(o);
    }

    public static void show(Node head){
        while(head != null){
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){

            Node head1 = null,tail1 = null;

            int n1 = sc.nextInt();
            int d1 = sc.nextInt();
            head1 = new Node(d1);
            tail1 = head1;

            while(n1-- > 1){
                Node n = new Node(sc.nextInt());
                n.next = head1;
                head1 = n;
            }

            ModifyLinkedList obj = new ModifyLinkedList();
            head1 = obj.modify(head1);
            obj.show(head1);
            System.out.println();
        }
    }

}// } Driver Code Ends


public class ModifyLinkedList {

    public Node modify(Node head){
        Stack<Integer> stack = new Stack<Integer>();
        Node temp = head;
        while(temp!=null)
        {
            stack.push((Integer) temp.data);
            temp=temp.next;
        }
        temp = head;
        while(temp!=null)
        {
            temp.data = (stack.pop())- (Integer)temp.data;
        }
        return head;

    }

    public void show(Node head){
        while(head!=null)
        {
            System.out.print(head.data+" ");
            head=head.next;
        }
    }
}