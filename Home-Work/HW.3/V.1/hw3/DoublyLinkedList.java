public class DoublyLinkedList {
    Node head;
    Node tail;
    String listName;
    
    public DoublyLinkedList(String name){ 
        //กำหนดชื่อของลิสต์ ตามที่รับมา แล้วก็กำหนดให้ heald = null และ tail = null
        this.listName = name;
        this.head = null;
        this.tail = null;
    }
    
    public void popBack() { //เอา node ตัวสุดท้ายทิ้ง
      if (isEmpty()){ //ถ้าลิสต์ว่างเปล่า ให้แจ้ง ERROR
            System.out.println("ERROR");
        }else if(head != tail){ //ถ้าลิสต์หลายตัว ให้ลบตัวสุดท้าย โดยการตัด .next ตัวก่อนหน้าตัวสุดท้าย
            tail.previous.next = null;
            tail = tail.previous;
        }else{ //ถ้ามีตัวเดียว ให้ head = null , tail = null ได้เลย
            head = null;
            tail = null;
        }
    }
    
    public void popFront(){ //เอา node ตัวแรกทิ้ง  
        if (isEmpty()){ //ถ้าลิสต์ว่างเปล่า ให้แจ้ง ERROR
            System.out.println("ERROR");
        }else if(head != tail){ //ถ้าลิสต์หลายตัว ให้ลบตัวแรก โดยการเปลี่ยน head ไปชี้ตัวถัดไปเลย
            head = head.next;
        }else{ //ถ้ามีตัวเดียว ให้ head = null , tail = null ได้เลย
            head = null;
            tail = null;
        }
    }
    
    public Node topFront(){ //return first node
        if (isEmpty()){ //ถ้าลิสต์ว่างเปล่า ให้แจ้ง ERROR แล้ว return เป็น Node ที่มี Error msg.
            System.out.println("ERROR");
            return new Node("Empty List!"); 
        } else { //ถ้าลิสต์ไม่ว่างเปล่า ให้ return ตัวแรก
            return head;
        }
    }
    
    public Node topBack(){ //return last node
        if (isEmpty()){ //ถ้าลิสต์ว่างเปล่า ให้แจ้ง ERROR แล้ว return เป็น Node ที่มี Error msg.
            System.out.println("ERROR");
            return new Node("Empty List!");
        } else { //ถ้าลิสต์ไม่ว่างเปล่า ให้ return ตัวสุดท้าย
            return tail;
        }
    }
    
    public void pushFront(Node node){
        //นำ node ใหม่ไปใส่หน้า list โดยถ้า list ว่างเปล่า ให้ head = node และ tail = node ได้เลย
        if (isEmpty()){
            this.head = node;
            this.tail = node;
        }else{ //ถ้าlistไม่ว่าง ให้นำ node ใหม่ไปใส่หน้า head แล้วก็ต้องกำหนดให้ head.previous = node และ node.next = head เพื่อจะสลับ head ได้
            node.next = head;
            head.previous = node;
            head = node;
        }
    }
    
    public void pushBack(Node node) {
        //นำ node ใหม่ไปใส่ท้าย list โดยถ้า list ว่างเปล่า ให้ head = node และ tail = node
        if (isEmpty()) {
            this.head = node;
            this.tail = node;
        } else { //ถ้า list ไม่ว่างก็นำ  Node ใหม่ไปต่อ tail
            node.previous = tail;
            tail.next = node;
            tail = node;
        }
    }

    public Node findNode(int id){
        if (isEmpty()){ //เช็ค node  ว่าว่างไหม ถ้าว่างให้แจ้ง ERROR แล้ว return เป็น Node ที่มี Error msg.
            return new Node("Empty List!");
        } else { //ถ้าไม่ว่าง loop หาจนถึง tail ถ้าเจอ id ที่ต้องการ ให้ return ตัวนั้น
            Node current = head;
            while(current != null){
                if(current.student_id == id){
                    return current;
                }
                current = current.next;
            }
            return new Node("Student Not Found!"); //ถ้าไม่เจอ return เป็น Node ที่มี Error msg.
        }
    }
    
    public Node eraseNode(int id){
        if (isEmpty()){ //เช็ค node  ว่าว่างไหม ถ้าว่างให้แจ้ง ERROR แล้ว return เป็น Node ที่มี Error msg.
            System.out.println("ERROR");
            return new Node("Empty List!");
        } else { //ถ้าไม่ว่าง
            Node DelNode = null; // สร้าง node ที่จะลบออกมา for เก็บค่าตัวนั้นไว้เพื่อ return.
            Node current = head; //declare current เป็น head : use for loop
            while(current != null){ // loop ปกติจนถึง tail
                if(current.student_id == id){ // ถ้าตัวนั้นมี id ที่ต้องการ
                    DelNode = current; //ให้ DelNode เป็น current
                    if(current == head) popFront(); //ถ้าอยู่ first node use : popFront();
                    else if(current == tail) popBack(); //ถ้าอยู่ last node use : popBack();
                    else{ //ถ้าไม่ใช่ first และ last node ก็ทำตามนี้
                        current.previous.next = current.next;
                        current.next.previous = current.previous;
                    }
                    return DelNode; //return ตัวที่ลบไป
                }
                current = current.next; //เปลี่ยน current ไปเรื่อยๆ จนถึง tail
            }
            return new Node("Student Not Found!"); // ถ้าไม่เจอ return เป็น Node ที่มี Error msg.
        }
    }
    
    public void addNodeAfter(Node node1, Node node2){
        if(node1 == tail){ //ถ้า node1 เป็น tail ให้เพิ่ม node2 ตามหลัง tail ได้เลย
            pushBack(node2);
        }else{
            node1.next.previous = node2; // เปลี่ยน previous ของ node1.next เป็น node2 
            node2.next = node1.next; // เปลี่ยน next ของ node2 เป็น node1.next
            node1.next = node2; // node1 connect node2
            node2.previous = node1; // node2 connect node1
        }
    }
    
    public void addNodeBefore(Node node1, Node node2){
        if(node1 == head){ // ถ้า node1 เป็น head ให้เปลี่ยน head เป็น node2
            node2.next = head; // เปลี่ยน next ของ node2 เป็น head เพื่อจะสลับ head ได้
            head.previous = node2; // เปลี่ยน previous ของ head เป็น node2
            head = node2; //สลับ head เป็น node2
        } else { // ถ้า node1 ไม่ใช่ head
            node2.previous = node1.previous; // เปลี่ยน previous ของ node2 เป็น node1.previous
            node1.previous.next = node2; // เปลี่ยน next ของ node1.previous เป็น node2 
            node1.previous = node2; // node1 connect node2
            node2.next = node1; // node2 connect node1
        }
    }
    
    public boolean isEmpty(){
        //เช็คค่า head ว่างไหม ถ้าว่างแสดงว่า list ว่าง
        if(head == null){
            return true;
        } else {
            return false;
        }
    }
    public void merge(DoublyLinkedList list){
        //ต่อtailของอันเดิมกับ list อันใหม่
        tail.next = list.head;
        list.head.previous = tail;
        tail = list.tail;
    }
    
    public void printStructure(){
        //ปริ้น ลิตออกมาตามรูปแบบโจทย์
        Node current=head;
        System.out.print(listName + ": head <-> ");
        while(current != null){
            System.out.print("{" + current.student_id + "} <-> ");
            current = current.next;
        }
        System.out.println("tail");
    }
    
    // This may be useful for you for implementing printStructure()
    public void printStructureBackward(){ 
        Node current=tail;
        System.out.print(listName + ": tail <-> ");
        while(current!=null){
            System.out.print("{" + current.student_id + "} <-> ");
            current = current.previous;
        }
        System.out.println("head");
    }
    
    public Node whoGotHighestGPA(){ //find highest GPA
        if (isEmpty()) { // ถ้า list ว่าง return node ที่มี Error msg.
            return new Node("Empty List!");
        } else { // ถ้า list ไม่ว่าง
            Node current = head; // ให้ current เป็น head เพื่อขะวนไปเรื่อยๆ
            Node highest = null; // สร้าง node เพื่อเอาไว้เก็บคนที่มี GPA สูงสุด
            double highestGPA = current.gpa; // เอาไว้เก็บ GPA
            while(current != null){  // ขะวนไปเรื่อยๆ จนถึง tail
                if (current.gpa >= highestGPA) { // ถ้า GPA ของ current มากกว่า GPA สูงสุด ***เติม >= เพื่อเอาคนที่อยู่ใกล้ tail มากที่สุด
                    highestGPA = current.gpa; // เอา GPA ของ current เป็น GPA สูงสุด
                    highest = current; // เอา current เป็น node ที่มี GPA สูงสุด
                }
                current = current.next; //วนไปเรื่อยๆ จนถึง tail
            }
            return highest; //return node ที่มี GPA สูงสุด
        }
    }
}
