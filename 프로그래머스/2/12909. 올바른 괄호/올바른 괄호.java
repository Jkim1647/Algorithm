class Solution {
    boolean solution(String s) {
        boolean answer = true;

        int n = s.length();
        //System.out.println(n);
        
        int count = 0;
        
        for(int i=0;i<n;i++){
            if(s.charAt(i) == '('){
                count++;
            }else{
                count--;
            }
            if(count < 0){
                answer = false;
            }
        }
        if(count != 0){
            answer = false;
        }

        //System.out.println("Hello Java");

        return answer;
    }
}