/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ortega_quiz2;

import java.util.Scanner;
class Node{    
int data;
Node next;

     Node(int m) {
         //Store the storage/Stock room
         data = m;
         next = null;
     }

}

public class Ortega_Quiz2 {

           public Node head;
           
    public Node insertNode(int data){
        
    Node newNode = new Node(data);
    newNode.next = head;
    head = newNode;
    
        return head;
    }
    
    
    
     public void display(){
        Node node = head;
        
        while (node != null) {            
            System.out.println(node.data + ",");
            node = node.next;
        }
        System.out.println("");
    }

 public boolean search(int target){
        Node current = head;
        
            while (current != null) {            
                if (current.data == target) {
                    return true;
                }
                current = current.next;
        }
        
        return false;
    }
 
   public int searchPosition(int target){
    Node current = head;
    int pos = 0;
    
        while (current != null) {            
            if (current.data == target) {
                return pos;
                
            }
            current = current.next;
            pos++;
        }
        return -1;
    }
   
private int size;
private Node  tail;

private Node createNewNode(int index) throws Exception {
    Node node = new Node(index);
    
    node.data = index;
    node.next = null;
    
    return node; 
}

private void insertion(int index, int position) throws Exception {
    if(position < 0 || position > size){
        throw new Exception("Index Invalid");
    } else if (position == 0){
        insertBeg(index);
    } else if (position == size){
        insertEnd(index);
    }else{
        Node node = createNewNode (index);
        Node prev = getNodeat(index -1);
        node.next = prev.next;
        prev.next = node;
        tail.next = head;
      size++;
    }
    
}
        
private void insertBeg(int index)throws Exception{
    Node node = createNewNode(index);
    
    if (size == 0){
    head = tail = node;
    }else{
        node.next = head;
        head = node;
    }
    
    tail.next = tail;
    
    size++;
}

private void insertEnd (int index) throws Exception{
    Node node = createNewNode(index);
    
    if(size > 0){
        tail.next = node;
        tail = node;
        
    }else if (size == 0){
        head = tail = node;
    }
    tail.next = head;
    size++;
}

private void display2() throws Exception {
    if (head == null){
        throw new Exception ("List is empty");
        
    }
    
   Node current = head;
   
    do {
            System.out.print(current.data + "-> ");
            current = current.next;
        } while (current != head);
        System.out.println("null");
       

    }  
    



private Node getNodeat (int position) throws Exception{
    
     if (size == 0){
        throw new Exception ("Linked list is empty");
    }else if (position < 0 || position > size ){
        throw new Exception("Invalid Position");
    }else {
        for (int i = 0; i < position; i++) {
            head = head.next;
            
        }
    }
            return head;
}


/**
 *
 * @author home
 */
//public class Ortega_Quiz2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        Scanner scn = new Scanner (System.in);
        boolean quiz = true;
        Ortega_Quiz2 list = new Ortega_Quiz2();
        
        while(quiz){
              System.out.println("Choose: [Question,1], [Question,2]");
              int num = scn.nextInt();
              
              
              switch(num){
                  case 1: 
    
                     list.insertNode(10);
                     list.insertNode(20);
                     list.insertNode(30);
                     list.insertNode(40);
                     list.insertNode(50);
                     list.display();
    
                       System.out.println("===========================");
         
                       Scanner scan = new Scanner(System.in);
        
                       System.out.println("Search Here:");
                       int search = scan.nextInt();
        
                       int p = list.searchPosition(search);
        
                       if (p != -1) {
                       System.out.println(search  + "exist. ");
                       } else {
                       System.out.println(""+ search + "does not exist.");
                       }
                       break;
        
              case 2:
            
                         Scanner scann = new Scanner(System.in);
                         boolean num2 = true;
             
                          while (num2){
                          System.out.println("[1] Insert Nodes: \n[2] Display");
                          int node = scann.nextInt();
            
                         switch(node){
                          case 1:
                                System.out.println("Enter Element:");
                                int ele = scann.nextInt();
                                System.out.println("Enter Position");
                                int position = scn.nextInt();
                    
                                list.insertion(ele, position -1);
                                break;
                
                         case 2:
                               list.display();
                               break;
                              }
                         }         
                       break;             
            default:
            System.out.println("Invalid choice. Please try again.");
                    break;
                      
              }
        }
        scn.close();
    }
  }
    
