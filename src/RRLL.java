public class RRLL {   //Reverse using Recursion in LinkedList
    private static Node head;
    private Node tail;
    private int size;
    int val;
    BSLL next;
    RRLL(int x){
        val=x;
        next=null;
    }
    

    public RRLL() {
        this.size=0;
    }
    public void insertfirst(int val){
        Node node=new Node(val);
        node.next=head;
        head=node;

        if(tail==null){
            tail=head;
        }
        size+=1;
    }
    public void inserlast(int val){
        if (tail == null) {
            insertfirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next=node;
        tail=node;
        size++;
    }
   
    public Node get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }
    private class Node {
        private int value;
        private Node next;
        public Object val;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }                                            
    }
    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value + "-->");
            temp = temp.next;
        }
        System.out.println("END");
    }
    //recursion reverse
    private void reverse(Node node) {
        if (node == tail) {
            head = tail;
            return;
        }
        reverse(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;
    }
    //in place reversal of a linked list - GOOGLE,MICROSOFT,AMAZON,APPLE
    public void reverse(){
        if(size < 2){
            return;
        }
        Node prev = null;
        Node present = head;
        Node next = present.next;

        while (present != null) {
            present.next = prev;
            prev = present;
            present = next;
            if(next != null){
                next=next.next;
            }
        }
        head=prev;
    }
    public Node reversebetween(Node head,int left,int right){
       
        if(left == right){
            return head;
        }
        //skip the first left-1 nodes
        Node current = head;
        Node prev = null;
        for (int i = 0;current!=null && i < left-1; i++) { 
            prev = current;
            current = current.next;
        }
        Node last = prev;
        Node newEnd = current;

        //reverse between left and right
        Node next = current.next;
        for (int i = 0;current!= null && i < right-left+1; i++) {
            current.next = prev;
            prev = current;
            current=next;
            if(next != null){
                next = next.next;
            }
              
        
        }
        if(last!=null){
            last.next = prev;
        }else{
            head = prev;
        }
        newEnd.next=current;
        return head;
    }
    public Node middleNode(Node head) {
        Node s = head;
        Node f = head;

        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }
        return s;
    }
    public Node reverseList(Node head) {
        if (head == null) {
            return head;
        }
        Node prev = null;
        Node present = head;
        Node next = present.next;

        while (present != null) {
            present.next = prev;
            prev = present;
            present = next;
            if (next != null) {
                next = next.next;
            }
        }
        return prev;
    }

    //linkedin,amazon,google,facebook,microsoft,apple
    public boolean isPalindrome (Node head){
        Node mid = middleNode(head);
        Node headSecond = reverseList(mid);
        Node rereverseHead = headSecond;

        //compare both halves
        while(head != null && headSecond != null){
            if(head.val != headSecond.val){
              break;  
            }
            head = head.next;
            headSecond = headSecond.next;
        }
        reverseList(rereverseHead);
        if(head == null || headSecond == null){
            return true;
        }
        return false;
    }
    //REORDER THE LIST(SINGLE LL)//google,facebook
    public void reorderList(Node head){
        if(head == null || head.next == null){
            return;
        }
        Node mid = middleNode(head);

        Node hs = reverseList(mid);
        Node hf = head;

        //rearranging
        while(hf != null && hs != null){
            Node temp = hf.next;
            hf.next = hs;
            hf = temp;


            //second-----@ round
            temp = hs.next;
            hs.next = hf;
            hs = temp;
        }
        if(hf != null){
            hf.next = null;
        }
    }
    //reversing the k number of liste
    //its also reversing the < k end items => modify it accordingly
    public Node reverseKgroup (Node head,int k){
        if(k <= 1 || head == null){
            return head;
        }
         //skip the first left-1 nodes
         Node current = head;
         Node prev = null;

         while(true){
            
         Node last = prev;
         Node newEnd = current;
 
         //reverse between left and right
         Node next = current.next;
         for (int i = 0;current!= null && i < k; i++) {
             current.next = prev;
             prev = current;
             current=next;
             if(next != null){
                 next = next.next;
             }
               
         
         }
         if(last!=null){
             last.next = prev;
         }else{
             head = prev;
         }
         newEnd.next=current;
         if(current == null){
            break;
         }
         prev = newEnd;
       }
     return head;
    }
    //rotate forom last k nodes
    //facebook,twitter,google
    public Node RotateRight(Node head, int k){
        if(k <= 0 || head == null || head.next == null ){
            return head;
        }
        Node last = head;
        int length = 1;
        while(last.next != null){
            last = last.next;
            length++;
        }
        last.next = head;
        int rotations = k%length;
        int skip = length - rotations;
        Node newLast = head;
        for (int i = 0; i < skip - 1; i++) {
            newLast = newLast.next;
            
            
        } 
        head = newLast.next;
            newLast.next = null;
            return head;
    }
       
    public static void main(String[] args) {
       /*  RRLL list = new RRLL();
        list.inserlast(5);
        list.inserlast(4);
        list.inserlast(3);
        list.inserlast(2);
        list.inserlast(1);
        list.display(); 
        list.reverse();
        list.display();
        list.display();*/
        RRLL list = new RRLL();  
        list.inserlast(1);              
        list.inserlast(2);
        list.inserlast(3);
        list.inserlast(4);
        list.inserlast(5);
        list.inserlast(6);
        list.inserlast(7);
        list.display();
        System.out.println("After last two node rotations it looks like ->>");
        list.RotateRight(head, 2);
        list.display();

       // System.out.println("the reordered list of the given singly linkedlist is-->");
        //list.reorderList(head);
       // list.display();
      // System.out.println("the re-ordered list is -->");
        //list.reversebetween(head, 2, 6);
        //list.display();



       // RRLL ans = new RRLL();
        //System.out.println("Is it a palindrome true/false --> " + ans.isPalindrome(head) );


    }
}