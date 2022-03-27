package generic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @date 2022/3/24 - 21:37
 */
class Generic_Dog {
    private String name;
    private int age;

    public Generic_Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

class Generic_Cat {
    private String name;
    private int age;

    public Generic_Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Generic_Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

/*
 * 类似于一个模板
 * */
class Generic_animal<E> {
    E s;

    public Generic_animal(E s) {
        this.s = s;
    }

    public E f() {
        return s;
    }
}

class A{}
class B extends A{}
class C <A> {
    A a;

    public C(A a) {
        this.a = a;
    }

    public void f(){
        System.out.println(a.getClass()); //getClass() 获取运行类型
    }
}

@SuppressWarnings("all")
public class Generic {
    /*
     * 传统演示
     * */
    @Test
    public void test1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Generic_Dog("xiaoxu", 1));
        arrayList.add(new Generic_Dog("liangjiedong", 1));
        arrayList.add(new Generic_Dog("xl", 1));

        // 默认的是放入
        for (Object obj : arrayList) {
            //  Object父类向下转型Generic_Dog子类
            Generic_Dog dog = (Generic_Dog) obj;
            System.out.println(dog.getName() + " " + dog.getAge());
        }
    }

    @Test
    public void test2() {
        ArrayList<Generic_Dog> generic_dogs = new ArrayList<>();
        generic_dogs.add(new Generic_Dog("xiaoxu", 1));
        generic_dogs.add(new Generic_Dog("liangjiedong", 1));
        generic_dogs.add(new Generic_Dog("xl", 1));

        // 无需类型转换
        for (Generic_Dog dog : generic_dogs) {
            System.out.println(dog.getName() + " " + dog.getAge());
        }
    }

    @Test
    public void test3() {
        Generic_animal<String> stringGeneric_animal = new Generic_animal<>("梁杰栋");
        System.out.println(stringGeneric_animal.f());
    }

    @Test
    public void test4() {
        HashSet<Generic_Cat> generic_cats = new HashSet<>();
        generic_cats.add(new Generic_Cat("xy", 1));
        generic_cats.add(new Generic_Cat("ljd", 1));

        for (Generic_Cat cat : generic_cats) {
            System.out.println(cat.getName() + " " + cat.getAge());
        }
    }

    @Test
    public void test5() {
        HashMap<String, Generic_Cat> map = new HashMap<>();
        map.put("新余学院", new Generic_Cat("xy", 1));
        map.put("湖北理工", new Generic_Cat("ljd", 2));

        Set<Map.Entry<String, Generic_Cat>> entries = map.entrySet();

        Iterator<Map.Entry<String, Generic_Cat>> iterator = entries.iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Generic_Cat> next = iterator.next();
            System.out.println(next.getKey() + " " + next.getValue());
        }
    }

    @Test
    public void test6(){
        ArrayList<Object> objects = new ArrayList<>();
//        ArrayList<int> list = new ArrayList<>(); int
        ArrayList<Integer> arrayList = new ArrayList<>();
    }

    @Test
    public void test7(){
        C<A> ac = new C<>(new A());
        C<B> bc = new C<>(new B());
        ac.f();
        bc.f();
    }
}
