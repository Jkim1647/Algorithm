function solution(begin, target, words) {

    if(!words.includes(target)) return 0;
    
    const visited = new Array(words.length).fill(false);
    const queue = [[begin,0]];
    
    while(queue.length > 0){
        const [current,step] = queue.shift();
        
        if(current === target){
            return step;
        }
        
        for(let i=0;i<words.length;i++){
            if(!visited[i] && canchange(current,words[i])){
                visited[i] = true;
                queue.push([words[i],step+1]);
            }
        }
    }
    
    
    
    
    return 0;
}
function canchange(word1,word2){
    let dif = 0;
    
    for(let i=0;i<word1.length;i++){
        if(word1[i] !== word2[i]){
            dif++;
        }
    }
    return dif === 1;
}