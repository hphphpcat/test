function solution(a, b) {
    let suma = 0; // a的总和
    let sumb = 0; // b的总和
    let mp = new Map(); // 记录b里面数出现的次数
    let mpa = new Map(); // 记录a里面数出现的次数
    for (let x of b) mp.set(x, 1); // 这里每个b只算做一次
    for (let x of b) sumb += x;
    for (let x of a) suma += x;
    suma -= sumb; // 计算(suma-sumb)/2
    if (suma % 2 != 0) return 0;
    suma /= 2;
    let res = 0; // 记录答案
    for (let i = 0; i < a.length; i++) {
        if (mpa.has(a[i])) continue; // 这里一定要是Number类型 ！！！
        mpa.set(a[i], 1);
        res += mp.get(a[i] - suma) || 0; // 查询的是 ai - (suma - sumb)/2
    }
    return res;
}

console.log(solution([1, 1], [2, 2]));
console.log(solution([1, 2, 3], [6, 12]));
console.log(solution([2, 3], [7, 8]));