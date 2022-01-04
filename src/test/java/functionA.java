import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

public class functionA {

    @Test
    public void shouldReturnOnlyUniqueIntegers() {
        Integer[] nums = {2, 5, -8, 2, 6, -5, 5};
        Set<Integer> my_set = new HashSet<>();
        for (int item : nums) {
            if (my_set.add(item) == false) {
                System.out.println("item is Duplicate: " + item);
            }
        }

        //System.out.println("only unique numbers" + my_set);


    }

}


