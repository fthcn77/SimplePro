package interviewTasks;



import com.sun.istack.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tasks {

    public static void main(String[] args) {
//        String str = "aaaabbbedddddddcfffffrggggggy";
//
//        System.out.println(getUniques3(str));

        String str = "Techtorial";

        System.out.println(reverseString(str));
    }
    /*
        write method, that will take all unique characters and store it to the list

        1. use map and count number of all characters
        2. nested for loop
        3. will work with indexes(without nested loops or maps)
     */

    public static List<Character> getUniques1(String str){
        Map<Character,Integer> map = new HashMap<>();

        for(int i=0; i<str.length(); i++) {
            char current = str.charAt(i);

            if(map.keySet().contains(current)) {
                int previousValue =  map.get(current);
                map.put(current, previousValue+1);
            } else {
                map.put(current,1);
            }
        }

        List<Character> result = new ArrayList<>();

        for(Character ch: map.keySet()){
            if(map.get(ch) == 1) {
                result.add(ch);
            }
        }

        return result;
    }

    public static List<Character> getUniques2(String str) {
        List<Character> result = new ArrayList<>();

        for(int i=0; i<str.length(); i++) { // a a b c c
            boolean isUnique = true;        // 0 1 2 3 4
            char charAtI = str.charAt(i);

            for(int q =0; q<str.length(); q++) {
                char charAtQ = str.charAt(q);

                if(charAtI == charAtQ && i != q) {
                    isUnique = false;
                    break;
                }
            }

            if(isUnique) {
                result.add(charAtI);
            }
        }

        return result;
    }

    public static List<Character> getUniques3(String str) {
        List<Character> result = new ArrayList<>();

        /*  a a b c c
            0 1 2 3 4

        a-> 0, 1
        b-> 2, 2
        c-> 3, 4

         */

        for(int i=0; i<str.length(); i++) {
            char current = str.charAt(i);
            int firstIndex = str.indexOf(current);
            int lastIndex = str.lastIndexOf(current);

            if(firstIndex == lastIndex) {
                result.add(current);
            }
        }


        return result;
    }

    public static String reverseString(@NotNull String str) {
        String result = "";

//        for(int i =str.length()-1; i>=0; i--) {
//            result += str.charAt(i);
//        }

        for(int i =0; i<str.length(); i++) {
            result = str.charAt(i) + result;
        }

        return result;
    }
}
