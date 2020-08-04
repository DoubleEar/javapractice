function apiGet(url) {
    //使用了一个Promise类，让代码不要陷入回调地狱中。
    return new Promise((resolve,reject) =>{
        let xhr=new XMLHttpRequest();
        xhr.open("get",url);
        xhr.onload=function (ev) {
            if(xhr.status!==200){
                reject(xhr.responseText);
                return;
            }

            //将数据转换为JSON格式
            let result=JSON.parse(xhr.responseText);
            if(result.status!==200){    //===值和类型都相等
                reject(result.reason);
            }else{
                resolve(result.data);
            }
        };
        xhr.onerror=function(ev){
            reject(xhr.responseText);
        };
        xhr.send();
    });
}