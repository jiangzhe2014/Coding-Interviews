import java.util.*;
public class StreamMedian {

    ArrayList<Integer> list = new ArrayList<>();
    public void Insert(Integer num) {
    	list.add(num);
    }

    public Double GetMedian() {
        Collections.sort(list);
        if(list.size()%2==0)
            return (double)(list.get(list.size()/2 -1)+list.get(list.size()/2))/2;
        else
            return (double)list.get(list.size()/2);
    }


}
