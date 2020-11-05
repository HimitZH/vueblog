<template>
  <div>
    <Header></Header>
    <div class="block">
      <el-timeline>
        <el-timeline-item
          placement="top"
          v-for="(blog,index) in blogContents"
          :key="index"
        >
          <el-card>
            <h2>
              <router-link class="link" :to="{name:'BlogDetail',params:{blogId:blog.id}}">{{blog.title}}</router-link>
            </h2>
            <div class="new-meta-box">
                          <div class="new-meta-item">
                                    <i class="el-icon-user-solid" aria-hidden="true"></i>
                      
                                      
                                        <router-link class="link" :to="{name:'User',params:{username:blog.author}}">{{blog.author}}</router-link>
                                    </div>
                                    <div class="new-meta-item date">
                                      <i class="el-icon-s-order" aria-hidden="true"></i>
                                        <a class="notlink">
                                    
                                            <p>{{blog.gmtCreate}}</p>
                                        </a>
                                    </div>                   
                </div>
                <div class="fenge">
                  <el-divider></el-divider>
                </div>
            <blockquote>
                    <p><i class="el-icon-collection-tag"></i>简介：{{blog.description}}</p>
            </blockquote>
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
    <Footer></Footer>
  </div>
</template>

<script>
import Header from "@/components/Header";
import Footer from "@/components/Footer";
export default {
  components: { Header,Footer },

  data() {
    return {
      blogContents: {},
      currentPage: 1,
      total: 0,
      pageSize: 5,
      avatar:require("@/asserts/img/default_user.jpg"),
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
.fenge .el-divider{
 margin: 2px 0 !important;
}
.new-meta-item a{
    text-decoration: none;
    color: rgba(68,68,68,0.65);
    padding-left: 0;
    padding-right: 4px;
}
.new-meta-box{
    -webkit-transition: all 0.1s ease;
    font-size: 0.8125rem;
    padding-top: px;
    padding-bottom: 2px;
    display: flex;
    align-items: center;
    flex-wrap: wrap;
}
.new-meta-item{
    color: rgba(68,68,68,0.65);
    display: flex;
    align-items: center;
    justify-content: center;
    padding: 2px;
    margin: 0 8px 0 0;
    border-radius: 4px;
}
blockquote{
    margin-left: 2px;
    text-align: left;
    font-size: 0.9375rem;
    margin-top: 0.5rem;
    margin-bottom: 0.5rem;
    position: relative;
    width: 95%;
    padding: 0.7em 1.2em;
    background: #e8f4fd;
    border-left: 4px solid #2196f3;
    border-radius: 4px;
}
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