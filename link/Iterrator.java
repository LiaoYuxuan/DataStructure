package link;

import java.util.ArrayList;
import java.util.Iterator;

public class Iterrator {
    //迭代器也就是将集合的数据放到一个容器中并排成一排，iterator有一个游标，
    // 最初的时候，游标在第一个元素前面，调用Iterator.next()是将游标往后移
    // 一位，Iterator.hasNext()是判断游标后面还没有可以迭代的元素。
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
        }
    }
}
