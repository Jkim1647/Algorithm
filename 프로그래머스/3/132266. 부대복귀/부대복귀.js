function solution(n, roads, sources, destination) {
    let answer = [];
    
    const graph = Array.from({length:n+1}, () => []);
    
    for(const [a,b] of roads){
       graph[a].push(b);
       graph[b].push(a);
    }
    
    
    
    const dist = Array(n+1).fill(-1);
    const queue = [destination];
    let front = 0;
    
    dist[destination] = 0;
    
    while(front < queue.length){
        const current = queue[front];
        front++;
        
        for(const next of graph[current]){
            if(dist[next] === -1){
                dist[next] = dist[current] + 1;
                queue.push(next);
            }
        }
        
    }
    // dist = [-1, 2, 1, -1, 1, 0];
    // source = [1, 3, 5];
    for(let i=0; i<dist.length;i++){
        console.log(i, dist[i]);
    }
    return sources.map(source => dist[source]);
    
/*
    for(const start of sources){

        
        const visited = Array(n+1).fill(-1);

        const end = destination;
        
        function bfs(node){

            for(let next of graph[node]){
                if(visited[next] === -1){
                    visited[next] = visited[node]+1;
                    bfs(next);
                }
                else if(visited[next] > visited[node]+1){
                    visited[next] = visited[node]+1;
                }
            }

        }
        visited[start] = 0;
        bfs(start);

        answer.push(visited[end]);

    }
    */
    return answer;
}