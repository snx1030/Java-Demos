package Stream;

import java.util.stream.Stream;

/**
 * @program: my-design-patterns
 * @description: Stream流的终结方法，返回元素个数
 * @author: Rui.Zhou
 * @create: 2019-07-09 15:33
 **/
public class Demo07Count {

    public static void main(String[] args) {


        //创建Stream流

        Stream<String> stream = Stream.of("张三", "李四", "王五", "赵六", "田七");

        long count = stream.count();

        System.out.println(count);
    }
}
