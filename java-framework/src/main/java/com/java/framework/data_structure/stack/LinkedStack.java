package com.java.framework.data_structure.stack;


/**
 * ����ʵ�� ջ��Stack��
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
	 * ��ջ
	 * @param obj
	 * @author xuhuanchao
	 */
	public void push(Object obj) {
		top = new SLLNode(obj,top);
		count++;
	}

	/**
	 * ��ջ
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
	 * �ж�ջ�Ƿ�Ϊ��ջ
	 * @author xuhuanchao
	 */
	public boolean isEmpty() {
		return top==null;
	}

	/**
	 * ����ջ����ȣ�Ԫ�ظ�����
	 * @author xuhuanchao
	 */
	public int size() {
		return count;
	}

	/**
	 * ���ص�ǰ�ڵ��Ԫ�����ݣ���ջ��Ԫ�ص�����
	 * @author xuhuanchao
	 */
	public Object peek() {
		if(isEmpty()){
			throw new IllegalStateException();
		}
		return top.element;
	}
	/**
	 * ��ջ�����еĶ���������ö��ż����Ȼ�����ַ�����ʽ����
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