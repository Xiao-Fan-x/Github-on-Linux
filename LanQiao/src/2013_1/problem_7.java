import jdk.internal.org.objectweb.asm.tree.LookupSwitchInsnNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class problem_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int N = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            String[] split = line.split(" ");
            for (int j = 0; j < split.length; j++){
                list.add(Integer.parseInt(split[j]));
            }
        }
//        System.out.println(list.size());
        Collections.sort(list);
        int a=0,b=0;

        for (int i = 1; i < list.size(); i++){
            if (list.get(i) - list.get(i-1)==2){
                a = list.get(i) - 1;
            }
            if (list.get(i).equals( list.get(i-1))){
                b = list.get(i);
            }
        }
        System.out.println(a+" "+b);

    }
}

