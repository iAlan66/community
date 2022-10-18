# 牛客网论坛笔记

[视频链接](https://www.nowcoder.com/study/live/246)

## ElasticSearch
### ElasticSearch 安装
- 版本7.17.4
- 配置文件更改
  - config\elasticsearch.yml
    - cluster.name: nowcoder // 集群名称
    - path.data: d:\work\data\elasticsearch-7.17.4\data // data 路径
    - path.logs: d:\work\data\elasticsearch-7.17.4\logs // log 路径
- 配置环境变量
  - path:D:\Programs\elasticsearch-7.17.4\bin
- 安装中文分词插件 ik
  - 下载地址：https://github.com/medcl/elasticsearch-analysis-ik
  - 解压到 D:\Programs\elasticsearch-6.4.3\plugins\ik文件夹下
- 启动
  - \bin\elasticsearch.bat
### Spring 整合 Elasticsearch
- pom.xml 导入 Spring Boot Starter Data Elasticsearch 的包
- 修改 springboot 中默认的 es 的版本号
  - 在pom.xml 文件的<properties>标签中修改为自己需要的版本号
    - <elasticsearch.version>7.17.4</elasticsearch.version>
- springboot 中application.properties配置文件设置
  ```properties
  # ElasticsearchProperties
  spring.elasticsearch.uris=127.0.0.1:9200
  ```