public class ReplaceBlank {
    public String replaceSpace(StringBuffer str) {
        StringBuffer sb = new StringBuffer();
    	if(str.length()==0)
            return sb.toString();
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)==' '){
                sb.append("%20");
            }
            else
                sb.append(str.charAt(i));
        }
        return sb.toString();
    }
    
    public static void main(String[] args){
        StringBuffer str = new StringBuffer("We are Happy.");
        String result = new ReplaceBlank().replaceSpace(str);
        System.out.println(result);
    }
}
