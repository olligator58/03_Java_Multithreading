package Task4090;

import java.util.LinkedList;
import java.util.List;

/*
Рефакторинг, анонимные классы
*/

public class Solution {
    public static List<Iterator> iterators = new LinkedList<>();

    private int countItems;

    public Iterator getIterator(final String name) {
        return new Iterator() {
            {
                countItems++;
                System.out.println(name + " item " + countItems);
            }

            public Iterator next() {
                return Solution.this.getIterator(name);
            }
        };
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        Iterator iterator = solution.getIterator("iterator");
        for (int i = 1; i < 5; i++) {
            iterators.add(iterator.next());
        }
    }
}
