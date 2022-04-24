package day_13_类加载器.课堂;

import org.junit.Test;

class 加载器 {
}

public class 加载器类别 {
    @Test
    public void 打印加载器() {
        ClassLoader classLoader = 加载器.class.getClassLoader();
        ClassLoader classLoader1 = classLoader.getParent();
        ClassLoader classLoader2 = classLoader.getParent();

        System.out.println(classLoader);
        System.out.println(classLoader1);
        System.out.println(classLoader2);
    }
}
