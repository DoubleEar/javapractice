/*
    pid:0   基本信息页
    pid>0   普通的调查问卷页
    pid:-1  致谢词页
 */
class EditorUI{
    currentPid=0;
    tabs=document.querySelector("#tabs");
    contentPanel=document.querySelector("#content");

    getAddTabButton(){
        //返回 html中id等于add-tab的元素
        return document.querySelector("#add-tab")  //#开头代表按照id查找
    }

    addTab(pid){
        //<div>第<pid>页<span>删除</span></div>
        let span=document.createElement("span");
        span.innerText="删除";

        let div=document.createElement("div");
        div.innerText="第"+pid+"页";
        div.appendChild(span);

        div.setAttribute("data-pid",pid);

        this.tabs.appendChild(div);
    }

    unactive(){
        //需要先确定之前的激活状态的tab
        //通过class等于active找到当前激活的页面
        let curActive=document.querySelector(".active");    //. 找到相应的类
        if(curActive===null){
            return;
        }

        curActive.classList.remove("active");
        this.contentPanel.innerText=""; //把该元素的所有孩子都删掉
    }

    active(pid,data){
        this.currentPid=pid;

        let toActiveTab=document.querySelector("[data-pid='"+pid+"']");
        toActiveTab.classList.add("active");

        if(pid===0){
            this.showBasicContent(data);
        }else if(pid===-1){
            this.showThanksContent(data);
        }else{
            this.showPageContent(pid,data);
        }
    }

    showBasicContent(data){
        console.log(data);
    }

    showThanksContent(data){
        console.log(data);
    }

    showPageContent(data){
        console.log(data);
    }

    getBasicTabButton(){
        return document.querySelector("#basic-tab");
    }
}