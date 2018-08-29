package com.nk.linkedlist.core;

import com.nk.linkedlist.core.MyDBLinkedList.Node;
import com.nk.linkedlist.exceptions.InvalidOperationException;

public class MyCircularLinkedList<T>
{
	Node head;
	
	private class Node
	{
		T data;
		Node next;
		
		Node(T data)
		{
			this.data = data;
			next = this;
		}
		
		@Override
		public String toString()
		{
			return "["+data+"]";
		}
	}
	
	public void addAtTop(T data)
	{
		Node newNode = new Node(data);	
		if(head == null)
		{
			head = newNode;
			return;
		}
		
		newNode.next = head;
		Node tempNode = head;
		while(tempNode.next != head)
		{
			tempNode = tempNode.next;
		}
		
		tempNode.next = newNode;
		head = newNode;
	}
	
	public void addAtLast(T data)
	{
		Node newNode = new Node(data);	
		if(head == null)
		{
			head = newNode;
			return;
		}
		
		newNode.next = head;
		Node tempNode = head;
		while(tempNode.next != head)
		{
			tempNode = tempNode.next;
		}
		
		tempNode.next = newNode;
		head = newNode;
	}
	
	public void addAt(T data, int pos) throws InvalidOperationException
	{
		if(pos <= 0)
			throw new InvalidOperationException("Invalid position");
		
		Node newNode = new Node(data);
		
		if(head == null)
		{
			if(pos == 1)
			{
				head = newNode;
				return;
			}
			throw new InvalidOperationException("Invalid position");
		}
			
		Node tempNode = head;
		int cursor = 1;
		while(cursor < pos-1 && tempNode.next != head )
		{
			tempNode = tempNode.next;
		}
		
		if(cursor != pos -1)
		{
			throw new InvalidOperationException("Invalid position");
		}
		
		newNode.next = tempNode.next;
		tempNode.next = newNode;		
	}
	
	public void printAll()
	{
		final char UP_ARROW =(char)65514;
		Node tempNode = head;
		System.out.print("HEAD");
		String listString = "";
		String listSecondString = "                      "+UP_ARROW;
		while(tempNode.next != head)
		{
//			System.out.print(tempNode+"==>");
			listString += "-->"+tempNode;
			tempNode = tempNode.next;
		}
		listString += "-->"+tempNode;
		System.out.println(listString);
		System.out.print(listSecondString);
		int cursor = listSecondString.length()-listSecondString.indexOf(UP_ARROW);
		while(cursor < listString.length()-7)
		{
			System.out.print("_");
			cursor++;
		}
		System.out.print("|");
	}
}
