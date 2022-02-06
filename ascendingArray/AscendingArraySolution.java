package com.ozgur.ascendingArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AscendingArraySolution {

    public static void main(String[] args) {

        List<Integer> dizi = Arrays.asList(1,5,5,7,3,4,8,10,14,7,5,4,4);
        System.out.println("--- solution1 ---\n");
        solution1(dizi);
        System.out.println("--- solution1 code refactor---\n");
        solution1CodeRefactor(dizi);
        System.out.println("--- solution2 ---\n");
        solution2(dizi);
    }
    public static void solution1(List<Integer> dizi){
        List<AscendingArray> ascendingArrayList = new ArrayList<>();

        AscendingArray ascendingArray = new AscendingArray();

        for(int i=0;i<dizi.size();i++){
            if (dizi.get(i) <= dizi.get(i+1)){
                ascendingArray.array.add(dizi.get(i));
                ascendingArray.arraySize+=1;
            }else {
                ascendingArray.array.add(dizi.get(i));
                ascendingArray.arraySize+=1;
                ascendingArrayList.add(ascendingArray);
                ascendingArray = new AscendingArray();
            }
            if(i==dizi.size()-2) {
                if (dizi.get(i) <= dizi.get(i+1)){
                    ascendingArray.array.add(dizi.get(i+1));
                    ascendingArray.arraySize+=1;
                    ascendingArrayList.add(ascendingArray);
                }else{
                    ascendingArray = new AscendingArray();
                    ascendingArray.array.add(dizi.get(i+1));
                    ascendingArray.arraySize+=1;
                    ascendingArrayList.add(ascendingArray);
                }
                break;
            }
        }

        ascendingArrayList.forEach(ascendingArray1 -> {
            System.out.print("Length of array: " + ascendingArray1.arraySize + " \nElements of the array: ");
            System.out.print("[ "); ascendingArray1.array.forEach(integer -> System.out.print(integer + " "));
            System.out.println("]\n");});

        System.out.println("*** Longest increment in the array ***");
        int max = ascendingArrayList.stream().map(ascendingArray1 -> ascendingArray1.arraySize).max(Integer::compareTo).get();
        ascendingArrayList.stream().filter(ascendingArray1 -> ascendingArray1.arraySize == max)
                .forEach(ascendingArray1 -> {
                    System.out.print("Length of array: " + ascendingArray1.arraySize + " \nElements of the array: ");
                    System.out.print("[ "); ascendingArray1.array.forEach(integer -> System.out.print(integer + " "));
                    System.out.println("]\n");});
    }

    public static void solution1CodeRefactor(List<Integer> dizi){
        List<AscendingArray> ascendingArrayList = new ArrayList<>();

        AscendingArray ascendingArray = new AscendingArray();

        for(int i=0;i<dizi.size();i++){
            ascendingArray.array.add(dizi.get(i));
            ascendingArray.arraySize+=1;
            if (dizi.get(i) > dizi.get(i+1)){
                ascendingArrayList.add(ascendingArray);
                ascendingArray = new AscendingArray();
            }
            if(i==dizi.size()-2) {
                if (dizi.get(i) > dizi.get(i+1)){
                    ascendingArray = new AscendingArray();
                }
                ascendingArray.array.add(dizi.get(i+1));
                ascendingArray.arraySize+=1;
                ascendingArrayList.add(ascendingArray);
                break;
            }
        }

        ascendingArrayList.forEach(ascendingArray1 -> {
            System.out.print("Length of array: " + ascendingArray1.arraySize + " \nElements of the array: ");
            System.out.print("[ "); ascendingArray1.array.forEach(integer -> System.out.print(integer + " "));
            System.out.println("]\n");});

        System.out.println("*** Longest increment in the array ***");
        int max = ascendingArrayList.stream().map(ascendingArray1 -> ascendingArray1.arraySize).max(Integer::compareTo).get();
        ascendingArrayList.stream().filter(ascendingArray1 -> ascendingArray1.arraySize == max)
                .forEach(ascendingArray1 -> {
                    System.out.print("Length of array: " + ascendingArray1.arraySize + " \nElements of the array: ");
                    System.out.print("[ "); ascendingArray1.array.forEach(integer -> System.out.print(integer + " "));
                    System.out.println("]\n");});
    }

    public static void solution2(List<Integer> dizi){
        List<AscendingArray> ascendingArrayList = new ArrayList<>();

        AscendingArray ascendingArray = new AscendingArray();

        for(int i=0;i<dizi.size();i++){
            if (dizi.get(i) <= dizi.get(i+1)){
                if(!ascendingArray.array.isEmpty() && ascendingArray.array.get(ascendingArray.array.size()-1).equals(dizi.get(i))){
                    ascendingArray.array.remove(ascendingArray.array.size()-1);
                    ascendingArray.arraySize-=1;
                }
                ascendingArray.array.add(dizi.get(i));
                ascendingArray.array.add(dizi.get(i+1));
                ascendingArray.arraySize+=2;
            }else {
                if(ascendingArray.array.isEmpty()) {
                    ascendingArray.array.add(dizi.get(i));
                    ascendingArray.arraySize += 1;
                }
                ascendingArrayList.add(ascendingArray);
                ascendingArray = new AscendingArray();
            }
            if(i==dizi.size()-2) {
                if (dizi.get(i) <= dizi.get(i+1)){
                    ascendingArrayList.add(ascendingArray);
                }else{
                    ascendingArray = new AscendingArray();
                    ascendingArray.array.add(dizi.get(i+1));
                    ascendingArray.arraySize+=1;
                    ascendingArrayList.add(ascendingArray);
                }
                break;
            }
        }

        ascendingArrayList.forEach(ascendingArray1 -> {
            System.out.print("Length of array: " + ascendingArray1.arraySize + " \nElements of the array: ");
            System.out.print("[ "); ascendingArray1.array.forEach(integer -> System.out.print(integer + " "));
            System.out.println("]\n");});

        System.out.println("*** Longest increment in the array ***");
        int max = ascendingArrayList.stream().map(ascendingArray1 -> ascendingArray1.arraySize).max(Integer::compareTo).get();
        ascendingArrayList.stream().filter(ascendingArray1 -> ascendingArray1.arraySize == max)
                .forEach(ascendingArray1 -> {
                    System.out.print("Length of array: " + ascendingArray1.arraySize + " \nElements of the array: ");
                    System.out.print("[ "); ascendingArray1.array.forEach(integer -> System.out.print(integer + " "));
                    System.out.println("]\n");});
    }
}

class AscendingArray {
    int arraySize = 0;
    ArrayList<Integer> array = new ArrayList<>();
}