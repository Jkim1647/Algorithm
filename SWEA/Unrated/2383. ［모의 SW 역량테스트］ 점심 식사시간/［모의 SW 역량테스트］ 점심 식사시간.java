import java.io.*;
import java.util.*;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T,N;
    static int[][] map;
    static int people_count;
    static int sx1,sy1,sx2,sy2;
    static int[] arr;
    static int[][] people;
    static int result;

    public static void main(String[] args) throws Exception{
        T = Integer.parseInt(br.readLine());

        for(int tc=1;tc<=T;tc++) {
            N = Integer.parseInt(br.readLine());

            map = new int[N][N];
            people_count = 0;
            sx1 = sy1 = sx2 = sy2 = 0;
            int stair_flag = 0;
            result = Integer.MAX_VALUE;

            for(int i=0;i<N;i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j] == 1) {
                        people_count++;
                    }else if(map[i][j] > 1) {
                        if(stair_flag == 0) {
                            sx1 = i;
                            sy1 = j;
                            stair_flag = 1;
                        }else {
                            sx2 = i;
                            sy2 = j;
                        }
                    }
                }
            }
            people = new int[2][people_count];
            int index = 0;
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    if(map[i][j] == 1) {
                        people[0][index] = i;
                        people[1][index] = j;
                        index++;
                    }
                }
            }
            /*
            for(int i=0;i<people_count;i++) {
                System.out.print(people[0][i]);
                System.out.println(people[1][i]);
            }*/

            arr = new int[people_count];
            dfs(0);

            //result += Math.max(map[sx1][sy1], map[sx2][sy2]);

            sb.append("#"+tc+" "+result+"\n");
        }
        System.out.print(sb);
    }

    private static void dfs(int depth) {

        if(depth == people_count) {
            //System.out.println(Arrays.toString(arr));
            calcul(arr);
            return;
        }

        arr[depth] = 1;
        dfs(depth+1);

        arr[depth] = 2;
        dfs(depth+1);
    }

    private static void calcul(int[] arr2) {

        //int[] dist = new int[people_count];

        ArrayList<Integer> stair1 = new ArrayList<>();
        ArrayList<Integer> stair2 = new ArrayList<>();
        for(int i=0;i<people_count;i++) {
            int cx = people[0][i];
            int cy = people[1][i];

            if(arr2[i] == 1) {
                int dist = Math.abs(cx-sx1) + Math.abs(cy-sy1);
                stair1.add(dist);
            }else {
                int dist = Math.abs(cx-sx2) + Math.abs(cy-sy2);
                stair2.add(dist);
            }
        }

        Collections.sort(stair1);
        Collections.sort(stair2);


        /*
        System.out.println(stair1);
        System.out.println(stair2);
        System.out.println();
        */
        int time1 = getTime(stair1,map[sx1][sy1]);
        int time2 = getTime(stair2,map[sx2][sy2]);

        result = Math.min(Math.max(time1, time2), result);
        //System.out.printf("result = %d",result);
    }

    private static int getTime(ArrayList<Integer> list, int stairlen) {

        if(list.isEmpty()) {
            return 0;
        }


        int[] finish = new int[list.size()];
        for(int i=0;i<list.size();i++) {

            int arrive = list.get(i)+1;

            if(i<3) {
                finish[i] = arrive + stairlen;
            }else {
                int start = Math.max(arrive, finish[i-3]);

                finish[i] = start + stairlen;
            }
        }
        return finish[finish.length-1];

    }
}

/*


2
5
0 1 1 0 0
0 0 1 0 3
0 1 0 1 0
0 0 0 0 0
1 0 5 0 0
5
0 0 1 1 0
0 0 1 0 2
0 0 0 1 0
0 1 0 0 0
1 0 5 0 0


최대 10명, 계단은 2개
각각 계단 1로 갈지, 2로 갈지 모든 경우의 수 구하기. dfs()
2^10 = 1024가지

각 경우의 수마다 거리 구하고, 시간계산

*/