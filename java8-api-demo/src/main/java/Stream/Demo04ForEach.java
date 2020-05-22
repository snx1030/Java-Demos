package Stream;

import java.util.stream.Stream;

/**
 * @program: my-design-patterns
 * @description: 用来遍历流中的数据，是一个终结方法，遍历后不能调用流中其他方法
 * @author: Rui.Zhou
 * @create: 2019-07-09 10:55
 **/
public class Demo04ForEach {

    public static void main(String[] args) {
        //获取Stream流
        Stream<String> stream = Stream.of("张三", "李四", "王五", "赵六", "田七");

        stream.forEach(s-> System.out.println(s));

    }


}
