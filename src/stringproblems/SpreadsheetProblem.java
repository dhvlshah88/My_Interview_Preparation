package stringproblems;

import java.util.HashMap;

/**
 * Created by Dhaval on 8/30/2016.
 */
public class SpreadsheetProblem {

   private static  HashMap<String, Integer> characterMap;

    public static void main(String[] args) {
        characterMap = new HashMap<>();
        characterMap.put("A", 1);
        characterMap.put("B", 2);
        characterMap.put("C", 3);
        characterMap.put("D", 4);
        characterMap.put("E", 5);
        characterMap.put("F", 6);
        characterMap.put("G", 7);
        characterMap.put("H", 8);
        characterMap.put("I", 9);
        characterMap.put("J", 10);
        characterMap.put("K", 11);
        characterMap.put("L", 12);
        characterMap.put("M", 13);
        characterMap.put("N", 14);
        characterMap.put("O", 15);
        characterMap.put("P", 16);
        characterMap.put("Q", 17);
        characterMap.put("R", 18);
        characterMap.put("S", 19);
        characterMap.put("T", 20);
        characterMap.put("U", 21);
        characterMap.put("V", 22);
        characterMap.put("W", 23);
        characterMap.put("X", 24);
        characterMap.put("Y", 25);
        characterMap.put("Z", 26);

        System.out.println(SpreadsheetProblem.convertColumnId("A"));
        System.out.println(SpreadsheetProblem.convertColumnId("ZY"));
        System.out.println(SpreadsheetProblem.convertColumnId("ZZ"));
        System.out.println(SpreadsheetProblem.convertColumnId("AbA"));
        System.out.println(SpreadsheetProblem.convertColumnId("AAAA"));
    }

    public static long convertColumnId(String columnId) {
        long id  = 0;
        if (columnId == null || columnId.isEmpty()) {
            return id;
        }

        int len = columnId.length();
        if (len > 1) {
            int total = 0;
            int charValue = 0;
            for (char c : columnId.toUpperCase().toCharArray()) {
                charValue = characterMap.get(Character.toString(c));
                total += charValue * Math.pow(26, --len);
            }
            id = total;
        } else {
            id  = characterMap.get(columnId);
        }

        return id;
    }

}
