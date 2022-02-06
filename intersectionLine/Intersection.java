package com.ozgur.intersectionLine;

import java.util.ArrayList;
import java.util.List;

public class Intersection {
    public static void main(String[] args) {

//        Line d1 = new Line(-2,1);
//        Line d2 = new Line(2,5);
//        Line d3 = new Line(1,3);
//        Line d4 = new Line(8,18);
//        Line d5 = new Line(7,13);

//        Line d1 = new Line(8,13);
//        Line d2 = new Line(10,15);
//        Line d3 = new Line(4,11);
//        Line d4 = new Line(2,3);
//        Line d5 = new Line(2,9);

        Line d1 = new Line(1,3);
        Line d2 = new Line(17,25);
        Line d3 = new Line(17,19);
        Line d4 = new Line(11,19);
        Line d5 = new Line(1,5);

        List<Line> lineList = new ArrayList<>();
        lineList.add(d1);
        lineList.add(d2);
        lineList.add(d3);
        lineList.add(d4);
        lineList.add(d5);

        //----------------------------------------------------

        List<Line> directionCopyList = new ArrayList<>(lineList);

        unionLine(lineList);

        lineList.removeIf(directionCopyList::contains);
        System.out.println("new lines formed after the intersection of lines:");
        lineList.forEach(line -> System.out.println(line.a + " " + line.b));
    }

    public static void unionLine (List<Line> lineList){
        for(int i=0; i<lineList.size();i++) {
            for (int j = 1; j<lineList.size();j++) {
                if(i==j){
                    continue;
                }
                if (!((lineList.get(i).a > lineList.get(j).a || lineList.get(j).a > lineList.get(i).a) && (lineList.get(i).a > lineList.get(j).b || lineList.get(j).a > lineList.get(i).b)
                        && (lineList.get(i).b > lineList.get(j).a || lineList.get(j).b > lineList.get(i).a) && (lineList.get(i).b > lineList.get(j).b || lineList.get(j).b > lineList.get(i).b))) {

                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(lineList.get(i).a);
                    tempList.add(lineList.get(i).b);
                    tempList.add(lineList.get(j).a);
                    tempList.add(lineList.get(j).b);

                    int max = tempList.stream().max(Integer::compareTo).get();
                    int min = tempList.stream().min(Integer::compareTo).get();

                    Line newLine = new Line(min, max);

                    lineList.remove(lineList.get(i));
                    lineList.remove(lineList.get(j-1));
                    lineList.add(newLine);
                    unionLine(lineList);
                }
            }
        }
    }
}

class Line {
    public int a;
    public int b;
    public Line (int a, int b){
        this.a = a;
        this.b = b;
    }
}