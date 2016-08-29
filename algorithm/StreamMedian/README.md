## Description
```
如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。 
```

## Solution
一种简单的方式是用集合容器存放数据，排序后中位数可以直接找到（下面代码就是这种方法）。
另一种是用最大堆实现左边的数据容器，用最小堆实现右边的数据容器。往堆中插入一个数据的时间效率是O(logn)，
由于只需要O(1)的时间就可以得到位于堆顶的数据，因此得到中位数的时间效率是O(1)。要保证数据平均分配，两个
堆中的数据的数目之差不能超过1.

## Code
```
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
```
