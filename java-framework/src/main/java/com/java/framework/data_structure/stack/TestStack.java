package com.java.framework.data_structure.stack;

public class TestStack {

	/**
	 * ͨ�����߳�----����
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedStack ls = new LinkedStack();
//		boolean flag = ls.isEmpty();
//		System.out.println(flag);

//		ls.push("Tom");
//		String obj = ls.peek().toString();
//		System.out.println(obj);

//		ls.push("1");
//		ls.push("2");
//		String ls_str = ls.toString();
//		System.out.println(ls_str);//�Ƚ����

//		ls.push("tom");
//		ls.push(1);
//		ls.push('a');
//		String ls_str = ls.toString();
//		System.out.println(ls_str);//�Ƚ����

//		ls.push("obj1");
//		ls.push("obj2");
//		ls.push("obj3");
//		ls.push("obj4");
//		ls.pop();		//ɾ��
//		System.out.println(ls.toString());

//		int count1 = ls.size();
//		System.out.println(count1);
//		ls.push("obj1");
//		int count2 = ls.size();
//		System.out.println(count2);

		ls.push("obj1");
		ls.push("obj1");
		ls.push("obj1");
		int count1 = ls.size();
		System.out.println(count1);
		ls.clear();//���ջ
		boolean flag = ls.isEmpty();
		System.out.println(flag);
		System.out.println(ls.size());

		//over
	}

}
