package day_13_类加载器.课堂;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class day_13 {

    public day_13() {
    }

    private day_13(String name) {
        System.out.println(name);
    }
}

public class 获取Class对象 {
    @Test
    public void 三种方法() throws ClassNotFoundException {
        // 全类名 包名加类名
        //Class<?> aClass = Class.forName("day_13_类加载器.课堂.获取Class对象.java");

        //
        Class<day_13> day_13Class = day_13.class;

        // 创建对象
        day_13 day_13 = new day_13();
        Class<? extends day_13_类加载器.课堂.day_13> aClass1 = day_13.getClass();

        System.out.println();
        System.out.println(day_13Class);
        System.out.println(aClass1);

    }

    @Test
    public void 强行反射() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //
        Class<day_13> day_13Class = day_13.class;

        // 获取无惨构造方法
        Constructor<day_13> declaredConstructor = day_13Class.getDeclaredConstructor(String.class);

        // 设置权限 获取私有属性
        declaredConstructor.setAccessible(true);

        // 创建对象
        day_13 newInstance = declaredConstructor.newInstance("梁杰栋");

        // 调用方法
        System.out.println(newInstance);

    }
}
