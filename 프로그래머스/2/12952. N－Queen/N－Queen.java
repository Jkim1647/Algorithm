import java.util.*;
import java.io.*;

class Solution {
    static int T,N;
    static int answer;
    static int[] dist1;
    static int[] dist2;
    static int[] dist3;
    
    public int solution(int n) {

        N = n;

        dist1 = new int[N*2+1];
        dist2 = new int[N*2+1];
        dist3 = new int[N+1];
        answer = 0;
        nqueen(0);
        return answer;

    }

    private static void nqueen(int depth){
        if(depth == N){
            answer++;
            return;
        }

        for(int i=0;i<N;i++){

            if(dist1[depth+i] == 1){
                continue;
            }
            if(dist2[depth-i+N] == 1){
                continue;
            }
            if(dist3[i] == 1){
                continue;
            }

            dist1[depth+i] = 1;
            dist2[depth-i+N] = 1;
            dist3[i] = 1;

            nqueen(depth+1);

            dist1[depth+i] = 0;
            dist2[depth-i+N] = 0;
            dist3[i] = 0;
        }

    }
}