# KotlinCode

趁着学习的Kotlin的机会，做个小demo巩固一下

## 成长
- 学会了MVP的使用
- 学会了tabLayout + ViewPage2的使用
- 学会了WebView 链接拦截 和 一些配置设置
- 学会了使用BaseRecyclerViewAdapterHelper这个库快速创建适配器
- 学会了viewBinding的使用
 
## 遇到的问题
- mvp架构使用起来不熟悉
- tabLayout + ViewPage2 有数据没效果
- webView页面有上一页的时候，每次按back就退出活动页面
- retrofit2 如何做cookie的持久化操作
- 命名重复要避免
```
 override fun getDataSuccess(data: BaseData) {
        //请注意重名的引用
        data.datas?.let {
            ...
            //mAdapter: CommonAdapter 它的父类中有data参数，如果此处不注意加this，
            //那么data.size获取到大小就是data: BaseData 这个数据的大小
            mAdapter.run {
                if (data.offset >= all || this.data.size >= all) {
                    loadMoreModule.loadMoreEnd()
                    return
                }
                ...
            }
        }
    }
```
## 修复日志
  ----------------- 2022.7.1 -----------
- 增添广场、体系、公众号、项目功能
- 修复webView页面加载不出的问题
- 修复webView页面返回键问题
- 修复tabLayout字体大写问题
- 修复fragment内容页面加载不出来问题

 ----------------- 2022.6.29 -----------
- 搭建MVP架构
- 使用Retrofit2搭建网络请求
- 学习kotlin

## 感谢-开源作者
[WanAndroid](https://www.wanandroid.com/)
[banner](https://github.com/youth5201314/banner)
[glide](https://github.com/bumptech/glide)
[retrofit](https://github.com/square/retrofit)
[BaseRecyclerViewAdapterHelper](https://github.com/CymChad/BaseRecyclerViewAdapterHelper)
