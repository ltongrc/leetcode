public class ListNode{
    int val;
    ListNode next = null;
        
    public ListNode(int val){
        this.val = val;
    }

    public String toString(){
        String res = "";
        ListNode n = this;
        while(n!=null){
            res += n.val+" -> ";
            n = n.next;
        }
        res += "null";
        return res;
    }

    public static ListNode testCase(){
        int[] test = {44, 23, 12, 23, 0, 29, 12, 20};
        ListNode head = new ListNode(test[0]);
        ListNode it = head;
        for(int i=1; i<test.length; i++){
            it.next = new ListNode(test[i]);
            it = it.next;
        }
        return head; 
    }
}
