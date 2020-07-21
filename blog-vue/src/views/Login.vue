<template>
  <div>
    <el-container>
      <el-header>
      
      </el-header>
      <el-main>
        <div class="demo-image__lazy">
          <el-image :key="url" :src="url" lazy></el-image>
        </div>
        <div>
        <el-form
          :model="ruleForm"
          :rules="rules"
          ref="ruleForm"
          label-width="100px"
          class="demo-ruleForm"
        >
          <el-form-item label="用户名" prop="username">
            <el-input v-model="ruleForm.username"></el-input>
          </el-form-item>
          <el-form-item label="密码" prop="password">
            <el-input type="password" v-model="ruleForm.password"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="submitForm('ruleForm')">登录</el-button>
            <el-button @click="resetForm('ruleForm')">重置</el-button>
          </el-form-item>
        </el-form>
        </div>
      </el-main>
    </el-container>
  </div>
</template>

<script>
export default {
  data() {
    return {
      ruleForm: {
        username: "",
        password: ""
      },
      rules: {
        username: [
          { required: true, message: "请输入用户名", trigger: "blur" },
          { min: 3, max: 15, message: "长度在 3 到 15 个字符", trigger: "blur" }
        ],
        password: [
          { required: true, message: "请输入密码", trigger: "blur" },
          { min: 3, max: 15, message: "长度在 3 到 15 个字符", trigger: "blur" }
        ]
      },
      url:"https://cdn.jsdelivr.net/gh/HimitZH/CDN/images/HCODE.png"
    };
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          const _this = this;
          this.$axios.post("/login", this.ruleForm).then(res => {
            const jwt = res.headers["authorization"];
            const userInfor = res.data.data;

            //提交到仓库
            _this.$store.commit("setToken", jwt);
            _this.$store.commit("setUserInfo", userInfor);

            console.log(_this.$store.getters.getUserInfo);

            //成功跳转
            _this.$router.push({ name: "Blog" });
          });
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  }
};
</script>

<style scoped>
.el-header,
.el-footer {
  background-color: #b3c0d1;
  color: #333;
  text-align: center;
  line-height: 60px;
}

.el-main {
  color: #333;
  text-align: center;
  line-height: 160px;
}

body > .el-container {
  margin-bottom: 40px;
}

.el-container:nth-child(5) .el-aside,
.el-container:nth-child(6) .el-aside {
  line-height: 260px;
}

.el-container:nth-child(7) .el-aside {
  line-height: 320px;
}
.logo {
  height: 80%;
  margin-top: 5px;
}
.demo-ruleForm {
  width: 31rem;
  margin: 0 auto;
  padding-top: 30px;
}
.demo-image__lazy{
  width: 300px;
  height: 300px;
  margin: 0 auto;

}
</style>