package com.aapitesting.TestAPI;

import com.graphbuilder.struc.LinkedList.Node;

public class LinkedList {
	
	static Node head;
	
	static class Node{
		
		int data;
		Node next;
		Node(int d){
			data=d;
			next=null;
		}

		void remove_duplicates() {
			Node ptr1=null, ptr2=null, dup=null;
			ptr1=head;
			
			while(ptr1!=null && ptr1.next!=null) {
				ptr2=ptr1;
				
				while(ptr2.next!=null) {
					
					if(ptr1.data== ptr2.next.data) {
						dup=ptr2.next;
						ptr2.next=ptr2.next.next;
						System.gc();
					}else
						ptr2=ptr2.next;
				}
				
				ptr1=ptr1.next;
			}
			
		}
		
	}
	
	void print_list(Node node) {
		while(node != null) {
			System.out.println(node.data + "");
			node=node.next;
		}
	}
	
	public static void main(String[] args) {
		
		LinkedList list= new LinkedList();
		list.head= new Node(10);
		list.head.next= new Node(12);
		list.head.next.next= new Node(11);
		list.head.next.next.next= new Node(11);
		list.head.next.next.next.next= new Node(12);
		list.head.next.next.next.next.next= new Node(11);
		list.head.next.next.next.next.next.next= new Node(10);
		
		System.out.println("Linked list before removing the duplicate");
		
		list.print_list(head);
		
		//list.remove_duplicates();
		
		
	}

	

}
