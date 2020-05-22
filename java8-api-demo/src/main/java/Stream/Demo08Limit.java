package Stream;

import java.util.stream.Stream;

/**
 * @program: my-design-patterns
 * @description: 对流进行截取，取前n个
 * @author: Rui.Zhou
 * @create: 2019-07-09 15:37
 **/
public class Demo08Limit {

    public static void main(String[] args) {
        //获取Stream流
        Stream<String> stream = Stream.of("张三", "李四", "王五", "赵六", "田七");

        stream.limit(3).forEach(s -> System.out.println(s));
    }
}
