package enumber;

import org.junit.Test;

// 这个类不能体现出来固定的属性
class Enum_season1 {
    private String name;
    private String description;

    public static final Enum_season1 SPRING = new Enum_season1("春天", "温暖");

    private Enum_season1(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Enum_season{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

enum Enum_season2 {
    //  开头位置
//  private static final Enum_season SPRING = new Enum_season("春天","温暖");
    Spring(1, "春天", "温暖"),
    Summer(2, "夏天", "炎热"),
    Autumn(3, "秋天", "凉爽"),
    Winter(4, "冬天", "寒冷");

    private String name;
    private String description;

    // 构造器默认私有
    Enum_season2(int num, String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Enum_season2{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

public class Enumeration {

    @Test
    public void Enum_1() {
        // 对于季节都是固定的 不会变化的
//        Enum_season1 enum_season = new Enum_season1("111","温暖");
//
//        System.out.println(enum_season);
    }

    @Test
    public void Enum_1_1() {
        // 构造器私有化
        System.out.println(Enum_season1.SPRING);
    }

    @Test
    public void Enum_Enum_season2_方法() {
        // Enum_season2
        System.out.println(Enum_season2.values());      // 数组地址
        Enum_season2[] values = Enum_season2.values();
        for (Enum_season2 s : values) {
            System.out.println(s);
        }

        Enum_season2 spring = Enum_season2.valueOf("Spring");   // 在枚举中找到枚举转化为字符串形式
        System.out.println(spring);
    }

    @Test
    public void Enum_Enum_season2_Spring_方法() {

        // Enum_season2.Spring
        System.out.println(Enum_season2.Spring);
        System.out.println(Enum_season2.Spring.name());
        // 编号
        int ordinal = Enum_season2.Spring.ordinal();
        System.out.println(ordinal);

        Class<Enum_season2> declaringClass = Enum_season2.Spring.getDeclaringClass();
        System.out.println(declaringClass);
        // 编号 0 - 2 = -2
        int i = Enum_season2.Spring.compareTo(Enum_season2.Autumn);
        System.out.println(i);

    }
}
