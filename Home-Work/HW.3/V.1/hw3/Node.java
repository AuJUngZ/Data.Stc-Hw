public class Node {
    public int student_id;
    public String name;
    public double gpa;
    
    Node next;
    Node previous;
    
    // Constructor 1
    public Node(int id, String name, double gpa){
        //set ค่าตัวแปรของ Node ที่สร้างมาตามค่าที่ส่งมา
        this.student_id = id;
        this.name = name;
        this.gpa = gpa;
        this.next = null;
        this.previous = null;
    }
    // Constructor 2
    public Node(String name){
        //set ค่าตัวแปรของ Node ที่สร้างมาตามค่าที่ส่งมา (ุถ้าส่งมาแค่ชื่อ จะเป็น Error ของ Node นั้นเลย)
        this.name = name;
    }
    // Constructor 3 (dummy)
    public Node(){
        // You can leave this function blank
    }
    
    public void printIDName(){
        //ปริ้นค่าตัวแปรของ Node เก็บไว้ออกมา
        System.out.println("StudentID: " + student_id + " , Name: " + name);
    }

}
