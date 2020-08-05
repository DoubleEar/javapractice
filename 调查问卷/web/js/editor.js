class Editor{
    survey;
    editorUI;

    constructor(survey,editorUI){
        this.survey=survey;
        this.editorUI=editorUI;
    }

    //绑定事件
    bindEvents(){
        console.log(this);  //editor对象
        this.editorUI.getAddTabButton().onclick=this.returnAddTabAction();
    }

    returnAddTabAction(){
        let editor=this;    //这里的this还是Editor对象
        //直接返回一个方法
        return function (evt) {
            //向Survey中新增一页，并得到pid。
            //这里不能用this.survey，只能使用editor.survey。
            //这里的this是点击的html的元素，不是Editor对象了。
            let pid=editor.survey.addPage();

            //新增一个tab页(只要和html有关系，全部放到editor-ui中)
            editor.editorUI.addTab(pid);

            //激活该tab页
            editor.activePage(pid);
        };
    }

    activePage(pid){
        //把原本来激活的页面处于不在激活的状态(tab显示，content内容)
        this.editorUI.unactive(pid);

        let data;
        if(pid===0){
            data=this.survey.getBasic();
        }else if(pid===-1){
            data=this.survey.getThanks();
        }else {
            data=this.survey.getPage(pid);
        }
        let page=this.survey.getPage(pid);
        this.editorUI.active(pid,page);
    }

    start(){
        this.bindEvents();
    }
}