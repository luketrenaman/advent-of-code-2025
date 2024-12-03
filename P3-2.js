const fs = require('fs')


// valid tokens are mul, do, and don't
const s = fs.readFileSync('./P3.txt').toString();
const result = s.match(/mul\(([0-9]+,[0-9]+)\)|don't\(\)|do\(\)/gi);

let total = 0;
let allowed = true;
for(let i = 0;i<result.length;i++){
    const current = result[i];
    if(current.includes("don't(")){
        allowed = false;
    }
    else if(current.includes("do(")){
        allowed = true;
    }
    else if(allowed){
        const ans = current.replace("mul(","").replace(")","").split(",");
        console.log(ans);
        total += ans[0] * ans[1];
    }
}
console.log(total);