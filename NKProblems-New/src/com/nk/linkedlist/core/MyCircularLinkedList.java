package com.nk.linkedlist.core;

import com.nk.exception.InvalidOperationException;

public class MyCircularLinkedList<T> extends MyList<T>
{
	public void addAtTop(T data)
	{
		Node<T> newNode = new Node<T>(data);
		if (head == null)
		{
			head = newNode;
			return;
		}

		newNode.next = head;
		Node<T> tempNode = head;
		while (tempNode.next != head)
		{
			tempNode = tempNode.next;
		}

		tempNode.next = newNode;
		head = newNode;
	}

	public void addAtLast(T data)
	{
		Node<T> newNode = new Node<T>(data);
		if (head == null)
		{
			head = newNode;
			return;
		}

		newNode.next = head;
		Node<T> tempNode = head;
		while (tempNode.next!= null && tempNode.next != head)
		{
			tempNode = tempNode.next;
		}

		tempNode.next = newNode;
	}

	public void addAt(T data, int pos) throws InvalidOperationException
	{
		if (pos <= 0)
			throw new InvalidOperationException("Invalid position");

		Node<T> newNode = new Node<T>(data);

		if (head == null)
		{
			if (pos == 1)
			{
				head = newNode;
				newNode.next = head;
				return;
			}
			throw new InvalidOperationException("Invalid position");
		}

		Node<T> tempNode = head;
		int cursor = 1;
		while (cursor < pos - 1 && tempNode.next != head)
		{
			tempNode = tempNode.next;
		}

		if (cursor != pos - 1)
		{
			throw new InvalidOperationException("Invalid position");
		}

		newNode.next = tempNode.next;
		tempNode.next = newNode;
	}

	public void printAll()
	{
		if(head == null)
		{
			System.out.println("HEAD-->NULL");
			return;
		}
		final char UP_ARROW = (char) 65514;
		Node<T> tempNode = head;
		System.out.print("HEAD");
		String listString = "";
		String listSecondString = "                      " + UP_ARROW;
		while (tempNode.next != head)
		{
//			System.out.print(tempNode+"==>");
			listString += "-->" + tempNode;
			tempNode = tempNode.next;
		}
		listString += "-->" + tempNode;
		System.out.println(listString);
		System.out.print(listSecondString);
		int cursor = listSecondString.length() - listSecondString.indexOf(UP_ARROW);
		while (cursor < listString.length() - 7)
		{
			System.out.print("_");
			cursor++;
		}
		System.out.print("|");
		System.out.println();
	}

	public void deleteAtTop() throws InvalidOperationException
	{
		if (head == null)
			throw new InvalidOperationException("List is already empty");

		if (head.next == head)
		{
			head = null;
			return;
		}

		Node<T> tempNode = head;
		while (tempNode.next != head)
		{
			tempNode = tempNode.next;
		}

		tempNode.next = head.next;
		head = head.next;
	}

	public void deleteAtLast() throws InvalidOperationException
	{
		if (head == null)
			throw new InvalidOperationException("List is already empty");

		if (head.next == head)
		{
			head = null;
			return;
		}

		Node<T> tempNode = head;
		while (tempNode.next.next != head)
		{
			tempNode = tempNode.next;
		}

		tempNode.next = head;
	}

	public void deleteAt(int pos) throws InvalidOperationException
	{
		if (head == null)
			throw new InvalidOperationException("List is already empty");

		if(pos == 1)
		{
			if (head.next == head)
			{
				head = null;
				return;

			}
			else
			{
				deleteAtTop();
				return;
			}
		}
		

		Node<T> tempNode = head;
		int cursor = 1;

		while (cursor < pos - 1 && tempNode.next.next != head)
		{
			tempNode = tempNode.next;
			cursor++;
		}

		if (cursor == pos - 1)
		{
			tempNode.next = tempNode.next.next;
			return;
		} else
			throw new InvalidOperationException("Invalid position");
	}

	public Node<T> getHead()
	{
		return head;
	}
}
