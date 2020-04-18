let vm = new Vue({
    el:'.main-container',
    data:{
        pageInfo:{
            pageNum:1,
            pageSize:5
        },
        demand:{}
    },
    methods:{
        selectPage:function (pageNum,pageSize) {
            axios({
                url:`manager/demand/selectPage/${pageNum}/${pageSize}`,
            }).then(response => {
                this.pageInfo = response.data.obj
            }).catch(error => {
                layer.msg(error.message);
            })
        },
        toUpdate:function (demand) {
            layer.obj=demand;
            layer.open({
                type: 2,
                title:'更新demend',
                area: ['80%', '80%'],
                time: 0,
                content: ['manager/demand/toUpdate'],
                end: function(){
                    if(layer.flag){
                        this.selectPage(1,this.pageInfo.pageSize)
                    }
                }
            })
        },
        toDetail:function (demand) {
            layer.obj=demand;
            layer.open({
                type:2,
                area: ['80%', '80%'],
                title:'详细demend',
                time: 0,
                content: ['manager/demand/toDetail'],
                end: function(){

                }
            })
        }
    },
    created:function () {
        this.selectPage(1,this.pageInfo.pageSize);
    }
})