package com.ozgur.findNumberShortcut;

import java.util.Arrays;
import java.util.List;

public class FindNumberShortcutSolution {

    public static void main(String[] args) {

        //note: time spent may not be fully functioning properly, https://bugs.openjdk.java.net/browse/JDK-6995364

        System.out.println("\n-------------------Example 1------------------------------");

        List<Integer> array = Arrays.asList(3,4,5,4,3,2,3,4,5,6,5,4,3,2,1,2,3,4,5,6);

        System.out.println("--- Shortcut solution ---");
        long startTime = System.nanoTime();

        findNumberShortcut(1,array);

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Time spent: "+duration);

        System.out.println("\n--- Long way solution ---");
        startTime = System.nanoTime();

        longWaySolution(1,array);

        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("Time spent: "+duration);


        System.out.println("\n-------------------Example 2------------------------------");
        // moves count reset
        moveCount = 2;

        List<Integer> array2 = Arrays.asList(3,4,5,4,3,2,3,4,5,6,5,4,3,2,3,4,5,6,7,8,6,7,8,7,6,5,4,5,4,3,2,1);

        System.out.println("--- Shortcut solution ---");
        startTime = System.nanoTime();

        findNumberShortcut(1,array2);

        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("Time spent: "+duration);

        System.out.println("\n--- Long way solution ---");
        startTime = System.nanoTime();

        longWaySolution(1,array2);

        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("Time spent: "+duration);

        System.out.println("\n-------------------Example 3------------------------------");
        // moves count reset
        moveCount = 2;

        List<Integer> array3 = Arrays.asList(11,10,9,8,9,10,11,12,13,11,10,9,8,7,6,5,4,5,6,7,8,7,6,5,4,3,4,5,6,7,8,9,10,9,8,7,6,5,4,3,2,3,4,5,6,7,6,5,4,3,2,1);

        System.out.println("--- Shortcut solution ---");
        startTime = System.nanoTime();

        findNumberShortcut(2,array3);

        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("Time spent: "+duration);

        System.out.println("\n--- Long way solution ---");
        startTime = System.nanoTime();

        longWaySolution(2,array3);

        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("Time spent: "+duration);

    }

    public static void findNumberShortcut(int num, List<Integer> array){
        int distance = Math.abs(num - array.get(0));

        if(array.get(distance) == num){
            System.out.println("find number:"+array.get(distance)+" index:"+distance + " found it in 1 moves");
        }else {
            int newDistance = distance + Math.abs(num - array.get(distance));
            findNumberShortcut(num,array,newDistance);
        }
    }

    public static void findNumberShortcut(int num, List<Integer> array, int distance){
        if(array.get(distance) == num){
            System.out.println("find number:"+array.get(distance)+" index:"+distance + " found it in " + moveCount + " moves");
        }else {
            moveCount = moveCount + 1;
            int newDistance = distance + Math.abs(num - array.get(distance));
            findNumberShortcut(num,array,newDistance);
        }
    }

    public static void longWaySolution(int num, List<Integer> array){
        for (int i=0;i<array.size();i++){
            if(array.get(i) == num){
                System.out.println("find number:"+array.get(i)+" index:"+i + " found it in " + (i+1) + " moves");
                break;
            }
        }
    }

    public static int moveCount = 2;
}
