import java.util.*;
public class LL1{
    public void addf(int data){
        Node newNode= new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;
    }
    public void addl(int data){
        Node newNode= new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        tail.next=newNode;
        tail=newNode;
    }
    public void print(){
        Node temp;
        if(head==null){
            System.out.println("LinkedList is empty. ");
            return;
        }
        temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
    public void addbtw(int data, int idx){
        if(idx==0){
            addf(data);
            return;
        }
        Node newNode= new Node(data);
        size++;
        if(head==null){
            addf(data);
        }
        Node temp=head;
        
        for(int i=0;i<idx;i++){
            temp=temp.next;
        }
        newNode.next=temp.next;
        temp.next=newNode;  
    }
    public void removef(){
        if(size==0){
            System.out.println("LinkedList is empty.");
        }
        if(size==1){
            head=tail=null;
            size--;
            return;
        }
        Node temp=head;
        head=temp.next;
        size--;
        
    }
    public void removel(){
        if(size==0){
            System.out.println("LinkedList is empty.");
            return;
        }
        else if (size==1){
            head=tail=null;
            size--;
        }
        Node temp= head;
        for(int i=1;i<size-1;i++){
            temp=temp.next;
        }
        temp.next=null;
        size--;
    }
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
        }
    }
    // SEARCHES
    //ITERATIVE
    public boolean itrsearch(int key){
        Node temp= head;
        for(int i=0;i<size;i++){
            if(temp.data==key){
                return true;
            }
            temp=temp.next;
        }
        return false;
    }
    //RECURSIVE SEARCH------->(Very Important).
    public int helprecsearch(Node heads, int key){
        if(heads==null){
            return -1;
        }
        if(heads.data==key){
            return 0;
        }
        int idx=helprecsearch(heads.next, key);
        if(idx==-1){
            return -1;
        }
        return idx+1;

    }
    public void reverse(){
        Node prev=null;
        Node curr=tail=head;
        Node next;
         while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
         }
         head=prev;
    }
    public int recsearch(int key){
        return helprecsearch(head, key);
    }
    public void removefromlast(int n){
        //size
        Node temp= head;
        int sz=0;
        while(temp!=null){
            sz++;
            temp=temp.next;
        }
        if(sz==n){
            head=head.next;
            return;
        }
        Node prev=head;
        for(int i=1;i<sz-n;i++){
            prev=prev.next;
        }
        prev.next=prev.next.next;
    }
    public Node findMidnode(Node head){
        Node slow=head;
        Node fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast= fast.next.next;
        }
        return slow;
    }
    public boolean isPellindrome(Node head){
        if(head==null|| head.next==null){
            return true;
        }
        //mid of LL
        Node midNode=findMidnode(head);
        // mid LL reverse 
        Node prev=null;
        Node curr=midNode;
        Node next;
        while(curr.next!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;// ye nahi soch paye
            curr=next;// ye nahi soch paye

        }
        // cheak left and right data.
        Node left=head;
        Node right=prev;
        while (right!=null){
            if(left.data==right.data){
                left=left.next;
                right=right.next;
            }
            else{
                return false;
            }
        }
        return true;
    }
    public static Node head;
    public static Node tail;
    public static int size;// not clicked, was creating function for the findig size; but later realized that the method can be created for finding hte size;
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        LL1 l1= new LL1();
        l1.addf(5);
        l1.addf(4);
        l1.addf(3);
        l1.addf(2);
        l1.addf(1);
        l1.addl(6);
        l1.addl(7);
        l1.addbtw(0, 0);
        l1.print();
        l1.removef();
        System.out.println();
        l1.print();
        System.out.println("\nLinked List is of size "+size);
        l1.removel();
        l1.print();
        System.out.println("\nLinked List is of size "+size);
        System.out.println(l1.itrsearch(4));;
        System.out.println(l1.recsearch(50));
        l1.reverse();
        l1.print();
        l1.removefromlast(5);
        System.out.println();
        l1.print();
        System.out.println(l1.isPellindrome(head));
        
    }

}