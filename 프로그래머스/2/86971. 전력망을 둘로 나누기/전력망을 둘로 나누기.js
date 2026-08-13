function solution(n, wires) {
    let answer = n;
    
    const graph = Array.from({length:n+1}, () => []);
    for(const [a,b] of wires){
        graph[a].push(b);
        graph[b].push(a);
    }
    //console.log(graph);
    
    for(const [cutA,cutB] of wires){
        console.log(cutA,cutB);
        
        const visited = new Array(n+1).fill(false);
        
        
        function dfs(node){
            visited[node] = true;
            let count = 1;
            
            for(const next of graph[node]){
                console.log(`next=${next}`); // 1->3
                
                if((node === cutA && next === cutB) ||( node === cutB && next === cutA)) continue;
                
                if(!visited[next]){
                    count += dfs(next);
                }
                //visited[next] = 
            }
            return count;
        }
        console.log(visited);
        const size = dfs(1);
        //1 - 4-1
        //const tt = Math.abs(n - (size-n));
        const tt = Math.abs(size - (n-size));
        answer = Math.min(answer,tt);
        console.log(`answer=${answer}`);
        //사이즈 계산해서 answer 업데이트
       
    
    }
    
    
    return answer;
}