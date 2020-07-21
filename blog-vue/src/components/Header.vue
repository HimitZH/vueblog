<template>
  <div class="m-content">
    <el-image 
    style="width: 200px; height: 200px"
    :src="url" 
    lazy>
  </el-image>
    <div class="block">
      <el-avatar :size="50" :src="user.avatar"></el-avatar>
      <div>{{user.username}}</div>
      <div class="m-action">
        <span><el-link type="info" href="/blog">主页</el-link></span>
        
        <el-divider direction="vertical"></el-divider>
        <span><el-link type="success" href="/blog/add">发表博文</el-link></span>
        
        <el-divider direction="vertical"></el-divider>
        <span v-show="!isLogin"><el-link type="primary" href="/login">登录</el-link></span>

        <span v-show="isLogin"><el-link type="danger" @click="logout">退出</el-link></span>

        <el-divider direction="vertical"></el-divider>
        <span><el-link type="warning" href="https://www.hcode.top">主站</el-link></span>
    
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      user: {
        username: "请先登录",
        avatar:
          "https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png"
      },
      isLogin: false,
      url:"https://cdn.jsdelivr.net/gh/HimitZH/CDN/images/HCODE.png"
    };
  },
  methods:{
      logout(){
          const _this = this
          _this.$axios.get("/logout",{
              headers:{
                  "Authorization": localStorage.getItem("token")
              }
          }).then(res => {
            _this.$store.commit("rmUserInfo")
            _this.$router.push('/login')
          })
      }
  },
  created(){
      if(this.$store.getters.getUserInfo.username){
          this.user.username = this.$store.getters.getUserInfo.username
          this.user.avatar = this.$store.getters.getUserInfo.avatar
          
          this.isLogin = true
      }
  }
};
</script>

<style>
.m-content {
  max-width: 960px;
  margin: 0 auto;
  text-align: center;
}
.m-action{
    margin: 10px 0;
}
</style>