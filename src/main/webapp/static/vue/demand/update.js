let vm = new Vue({
    el:'.main-container',
    data:{
        demand:{}
    },
    methods:{
        doUpdate:function () {
            axios({
                url:'manager/demand/doUpdate',
                method:'put',
                data:this.demand
            }).then(response => {
                let flag = false;
                if (response.data.success){
                    // 通过父窗口获取frame的索引值
                    let index = parent.layer.getFrameIndex(window.name);
                    //把标记设置为true,并传给父layer
                    flag = true;
                    parent.layer.flag = flag;
                    // 再通过父窗口根据索引值关闭frame
                    parent.layer.close(index);
                    // 在父窗口中提示
                    parent.layer.msg(response.data.msg);
                }
            }).catch(error => {
                this.layer.msg(error.message);
            })
        }
    },
    created:function () {
        //初始化app  从父窗口的layer对象中获取obj属性
        this.demand = parent.layer.obj;
    }
})