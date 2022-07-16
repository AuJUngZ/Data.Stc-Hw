public class Main {
        public static void main(String[] args) {
            Node node;
DoublyLinkedList list = new DoublyLinkedList("list3");
node = list.topFront();
node.printIDName();
node = list.topBack();
node.printIDName();
list.pushBack(new Node(5906001, "Matthew", 3.50));
list.pushBack(new Node(5906002, "Mark", 2.75));
list.pushBack(new Node(5906003, "Luke", 3.00));
node = list.topFront();
node.printIDName();
node = list.topBack();
node.printIDName();
    }
}
