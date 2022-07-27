

public class Stock {
    private List list; //declare list
    private int totalShares; //declare totalShares
    
    public Stock(String costBasis){ //สร้าง constructor ของ Stock และสร้าง list ให้ตรงกับการประมวลผลที่จะทำกับข้อมูลที่รับมา
        switch (costBasis) {
            case "FIFO": //ถ้า costBasis มีค่าเป็น FIFO จะทำการสร้าง list เป็นประเภท queue
                list = new Queue();
                break;
            case "LIFO": //ถ้า costBasis มีค่าเป็น LIFO จะทำการสร้าง list เป็นประเภท stack
                list = new Stack();
                break;
            default: //ถ้าป้อนค่ามาไม่ถูกจะแจ้ง ERROR
                System.out.println("Invalid cost basis. Choose FIFO or LIFO");
                break;
        }
    }
    
    public void buy(int boughtShares, double boughtPrice){ //ซื้อหุ้นเข้าบัญชี ตามจํานวนและราคาที่ระบุไว้ใน boughtShares และ boughtPrice
        list.push(new Node(boughtShares,boughtPrice)); //push ข้อมูลที่รับมาไปใน list
        totalShares += boughtShares; //บวกจำนวนหุ้นที่ซื้อมาทั้งหมด
    }
    
    public void sell(int soldShares, double soldPrice){ //ขายหุ้นตามคําสั่ง โดยจํานวนขายและราคาขาย เป็นไปตามที่ระบุไว้ใน soldShares และ soldPrice
        if (soldShares <= totalShares){
            double realizedGain = 0.0; //สร้างตัวแปร realizedGain เพื่อบอกมูลค่าหุ้นที่ขายได้จริง
            double unrealizedGain = 0.0; //สร้างตัวแปร unrealizedGain เพื่อบอกมูลค่าหุ้นทางบัญชี
            
            //realProfit คำนวณมูลค่าหุ้นที่ขายได้จริง
            while (list.top() != null && soldShares>0){ //เช็คค่า node ที่ได้รับมาไม่เป็น null และจำนวนหุ้นที่ขายมากกว่า 0
                if (soldShares>=list.top().shares){ //ถ้าขายมากกว่าหรือเท่ากับจำนวนหุ้นที่มีอยู่ใน node
                    double Pf = (soldPrice - list.top().price)*list.top().shares; //คำนวณมูลค่าหุ้นที่ขายได้จริง
                    realizedGain += Pf; //บวกมูลค่าหุ้นที่ขายได้จริงทั้งหมด
                    soldShares -= list.top().shares; //ลดจำนวนหุ้นที่ขายจากจำนวนหุ้นที่มีอยู่ใน node ทั้งหมด
                    list.pop(); //ลบ node ที่ขายได้ออกจาก list
                }else{ //ถ้าขายน้อยกว่าจำนวนหุ้นที่มีอยู่ใน node
                    double Pf = (soldPrice - list.top().price)*soldShares; //คำนวณมูลค่าหุ้นที่ขายได้จริง
                    realizedGain += Pf; //บวกมูลค่าหุ้นที่ขายได้จริงทั้งหมด
                    list.top().shares -= soldShares; //ลดจำนวนหุ้นที่ขายจากจำนวนหุ้นที่มีอยู่ใน node
                    soldShares = 0; //กำหนดจำนวนหุ้นที่จะขายเป็น 0
                }
            }
            //UnrealProfit //คำนวณมูลค่าหุ้นที่ขายได้ทางบัญชี
            Node current = list.top(); //สร้างตัวแปร current เพื่อให้เป็น head ของ list เพราะ  pop() return head
            while(current != null){ //เช็คค่า node ที่ได้รับมาไม่เป็น null
                double Pf = (soldPrice - current.price)*current.shares; //คำนวณมูลค่าหุ้นทางบัญชี
                unrealizedGain += Pf; //บวกมูลค่าหุ้นทางบัญชีที่จะขายได้ทั้งหมด
                current = current.next; //เปลี่ยน current เป็น node ถัดไป
            }
            // Complete this code
            // Something is missing here
            // totalShares -= soldShares;
            System.out.println("Realized P/L = " + realizedGain + " Unrealized P/L = " + unrealizedGain); //แสดงผลการขายทั้งหมด
        }else{
            System.out.println("Sell command rejected"); //แสดงผลการขายที่ไม่สำเร็จ
        }
    }
    
    public void showList(){ //แสดงรายการหุ้นที่มีอยู่ในบัญชี
        Node currentNode = list.top();
        System.out.print("head -> ");
        while (currentNode!=null){
            System.out.print("[" + currentNode.shares + "@" + currentNode.price + "B] -> ");
            currentNode = currentNode.next;
        }
        System.out.println("tail");
    }
}