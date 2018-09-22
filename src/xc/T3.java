

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class T3 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n,key,value;
        String op;

        HashMap<Integer, Integer> map=new HashMap<>();
        LinkedList<Integer> link=new LinkedList<>();

        n=sc.nextInt();
        while(sc.hasNext()){
            op=sc.next();
            if(op.equals("p")){
                key=sc.nextInt();
                value=sc.nextInt();
                if(map.size()>=n){
                    if(map.containsKey(key)){
                        map.put(key, value);
                    }else{
                        map.remove(link.getFirst());
                        link.removeFirst();
                        link.addLast(key);
                        map.put(key, value);
                    }

                }else{
                    if(map.size()>0){
                        if(!map.containsKey(key)){
                            link.addLast(key);
                        }
                        map.put(key, value);
                    }else{
                        link.addLast(key);
                        map.put(key, value);
                    }

                }
            }else if(op.equals("g")){
                key=sc.nextInt();
                if(map.size()>0){
                    if(map.containsKey(key)){
                        if(link.getFirst()==key){
                            link.removeFirst();
                        }else if(link.getLast()==key){
                            link.removeLast();
                        }else{
                            for(int i=1;i<link.size()-1;i++){
                                if(link.get(i)==key){
                                    link.remove(i);
                                }
                            }
                        }
                        link.addLast(key);
                        System.out.println(map.get(key));
                    }else{
                        System.out.println(-1);
                    }
                }else{
                    System.out.println(-1);
                }
            }
        }
    }
}