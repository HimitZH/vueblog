<template>
  <div>
    <Header></Header>
    <div class="block">
      <el-timeline>
        <el-timeline-item
          :timestamp="blog.gmtCreate"
          placement="top"
          v-for="(blog,index) in blogContents"
          :key="index"
        >
          <el-card>
            <h2>
              <router-link class="link" :to="{name:'BlogDetail',params:{blogId:blog.id}}">{{blog.title}}</router-link>
            </h2>
            <el-divider></el-divider>
            <p><i class="el-icon-collection-tag"></i> {{blog.description}}</p>
          </el-card>
        </el-timeline-item>
      </el-timeline>
      <!--分页-->
      <el-pagination class="pager" background layout="prev, pager, next" 
      :current-page="currentPage" 
      :page-size="pageSize"
      :total="total"
      @current-change="getPage">
      </el-pagination>
    </div>
  </div>
</template>

<script>
import Header from "@/components/Header";
export default {
  components: { Header },

  data() {
    return {
      blogContents: {},
      currentPage: 1,
      total: 0,
      pageSize: 5
    };
  },

  methods: {
    getPage(currentPage) {
      const _this = this;
      _this.$axios.get("/blogs?currentPage=" + currentPage).then(res => {
        _this.blogContents = res.data.data.records;
        _this.currentPage = res.data.data.current;
        _this.total = res.data.data.total;
        _this.pageSize = res.data.data.size;
      });
    }
  },
  created() {
    this.getPage(1);
  }
};
</script>

<style>
.pager {
  margin: 0 auto;
  text-align: center;
}
.link{
  color: skyblue;
  text-decoration: none;
}
.link:hover{
  color: #ff5722;
}
</style>