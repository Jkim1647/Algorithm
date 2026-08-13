function solution(id_list, report, k) {
    //var answer = [];
    const answer = new Array(id_list.length).fill(0);
    
    const uniqeReports = new Set(report);
    
    const reportMap = {}; //누가 누구를 신고했는지.
    const reportedCount = {}; //누가 몇번 신고 당했는지.
    
    //초기화
    for (const id of id_list){
        reportMap[id] = []; //id : []
        reportedCount[id] = 0; // id: 0
    }
    
    for(const item of uniqeReports){
        const[from,to] = item.split(" ");
        reportMap[from].push(to);
        reportedCount[to]++;
    }
    
    const bannedUsers = new Set();
    
    for(const id of id_list){
        if(reportedCount[id] >= k){
            bannedUsers.add(id);
        }
    }
    
    for(let i=0;i<id_list.length;i++){
        const user = id_list[i];
        let mailcount = 0;
        
        for(const reportedUser of reportMap[user]){
            if(bannedUsers.has(reportedUser)){
                mailcount++;
            }
        }
        answer[i] = mailcount;
    }
    
    
    return answer;
}