let vm = new Vue({
    el:'.main-container',
    data:{
        demand:{}
    },
    methods:{

    },
    created:function () {
        this.demand = parent.layer.obj;
    }
})