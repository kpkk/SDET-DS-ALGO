package dunZo;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class SellingProducts {

    @Test
    public void test1() {
        int[] nums = {1, 1, 2, 3, 2};
        Assert.assertEquals(removeNums(nums,2), 2);
    }

    private int removeNums(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        ArrayList<Integer> list = new ArrayList<>(map.values());
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > 1) {

            }

        }
        return 1;
    }

}

