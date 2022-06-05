package interviewTasks;

import java.util.Arrays;

public class someTask {

    /*
    we string with positive and negative numbers, and other characters, find sum of this numbers
     */

    public static void main(String[] args) {
//        String example = "fg454gsfdsf-332,fdf4,454fgf-6"; // 454 -332 + 4 +454 -6 = 574
//
//        System.out.println(getSum(example));

        System.out.println(Arrays.toString(solution("aaab", 'b')));
    }

    public static int getSum(String str) {
        String[] nums = str.split("[^0-9\\-]");
        int sum = 0;

        for (String num : nums) {
            sum += parseInt(num);
        }

        return sum;
    }

    public static int parseInt(String str) {
        try {
            return Integer.parseInt(str.trim());
        } catch (Exception e) {
            return  0;
        }
    }

    /*
    Given a string s and a character c that occurs in s, return an array of integers answer where
    answer.length == s.length and answer[i] is the shortest distance from s[i] to the character c in s.
    Example 1:
    Input: s = "loveleetcode", c = "e"
    Output: [3,2,1,0,1,0,0,1,2,2,1,0]
    Example 2:
    Input: s = "aaab", c = "b"
    Output: [3,2,1,0]
     */

    public static int[] solution(String s, char c) {
        int[] result = new int[s.length()];

        /*
        1. Find out indexes of c, and store them to array
        2. Find out distances
         */

        int[] indexesOfC = new int[0];

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == c) {
                indexesOfC = addNumToArray(indexesOfC, i);
            }
        }

        for (int i=0; i<s.length(); i++) {
            result[i] = findMin(i, indexesOfC);
        }

        return result;
    }

    public static int findMin(int index, int[] indexes) {
        int result =Math.abs(indexes[0]-index);

        for (int i=1; i<indexes.length; i++) {
            int newDif = Math.abs(indexes[i]-index);

            if(newDif<result) {
                result = newDif;
            }
        }

        return  result;
    }

    public static int[] addNumToArray(int[] nums, int num) {
        int[] result = new int[nums.length+1];

        System.arraycopy(nums, 0, result,0, nums.length);

        result[result.length-1] = num;

        return result;
    }
}
