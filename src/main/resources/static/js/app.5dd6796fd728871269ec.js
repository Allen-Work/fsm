webpackJsonp([1],{"DT+5":function(e,t){},EB8d:function(e,t){},HNOq:function(e,t){},NHnr:function(e,t,n){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var r=n("7+uW"),a={render:function(){var e=this.$createElement,t=this._self._c||e;return t("div",{attrs:{id:"app"}},[t("router-view")],1)},staticRenderFns:[]};var i=n("VU/8")({name:"App"},a,!1,function(e){n("l1Gs")},null,null).exports,o=n("/ocq"),l={name:"main.vue",data:function(){return{tableData:Array(20).fill({date:"2016-05-02",name:"王小虎",address:"上海市普陀区金沙江路 1518 弄"})}}},s={render:function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",[n("el-container",{staticStyle:{height:"500px",border:"1px solid #eee"}},[n("el-aside",{staticStyle:{"background-color":"rgb(238, 241, 246)"},attrs:{width:"200px"}},[n("el-menu",{attrs:{"default-openeds":["2"]}},[n("el-submenu",{attrs:{index:"2"}},[n("template",{slot:"title"},[n("i",{staticClass:"el-icon-menu"}),e._v("文件管理")]),e._v(" "),n("el-menu-item-group",[n("el-menu-item",{attrs:{index:"2-1"}},[n("router-link",{attrs:{to:"/file/add"}},[e._v("新建文件")])],1),e._v(" "),n("el-menu-item",{attrs:{index:"2-2"}},[n("router-link",{attrs:{to:"/file/list"}},[e._v("文件列表")])],1)],1)],2),e._v(" "),n("el-submenu",{attrs:{index:"1"}},[n("template",{slot:"title"},[n("i",{staticClass:"el-icon-message"}),e._v("用户管理")]),e._v(" "),n("el-menu-item-group",[n("el-menu-item",{attrs:{index:"1-1"}},[n("router-link",{attrs:{to:"/user/add/1"}},[e._v("新增用户")])],1),e._v(" "),n("el-menu-item",{attrs:{index:"1-2"}},[n("router-link",{attrs:{to:"/user/list/2"}},[e._v("用户列表")])],1)],1)],2)],1)],1),e._v(" "),n("el-container",[n("el-header",{staticStyle:{"text-align":"right","font-size":"12px"}},[n("el-dropdown",[n("i",{staticClass:"el-icon-setting",staticStyle:{"margin-right":"15px"}}),e._v(" "),n("el-dropdown-menu",{attrs:{slot:"dropdown"},slot:"dropdown"},[n("el-dropdown-item",[e._v("查看")]),e._v(" "),n("el-dropdown-item",[e._v("新增")]),e._v(" "),n("el-dropdown-item",[e._v("删除")]),e._v(" "),n("el-dropdown-item",[n("router-link",{attrs:{to:"/home"}},[e._v("首页")])],1)],1)],1),e._v(" "),n("span",[e._v("王小虎")])],1),e._v(" "),n("el-main",[n("router-view")],1)],1)],1)],1)},staticRenderFns:[]};var u=n("VU/8")(l,s,!1,function(e){n("uROQ")},"data-v-3f7c1e12",null).exports,c={render:function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",[n("h1",{staticClass:"login-title"},[e._v("欢迎登录")]),e._v(" "),n("el-form",{ref:"form",staticClass:"login-box",attrs:{model:e.form,rules:e.rules,"label-width":"80px"}},[n("el-form-item",{attrs:{label:"账号",prop:"username"}},[n("el-input",{model:{value:e.form.username,callback:function(t){e.$set(e.form,"username",t)},expression:"form.username"}})],1),e._v(" "),n("el-form-item",{attrs:{label:"密码",prop:"password"}},[n("el-input",{attrs:{type:"password"},model:{value:e.form.password,callback:function(t){e.$set(e.form,"password",t)},expression:"form.password"}})],1),e._v(" "),n("el-form-item",[n("el-button",{attrs:{type:"primary"},on:{click:function(t){return e.login("form")}}},[e._v("登录")])],1)],1)],1)},staticRenderFns:[]};var d=n("VU/8")({name:"login.vue",data:function(){return{form:{username:"",password:""},rules:{username:[{required:!0,message:"请输入用户名",trigger:"blur"}],password:[{required:!0,message:"请输入密码",trigger:"blur"}]}}},methods:{login:function(e){var t=this;this.$refs[e].validate(function(e){if(!e)return t.$message.error("请输入用户名密码"),!1;t.$router.push("/main")})}}},c,!1,function(e){n("HNOq")},"data-v-1f61f3ea",null).exports,m={render:function(){var e=this.$createElement;return(this._self._c||e)("div",[this._v("新增用户"+this._s(this.$route.params.id))])},staticRenderFns:[]};var p=n("VU/8")({name:"UserAdd"},m,!1,function(e){n("wxh3")},"data-v-8da517f8",null).exports,f={render:function(){var e=this.$createElement;return(this._self._c||e)("div",[this._v("用户列表"+this._s(this.no))])},staticRenderFns:[]};var h=n("VU/8")({props:["no"],name:"UserList"},f,!1,function(e){n("pZiu")},"data-v-1d4ee823",null).exports,v={render:function(){this.$createElement;this._self._c;return this._m(0)},staticRenderFns:[function(){var e=this.$createElement,t=this._self._c||e;return t("div",[t("h1",[this._v("页面不存在")])])}]};var _=n("VU/8")({name:"404"},v,!1,function(e){n("DT+5")},"data-v-25eab130",null).exports,w={removeTheLastComma:function(e){var t=e.lastIndexOf(",");return e.substring(0,t)}},b={name:"showFiles",data:function(){return{isShow:!1,tableData:[{checked:"",fileName:"",directory:"",size:"",createTime:"",updateTime:"",remark:""}],arrList:[],pdfAddress:""}},mounted:function(){this.show("")},methods:{preview:function(){var e=this.arrList;if(e.length>1)this.$alert("只能预览一个文件",{confirmButtonText:"确定"});else{var t=e[0];if(0!=t.fileType){var n="http://192.168.75.134:8081/show/pdfPreview?fileId="+t.fileId+"&fullfilename="+t.fileName;window.open("http://192.168.75.134:8012/onlinePreview?url="+encodeURIComponent(n))}else this.$alert("不能预览文件夹",{confirmButtonText:"确定"})}},show:function(e){var t=this;this.axios({method:"get",params:{fileId:e},url:"http://192.168.75.134:8081/show/getFileList"}).then(function(e){var n=e.data.data;null!=n?t.tableData=n:t.$alert(e.data.msg,{confirmButtonText:"确定"}),console.log(e)}).catch(function(e){console.log(e)})},clickRow:function(e){this.$refs.checkTable.toggleRowSelection(e)},toggleSelection:function(){for(var e=this,t=this.arrList,n="",r=0;r<t.length;r++)n+=t[r].fileId+",";this.axios({method:"post",params:{fileIds:w.removeTheLastComma(n)},url:"http://192.168.75.134:8081/share/generateLink"}).then(function(t){e.$alert("生成的地址:"+t.data.data,{confirmButtonText:"确定"})}).catch(function(e){console.log(e)})},handleSelectionChange:function(e){this.arrList=e}},watch:{$route:function(e,t){var n=this.$route.query.fileId;this.show(n)}}},g={render:function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",[n("el-button",{staticClass:"btn-show",attrs:{type:"primary"},on:{click:e.preview}},[e._v("预览")]),e._v(" "),n("el-button",{staticClass:"btn-show",attrs:{type:"primary"},on:{click:e.toggleSelection}},[e._v("分享")]),e._v(" "),n("el-table",{ref:"checkTable",staticStyle:{width:"100%"},attrs:{data:e.tableData,stripe:""},on:{"row-click":e.clickRow,"selection-change":e.handleSelectionChange}},[n("el-table-column",{attrs:{type:"selection"}}),e._v(" "),e.isShow?n("el-table-column",{attrs:{prop:"fileId",label:"文件Id",width:"180"}}):e._e(),e._v(" "),n("el-table-column",{attrs:{prop:"fileName",label:"文件名称",width:"180"},scopedSlots:e._u([{key:"default",fn:function(t){return[n("router-link",{attrs:{to:{path:"/file/list",query:{fileId:t.row.fileId,fileName:t.row.fileName}}}},[e._v(e._s(t.row.fileName)+"\n        ")])]}}])}),e._v(" "),n("el-table-column",{attrs:{prop:"directory",label:"文件目录",width:"180"}}),e._v(" "),n("el-table-column",{attrs:{prop:"size",label:"文件大小"}}),e._v(" "),n("el-table-column",{attrs:{prop:"createTime",label:"创建时间"}}),e._v(" "),n("el-table-column",{attrs:{prop:"updateTime",label:"修改时间"}}),e._v(" "),n("el-table-column",{attrs:{prop:"remark",label:"备注"}}),e._v(" "),n("el-table-column",{attrs:{label:"操作",width:"180"}})],1)],1)},staticRenderFns:[]};var x=n("VU/8")(b,g,!1,function(e){n("EB8d")},"data-v-78516614",null).exports;r.default.use(o.a);var k=new o.a({routes:[{name:"Login",path:"/login",component:d},{name:"Main",path:"/main",component:u,children:[{name:"UserAdd",path:"/user/add/:id",component:p},{name:"UserList",path:"/user/list/:no",component:h,props:!0},{name:"ShowFiles",path:"/file/list",component:x,props:!0}]},{path:"/",redirect:"/main"},{path:"*",component:_}]}),y=n("mtWM"),$=n.n(y),T=n("zL8q"),R=n.n(T),S=(n("tvR6"),n("wvfG")),C=n.n(S);r.default.config.productionTip=!1,r.default.use(R.a),r.default.prototype.axios=$.a,r.default.use(w),r.default.use(C.a),new r.default({el:"#app",components:{App:i},template:"<App/>",router:k,render:function(e){return e(i)}})},l1Gs:function(e,t){},pZiu:function(e,t){},tvR6:function(e,t){},uROQ:function(e,t){},wxh3:function(e,t){}},["NHnr"]);