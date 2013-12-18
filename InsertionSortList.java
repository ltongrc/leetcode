public class InsertionSortList{
    public static ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode resHead = null;
        ListNode resTail = null;
        while( head != null){
            ListNode curr = head;
            head = head.next;
            // insert before the head
            if( resHead == null){
                resHead = curr;
                resTail = curr;
                resTail.next = null;
            } else if(curr.val <= resHead.val){
                curr.next = resHead;
                resHead = curr;
            } else if(curr.val >= resTail.val){
                resTail.next = curr;
                resTail = curr;
                resTail.next = null;
            } else {
                ListNode findPos = resHead;
                while(findPos != null){
                    if(findPos.next == null || curr.val < findPos.next.val){
                        curr.next = findPos.next;
                        findPos.next = curr;    
                        break;
                    }
                    findPos = findPos.next;
                }
            }
        }
        return resHead;
    }
    public static void main(String args[]){
        ListNode test = ListNode.testCase();
        System.out.println(test);
        System.out.println("----------------");
        System.out.println(insertionSortList(test));
    }
}
