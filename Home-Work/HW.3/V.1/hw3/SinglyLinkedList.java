public class SinglyLinkedList {
    Node head;
    String listName;
    
    public SinglyLinkedList(String name){
        this.listName = name;
        this.head = null;
    }
    
    public void popBack() {
        if (isEmpty()){ //ถ้าลิสต์ว่างเปล่า ให้แจ้ง ERROR
            System.out.println("ERROR");
        }else{
            Node current = head; //สร้าง node current มาเพื่อวนเช็ค
            if(current.next == null){ //ถ้าลิสต์มีข้อมูลเดียว ลบได้เลย
                head = null;
            }else{
                while(current.next != null){ //วนลูปวนลูปจนกว่าจะถึงตำแหน่งสุดท้าย
                    current = current.next;
                }
                current.previous.next = null; //ลบข้อมูลตำแหน่งสุดท้าย
            }
        }
    }
    
    public void popFront(){
        if (isEmpty()){ //ถ้าลิสต์ว่างเปล่า ให้แจ้ง ERROR
            System.out.println("ERROR");
        }else{
            if(head.next == null){ //ถ้าลิสต์มีแค่head ตัวเดียว
                head = null; //ลบออกได้เลย
            }else{ //ถ้าลิสต์มีมากกว่า 1 ตัว
                head = head.next; //ลบ head ออกไป
                head.previous = null; //ลบตัวก่อน head ออกไป
            }
        }
    }
    
    public Node topFront(){
        if (isEmpty()){ //ถ้าลิสต์ว่างเปล่า ให้แจ้ง ERROR แล้ว return เป็น Node ที่มี Error msg.
            System.out.println("ERROR");
            return new Node("Empty List!");
        } else { //ถ้าลิสต์มีข้อมูลอยู่
            return head; //return head ได้เลย
        }
    }
    
    public Node topBack(){ 
        if (isEmpty()){ //ถ้าลิสต์ว่างเปล่า ให้แจ้ง ERROR แล้ว return เป็น Node ที่มี Error msg.
            System.out.println("ERROR");
            return new Node("Empty List!");
        } else { //ถ้าลิสต์มีข้อมูลอยู่
            Node current = head; //สร้าง node current มาเพื่อวนเช็ค
            if(current.next == null){ //ถ้า current.next == null แสดงว่าเป็นตัวสุดท้าย(ตั้งแต่ตัวแรก)
                return current; //return current ได้เลย
            }else{ //ถ้าไม่ใช่
                while(current.next != null){ //วนไปจนถึงตัวสุดท้าย
                    current = current.next;
                }
                return current; //return current ได้เลย
            }
        }
    }
    
    public void pushFront(Node node){
        if (isEmpty()){
            this.head = node; //ถ้าลิสต์ว่างเปล่า ให้เอา node มาเป็น head
        }else{
            node.next = head; //เอา next ของ node ต่อไปที่ head
            head.previous = node; //เอา previous ของ head ต่อไปที่ node
            head = node; //สลับ head เป็น node แทน
        }
    }
    
    public void pushBack(Node node) {
        if (isEmpty()){
            this.head = node;
        } else {
            Node current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = node;
            node.previous = current;
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
                    else if(current.next == null) popBack(); //ถ้าอยู่ last node use : popBack();
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
        if(node1 == head){ //ถ้า Node1 คือ head ให้นำ node2 ต่อ node1 ได้เลย
            node2.next = head.next; //ต่อ node
            head.next.previous = node2;
            head.next = node2;
            node2.previous = head;
        }else{ //ถ้า Node1 ไม่ใช่ head 
            Node current = head; 
            while(current != node1){ //loop จนถึง node1
                current = current.next;
            }
            //นำ node2 ต่อ node1 ได้เลย
            node2.next = current.next; //ต่อ node
            current.next = node2;
            node2.previous = current;
            current.next = node2;
        }
    }
    
    public void addNodeBefore(Node node1, Node node2){
        if(node1 == head){ //ถ้า Node1 คือ head ให้นำ node2 pushFront ได้เลย == node2 จะเป็นตัวแรก
            pushFront(node2);
        }else{ //ถ้า Node1 ไม่ใช่ head
            Node current = head;
            while(current != node1){ //loop จนถึง node1
                current = current.next;
            }
            //นำ node2 ไว้ข้างหน้า node1 ได้เลย
            current.previous.next = node2;
            node2.previous = current.previous;
            node2.next = current;
        }
    }
    
    public boolean isEmpty(){
        if(head == null){ //ถ้า list ว่าง จะ return true
            return true;
        }else{  //ถ้า list ไม่ว่าง จะ return false
            return false;
        }
    }
    public void merge(SinglyLinkedList list){
        Node current = head; //declare current เป็น head : use for loop
        while(current.next != null){ //loop ปกติจนถึงตัวสุดท้าย
            current = current.next;
        }
        //ต่อ node ตัวสุดท้ายกับ head ชอง list ที่ส่งมา
        current.next = list.head;
        list.head.previous = current;
    }
    
    public void printStructure(){
        //ปริ้น ลิตออกมาตามรูปแบบโจทย์
        Node current=head;
        System.out.print(listName + ": head -> ");
        while(current != null){
            System.out.print("{" + current.student_id + "} -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    
    public Node whoGotHighestGPA(){
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
