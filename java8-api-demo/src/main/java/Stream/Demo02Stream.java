package Stream;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: my-design-patterns
 * @description: 1.8之后出现,关注的是做什么，而是不是怎么做
 * @author: Rui.Zhou
 * @create: 2019-07-03 17:01
 **/
public class Demo02Stream {
    public static void main(String[] args) {
        //创建一个List储存姓名
        List<String> list = new ArrayList<>();

        list.add("张三");
        list.add("张二娃");
        list.add("张五娃");
        list.add("李四");
        list.add("李三贵");
        list.add("周志伟");

        //对List中的元素进行过滤，只要以张开头的存储到一个集合中
        //对zhang进行过滤，只要姓名长度为3的人
        //遍历three打印

        list.stream()
                .filter(name->name.startsWith("张"))
                .filter(name->name.length()==3)
                .forEach(System.out::println);
    }
}
