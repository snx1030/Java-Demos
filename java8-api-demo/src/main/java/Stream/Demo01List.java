package Stream;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: my-design-patterns
 * @description:
 * @author: Rui.Zhou
 * @create: 2019-07-03 16:50
 **/
public class Demo01List {


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

        ArrayList<String> zhang = new ArrayList<>();

        for (String s : list) {

            if(s.startsWith("张")){
                zhang.add(s);
            }
        }

        //对zhang进行过滤，只要姓名长度为3的人

        ArrayList<String> three = new ArrayList<>();

        for (String s : zhang) {

            if(s.length() == 3){
                three.add(s);
            }
        }

        //遍历three打印

        for (String s : three) {

            System.out.println(s);
        }
    }


}
