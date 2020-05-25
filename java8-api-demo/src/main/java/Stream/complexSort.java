package Stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author: nyj
 * @CreateDate: 2018/9/13 14:32
 */
public class complexSort {

    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        User u1 = new User(18,4500, new Date(1));
        User u7 = new User(18,4500, new Date(2));
        User u2 = new User(22,1800, new Date(2));
        User u3 = new User(33,15000, new Date(6));
        User u4 = new User(24,17000, new Date(4));
        User u5 = new User(29,16000, new Date(7));
        User u6 = new User(30,7500, new Date(3));
        list.add(u1);
        list.add(u2);
        list.add(u3);
        list.add(u4);
        list.add(u5);
        list.add(u6);
        list.add(u7);


        Comparator<User> comparing = Comparator
                //通过两个值相减比较大小
                .comparing(User::getAge, (o1, o2) -> o2 - o1)
                .thenComparing(User::getBirthday,(o1, o2) -> (int) (o1.getTime()-o2.getTime()));

        List<User> collect = list.stream().sorted(comparing).collect(Collectors.toList());

        collect.forEach(
                user -> System.out.println(user.getAge()+":" +user.getBirthday().getTime())
        );
    }


}

class User {
    private int age;
    private int salary;
    private Date birthday;

    public User() {
    }

    public User(int age, int salary, Date birthday) {
        this.age = age;
        this.salary = salary;
        this.birthday = birthday;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}