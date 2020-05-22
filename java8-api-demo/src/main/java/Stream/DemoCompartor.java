package Stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: zhr66-study
 * @description:
 * @author: Rui.Zhou
 * @create: 2019-10-31 12:30
 **/
public class DemoCompartor {


    public static void main(String[] args) {

        ArrayList<Cat> cats = new ArrayList<>();
        cats.add(new Cat(1,"AAA"));
        cats.add(new Cat(4,"AAA"));
        cats.add(new Cat(2,"ccc"));
        cats.add(new Cat(2,"bbb"));


        Comparator<Cat> catComparator = Comparator.comparing(Cat::getId).thenComparing(Cat::getName);


        List<Cat> collect = cats.stream().sorted(catComparator).collect(Collectors.toList());

        collect.forEach(x->
                        System.out.println(x.getId() + ":" + x.getName())
                );

    }




}
