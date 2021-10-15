package dunZo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RodCutting {

    @Test
    public void example1() {
        List<Integer> lengths =  new ArrayList<Integer>();
        lengths.add(1);
        lengths.add(1);
        lengths.add(3);
        lengths.add(4);
        System.out.println(rodCut(lengths));

    }

    public List<Integer> rodCut(List<Integer> lengths) {
        List<Integer> outList = new ArrayList<Integer>();
        Collections.sort(lengths);
        outList.add(lengths.size());
        for (int i = 1; i < lengths.size(); i++) {
            if (lengths.get(i) != lengths.get(i-1))
                outList.add(lengths.size() - i);
        }
        return outList;
    }
   /* List<Integer> outList = new ArrayList<Integer>();
		Collections.sort(lengths);
		outList.add(lengths.size());
        for (int i = 1; i < lengths.size(); i++) {
        if (lengths.get(i) != lengths.get(i-1))
            outList.add(lengths.size() - i);
    }
        return outList;*/

//    int count, len=lengths.size();
//    HashMap<Integer,Integer> countMap=new HashMap<Integer,Integer>();
//    TreeSet<Integer> sticks=new TreeSet<Integer>();
//		for(Integer stick: lengths) {
//        count=countMap.getOrDefault(stick,0);
//        countMap.put(stick,++count);
//        sticks.add(stick);
//    }
//    List<Integer> result = new ArrayList<Integer>();
//    count=0;
//		for(Integer stick:sticks) {
//        result.add(len-count);
//        count+=countMap.get(stick);
//    }
//		return result;

}
