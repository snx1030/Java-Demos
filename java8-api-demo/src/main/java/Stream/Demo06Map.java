package Stream;

import java.util.stream.Stream;

/**
 * @program: my-design-patterns
 * @description: 将流中的元素映射到另一个流中
 * @author: Rui.Zhou
 * @create: 2019-07-09 15:05
 **/
public class Demo06Map {

    public static void main(String[] args) {

        //获取一个String类型的流
        Stream<String> stringStream = Stream.of("1", "2", "3");

        //适用map把字符串映射成integer
        stringStream.map(s -> Integer.parseInt(s)).forEach(integer -> System.out.println(integer));




    }
}
