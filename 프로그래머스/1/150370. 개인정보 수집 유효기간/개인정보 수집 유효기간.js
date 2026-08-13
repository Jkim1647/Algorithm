function solution(today, terms, privacies) {
    var answer = [];
    
    const termMap = {};
    
    for(const term of terms){
        const[type, month] = term.split(" ");
        termMap[type] = Number(month);
    }
    //console.log(termMap);
    
    /*
    function toDays(date) {
        const [year, month, day] = date.split(".").map(Number);
        return year * 12 * 28 + month * 28 + day;
    }
    */
    const toDays = (date) => {
        const [year,month,day] = date.split(".").map(Number);
        return year *12 * 28 + month * 28 + day;
    };
    
    const todayDays = toDays(today);
    console.log(todayDays);
    
    for(let i=0;i<privacies.length;i++){
        const[date,type] = privacies[i].split(" ");
        const expireDays = toDays(date) + termMap[type]*28;
        
        //console.log(i,date,type,expireDays,termMap[type]);
        if(todayDays >= expireDays){
            answer.push(i+1);
        }
    }
    
    return answer;
}