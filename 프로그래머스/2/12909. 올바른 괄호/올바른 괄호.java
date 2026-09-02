import java.io.*;
import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Deque<Character> q = new ArrayDeque<>();
        
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            
            if(c == '('){
                q.add(c);
                //System.out.println("asd");
            }else{
                if(!q.isEmpty()){
                    if(q.peekLast() == '('){
                        q.poll();
                    }    
                }else{
                    q.add(c);    
                }
                
                //answer = false;
                //System.out.println("qqq");
            }
            
            //System.out.println(c);
        }
        answer = true;
        if(!q.isEmpty()){
            answer = false;
        }

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        //System.out.println("Hello Java");

        return answer;
    }
}