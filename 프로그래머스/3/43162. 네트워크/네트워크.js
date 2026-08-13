function solution(n, computers) {
    let answer = 0;
    
    const visited = new Array(n).fill(false);
    
    console.log(visited);
    
    function dfs(node){
         visited[node] = true;
        
        for(let i=0;i<n;i++){
            if(computers[node][i] === 1 && visited[i] === false){
                dfs(i);
            }
        }
    }
    
    for(let i=0;i<n;i++){
        if(visited[i] === false){
            dfs(i);
            answer++;
        }
    }
    
    return answer;
}