let vm = new Vue({
    el:'.main-content',
    data:{
        pageInfo:{
            pageNum:1,
            pageSize:5
        },
        condition:{
            type:'',
            check:''
        }
    },
    methods:{
        selectPage:function (pageNum,pageSize) {
            axios({
                url:`manager/qualification/selectPage/${pageNum}/${pageSize}`,
                params:this.condition
            }).then(response => {
                this.pageInfo = response.data.obj;
            }).catch(error => {
                console.log(error.message);
            })
        },
        selectAll:function(){
            this.condition = {};
            this.selectPage(1,this.pageInfo.pageSize);
        },
        toUpdate:qualification =>{
            layer.obj=qualification;
            layer.open({
                type: 2,
                title:'更新qualification',
                area: ['80%', '80%'],
                content: ['manager/qualification/toUpdate'],
                end:function () {
                    if(layer.flag){
                        this.selectPage(1,this.pageInfo.pageSize)
                    }
                }
            })
        }
    },
    created:function () {
        this.selectPage(1,this.pageInfo.pageSize)
    }
})