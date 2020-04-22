package com.laorencel.learn.reflection;

import com.laorencel.learn.Hero;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTest {

    public static void main(String[] args) {
//       constuctor();
//        getMethod();
        invokeMethod();
    }

    private static void invokeMethod() {
        Hero hero = new Hero("盖伦");
        try {
            Method method = hero.getClass().getMethod("setName", String.class);
            method.invoke(hero, "盖伦1");
            System.out.println("hero = " + hero);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private static void getMethod() {
        Hero hero = new Hero("盖伦");
        //getField和getDeclaredField的区别
        //这两个方法都是用于获取字段
        //getField 只能获取public的，包括从父类继承来的字段。
        //getDeclaredField 可以获取本类所有的字段，包括private的，但是不能获取继承来的字段。 (注： 这里只能获取到private的字段，但并不能访问该private字段的值,除非加上setAccessible(true))
        Field[] fields = hero.getClass().getDeclaredFields();
        for (Field field :
                fields) {
            System.out.println("DeclaredField = " + field);
        }
        Field[] fields1 = hero.getClass().getFields();
        for (Field field :
                fields1) {
            System.out.println("field = " + field);
        }
        Class[] classes = hero.getClass().getDeclaredClasses();
        for (Class field :
                classes) {
            System.out.println("Class = " + field);
        }
        Annotation[] annotations = hero.getClass().getDeclaredAnnotations();
        for (Annotation field :
                annotations) {
            System.out.println("Annotation = " + field);
        }
        Method[] methods = hero.getClass().getDeclaredMethods();
        for (Method field :
                methods) {
            System.out.println("Method = " + field);
        }
        Constructor[] constructors = hero.getClass().getDeclaredConstructors();
        for (Constructor field :
                constructors) {
            System.out.println("Constructor = " + field);
        }


    }

    private static void constuctor() {
        try {
            Class c = Class.forName("com.laorencel.learn.Hero");
            Constructor constructor = c.getConstructor();
            Hero hero = (Hero) constructor.newInstance();
            hero.name = "盖伦";
            System.out.println("盖伦 = " + hero);
            Constructor constructor1 = hero.getClass().getConstructor(String.class);
            Hero timo = (Hero) constructor1.newInstance("提莫");
            System.out.println("constructor = " + constructor1);
            System.out.println("提莫 = " + timo);
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
