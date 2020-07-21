<template>
  <div>
    <Header></Header>
    <div class="content">
      <h2>{{blog.title}}</h2>

      <el-button-group>
        <el-button type="primary" icon="el-icon-edit" @click="toEdit">编辑</el-button>
        <el-button type="danger" icon="el-icon-delete" @click="toDelete">删除</el-button>
      </el-button-group>

      <el-divider>
        <i class="el-icon-reading"></i>
      </el-divider>
      <div class="markdown-body" v-html="blog.content"></div>
    </div>
  </div>
</template>

<script>
import Header from "@/components/Header";
import "github-markdown-css";
export default {
  components: { Header },
  data() {
    return {
      blog: {
        id: "",
        title: "",
        content: ""
      },
      ownBlog: false
    };
  },
  methods: {
    toEdit() {
      this.$router.push({ name: "BlogEdit", params: { blogId: this.blog.id } });
    },
    toDelete() {
      this.$confirm("是否删除该博文？", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      })
        .then(() => {
          this.$axios
            .get("/blog/delete/" + this.blog.id, {
              headers: {
                Authorization: localStorage.getItem("token")
              }
            })
            .then(res => {
              this.$router.push({ name: "Blog" });
            });
          this.$message({
            type: "success",
            message: "删除成功!"
          });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消删除"
          });
        });
    }
  },
  created() {
    let blogId = this.$route.params.blogId;
    if (blogId) {
      this.$axios.get("/blog/" + blogId).then(res => {
        let blog = res.data.data;
        this.blog.id = blog.id;
        this.blog.title = blog.title;

        // 进行css渲染
        let MardownIt = require("markdown-it");
        let md = new MardownIt();

        let result = md.render(blog.content);

        this.blog.content = result;
        // 判断是否为该作者，是才能编辑
        this.ownBlog = blog.userId === this.$store.getters.getUserInfo.id;
      });
    }
  }
};
</script>

<style scoped>
.content {
  padding: 20px 15px;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
  width: 100%;
  min-height: 700px;
}
.edit {
  color: skyblue;
  text-decoration: none;
}
.edit:hover {
  color: red;
  scale: 1;
}
</style>