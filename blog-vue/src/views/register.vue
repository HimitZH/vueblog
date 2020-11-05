<template>
	<div>
	<div class="box">

		<div class="pop-up">
			<div id="small-dialog" class="mfp-hide book-form">
				<h3>用&emsp;户&emsp;注&emsp;册 </h3>
				<form>
					<span>
						<el-input v-model="username" placeholder="请输入用户名:" required></el-input>
					</span>
					<span>
						<el-input v-model="email" placeholder="请输入邮箱:" required></el-input>
					</span>
					<span>
						<el-input v-model="password" placeholder="请输入密码:" clearable required></el-input>
					</span>
					<span>
						<el-input v-model="password2" placeholder="确认密码:" required></el-input>
					</span>
					<span >
						<el-button type="primary" plain style="margin-top: 40px;" @click="toRegister">注册</el-button>
						<el-button type="warning" plain style="margin-top: 40px;margin-right: 40px;" @click="reset">重置</el-button>
						<el-button type="success" plain style="margin-top: 40px;" @click="toLogin">返回</el-button>
					</span>
				</form>
			</div>
		</div>
		
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
				username: '',
				email: '',
				password: '',
				password2: ''
			}
		},
		methods:{
	
			toLogin(){
				this.$router.push({ name: "Login" });
			},
			toRegister(){
				if(this.username==""){
					this.$message({
						type: "warning",
						message: "用户名不能为空！"
					});
					return;
				}
				if(this.email==""){
					this.$message({
						type: "warning",
						message: "邮箱不能为空"
					});
					return;
				}
				if(this.password==""||this.password.length<6){
					this.$message({
						type: "warning",
						message: "密码不能为空或长度小于6"
					});
					return;
				}
				if(this.password2==""){
					this.$message({
						type: "warning",
						message: "确认密码不能为空！"
					});
					return;
				}
				if(this.password!=this.password2){
					this.$message({
						type: "danger",
						message: "两次密码不一致，请重新输入！"
					});
					this.password = this.password2 = "";
					return;
				}
				this.$axios.post("/register", {
					username: this.username,
					password: this.password,
					email: this.email
				}).then(res => {
					let _this = this
					this.$notify({
						title: res.data.msg,
						message: "恭喜注册成功,5秒后将自动返回登录页面~",
						type: 'success',
						duration: 5000,
						onClose(){
							 _this.$router.push({ name: "Login" });
						}
        			});
				})
			},
			reset(){
				this.username = "",
				this.email = "",
				this.password = "",
				this.password2 = ""
			}
		}
	}
</script>

<style scoped>
	.box {
		max-width: 800px;
		height: 650px;
		border: 2px solid skyblue;
		box-shadow: darkgrey 10px 10px 30px 5px;
		border-radius: 15px;
		margin: 5% auto;
	}
	.el-input{
		margin-top: 40px;
	}
	.el-button--primary {
	    color: #FFF;
	    background-color: #409EFF;
	    border-color: #409EFF;
		width: 500px;
	}
	.el-button--warning{
		width: 230px;
	}
	.el-button--success{
		width: 230px;
	}
	.el-button+.el-button {
    	margin-left: 0 !important; 
	}
	#small-dialog,
	#small-dialog2 {
		background: #fff;
		text-align: left;
		max-width: 500px;
		margin: 40px auto;
		position: relative;
	}
span{
	margin-top: 50px;
	
}
	h1,
	h2,
	h3,
	h4,
	h5,
	h6 {
		font-family: 'Montserrat', sans-serif;
	}

	form {
		display: block;
		margin-top: 0em;
	}

	input {
		-webkit-writing-mode: horizontal-tb !important;
		text-rendering: auto;
		color: -internal-light-dark(black, white);
		letter-spacing: normal;
		word-spacing: normal;
		text-transform: none;
		text-indent: 0px;
		text-shadow: none;
		display: inline-block;
		text-align: start;
		appearance: textfield;
		background-color: -internal-light-dark(rgb(255, 255, 255), rgb(59, 59, 59));
		-webkit-rtl-ordering: logical;
		cursor: text;
		margin: 0em;
		font: 400 13.3333px Arial;
		padding: 1px 2px;
		border-width: 2px;
		border-style: inset;
		border-color: -internal-light-dark(rgb(118, 118, 118), rgb(133, 133, 133));
		border-image: initial;
	}
</style>
