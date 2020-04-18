let vm = new Vue({
    el:'.main-content',
    data:{
        pageInfo:{
            pageNum:1,
            pageSize:5
        },
        app:{},
        active:false
    },
    methods:{
        selectPage:function (pageNum,pageSize) {
            axios({
                url:`manager/app/selectPage/${pageNum}/${pageSize}`
            }).then(response => {
                this.pageInfo = response.data.obj;
            }).catch(error => {
                console.log(error);
            })
        },
        toUpdate:app =>{
            layer.obj=app;
            layer.open({
                type: 2,
                title:'更新app',
                area: ['80%', '80%'],
                content: ['manager/app/toUpdate'],
                end:function () {
                    if(layer.flag){
                        this.selectPage(1,this.pageInfo.pageSize)
                    }
                }
            })
        },
        changeActive:function () {//修改激活状态
            this.active=!this.active;
           /* this.active=false;
            console.log(this.active);*/
        },
        toInsert:function () {
            axios({
                url:'manager/app/doInsert',
                data:this.app,
                method:'post'
            }).then(response => {
                if (response.data.success){
                    this.clear();
                    this.active = false;
                    this.selectPage(1,this.pageInfo.pageSize);
                }
                layer.msg(response.data.msg);
            }).catch(error => {
                layer.msg(error.message);
            })
        },
        toDelete:function(id){
            // layer.msg('你确定你很帅么？', {
            //     time: 0 //不自动关闭
            //     ,btn: ['必须啊', '丑到爆']
            //     ,yes: function(index){
            //         layer.close(index);
            //         layer.msg('雅蠛蝶 O.o', {
            //             icon: 6
            //             ,btn: ['嗷','嗷','嗷']
            //         });
            //     }
            // });
            layer.msg('你确定要删除么？',{
                time:0,
                btn:['确定','取消'],
                yes:(index) => {
                    layer.close(index);
                    axios({
                        url: `manager/app/doDelete/${id}`
                    }).then(response => {
                        if(response.data.success){
                            this.selectPage(1,this.pageInfo.pageSize);
                        }
                        layer.msg(response.data.msg);
                    }).catch(error => {
                        layer.msg(error.message);
                    })
                }
            })
        },
        clear:function () {
            this.app={}
        }
    },
    created:function () {
        this.selectPage(1,this.pageInfo.pageSize)
    }
})