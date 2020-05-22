package Stream;

import java.util.stream.Stream;

/**
 * @program: my-design-patterns
 * @description:
 * @author: Rui.Zhou
 * @create: 2019-07-09 11:11
 **/
public class Demo05Filter {

    public static void main(String[] args) {

        //创建Stream流

        Stream<String> stream = Stream.of("张三", "李四", "王五", "赵六", "田七");


        stream.filter(name->name.startsWith("张")).forEach(name-> System.out.println(name));

        //管道流的特点使用过就关闭了
        //stream has already been operated upon or closed

        stream.forEach(name-> System.out.println(name));
    }
}
