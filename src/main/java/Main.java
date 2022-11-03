import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String s="This is a testing string";

        s
                .chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream().filter(i->i.getValue()>1)
                .forEach(System.out::println);

        //another way


        s
                .chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream().collect(Collectors.partitioningBy(i->i.getValue()>1))
                .entrySet()
                .forEach(System.out::println);
    }
}
