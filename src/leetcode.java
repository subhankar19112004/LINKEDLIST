

public class leetcode {


    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    // find length of the cycle
    public int lengthCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                // calculate the length
                ListNode temp = slow;
                int length = 0;
                do {
                    temp = temp.next;
                    length++;
                } while (temp != slow);
                return length;
            }
        }
        return 0;
    }
    class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode detectCycle(ListNode head){
        int length=0;

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow=slow.next;
            if(fast==slow){
                length = lengthCycle(slow);
                break;
            }
            if (length == 0) {
                return null;

            }
        }
        //find the start node
        ListNode f = head;
        ListNode s = head;

        while (length >0){
            s = s.next;
            length--;
        }
        //keep moving both forward they will meet at cycle start
        while (f!=s){
            f = f.next;
            s = s.next;
        }
        return s;
    }
    //HAPPY NUMBER
    public boolean isHappy(int n){
        int slow = n;
        int fast = n;

        do{
            slow =findSquare(slow);
            fast = findSquare(findSquare(fast));
        }while(slow != fast);
        if (slow == 1) {
            return true;

        }
        return false;
    }
    public int findSquare(int number){
        int ans = 0;
        while(number>0){
            int rem = number % 10;
            ans += rem * rem;
            number /= 10;
        }
        return ans;
    }
    //middle of the linkedlist
    public ListNode middleNode(ListNode head){
        ListNode s = head;
        ListNode f = head;

        while(f!=null && f.next != null){
            s = s.next;
            f = f.next.next;
        }
        return s;
    }


    public static void main(String[] args) {



    }

}
