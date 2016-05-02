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
     * 获取类类型的三种方式(用之前写的RationalImpl类举例)
     * 三种方式都可以
     */
    public static Class<?> getClassMethods() {
        Class<?> clazz = null;

        //1.通过Class的静态方法forName("packageName + className");
        try {
            clazz = Class.forName("com.java.framework.data_structure.adt.RationalImpl");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

//        //2.通过类的class属性
//        clazz = RationalImpl.class;
//
//        //3.通过RationalImpl的对象，调用getClass()方法获取
//        clazz = new RationalImpl(2,2).getClass();
        return clazz;
    }


    /**
     * 测试 Class常用的方法
     */
    public static void testUsualMethods(Class<?> clazz) {

        System.out.println("类名字：" + clazz.getName());
        System.out.println("包名：" + clazz.getPackage());

        //获取所有公开字段
        Field[] fields = clazz.getFields();
        for (Field f : fields) {
            System.out.println("公开字段：" + f.getName());
        }
        //获取所有字段包括私有
        Field[] privateFields = clazz.getDeclaredFields();
        for(Field f : privateFields) {
            System.out.println("所有字段：" + f.getName());
        }

        //获取具体的某一个字段，可以获取私有字段
        try {
            Field field = clazz.getDeclaredField("numerator");
            System.out.println("指定Field Name获取的字段：" + field.getName() + ", 字段类型：" + field.getType());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        System.out.println("**********************Method**************************");

        //获取所有的公开的方法
        Method[] methods = clazz.getMethods();
        for (Method m : methods) {
            System.out.println("获取的所有公开的方法：" + m.getName() + ",方法访问修饰符：" + getAccessPermission(m.getModifiers()));
        }

        Method[] privateMethods = clazz.getDeclaredMethods();
        for (Method m : privateMethods) {
            System.out.println("获取所有的方法（include private） : " + m.getName() + "，访问权限：" + getAccessPermission(m.getModifiers()));
        }

        //通过方法名，指定获取具体的一个方法对象
        try {
            Method method = clazz.getDeclaredMethod("getCommonDivisor", int.class, int.class);
            RationalImpl r = new RationalImpl(2, 3);
            System.out.println("方法名：" + method.getName() );
            //Tips:通过Method对象的invoke方法，调用私有方法，一定要设置其访问权限为true，否则为报IllegalAccessException异常
            method.setAccessible(true);
            System.out.println("反射调用RationalImpl中的获取最大公约数的方法：value = " + method.invoke(r, 8, 72));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        //构造方法对象Constructor
        try {
            Constructor constructor = clazz.getConstructor(int.class, int.class);
            RationalImpl r = (RationalImpl) constructor.newInstance(4,32);
            System.out.println("比较大小 ： " + r.compareTo(new RationalImpl(1, 8)));
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
