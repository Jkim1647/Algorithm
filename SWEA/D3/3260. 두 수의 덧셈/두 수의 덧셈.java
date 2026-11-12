import java.io.*;
import java.util.*;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static String num1;
    static String num2;
    static String result;

    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());

        for(int test_case=1;test_case<=N;test_case++) {
            st = new StringTokenizer(br.readLine());
            num1 = st.nextToken();
            num2 = st.nextToken();

            int i = num1.length();
            int j = num2.length();
            result = "";

            int sum = 0;
            int next = 0;
            while(i != 0 || j != 0) {
                int n1=0;
                int n2=0;

                if(i > 0) {
                    n1 = num1.charAt(i-1) - 48;
                    i--;
                }
                if(j > 0) {
                    n2 = num2.charAt(j-1) - 48;
                    j--;
                }
                sum = next + n1+n2;
                if(sum > 9) {
                    if(i == 0 && j == 0) {
                        result = result + "01";
                        //sb.append(0);
                        //System.out.println(result.length());
                        continue;
                    }
                    else {
                        sum = sum % 10;
                        result = result + sum;
                        next = 1;
                        continue;
                    }

                }
                next = 0;
                result = result + sum;
            }

            sb.append("#")
            .append(test_case)
            .append(" ");
            for(int k=result.length()-1;k>=0;k--) {
                sb.append(result.charAt(k));
            }
            sb.append("\n");
        }
        System.out.print(sb);


    }
}