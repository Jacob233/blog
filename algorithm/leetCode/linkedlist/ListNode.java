package linkedlist;


/**
 * 定义链表:
 * 1.值:(String、int……)
 * 2.next:链表对象
 */
public class ListNode {
    private String strVal;
    private int intVal;
    private ListNode next;

    public ListNode() {
    }

    public ListNode(String strVal) {
        this.strVal = strVal;
        this.next = null;
    }

    public ListNode(String strVal, ListNode node) {
        this.strVal = strVal;
        this.next = node;
    }

    public ListNode(int intVal) {
        this.intVal = intVal;
        this.next = null;
    }

    public ListNode(int intVal, ListNode node) {
        this.intVal = intVal;
        this.next = node;
    }

    public static ListNode initIntNode(int[] intVals) {
        ListNode rear = new ListNode();
        for (int val : intVals) {
            ListNode next = new ListNode(val);
            rear.setNext(next);
            rear = next;
        }
        return rear;
    }

    /**
     * 尾插
     */
    public static ListNode rearStrNode(String[] strVals) {
        ListNode head = new ListNode();
        ListNode cur = new ListNode();
        for (int i = 0; i < strVals.length; i++) {
            ListNode next = new ListNode(strVals[i],cur);
            if(i==0){
                head.setNext(next);
            }
            cur = next;
        }
        return head;
    }

    /**
     * 头插
     */
    public static ListNode headStrNode(String[] strVals) {
        ListNode head = new ListNode();
        for (String val : strVals) {
            ListNode next = new ListNode(val);
            next.setNext(head.getNext());
            head.setNext(next);
        }
        return head;
    }

    public String getStrVal() {
        return strVal;
    }

    public void setStrVal(String strVal) {
        this.strVal = strVal;
    }

    public int getIntVal() {
        return intVal;
    }

    public void setIntVal(int intVal) {
        this.intVal = intVal;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
