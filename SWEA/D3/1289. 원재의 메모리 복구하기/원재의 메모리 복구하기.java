import java.util.*;
import java.io.*;
 
class Solution
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int K;
    static int[] arr;
     
    public static void main(String[] args) throws Exception{
        K = Integer.parseInt(br.readLine());
         
        for(int test_case = 1;test_case<=K;test_case++) {
            arr = new int[51];
            int flag = 0;
            int count = 0;
             
            String temp = br.readLine();
             
            for(int i=0;i<temp.length();i++) {
                if(temp.charAt(i) == '0') {
                    arr[i] = 0;
                }else {
                    arr[i] = 1;
                }
            }
             
            for(int i=0;i<temp.length();i++) {
                if(arr[i] == 1) {
                    if(flag == 1) {
                    }
                    else if(flag == 0) {
                        flag++;
                        count++;
                         
                        if(flag == 2) {
                            flag = 0;
                        }
                    }
                }
                if(arr[i] == 0) {
                    if(flag == 1) {
                        flag++;
                        count++;
                         
                        if(flag == 2) {
                            flag = 0;
                        }
                    }
                }
 
            }
            sb.append("#")
            .append(test_case)
            .append(" ")
            .append(count)
            .append("\n");
             
        }
         
        System.out.println(sb);
    }
     
}