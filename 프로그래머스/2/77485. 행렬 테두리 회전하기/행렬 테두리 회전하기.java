class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];

        int[][] map = new int [rows][columns];
        
        int num=1;
        
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                map[i][j] = num++;
            }
        }
        
        for(int i=0;i<queries.length;i++){
            answer[i] = rotate(queries[i][0],queries[i][1],queries[i][2],queries[i][3],map);
        }

        return answer;
    }
    
    public static int rotate(int x1, int y1, int x2, int y2, int[][] map){

        //처음 백업
        int temp = map[x1-1][y1-1];
        int min = temp;
        
        //왼쪽
        for(int i=x1;i<x2;i++){
            map[i-1][y1-1] = map[i][y1-1];
            min = Math.min(map[i-1][y1-1],min);
        }
        //아래
        for(int i=y1;i<y2;i++){
            map[x2-1][i-1] = map[x2-1][i];
            min = Math.min(map[x2-1][i-1],min);
        }
        //오른쪽
        for(int i=x2-1;i>=x1;i--){
            map[i][y2-1] = map[i-1][y2-1];
            min = Math.min(map[i][y2-1],min);
        }
        //윗면
        for(int i=y2-1;i>y1;i--){
            map[x1-1][i] = map[x1-1][i-1];
            min = Math.min(map[x1-1][i],min);
        }
        //백업
        map[x1-1][y1] = temp;

        return min;
    }
}