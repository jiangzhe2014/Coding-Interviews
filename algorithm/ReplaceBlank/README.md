## Description
```
请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为
We%20Are%20Happy。 
```
## Solution
1、遍历字符串，用StringBuffer添加元素，如果是空格就添加“%20”，否则就添加原来的元素，最后返回即可。

2、可以先遍历一次字符串，统计出字符串中空格的总数，并可以由此计算出替换之后字符串的总长度。每替换一次，总长度增加2.
我们可以从字符串的后面开始复制和替换。准备两个指针，P1和P2。P1指向原始字符串的末尾，P2指向替换之后的字符串的末尾。P1和
P2指向同一位置，表明所有空格都已经替换完毕。
## Code
```
public class ReplaceBlank {
    public String replaceSpace(StringBuffer str) {
        StringBuffer sb = new StringBuffer();
    	if(str.length()==0)
            return sb.toString();
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)==' ')
                sb.append("%20");
            else
                sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}
```
