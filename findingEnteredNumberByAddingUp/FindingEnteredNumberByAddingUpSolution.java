package com.ozgur.findingEnteredNumberByAddingUp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindingEnteredNumberByAddingUpSolution {

    public static void main(String[] args) {

        System.out.println("--- Example 1 ---");
        List<Integer> list1 = Arrays.asList(1, 2, 4, 2, 3, -8, 12);
        findingEnteredNumberByAddingUp(list1, 4);

        System.out.println("\n--- Example 2 ---");
        List<Integer> list2 = Arrays.asList(7, 5, 11, 8, 4, 2, -5, -4, 7);
        findingEnteredNumberByAddingUp(list2, 13);

        System.out.println("\n--- Example 3 ---");
        List<Integer> list3 = Arrays.asList(18, 23, 7, 41, 3, 41, 27, 17, 14);
        findingEnteredNumberByAddingUp(list3, 44);

    }

    public static void findingEnteredNumberByAddingUp(List<Integer> list, int enteredNumber) {
        if (list.isEmpty()) {
            System.out.println("List is empty");
        } else {
            List<Integer> copyList = new ArrayList<>(list);
            findingEnteredNumberByAddingUpMethodLogic(copyList, enteredNumber);
        }
    }

    public static void findingEnteredNumberByAddingUpMethodLogic(List<Integer> list, int enteredNumber) {
        if (list.size()>1) {
            for (int i = 1; i < list.size(); i++) {
                if (list.get(0) + list.get(i) == enteredNumber) {
                    System.out.println(list.get(0) + "+" + list.get(i) + "=" + (list.get(0) + list.get(i)));
                }
            }
            list.removeAll(Arrays.asList(list.get(0)));
            findingEnteredNumberByAddingUpMethodLogic(list, enteredNumber);
        }
    }
}