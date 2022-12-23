
public class MyList {
    private static class Node {
        private final Node next;
        private String value;

        public Node(String value, Node next) {
            this.value = value;
            this.next = next;
        }

        public String getValue() {
            return this.value;
        }

        public Node getNext() {
            return this.next;
        }

        public String replaceValue(String newValue) {
            String replacedValue = this.value;
            this.value = newValue;
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

    public synchronized void push(String value) {
        Node node = new Node(value, head);
        this.head = node;
        len++;
    }

    public synchronized void print() {
        Node tmp;
        if (this.head == null) return;
        tmp = this.head;
        while (tmp != null) {
            System.out.println(tmp.getValue());
            tmp = tmp.getNext();
        }

    }

    public synchronized void bubblesort() {
        if (this.head == null) return;
        for (int i = 0; i + 1 < this.len; i++) {
            Node tmp = this.head;
            for (int j = 0; j + 1 < this.len - i; j++) {
                if (tmp.getValue().compareTo(tmp.getNext().getValue()) > 0) {
                    tmp.getNext().replaceValue(tmp.replaceValue(tmp.getNext().getValue()));
                }
                tmp = tmp.getNext();
            }
        }
    }

}