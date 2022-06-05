package interviewTasks;

/*
nums = new Integer[]{1, 2, 3, 4} //maxSum:10, starting at index 0, length of 4
nums = new Integer[]{1, 2, 3, 4, -10} // 10
nums = new Integer[]{1, 2, 3, 4, -10, 1} // 10
nums = new Integer[]{1, 2, 3, 4, -5, 12} // 17
nums = new Integer[]{-5, 1, 2, 3, 4, -5, 12} // 17
nums = new Integer[]{-5, 1, 2, 3, 4, -10, 12} //12
nums = new Integer[]{-5, 1, 2, 3, 4, -10} //
nums = new Integer[]{-5, 1, 2, 3, 4, -10, -5, 120} //
nums = new Integer[]{-5, 1, 2, 3, 4, 5, 6, 1, -5, -8, 110} //
nums = new Integer[]{1, 2, 3, 4, -5, -6,-7,-8, 5, 6, 7 ,8} //
 */
public class Apple {
    int maxSum, length, startIndex;

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{-5, 1, 2, 3, 4, -10, -5, 120};

        System.out.println(getMaxSum(nums));
    }

    private static Apple getMaxSum(Integer[] nums) {
        Apple result = new Apple();

        for(int i=0; i<nums.length; i++) {
            int sum = nums[i];
            for(int q = i+1; q<nums.length; q++) {
                sum += nums[q];

                if(sum> result.maxSum) {
                    result.maxSum = sum;
                    result.startIndex = i;
                    result.length = q-i+1;
                }
            }
        }

        return result;
    }

    public String toString(){
        return "maxSum:"+maxSum+", starting at index "+startIndex+", length of "+length;
        // TODO: like "maxSum:10, starting at index 0, length of 4"
    }
}
