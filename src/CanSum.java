import java.util.HashMap;
import java.util.Map;

/**
 * @author : Ahmad Al-Omari
 * @mailto : alomari.ah98@gmail.com
 * @created : 10/21/2022, Friday
 * @project : dynamic-programming-memoization-can-sum
 **/
public class CanSum {

    public static boolean canSum(int targetSum, int[] numbers, Map<Integer, Boolean> memo){
        if(memo.containsKey(targetSum)){
            return memo.get(targetSum);
        }
        if (targetSum == 0){
            return true;
        }
        if (targetSum < 0){
            return false;
        }
        for (int num : numbers) {
            int reminder = targetSum - num;
            if (canSum(reminder, numbers, memo)) {
                memo.put(targetSum, true);
                return true;
            }
        }
        memo.put(targetSum, false);
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canSum(7, new int[]{2, 3}, new HashMap<>()));
        System.out.println(canSum(7, new int[]{5, 3, 4, 7}, new HashMap<>()));
        System.out.println(canSum(7, new int[]{2, 4}, new HashMap<>()));
        System.out.println(canSum(8, new int[]{2, 3, 5}, new HashMap<>()));
        System.out.println(canSum(300, new int[]{7, 14}, new HashMap<>()));
    }
}
