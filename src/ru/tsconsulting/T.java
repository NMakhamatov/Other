package ru.tsconsulting;

import java.io.*;
import java.util.*;

public class T {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Solution solution = new Solution();
        ListNode listNode1 = new ListNode(5);
        ListNode listNode2 = new ListNode(4);

        listNode2.next = new ListNode(9);

        solution.addTwoNumbers(listNode1, listNode2);
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        rec2(l1, list1);
        rec2(l2, list2);

        int num1 = 0;
        int num2 = 0;

        for (int i = 0; i < list1.size(); i++) {
            num1 += list1.get(i)*(Math.pow(10,list1.size()-i-1));
            num2 += list2.get(i)*(Math.pow(10,list1.size()-i-1));
        }

        int result = num1 + num2;

        ListNode res;
        rec3(res,result)
//        System.out.println(result);
//        char[] chars = result.toCharArray();

//        ListNode resultListNode = new ListNode(chars[chars.length - 1]);
//        for (int i = chars.length - 2; i > 0; i--) {
//            resultListNode = new ListNode(chars[i]);
//            resultListNode.next = new ListNode(chars[i - 1]);
//        }

        return null;
    }


    void rec(ListNode listNode, StringBuilder stringBuilder) {
        if (listNode.next == null) stringBuilder.append(Integer.toString(listNode.val));
        else {
            rec(listNode.next, stringBuilder);
            stringBuilder.append(Integer.toString(listNode.val));
        }
    }

    void rec2(ListNode listNode, List<Integer> list) {
        if (listNode.next == null) list.add(listNode.val);
        else {
            rec2(listNode.next, list);
            list.add(listNode.val);
        }
    }
    void rec3(ListNode listNode,int i) {
        if (i < 10) listNode.next = new ListNode(i%10) ;
        else {
//            listNode = new ListNode(i%10);
//            rec3(listNode.next,i%10);
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}