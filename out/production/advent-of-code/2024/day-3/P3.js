const fs = require('fs')

const s = fs.readFileSync('./P3.txt').toString();
const result = s.match(/mul\([0-9]+,[0-9]+\)/gi).map(x => {
    return x.replace("mul(","").replace(")","").split(",")
}).map(x => x[0]*x[1]).reduce((a,b) => a+b);
console.log(result);