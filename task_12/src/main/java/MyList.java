
public class MyList {
    private static class Node {
        private final Node next;
        private String value;

        public Node(String value, Node next) {
            this.value = value;
            this.next = next;
        }
        public String getValue(){
            return this.value;
        }
        public Node getNext() {
            return this.next;
        }
        public String replaceValue(String newValue){
            String replacedValue = this.value;
            this.value=newValue;
            return replacedValue;
        }
    }


    private Node head;
    private int len;

    public Node getHead() {
        return head;
    }

    public int getLen() {
        return len;
    }

    public MyList() {
        this.head = null;
        this.len = 0;
    }

    public void push(String value) {
        Node node = new Node(value, head);
        if(this.head==null)this.head = node;
        synchronized (this.head) {
            this.head = node;
        }
        len++;
    }

    public void print() {
        Node tmp;
        if(this.head==null)return;
        synchronized (this.head) {
            tmp = this.head;
            while (tmp != null) {
                System.out.println(tmp.getValue());
                tmp = tmp.getNext();
            }
        }
    }

    public void bubblesort() {
        if (this.head == null)return;
        synchronized (this.head) {
            for (int i = this.len - 1; i > 0; i--) {
                Node tmp = this.head;
                for (int j = 0; j < i; j++) {
                    if (tmp.getValue().compareTo(tmp.getNext().getValue()) > 0) {
                        tmp.getNext().replaceValue(tmp.replaceValue(tmp.getNext().getValue()));
                    }
                    tmp = tmp.getNext();
                }

            }
        }
    }

}