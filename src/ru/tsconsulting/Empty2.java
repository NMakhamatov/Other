package ru.tsconsulting;
import java.util.ArrayList;
import java.util.List;

public class Empty2 {
    public static void main(String[] args) {
        ArrayList<String> in = new ArrayList<>(4);
        in.add("a");
        in.add("b");
        in.add("c");
        in.add("d");
        in.add("e");
        Empty2 e = new Empty2();
        ArrayList<String> list = (ArrayList<String>) e.method3(in);
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("Общее количество: " + list.size());

    }

    List<String> method3(ArrayList<String> in) {
        if (in.size() == 1) {
            return in;
        } else {
            String sym = in.get(in.size() - 1);
            in.remove(in.size() - 1);
            ArrayList<String> out = (ArrayList<String>) method3(in);
            int j = out.size();
            for (int i = 0; i < j; i++) {
                out.add(out.get(i) + sym);
            }
            in.add(sym);
            return out;
        }
    }

//    List<String> method(ArrayList<String> list) {
//        ArrayList<String> out = new ArrayList<>(1);
//        out.add("");
//
////        out.addAll(out);
//        ArrayList<String> list1 = list;
//        String s = list1.get(0);
//        for (int i = 0; i < out.size(); i++) {
////            if (i == -1) {
////                out = new ArrayList<>(1);
////                out.add("");
////                continue;
////            }
//            out.add(out.get(i) + s);
////            for (int j = 0; j < ; j++) {
////
////            }
//        }
//        list1.remove(0);
//        if (list1.size() != 0)
//            method(list1);
//        return out;
//    }

    //    List methodCycle(ArrayList list) {
//        ArrayList out = new ArrayList(1);
//        out.add(0,"");
//        out.add(list.get(0));
//
//        for (int i = 1; i < list.size(); i++) {
//           int j = out.size();
//            for (int k = 0; k < j; k++) {
//                out.add(out.get(k) + list.get(i) );
//            }
//        }
//        list.remove("");
//        for (String s:out             ) {
//            System.out.println(s);
//        }
//        return out;
//    }


//    List<String[]> method4(ArrayList<String> in) {
//        if (in.size() == 1) {
//            return in;
//        } else {
//            String sym = in.get(in.size() - 1);
//            in.remove(in.size() - 1);
//            ArrayList<String> out = (ArrayList<String>) method4(in);
//
//            out.add("");
//            int j =out.size();
//            for (int i = 0; i < j; i++) {
//                out.add(out.get(i) + sym);
//            }
//            out.remove("");
//            return out;
//        }
//    }
}