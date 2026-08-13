function solution(tickets) {
    let answer = [];
    
    const visited = new Array(tickets.length).fill(false);
    
    tickets.sort();
    
    function dfs(current, path, count){
        
        if(count === tickets.length){
            answer = [...path];
            return true;
        }
        
        for(let i=0; i<tickets.length;i++){
            
            //
            const [from,to] = tickets[i];
            
            if(!visited[i] && current === from){
                //
                visited[i] = true;
                
                path.push(to);
                //
                if(dfs(to,path,count+1)){
                    return true;
                }
                
                path.pop();
                visited[i] = false;
            }
            
            
        }
        
        //
        //return false;
        
    }
    
    dfs("ICN",["ICN"],0);
    
    return answer;
}

