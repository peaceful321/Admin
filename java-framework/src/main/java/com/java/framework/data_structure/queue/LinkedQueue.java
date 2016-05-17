package com.java.framework.data_structure.queue;

/**
 * 用链表实现队列
 * @author xhc
 */
public class LinkedQueue implements Queue {
	private SLLNode front, rear;
	private int count;

	//Construtor
	public LinkedQueue(){
		clear();
	}

	/**
	 * Inner Class
	 * 表示一个节点
	 * @author xhc
	 */
	private static class SLLNode{
		Object element;
		SLLNode next;

		//Construtor
		SLLNode(){

		}
		SLLNode(Object element){
			this.element = element;
		}
		SLLNode(Object element, SLLNode pNode){
			this.element = element;
			this.next = pNode;
		}
	}

	@Override
	public void clear() {
		front = rear = null;
		count = 0;
	}

	@Override
	public void enqueue(Object obj) {//入队
		SLLNode pNode = new SLLNode(obj,null);
		if(rear == null){
			front = pNode;
		}else{
			rear.next = pNode;
		}
		rear = pNode;
		count++;
	}

	@Override
	public Object dedueue() {
		if(count ==0 ){
			throw new IllegalStateException();
		}
		Object val = front.element;
		front = front.next;
		if(front == null){
			rear =null;
		}
		count--;
		return val;
	}

	@Override
	public boolean isEmpty() {
		return count == 0;
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public Object peek() {
		if(isEmpty())
			throw new IllegalStateException();
		return front.element;
	}

	public String toString(){
		String buf = new String("[");
		SLLNode pNode = front;
		while(pNode != null){
			if(pNode != front){
				buf+=",";
			}
			buf+=pNode.element.toString();
			pNode = pNode.next;
		}
		buf+="]";
		return buf;
	}

}
