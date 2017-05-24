

public class LongestCommonPrefix {

	public String longestCommonPrefix(String[] strs) {
		String result = ""; 
		if(strs.length==0||strs[0]==""){
			return "";
		}
		for(int i = 0; i < strs[0].length(); i++){
			for(int j = 1; j < strs.length; j++){
				if(strs[j].length()<i+1 || strs[0].charAt(i) != strs[j].charAt(i)){
					return result;
				}
			}
			result = strs[0].substring(0, i+1);
		}
		return result;
    }
       
	public static void main(String[] args) {
		LongestCommonPrefix obj = new LongestCommonPrefix();
		String[] strs = {"aa","a"};
		System.out.println(obj.longestCommonPrefix(strs));
	}

}
