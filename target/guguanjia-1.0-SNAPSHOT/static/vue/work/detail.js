let vm = new Vue({
    el:'.main-container',
    data:{
        result:{},
        work:{}
    },
    methods:{
        doDetail:function () {
            axios({
                url:`manager/work/doDetail/${this.work.id}`,
                method:'put'
            }).then(response => {
                let flag = false;
                this.result = response.data.obj;
            }).catch(error => {
                this.layer.msg(error.message);
            })
        }
    },
    created:function () {
        //初始化app  从父窗口的layer对象中获取obj属性
        this.work = parent.layer.obj;
    },
    mounted:function () {
        this.doDetail();
    }
})