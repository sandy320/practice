import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.stream.Collectors;

public class UniqueNumbers {

    public static Collection<Integer> findUniqueNumbers(Collection<Integer> numbers) {
        HashMap<Integer, Integer> map = new HashMap<>();
        numbers.stream()
               .forEach(n -> {
                   Integer value = map.get(n);
                   if (value == null) {
                       map.put(n, 1);
                   } else {
                       map.put(n, value + 1);
                   }
               });
        return map.entrySet()
                  .stream()
                  .filter(entry -> entry.getValue() == 1)
                  .map(e -> e.getKey())
                  .sorted()
                  .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Collection<Integer> numbers = Arrays.asList(1, 2, 1, 3);
        for (int number : findUniqueNumbers(numbers)) {
            System.out.println(number);
        }
    }
}
