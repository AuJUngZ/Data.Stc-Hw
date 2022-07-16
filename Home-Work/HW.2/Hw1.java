/**
 * Hw1
 */
public class Hw1 {
    public static class DynamicArray {
        private int[] arr;
        private int capacity;
        private int size; // Last element can be indexed at size-1
        
        public DynamicArray(int cap){ // Class Constructor
            arr = new int[cap];
            capacity = cap;
        }
        
        public void pushBack(int data){
            if(size < capacity){
                arr[size] = data;
                size++;
            }else{
                capacity = capacity * 2;
                int [] arr2 = new int[capacity];
                for(int i = 0; i < size; i++){
                    arr2[i] = arr[i];
                }
                arr = arr2;
                arr[size] = data;
                size++;
            }
        }
        public int popBack(){
            if(size == 0){
                System.out.println("ERROR");
                return 0;
            }else{
                int data = arr[size-1];
                arr[size-1] = 0;
                size--;
                return data;
            }
        }
    
        public int get(int i){
            if(i >= size || i < 0 || size == 0){
                System.out.println("ERROR");
                return 0;
            }else{
                return arr[i];
            }
        }
        public void set(int i, int value){
            if(i >= size || i < 0 || size == 0){
                System.out.println("ERROR");
            }else{
                if(size < capacity){
                    arr[i] = value;
                }else{
                    capacity = capacity * 2;
                    int [] arr2 = new int[capacity];
                    for(int j = 0; j < size; j++){
                        arr2[j] = arr[j];
                    }
                    arr = arr2;
                    arr[i] = value;
                }
            }
        }
        
        public void remove(int i){
            if(size == 0 || i >= size || i < 0){
                System.out.println("ERROR");    
            }else{
                if(i == size-1){
                    arr[i] = 0;
                    size--;
                }else{
                    for(int j = i; j < size ; j++){
                        arr[j] = arr[j+1];
                    }
                    size--;
                }
            }
        }
        
        public boolean isEmpty(){
           if(size == 0) return true;
           else return false;
        }
        
        public int getSize(){
            return size;
        }
        
        public void printStructure(){
            System.out.print("Size = " + size + ", Cap = " + capacity + ", arr = [ ");
            if(size == 0) System.out.print("]");
            for(int i = 0 ; i < size ; i++){
                if(i == size-1) System.out.print(arr[i] + " ]");
                else System.out.print(arr[i] + ", ");
            }
            System.out.println("");
        }
    }
    public static void main(String[] args) {
        DynamicArray var = new DynamicArray(2);
System.out.println(var.isEmpty());
var.pushBack(555);
System.out.println(var.isEmpty());
    }
}