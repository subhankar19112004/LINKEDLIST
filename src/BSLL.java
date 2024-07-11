public class BSLL {  // BSLL is bubble sort linklist.  
    private Node head;
    private Node tail;
    private int size;
    int val;
    BSLL next;
    BSLL(int x){
        val=x;
        next=null;
    }
    

    public BSLL() {
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
   
    public void bubbleSort(){
        bubbleSort(size-1,0);
    }
    private void bubbleSort(int row,int col){
        if(row == 0){
            return;
        }
        if(col < row){
            Node first = get(col);
            Node second =  get(col + 1);

            if(first.value > second.value){
                //swap
                if(first == head){ // case1, if pointer are in head
                    head = second;
                    first.next = second.next;
                    second.next = first;
                }else if(second == tail){  //case2, if pointer is at tail
                    Node prev = get(col - 1);
                    prev.next = second;
                    tail = first;
                    first.next = null;
                    second.next = tail;
                }else{                     //case3, if pointer are in somewhere
                    Node prev = get(col - 1);
                    prev.next = second;
                    first.next = second.next;
                    second.next = first;
                }
            }
            bubbleSort(row,col + 1);
        }else{
            bubbleSort(row-1,0);
        }





    
    }
    public static void main(String[] args) {
        BSLL list = new BSLL();
        for (int i = 7; i > 0; i--) {
            list.inserlast(i);
        }
        list.display();
        list.bubbleSort();
        list.display();
    }

}
