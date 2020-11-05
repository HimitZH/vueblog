<template>
<div>
  <div class="box">
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
          class="demo-ruleForm form_item"
        >
          <el-form-item label="用户名" prop="username" >
            <el-input v-model="ruleForm.username" prefix-icon="el-icon-user-solid"></el-input>
          </el-form-item>
          <el-form-item label="密码" prop="password" >
            <el-input type="password" v-model="ruleForm.password"  @keyup.enter="submitForm('ruleForm')" prefix-icon="el-icon-date"></el-input>
          </el-form-item>
          <el-form-item>
              <el-button type="primary" round  @click="submitForm('ruleForm')" class="button">登录</el-button>

            <el-button type="info" round  @click="resetForm('ruleForm')" class="button" style="margin-left: 20px;">重置</el-button>
          </el-form-item>
        </el-form>
        </div>
        
      </el-main>
    
    </el-container>

    <a href="#" class="text-center block font-color">忘记密码？</a>
		<p class="text-center">
			没有账号？<router-link :to="{name:'Register'}" class="font-color">立即注册</router-link>
		</p>
    </div>
    <Footer></Footer>
  </div>
</template>

<script>
import Footer from "@/components/Footer";
export default {
  components: { Footer },
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
.font-color {
	    color: #c2c2c6;
		font-size:15px;
	}
	.block {
	    display: block !important;
	}
	.text-center {
	    text-align: center !important;
		font-size:15px;
	}
	a {
	    color: #333;
	    text-decoration: none;
	}
	p {
	    margin-top: 25px;
	}
	
.form_item >>> .el-form-item:nth-child(3) .el-form-item__content{
  margin-left: 50px !important;
  margin-top: 40px !important;
}
.box{
  max-width: 800px;
  height:  650px;
  border:2px solid skyblue;
  box-shadow: darkgrey 10px 10px 30px 5px ;
  border-radius: 15px;
  margin: 5% auto;
   background: white;
}
.button{
  margin-left:5px;
  width: 40%;
}
.el-header{
  border-radius: 15px;
}
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
  margin: 100px auto;

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
}
.demo-image__lazy{
  width: 250px;
  height: 250px;
  margin: 0 auto;

}
</style>