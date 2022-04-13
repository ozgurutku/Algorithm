package findMinCost;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindMinCost_Solution {

    public static void main(String[] args) {

//        List<Integer> efficiency = new ArrayList<>();
//        efficiency.add(4);
//        efficiency.add(2);
//        efficiency.add(8);
//        efficiency.add(1);
//        efficiency.add(9);

//        List<Integer> efficiency = new ArrayList<>();
//        efficiency.add(4);
//        efficiency.add(2);
//        efficiency.add(1);
//        efficiency.add(16);
//        efficiency.add(8);

        List<Integer> efficiency = new ArrayList<>();
        efficiency.add(2);
        efficiency.add(13);
        efficiency.add(12);
        efficiency.add(9);
        efficiency.add(6);
        efficiency.add(3);
        efficiency.add(2);

        System.out.println("result: "+findMinCost(efficiency));
    }

    public static int findMinCost(List<Integer> efficiency) {
        Map<List<Integer>,Integer> diffList = new HashMap<>();
        int size = efficiency.size();

        for (int i = 0; i < size; i++) {
            diffList.putAll(calculateDiffAndKeepAsKeyValue(efficiency));
        }

        Map<List<Integer>,Integer> sortedDiffList = diffList.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));


        List<Integer> uniqeKeyList = new ArrayList<>();
        for(Map.Entry<List<Integer>,Integer> entry:sortedDiffList.entrySet()){
            if (!(uniqeKeyList.contains(entry.getKey().get(0)) || uniqeKeyList.contains(entry.getKey().get(1)))) {
                uniqeKeyList.addAll(entry.getKey());
            }
        }

        int sum = 0;
        for (int i = 0; i < size-1; i=i+2) {
            sum = sum + Math.abs(uniqeKeyList.get(i) - uniqeKeyList.get(i+1));
        }
        return sum;
    }

    public static Map<List<Integer>,Integer> calculateDiffAndKeepAsKeyValue(List<Integer> efficiency){
        Map<List<Integer>,Integer> diffList = new HashMap<>();
        for (int i = 1; i < efficiency.size(); i++) {
            int diff = Math.abs(efficiency.get(0) - efficiency.get(i));
            diffList.put(Arrays.asList(efficiency.get(0),efficiency.get(i)),diff);
        }
        efficiency.remove(0);
        return diffList;
    }
}
