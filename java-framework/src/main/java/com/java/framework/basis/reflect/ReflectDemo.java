package com.java.framework.basis.reflect;

import com.java.framework.data_structure.adt.RationalImpl;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by Ryan Xu on 2016/5/1.
 */
public class ReflectDemo {

    public static void main(String args[]) {

        Class<?> clazz = getClassMethods();

        testUsualMethods(clazz);
    }


    /**
     * ��ȡ�����͵����ַ�ʽ(��֮ǰд��RationalImpl�����)
     * ���ַ�ʽ������
     */
    public static Class<?> getClassMethods() {
        Class<?> clazz = null;

        //1.ͨ��Class�ľ�̬����forName("packageName + className");
        try {
            clazz = Class.forName("com.java.framework.data_structure.adt.RationalImpl");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

//        //2.ͨ�����class����
//        clazz = RationalImpl.class;
//
//        //3.ͨ��RationalImpl�Ķ��󣬵���getClass()������ȡ
//        clazz = new RationalImpl(2,2).getClass();
        return clazz;
    }


    /**
     * ���� Class���õķ���
     */
    public static void testUsualMethods(Class<?> clazz) {

        System.out.println("�����֣�" + clazz.getName());
        System.out.println("������" + clazz.getPackage());

        //��ȡ���й����ֶ�
        Field[] fields = clazz.getFields();
        for (Field f : fields) {
            System.out.println("�����ֶΣ�" + f.getName());
        }
        //��ȡ�����ֶΰ���˽��
        Field[] privateFields = clazz.getDeclaredFields();
        for(Field f : privateFields) {
            System.out.println("�����ֶΣ�" + f.getName());
        }

        //��ȡ�����ĳһ���ֶΣ����Ի�ȡ˽���ֶ�
        try {
            Field field = clazz.getDeclaredField("numerator");
            System.out.println("ָ��Field Name��ȡ���ֶΣ�" + field.getName() + ", �ֶ����ͣ�" + field.getType());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        System.out.println("**********************Method**************************");

        //��ȡ���еĹ����ķ���
        Method[] methods = clazz.getMethods();
        for (Method m : methods) {
            System.out.println("��ȡ�����й����ķ�����" + m.getName() + ",�����������η���" + getAccessPermission(m.getModifiers()));
        }

        Method[] privateMethods = clazz.getDeclaredMethods();
        for (Method m : privateMethods) {
            System.out.println("��ȡ���еķ�����include private�� : " + m.getName() + "������Ȩ�ޣ�" + getAccessPermission(m.getModifiers()));
        }

        //ͨ����������ָ����ȡ�����һ����������
        try {
            Method method = clazz.getDeclaredMethod("getCommonDivisor", int.class, int.class);
            RationalImpl r = new RationalImpl(2, 3);
            System.out.println("��������" + method.getName() );
            //Tips:ͨ��Method�����invoke����������˽�з�����һ��Ҫ���������Ȩ��Ϊtrue������Ϊ��IllegalAccessException�쳣
            method.setAccessible(true);
            System.out.println("�������RationalImpl�еĻ�ȡ���Լ���ķ�����value = " + method.invoke(r, 8, 72));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        //���췽������Constructor
        try {
            Constructor constructor = clazz.getConstructor(int.class, int.class);
            RationalImpl r = (RationalImpl) constructor.newInstance(4,32);
            System.out.println("�Ƚϴ�С �� " + r.compareTo(new RationalImpl(1, 8)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param permission
     * @return
     */
    public static String getAccessPermission(int permission) {
        String accessPermission = "";
        switch(permission) {
            case Modifier.PUBLIC:
                accessPermission = "PUBLIC";
                break;
            case Modifier.PRIVATE:
                accessPermission = "PRIVATE";
                break;
        }
        return accessPermission;
    }

}
