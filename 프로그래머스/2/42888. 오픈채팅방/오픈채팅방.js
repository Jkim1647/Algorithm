function solution(record) {
    var answer = [];
    
    const userMap = new Map();

    for(const reco of record){
        const [code,id,name] = reco.split(" ");
        
        if(code == "Change" || code == "Enter"){
            userMap.set(id,name);
        }

    }
    for(const reco of record){
        const [code,id,name] = reco.split(" ");
        if(code == "Enter"){
            //console.log(userMap.get(id));
            //answer.push(userMap.get(id) + "님이 들어왔습니다.");
            answer.push(`${userMap.get(id)}님이 들어왔습니다.`)
        }
        else if(code == "Leave"){
            answer.push(userMap.get(id) + "님이 나갔습니다.");
        }
    }
    return answer;
}