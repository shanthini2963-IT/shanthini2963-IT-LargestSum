
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LargestSum {
    /**
     * Get the largest possible sum that can be obtained from a pair of values in the list. A number can't be added
     * to itself, unless there are duplicates.
     *
     * @param nums a list of ints.
     * @return the largest possible sum of separate numbers from nums.
     */
    public int bigSum(List<Integer> nums){
        if (nums == null || nums.size() < 2) return 0;
        Map<Integer, Long> freq = nums.stream()
                                      .collect(Collectors.groupingBy(n -> n, Collectors.counting()));
        List<Integer> sorted = freq.keySet().stream()
                                   .sorted(Comparator.reverseOrder())
                                   .toList();
        if (sorted.isEmpty()) return 0;

        int first = sorted.get(0);
        if (freq.get(first) > 1) return first * 2;
        return sorted.size() > 1 ? first + sorted.get(1) : 0;
    }
}