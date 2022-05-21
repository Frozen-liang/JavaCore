package day_07_泛型treeSet.课堂;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class 泛型 {
    @Test
    public void test(){}
    @Test
    public void 泛型接口(){
        List<a> aArrayList = new ArrayList<>();
        aArrayList.add(new a());
        aArrayList.add(new b());
        List<b> bArrayList = new ArrayList<>();
        List<c> cArrayList = new ArrayList<>();
        cArrayList.add(new d());
        List<d> dArrayList = new ArrayList<>();
        dArrayList.add(new d());

        mathod(cArrayList);
        mathod(dArrayList);

        show(aArrayList);
        show(dArrayList);
    }
    // 只能传入 c 或 c的子类
    public void mathod(List<? extends c> list){
        // 不能存入数据 因为mathod不知道添加的子类还是父类
        // boolean add = list.add(new c());
        // 可以取出数据 用父类接住数据
        c c = list.get(0);
        System.out.println(c);
    }
    // 只能传入 d 或者 d类的父类
    public void show(List<? super d> list){
        // 不能获取数据 因为show不知道用哪个父类去接数据 ???
        Object object = list.get(0);
        System.out.println(object);
        // 可以存入数据 因为父类可以存入子类
        list.add(new d());

    }
    class a{}
    class b extends a{}
    class c extends a{}
    class d extends c{}

    public void test2(){}
    public void test3(){}
}
