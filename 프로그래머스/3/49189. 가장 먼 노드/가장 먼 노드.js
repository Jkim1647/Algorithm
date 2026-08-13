function solution(n, edge) {
    
    const graph = Array.from({length:n+1}, () => []);
    
    for(const [a,b] of edge){
        graph[a].push(b);
        graph[b].push(a);
    }
    
    //console.log(graph);
    
    let dist = new Array(n+1).fill(-1);
    
    //console.log(dist);
    
    const queue = [1];
    dist[1] = 0;
    
    /*      [          [],
          1 [ 3, 2 ],
          2 [ 3, 1, 4, 5 ],
          3 [ 6, 4, 2, 1 ],
          4 [ 3, 2 ],
          5 [ 2 ],
          6 [ 3 ]        ]    */
    
    while(queue.length > 0){
        let cur = queue.shift();
        //console.log("check1");
        
        for(const next of graph[cur]){
            //console.log("check2");
            
            if(dist[next] === -1){
                dist[next] = dist[cur]+1;
                queue.push(next);
            }
        }
    }
    console.log(...dist);
    
    const max = Math.max(...dist);
    
    const answer = dist.filter(v => v === max).length;
    
    return answer;
}