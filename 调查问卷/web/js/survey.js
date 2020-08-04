class Survey {
    //属性 没有变量类型，没有访问限定符。
    data;

    //构造方法
    constructor(data){
        this.data=data;
    }

    addPage(){
        //js的数组类似于Java中的list
        //往数组中尾插一个数据
        this.data.pages.push({
            questions:[]
        });

        console.log(this.data);
        //返回data中pages的个数
        return this.data.pages.length;
    }


    //根据sid，从后台获取相应的调查问卷数据，并构建survey对象
    static load(sid){
        return apiGet("/api/get-survey.json?sid="+sid)
            .then(data=>{
                return new Survey(data);
            });
    }
}