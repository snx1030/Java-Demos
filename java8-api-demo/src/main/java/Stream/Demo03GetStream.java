package Stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @program: my-design-patterns
 * @description:
 * @author: Rui.Zhou
 * @create: 2019-07-09 10:18
 **/
public class Demo03GetStream {

    public static void main(String[] args) {

        //集合转stream
        ArrayList<Object> list = new ArrayList<>();

        Stream<Object> stream = list.stream();

        HashSet<Object> set = new HashSet<>();

        Stream<Object> stream1 = set.stream();

        HashMap<Object, Object> map = new HashMap<>();

        Stream<Object> stream2 = map.values().stream();
        Stream<Object> stream3 = map.keySet().stream();
        Stream<Map.Entry<Object, Object>> stream4 = map.entrySet().stream();

        int[] ints = {1,2,3};
        //数组转steam
        Stream<int[]> ints1 = Stream.of(ints);





    }
}
