package com.java.framework.data_structure.queue;


/**
 * 用循环数组实现队列
 * 队列：先进先出（first-in-first-out）
 * @author xuhuanchao
 */
public class ArrayQueue implements Queue {

	private static final int DEFAULT_SIZE=5;//队列默认长度为5
	private Object[] array;
	private int front;
	private int rear;
	private int count;

	//Constructor
	public ArrayQueue(){
		array = new Object[DEFAULT_SIZE];
		front = rear = 0;
		count =0;
	}

	@Override
	public void clear() {//清空队列
		for(int i=0; i<array.length; i++){
			array[i] = null;
			front = rear = count = 0;
		}
	}

	@Override
	public void enqueue(Object obj) {        //入队
		if (count == array.length) {
			expand();
		}
		array[rear++] = obj;
		if (rear == array.length) {
			rear = 0;
		}
		count++;

	}

	@Override
	public Object dedueue() {
		if(isEmpty())
			throw new IllegalStateException();
		Object val = array[front];
		array[front++] = null;
		if(front == array.length){
			front = 0;
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
		if(isEmpty()){
			throw new IllegalStateException();
		}
		return array[front];
	}

	/**
	 * 如果数组长度不够，则成倍增加其长度
	 * @author xhc
	 */
	public void expand(){
		Object[] newArray = new Object[2 * array.length];
		for(int i=0; i<array.length; i++){
			newArray[i] = array[(front+i) % array.length];
		}
		front =0;
		rear = array.length;
		array = newArray;
	}

	/**
	 * 将队列中的所有元素以逗号分割，然后以字符串形式返回
	 * @author xhc
	 */
	public String toString(){
		String buf = new String("[");
		for(int i=0; i<count; i++){
			if(i>0){
				buf+=",";
			}
			buf+=array[(front+i) % array.length].toString();
		}
		buf+="]";
		return buf;
	}

}
