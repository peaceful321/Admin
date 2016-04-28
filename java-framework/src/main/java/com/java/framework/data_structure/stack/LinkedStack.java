package com.java.framework.data_structure.stack;


/**
 * 链表实现 栈（Stack）
 * @author admin
 */
public class LinkedStack implements Stack {

	private int count;
	private SLLNode top;

	public LinkedStack(){
		clear();
	}

	public final void clear(){
		top=null;
		count=0;
	}


	/**
	 * Inner Class
	 * @author xuhuanchao
	 */
	private static class SLLNode{
		Object element;
		SLLNode next;
		SLLNode(){}
		SLLNode(Object element){
			this.element = element;
			next =null;
		}
		SLLNode(Object element, SLLNode link){
			this.element = element;
			this.next = link;
		}

	}

	/**
	 * 进栈
	 * @param obj
	 * @author xuhuanchao
	 */
	public void push(Object obj) {
		top = new SLLNode(obj,top);
		count++;
	}

	/**
	 * 出栈
	 * @author xuhuanchao
	 */
	public Object pop() {
		if(isEmpty()){
			throw new IllegalStateException();
		}
		Object object = top.element;
		top = top.next;
		count--;
		return object;
	}

	/**
	 * 判断栈是否为空栈
	 * @author xuhuanchao
	 */
	public boolean isEmpty() {
		return top==null;
	}

	/**
	 * 返回栈的深度（元素个数）
	 * @author xuhuanchao
	 */
	public int size() {
		return count;
	}

	/**
	 * 返回当前节点的元素数据，即栈顶元素的数据
	 * @author xuhuanchao
	 */
	public Object peek() {
		if(isEmpty()){
			throw new IllegalStateException();
		}
		return top.element;
	}
	/**
	 * 将栈中所有的对象的数据用逗号间隔，然后以字符串形式返回
	 * @author xuhuanchao
	 */
	public String toString(){
		String str ="[";
		SLLNode  curr = top;
		SLLNode pNode = top;
		while(pNode != null){
			if(pNode != top){
				str+=",";
			}
			str+=pNode.element;
			pNode = pNode.next;
		}
		str+="]";
		return str;
	}

}