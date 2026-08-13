import java.util.*;
import java.io.*;
 
class Solution
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb;
    static StringTokenizer st;
    static int N;   
     
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
         
        //String answer;
         
        sb = new StringBuffer();
         
        for(int i=1;i<=N;i++) {
             
            String s = String.valueOf(i);
             
            boolean flag_369 = false;
             
            for(int k=0;k<s.length();k++) {
                char temp = s.charAt(k);
                 
                if(temp == '3' || temp == '6' || temp == '9') {
                    flag_369 = true;
                    sb.append('-');
                }
                 
            }
            if(flag_369 == false) {
                sb.append(i);
                 
            }
             
            sb.append(" ");
        }
        System.out.print(sb);
    }
     
}