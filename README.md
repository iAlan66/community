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
## 项目部署 Centos7.6
### 下载上传文件
- 远程下载
  - `wget -i -c <url>`
- 本地上传远程服务器
  - 本地终端 `pscp <文件名> <远程服务器用户名(root)>@<ip地址(120.55.217)>:<目标文件夹路径(/root/test)>`

### 安装

- 安装zip解压缩工具
  - yum仓库查询文件名`yum list unzip*`
  - 用yum安装yum文件` yum -y install unzip.x86_64`

- 安装jre
  - `yum install -y java-1.8.0-openjdk.x86_64`

- 安装maven
  - 解压缩apache-maven-3.6.1-bin.tar.gz到指定文件夹`tar -xzvf apache-maven-3.6.1-bin.tar.gz -C /opt`
  - 配置环境变量
    - `vim /etc/profile`
    - 插入 `export PATH:$PATH:/opt/apache-maven-3.6.1 /bin`
    - 配置文件生效 `source /etc/profile`
    - 如果有需要配置maven仓库镜像 ，在/maven/conf/settings.xml文件中添加下列配置，`vim settings.xml`					

        ```xml
        <mirror>
            <id>nexus-aliyun</id>
            <mirrorOf>central</mirrorOf>
            <name>Nexus aliyun</name>
            <url>http://maven.aliyun.com/nexus/content/groups/public</url>
        </mirror>
        ```

- 安装mysql [参考](https://www.cnblogs.com/smallmin/p/15533895.html)
  - 下载mysql 的yum仓库，`wget -i -c https://dev.mysql.com/get/mysql80-community-release-el7-7.noarch.rpm`
  - 安装mysql的yum仓库，`yum install -y mysql80-community-release-el7-7.noarch.rpm`
  - 默认yum开启mysql8.0禁用mysql5.7
  - 启用 MySQL 5.7

    ```shell
    # 禁用 8.0 版本
    yum-config-manager --disable mysql80-community
    # 启用 5.7 版本
    yum-config-manager --enable mysql57-community
    ```

  - 安装MySQL5.7 `yum -y install mysql-community-server.x86_64`

  - 启动mysql

    ```shell
    # 启动 mysql 服务
    systemctl start mysqld
    # 配置 mysql 开机启动
    systemctl enable mysqld
    # 查看 mysql 状态
    systemctl status mysqld
    # 查看临时密码
    grep 'temporary password' /var/log/mysqld.log
    # 用临时密码登录mysql
    mysql -uroot -p
    # 更改密码
    alter user root@localhost identified by '<自定义密码>'
    # 解压数据库文件
    unzip -d /root community-init-sql-1.5.zip
    # 进入mysql新建数据库
    create database community;
    # 一次执行三个sql命令
    source /root/community-init-sql-1.5/init_schema.sql
    source /root/community-init-sql-1.5/init_data.sql
    source /root/community-init-sql-1.5/tables_mysql_innodb.sql
    ```

- 安装redis

  - yum仓库没有redis，首先安装拓展包`yum install -y epel-release`

  - 安装老版本redis `yum install -y redis.x86_64`

  - 启动redis

    ```shell
    # 启动 redis
    systemctl start redis
    # 配置 redis 开机启动
    systemctl enable redis
    # 测试redis
    redis-cli
    ```

- 安装kafka

  - 下载文件 `wget -c -i https://downloads.apache.org/kafka/3.3.1/kafka_2.13-3.3.1.tgz`
  - 解压文件到opt `tar -xzvf kafka_2.13-3.3.1.tgz -C /opt`
  - 如果有需要修改配置文件 `zookeeper.properties` `server.properties`
  - 启动
    - 在kafka的bin目录下启动zookeeper `bin/zookeeper-server-start.sh -daemon config/zookeeper.properties`
    - 在kafka的bin目录下启动kafka `nohup bin/kafka-server-start.sh config/server.properties 1>/dev/null 2>&1 &`
    - 测试kafka，未报错即可 `bin/kafka-topics.sh --list --bootstrap-server localhost:9092`

- 安装elasticsearch

  - 下载elasticsearch和ik分词插件，并解压缩
  - 配置elasticsearch.yml
    - 集群名字：cluster.name:nowcoder
    - data存放目录：path.data:/tmp/elastic/data
    - log存放目录：path.log:/tmp/elastic/logs
  - 更改内存占用
    - `vim jvm.options`
    - `-Xms1g`改为`-Xms256m`
    - `-Xmx1g`改为`-Xmx512m`
  - 切换普通用户启动elasticsearch
    - 切换到elasticsearch目录，后台启动 `bin/elasticsearch -d`

- 安装wkhtmltopdf

  - `yum install -y wkhtmltopdf.x86_64`

- 安装xorg-x11-server-Xvfb.x86_64

  - `yum isntall -y xorg-x11-server-Xvfb.x86_64`

  - 测试生成图片`xvfb-run --server-args="-screen 0, 1024x768x24" wkhtmltoimage https://www.baidu.com 1.png`

  - 编写.sh脚本

    ```shell
    xvfb-run --server-args="-screen 0, 1024x768x24" wkhtmltoimage "$@"
    ```

- 安装tomcat

  - 下载tar文件
  - 解压到指定文件夹
  - 配置环境变量
  - 启动tomcat
    - startup.sh
    - 访问http://192.168.142.128:8080
    - 遇到问题，防火墙8080端口未开放
      - 开启8080端口`firewall-cmd --zone=public --add-port=8080/tcp --permanent`
      - 重启防火墙`firewall-cmd --reload`
      - 查看开启端口`firewall-cmd --list-ports`

- 安装nginx

  - 安装`yum install -y nginx.x86_64`

  - 配置ngnix

    - `vim /etc/nginx/nginx.conf`

    - 添加如下配置

      ```
      upstream myserver {
              server 127.0.0.1:8080 max_fails=3 fail_timeout=30s;
      }
      
      server {
              listen 80;
              server_name 192.168.142.128;
              location/ {
                      proxy_pass http://myserver;
              } 
      }
      ```

    - 启动ngnix `systemctl start ngnix`

    - 问题80端口未开放

      - 开启80端口`firewall-cmd --zone=public --add-port=80/tcp --permanent`
      - 重启防火墙`firewall-cmd --reload`
      - 查看开启端口`firewall-cmd --list-ports`

    - 502 bad gateway

      - 在/var/log/nginx/error.log 中查找错误信息 `failed (13: Permission denied) while connecting to upstream`
      - [参考](https://www.cnblogs.com/songxingzhu/p/10063043.html) `setsebool -P httpd_can_network_connect 1`

### 部署

- 关闭tomcat`shutdown.sh`

- 删除tomcat起始页

  - 在webapps文件夹下执行 `rm -rf *` 删除webapps下所有文件

- 配置文件改为produce和devlop

- pom.xml中打包方式改为war，build中的finalName改为ROOT

- 将项目压缩打包上传到服务器

- 服务器解压缩并用maven编译

  - 解压缩：`unzip -d /root nowcoderCommunity.zip`
  - 编译：`mvn clean package -Dmaven.test.skip=true`

  - 编译中出现错误，`No compiler is provided in this environment. Perhaps you are running on a JRE rather than a JDK?`
  - 解决：执行 `yum install -y java-devel` [参考](https://blog.csdn.net/qq_41767116/article/details/113734315) jre没有安装完整
  - 将编译完成的ROOT.war移动到tomcat的webapps文件夹下，`mv ROOT.war /opt/apache-tomcat-9.0.68/webapps/`
  - 启动tomcat `startup.sh`