public class MinNumberInRotatedArray {
    public int minNumberInRotateArray(int [] array) throws Exception {
        int len = array.length;
        if(len==0)
            return 0;
        int index1 = 0;
        int index2 = len-1;
        int middle = index1;
         
        while(array[index1]>=array[index2]){
            if((index2-index1) == 1){
                middle = index2;
                break;
            }
            middle = (index2 + index1)/2;
            //如果下标为index1,index2和middle指向的三个数字相等，则只能顺序查找
            if(array[index1]==array[index2]&&array[middle]==array[index1]){
                return minInOrder(array,index1,index2);
            }
            if(array[middle]>=array[index2]){
                index1 = middle;
            }
            else if(array[middle]<=array[index2])
                index2 = middle;
        }
        return array[middle];
    }
     
    public int minInOrder(int[] array, int index1, int index2){
        int result = array[index1];
        for(int i=index1+1; i <= index2; i++){
            if(result>array[i]){
                result = array[i];
            }
        }
        return result;
    }
}
