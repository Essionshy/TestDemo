package com.tingyu.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class User{
    private Integer id;
    private String name;
    private Integer age;

    public User(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class StreamDemo {
    public static void main(String[] args) {
        User user1 = new User(1, "a", 25);
        User user2 = new User(2, "b", 21);
        User user3 = new User(3, "c", 23);
        User user4 = new User(4, "d", 27);
        User user5 = new User(5, "e", 28);

        List<User> list= Arrays.asList(user1,user2,user3,user4,user5);
        //list.forEach(System.out::println);
        // list  ===> Stream
        //list.stream().filter(t -> {return t.getId()%2==0;}).forEach(System.out::println);
        //映射
       // list.stream().map(t ->{return t.getName().toUpperCase();}).forEach(System.out::println);
        //排序
        //list.stream().map(t ->{return t.getName().toUpperCase();}).sorted().forEach(System.out::println);
        //list.stream().map(t ->{return t.getName().toUpperCase();}).sorted((o1,o2) ->{return o2.compareTo(o1);}).forEach(System.out::println);
        list.stream()
                .filter(t -> {return t.getId()%2==0;})
                .filter(t -> {return t.getAge()>24;})
                .map(t ->{return t.getName().toUpperCase();})
                .sorted((o1,o2) ->{return o2.compareTo(o1);})
                .forEach(System.out::println);


    }
}
