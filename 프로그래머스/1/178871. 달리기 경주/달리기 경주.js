function solution(players, callings) {
    
    var answer = [];
    //배열에 번호를 매겨서 담고, 이름을 찾으면
    
    const rankMap = {};
    //{ mumu: 1, soe: 2, poe: 3, kai: 4, mine: 5 }
    
    for(let i=0;i<players.length;i++){ // {이름 -> 등수}
        rankMap[players[i]] = i;
    }
    //console.log(rankMap);
    
    for(const name of callings){
        const currentIndex = rankMap[name];
        //console.log(currentIndex);
        const frontIndex = currentIndex-1;
        const frontPlayer = players[frontIndex];
        
        players[frontIndex] = name;
        players[currentIndex] = frontPlayer;
        
        rankMap[name] = frontIndex;
        rankMap[frontPlayer] = currentIndex;
        
    }
    /*
    for(let i=0;i<callings.length;i++){
        console.log(result[callings[i]]);
        //console.log("TEST");
        if(result[callings[i]] != 1){
            result[callings[i]]--;
            
            console.log("TEST");
            console.log(result[callings[i]]);
            
            //console.log(result(result[callings[i]]));
            // = result(callings[i])-1;
        }
        
    }
    console.log(result);
    */
    return players;
}

/*
1 2 3 4 5
1 2 4 3 5
1 4 2 3 5
1 4 2 5 3
1 4 5 2 3
*/