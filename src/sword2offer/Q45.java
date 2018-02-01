package sword2offer;

import java.util.*;

public class Q45 {


    public String PrintMinNumber(int [] numbers) {
        if (numbers == null || numbers.length == 0) return "";
        List<String> strs = new ArrayList<>(numbers.length);
        for (int num : numbers) {
            strs.add(String.valueOf(num));
        }
        /*
        Collections.sort(strs, new Comparator<String>(){
            @Override
            public int compare(String n1, String n2) {
                Long l1 = Long.parseLong(n1 + n2);
                Long l2 = Long.parseLong(n2 + n1);
                return l1.compareTo(l2);
            }
        });
         */
        strs.sort((n1, n2) -> {
            Long l1 = Long.parseLong(n1 + n2);
            Long l2 = Long.parseLong(n2 + n1);
            return l1.compareTo(l2);
        });
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }
        return sb.toString();
    }


    int compare(String n1, String n2) {
        Long l1 = Long.parseLong(n1 + n2);
        Long l2 = Long.parseLong(n2 + n1);
        return l1.compareTo(l2);
    }
}
