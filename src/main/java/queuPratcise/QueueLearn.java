package queuPratcise;

import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.TreeMap;

public final class QueueLearn implements Serializable {

    public static void main(String[] args) {
       /* ArrayDeque<Integer>queue=new ArrayDeque<Integer>();
        queue.add(12);
        queue.offer(13);
        queue.offerLast(14);
        queue.offerFirst(15);
        queue.addFirst(16);
        queue.pollLast();
        queue.poll();
        System.out.println(queue.peek());
        System.out.println(queue.peekLast());
        System.out.println(queue);*/

        TreeMap<Integer,Integer>map=new TreeMap<>();
        map.put(6,map.getOrDefault(6,0)+1);
        map.put(10,map.getOrDefault(10,0)+1);
        map.put(6,map.getOrDefault(6,0)+1);
        System.out.println(map);
        System.out.println(map.firstEntry().getKey());
        System.out.println(map.lastEntry().getKey());






    }
}
