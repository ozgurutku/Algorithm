package findLongestSingleSlot;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class FindLongestSingleSlotSolution {

    public static void main(String[] args) {
        List<List<Integer>> slotList = new ArrayList<>();

        List<Integer> slot1 = new ArrayList<>();
        slot1.add(0);
        slot1.add(3);
        slotList.add(slot1);

        List<Integer> slot2 = new ArrayList<>();
        slot2.add(2);
        slot2.add(5);
        slotList.add(slot2);

        List<Integer> slot3 = new ArrayList<>();
        slot3.add(0);
        slot3.add(9);
        slotList.add(slot3);

        List<Integer> slot4 = new ArrayList<>();
        slot4.add(1);
        slot4.add(15);
        slotList.add(slot4);

        /* example 2
        List<Integer> slot1 = new ArrayList<>();
        slot1.add(0);
        slot1.add(2);
        slotList.add(slot1);

        List<Integer> slot2 = new ArrayList<>();
        slot2.add(1);
        slot2.add(3);
        slotList.add(slot2);

        List<Integer> slot3 = new ArrayList<>();
        slot3.add(0);
        slot3.add(7);
        slotList.add(slot3);
        */

        System.out.println(findLongestSingleSlot_Solution1(slotList));
        System.out.println(findLongestSingleSlot_Solution2(slotList));
    }

    public static char findLongestSingleSlot_Solution1(List<List<Integer>> leaveTimes) {

        List<Integer> diffList = new ArrayList<>();

        for (int i = 0; i < leaveTimes.size()-1; i++) {
            if(i == 0){
                diffList.add(leaveTimes.get(i).get(1));
            }
            int diff = leaveTimes.get(i+1).get(1) - leaveTimes.get(i).get(1);
            diffList.add(diff);
        }

        int max = diffList.stream().mapToInt(integer -> integer.intValue()).max().getAsInt();
        int index = diffList.indexOf(max);
        int slotIndex = leaveTimes.get(index).get(0);

        char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        return alphabet[slotIndex];
    }

    public static char findLongestSingleSlot_Solution2(List<List<Integer>> leaveTimes) {

        List<Integer> list = leaveTimes.stream().flatMap(integers -> integers.stream()).collect(Collectors.toList());

        List<Integer> difflist = new ArrayList<>();
        int index1 = 0;
        difflist.add(list.get(1));
        for (int i = 1;   index1 < (list.size()/2)-1 ; i=i+2) {
            int diff = list.get(i+2) - list.get(i);
            difflist.add(diff);
            index1 = index1+1;
        }


        OptionalInt max = difflist.stream().mapToInt(integer -> integer.intValue()).max();
        int index = difflist.indexOf(max.getAsInt());
        List<Integer> d = leaveTimes.get(index);
        int aranan = d.get(0);
        char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        return alphabet[aranan];
    }
}
