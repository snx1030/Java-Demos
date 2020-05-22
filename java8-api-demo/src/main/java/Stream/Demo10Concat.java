package Stream;

import java.util.stream.Stream;

/**
 * @program: my-design-patterns
 * @description:
 * @author: Rui.Zhou
 * @create: 2019-07-09 16:22
 **/
public class Demo10Concat {

    public static void main(String[] args) {

        Stream<String> stream1 = Stream.of("张三");

        Stream<Integer> stream2 = Stream.of(1);

        Stream.concat(stream1,stream2).forEach(System.out::println);

    }
}
