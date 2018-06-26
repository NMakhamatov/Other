package ru.tsconsulting;

public class Hanoitower  {
    public static void main(String[] args) {
        tower(3,'a','b','c');
    }
    static void tower(int topN,char from, char inter, char to) {
        if (topN ==1) System.out.println("Disk 1 from " + from + " to " + to);
        else {
            tower(topN-1,from,to,inter); //from -> inter
            System.out.println("Disk " + topN + " from " + from + " to " + to);
            tower(topN-1,inter,from,to);  // inter -> to
        }
    }
}