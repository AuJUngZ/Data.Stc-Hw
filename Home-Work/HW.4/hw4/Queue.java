public class Queue implements List{
    // Implement Queue using Linked List with tail
    Node head;
    Node tail;
    
    public void push(Node node){
        //การ pushback ใน linklist ปกติทำเหมือนการบ้านก่อนหน้า
        if (head == null){
            //ถ้า list ว่างเพิ่ม node เข้าไปได้เลย โดยให้ head = node
            head = node;
            tail = node;
        }else{
            //แต่ถ้า list ไม่ว่างให้เติมเข้าไปต่อเป็นตัวสุดท้าย
            tail.next = node;
            tail = node;
        }
    }
    
    public void pop(){
        // popFront เหมือนในการบ้าน 3
        if (head != null){
            if (head != tail){
                //ถ้า list มีข้อมูลหลายๆตัว ให้เอา head ไปชี้ที่ตัวถัดไปของมันเอง จะทำให้ตัวแรก(ตัวที่จะโดนลบ)ไม่ถูกชี้และจะโดนลบไปเอง
                head = head.next;
            }else{
                //แตุ่้ามีอยู่ตัวเดียว ให้ head = null ได้เลย
                head = null;
            }
        }else{
            System.out.println("Error: Queue Underflow");
        }
    }
    
    public Node top(){
        // Fix this
        return head; //return first Node in list
    }
    
}
