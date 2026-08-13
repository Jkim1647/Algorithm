function solution(n, times) {
    let min = 1;
    let max = n * Math.max(...times);
    let answer = max;
    
    while(min <= max){
        
        let mid = Math.floor((min + max)/2);
        
        let count = 0;
        
        for(const work of times){
            count += Math.floor(mid/work);
            //console.log(`max=${max}, min=${min}, mid=${mid},count=${count},work=${work}`);
            
            if(count > n){
                break;
            }
        }
        if(count >= n){
            answer = mid;
            max = mid-1;
        }
        else{
            min = mid+1;
        }
  
    }
    return answer;
}
