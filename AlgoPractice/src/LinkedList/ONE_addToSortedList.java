/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList;

/**
 *
 * @author User
 */
public class ONE_addToSortedList {
    static Node head ;
    
    static class Node {
        int data;
        Node next;
        Node(int n){
            this.data=n;
            this.next = null;
        }
    }
    
    public static void add(int data){
        
         { 
        Node current; 
        Node new_node = new Node(data);
        /* Special case for head node */
        if (head == null || head.data >= data) { 
            new_node.next = head; 
            head = new_node; 
        } 
        else { 
  
            /* Locate the node before point of insertion. */
            current = head; 
  
            while (current.next != null 
&& current.next.data < new_node.data) 
                current = current.next; 
  
            new_node.next = current.next; 
            current.next = new_node; 
        } 
    }   
        
    
    }
    
    public static void main(String[] args) {
        add(3);
        add(5);
        add(2);
        add(1);
        add(6);
        add(7);
        add(9);

        
        Node temp = head;
        while (temp !=null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
