<template>

	<div class="m-content">

		<div class="nav-left">
			<el-image style="width: 100px; height: 100px" :src="url" lazy>
			</el-image>
		</div>
		<div class="nav-right">
			  <span v-show="!isLogin"><el-link type="primary" href="/login">登录</el-link></span>
			  <span v-show="isLogin"><el-link type="primary" ><el-popover
					placement="bottom"
					width="40"
					trigger="click"
					>
					<el-avatar :size="50" :src="user.avatar"></el-avatar>
					<el-button slot="reference">{{user.username}}</el-button>
				</el-popover></el-link> </span>
			  &nbsp;&nbsp;&nbsp;| &nbsp;&nbsp;&nbsp;
			 <span v-show="!isLogin"><el-link type="primary" href="/register">注册</el-link></span>
			 <span v-show="isLogin"><el-link type="danger"  @click="logout">退出</el-link></span>
		</div>
		<div class="block">
			<!-- <el-avatar :size="50" :src="user.avatar"></el-avatar>
            <div>{{user.username}}</div> -->
			<div class="m-action">

				<el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal">
					<el-menu-item index="1">
						<el-link type="info" href="/blog">主页</el-link>
					</el-menu-item>
					<el-menu-item index="1">
						<el-link type="success" href="/blog/add">发表博文</el-link>
					</el-menu-item>
					<el-menu-item index="1">
						<el-link type="warning" @click="toUser">个人文章</el-link>
					</el-menu-item>

				</el-menu>
			</div>

		</div>


	</div>

</template>

<script>
	export default {
		data() {
			return {
				activeIndex:"1",
				user: {
					username: "请先登录",
					avatar: require("@/asserts/img/default_user.jpg"),
				},
				isLogin: false,
				url: "https://cdn.jsdelivr.net/gh/HimitZH/CDN/images/HCODE.png"
			};
		},
		methods: {
			logout() {
				const _this = this
				_this.$axios.get("/logout", {
					headers: {
						"Authorization": localStorage.getItem("token")
					}
				}).then(res => {
					_this.$store.commit("rmUserInfo")
					_this.$router.push('/login')
				})
			},
			toUser(){
				this.$router.push({ path: '/user/'+this.user.username})
			}
		},
		created() {
			if (this.$store.getters.getUserInfo.username) {
				this.user.username = this.$store.getters.getUserInfo.username
				this.user.avatar = this.$store.getters.getUserInfo.avatar
				this.isLogin = true
			}
		}
	};
</script>

<style>
	.m-content {
		max-width: 890px;
		height: 100px;
		margin: 0 auto;
		
	}

	.m-action {
		margin: 10px 0;
	}

	.nav-left {
		float: left;
	}

	.nav-right {
		float: right;
		height: 80px;
		padding-top:30px;
		font-size: 14px;
		color:#909399;
	}

	.block {
		text-align: center;
	}
	.el-popover{
		text-align: center!important;
	}

	.el-menu-demo {
		padding-right: 20%;
		height: 80px;
		padding-top: 20px;
		background-color: rgba(0, 0, 0, 0);
		float: right;
		

	}

	/* 点击出来的下划线进行隐藏 */
	.el-menu-item.is-active {
		border-bottom: none !important;
		color: rgba(0, 0, 0, 0);
	}

	/* 整体的下划线进行隐藏 */
	.el-menu.el-menu--horizontal {
		border-bottom: none !important;
	}

	/* 导航栏的间距等样式 */
	.el-menu-item {
		padding: 0 62px;
		font-size: 16px;
	}

	/* 点击出来的下划线动效残留进行隐藏 */
	.el-menu--horizontal>.el-menu-item {
		border-bottom: none;
	}

	/* 点击以后的背景色进行隐藏 */
	.el-menu--horizontal>.el-menu-item:not(.is-disabled):focus,
	.el-menu--horizontal>.el-menu-item:not(.is-disabled):hover,
	.el-menu--horizontal>.el-submenu .el-submenu__title:hover {
		background-color: rgba(0, 0, 0, 0);
	}
</style>
