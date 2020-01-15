public class LinkedList {
    private Node root;
    private Node tail;
    private int size;

    public LinkedList() {
    }

    public void add(Object value){
        Node node = new Node();
        node.setValue(value);

        if (this.root == null) {
            this.root = node;
        } else {
            node.setPrev(this.tail);
            this.tail.setNext(node);
        }

        this.tail = node;
        ++this.size;
    }

    public void remove(Object value) {
        if (this.size == 0) {
            System.out.println("List is empty");
            return;
        }
        Node currentPointer = this.root;

        while (currentPointer != null) {
            if ( currentPointer.getValue().equals(value)) {

                if (currentPointer.getPrev() == null && currentPointer.getNext() == null ) {
                    // only one element
                    this.root = null;
                    this.tail = null;
                } else if (currentPointer.getPrev() == null && currentPointer.getNext() != null) {
                    // first element
                    this.root = currentPointer.getNext();
                    this.root.setPrev(null);
                } else if(currentPointer.getPrev() != null && currentPointer.getNext() == null) {
                    // last element
                    this.tail = currentPointer.getPrev();
                    this.tail.setNext(null);
                } else if(currentPointer.getPrev() != null && currentPointer.getNext() != null){
                    // middle element
                    Node prevPointer = currentPointer.getPrev();
                    Node nextPointer = currentPointer.getNext();
                    prevPointer.setNext(nextPointer);
                    nextPointer.setPrev(prevPointer);
                }
                --this.size;
                return;
            }
            currentPointer = currentPointer.getNext();
        }

    }

    public boolean contains(Object value){

        if (this.size == 0) {
            System.out.println("List is empty");
            return false;
        }

        Node currentPointer = this.root;

        while (currentPointer != null) {
            if (currentPointer.getValue().equals(value)){
                return true;
            }
            currentPointer = currentPointer.getNext();
        }
        return false;
    }


    private class Node {
        private Object value;
        private Node next;
        private Node prev;

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }
    }

    public int getSize() {
        return this.size;
    }

    public void show(boolean desc) {
        if (this.size == 0) {
            System.out.println("List is empty");
            return;
        }

        Node currentPointer = this.root;
        if (desc) {currentPointer = this.tail;}

        System.out.print("{ ");
        while (currentPointer != null) {
            System.out.print(currentPointer.getValue());

            if (desc) {
                currentPointer = currentPointer.getPrev();
            } else {
                currentPointer = currentPointer.getNext();
            }

            if (currentPointer != null ) {
                System.out.print(", ");
            }
        }
        System.out.println("}");
    }

}
