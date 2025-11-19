package org.dp.topDown.twoSequences;
import java.util.HashMap;

public class InterleavingString {

    /**
     * Create Cache
     */
    private HashMap<String,Boolean> memo = new HashMap<>();

    public boolean solution(String s1, String s2, String s3) {
        String key = s1+"_"+s2+"_"+s3;
        if(!memo.containsKey(key))
            memo.put(key,   (s1.length()==0&&s2.length()==0&s3.length()==0)||
                            (s3.length()>0&&
                            ((s1.length()>0&&s1.charAt(0)==s3.charAt(0)&&solution(s1.substring(1),s2,s3.substring(1)))||
                            (s2.length()>0&&s2.charAt(0)==s3.charAt(0)&&solution(s1,s2.substring(1),s3.substring(1))))));
        return memo.get(key);

    }
}
