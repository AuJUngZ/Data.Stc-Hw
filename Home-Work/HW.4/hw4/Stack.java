

public class Stack implements List{
    // Implement Stack using Linked List without tail
    Node head;
    
    public void push(Node node){
        //PushFront เหมือนกับการบ้าน3
        if (head == null){
            //ถ้า list ว่างให้เพิ่มเป็นตัวแรกได้เลย
            head = node;
        }else{
            //ถ้าไม่ว่างให้เปลี่ยน head มาชี้ที่ตัวใหม่แล้วให้ตัวใหม่ชี้ไปที่ head ตัวเดิม จะทำให้ ตัวใหม่อยู่หน้าตัวเดิม
            node.next = head;
            head = node;
        }
    }
    
    public void pop(){
        // Fix this function
        //popFront เหมือนการบ้าน 3
        if (head != null){ //check Node not empty
            if(head.next == null){
                head = null; //ถ้าเหลือข้อมูลอยู่ตัวเดัยวใน list pop ออกไปได้เลย
            }else{
                head = head.next; //ถ้า list มีข้อมูลหลายๆตัว ให้เอา head ไปชี้ที่ตัวถัดไปของมันเอง จะทำให้ตัวแรก(ตัวที่จะโดนลบ)ไม่ถูกชี้และจะโดนลบไปเอง
            }

        }else{
            System.out.println("Error: Stack Underflow"); //ถ้า list ว่างให้แจ้ง ERROR
        }
    }
    
    public Node top(){
        // Fix this
        return head; //return top node
    }
    
}
