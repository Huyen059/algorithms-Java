package com.company;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Learn {
    public static void main(String[] args) {
//        Product door = new Product(1, "Wooden Door", 35);
//        Product floorPanel = new Product(2, "Floor Panel", 25);
//        Product window = new Product(3, "Glass Window", 10);
//
//        List<Product> products = new ArrayList<>();
//        products.add(door);
//        products.add(floorPanel);
//        products.add(window);
//        products.add(floorPanel);
//        products.add(window);
//        products.add(floorPanel);
//        List<Product> a = products.stream().sorted(Comparator.comparingInt(Product::getWeight)).collect(Collectors.toList());
//        List<Product> b = products.stream().filter(item -> item.getWeight() > 30).collect(Collectors.toList());
//        List<Product> c = products.stream().distinct().collect(Collectors.toList());
//        List<String> d = products.stream().map(product -> product.getName() + product.getWeight()).sorted().collect(Collectors.toList());
//        var e = products.stream().anyMatch(product -> product.getWeight() > 30);
//        var f = products.stream().allMatch(product -> product.getWeight() > 20);
//        Product[] g = products.toArray(Product[]::new);
//        var h = Arrays.stream(g).distinct().collect(Collectors.toList());
//        h.add(door);

//        Function<String, Integer> converter = Integer::parseInt;
//        var result = converter.apply("123");

//        Predicate<Integer> isPossitive = num -> num > 0;
//        var r1 = isPossitive.test(123);
//        var isNegative = isPossitive.negate();
//        var r2 = isNegative.test(-1);
//        var isPossitiveAndEven = isPossitive.and(num -> num % 2 == 0);
//        var r3 = isPossitiveAndEven.test(4);

//        String input = "4";
//        Function<String, Integer> convert = Integer::parseInt;
//        var powerTwo = convert.andThen(num -> num * num);
//        var r1 = convert.apply(input);
//        var r2 = powerTwo.apply(input);

//        double value = Math.random();
//        Optional<String> optional = value > 0.5 ? Optional.of("abc") : Optional.empty();
//        if (optional.isPresent()) {
//            String result1 = optional.get();
//        } else {
//            System.out.println("null object");
//        }
//        String result2 = optional.orElse("default");

//        List<String> stringCollection = new ArrayList<>();
//        stringCollection.add("ddd2");
//        stringCollection.add("aaa2");
//        stringCollection.add("bbb1");
//        stringCollection.add("aaa1");
//        stringCollection.add("bbb3");
//        stringCollection.add("ccc");
//        stringCollection.add("bbb2");
//        stringCollection.add("ddd1");
//        Optional<String> length = stringCollection
//                .stream()
//                .reduce((s, s2) -> s + " " + s2);

//        OptionalDouble r = IntStream.range(1, 4)
//                .average();

//        class Person {
//            String name;
//            int age;
//            Person(String name, int age) {
//                this.name = name;
//                this.age = age;
//            }
//
//            @Override
//            public String toString() {
//                return name;
//            }
//        }
//
//        List<Person> persons = Arrays.asList(
//                        new Person("Max", 18),
//                        new Person("Peter", 23),
//                        new Person("Pamela", 23),
//                        new Person("David", 12));
//
//        var personsByAge = persons
//                .stream()
//                .collect(Collectors.groupingBy(person -> person.age));
//
//        var totalAge = persons
//                .stream()
//                .reduce(0, (sum, person) -> sum += person.age, Integer::sum);

//        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
//        map.putIfAbsent("A", 18);
//        map.putIfAbsent("B", 22);
//        map.putIfAbsent("C", 34);
//        map.putIfAbsent("D", 12);
//
//        var r1 = map.reduce(1, (key, value) -> value, Integer::sum);
//        var r2 = map.reduce(1, (key, value) -> value >= 18 ? value : 0, Integer::sum);

//        ToIntBiFunction<Integer, Integer> function = Integer::sum;
//        var r = function.applyAsInt(2, 4);

//        IntFunction<Integer> function = a -> a * 10;
//        var r = function.apply(3);

//        ObjIntConsumer<String> consumer = (a, b) -> System.out.println(a + b);
//        consumer.accept("abc", 123);

//        CURRYING
//        Function<IntUnaryOperator, IntBinaryOperator> function = unaryOperator -> (number1, number2) -> unaryOperator.applyAsInt(number1) + unaryOperator.applyAsInt(number2);
//        var r = function.apply(x -> x * x).applyAsInt(5, 10);

//        List<String> friends = List.of("An", "Binh", "Cong", "Dung");
//        List<String> partners = List.of("Mr. An", "Mr. Binh", "Mr. Cong", "Mrs. Dung");
//
//        Function<String, Consumer<String>> greeting = what -> who -> System.out.println(what + " " + who);
//        friends.forEach(friend -> greeting.apply("Hi").accept(friend));
//        partners.forEach(partner -> greeting.apply("Hello").accept(partner));

        System.out.println("");
    }


}

class Product
{
    private final int id;
    private final String name;
    private final int weight;

    public Product(final int id, final String name, final int weight)
    {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    public String getName()
    {
        return name;
    }

    public int getWeight()
    {
        return weight;
    }

    public int getId()
    {
        return id;
    }

    public String toString()
    {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }

    public boolean equals(final Object o)
    {
        if (!(o instanceof Product)) return false;

        final Product product = (Product) o;

        return Objects.equals(id, product.id)
                && Objects.equals(weight, product.weight)
                && Objects.equals(name, product.name);
    }

    public int hashCode()
    {
        return Objects.hash(id, name, weight);
    }
}
