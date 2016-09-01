public class ReorderArray{
    public void reOrderArray(int [] array){
        if(array.lenth==0)
            return;
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        for(int i=0; i<array.length; i++){
            if(array[i]%2==0)
                queue2.add(array[i]);
            else
                queue1.add(array[i]);
        }
        int i=0;
        while(!queue1.isEmpty()){
            array[i++] = queue1.remove();
        }
        while(!queue2.isEmpty()){
            array[i++] = queue2.remove();
        }
    }
}
