# [MobPush API for Java](http://wiki.mob.com/mobpush-rest-api-接口文档/)

![image](https://github.com/MOBX/MOB-SMS-WEBAPI/blob/master/doc/images/logo.png)

**[MobPush API for Java](http://wiki.mob.com/mobpush-rest-api-接口文档/)** 
为了帮助开发者更方便接入MobPush免费推送SDK，提供完整的API接口的java实现，包含设备操作相关接口、推送操作相关接口以及公共接口。

了解更多 [MobPush 免费推送SDK.](http://mobpush.mob.com)


## 优势

**免费使用**、**自定义UI**、**稳定服务**、**流程体验**、**数据同步**、**专业技术团队服务**

## 接口
* 推送接口
	* 发送推送
	* 查询推送（根据batchId）
	* 查询推送（根据workno）
* 推送统计接口
	* 查询推送统计（根据batchId）
	* 查询推送统计（根据workno）
* 别名操作接口
	* 查询别名
	* 设置别名
* 标签操作接口
	* 查询标签
	* 设置标签
* 公共接口
	* 地理位置信息接口	

## jar包依赖说明

主要需要依赖httpclient.jar 、fastjson.jar

* 如果使用 Maven 构建项目，则需要在你的项目 pom.xml 里增加：

```xml
		<dependency>
			<groupId>org.apache.httpcomponents</groupId>
			<artifactId>httpclient</artifactId>
			<version>4.5.3</version>
			<scope>compile</scope>
		</dependency>

		<dependency>
			<groupId>org.slf4j</groupId>
			<artifactId>slf4j-api</artifactId>
			<version>1.7.7</version>
		</dependency> 
		<dependency>
			<groupId>org.slf4j</groupId>
			<artifactId>slf4j-log4j12</artifactId>
			<version>1.7.7</version>
		</dependency>
		<dependency>
			<groupId>log4j</groupId>
			<artifactId>log4j</artifactId>
			<version>1.2.17</version>
		</dependency>
 
		<dependency>
			<groupId>com.alibaba</groupId>
			<artifactId>fastjson</artifactId>
			<version>1.2.31</version>
		</dependency>
```

* 如果不使用 Maven 构建项目，则项目 libs/ 目录下有依赖的 jar 可复制到你的项目里去。
 
## 使用注意事项
* 初始化appkey、appSecret
```Java
   MobPushConfig.appkey = "moba6b6c6d6";
   MobPushConfig.appSecret = "";
```
以上是使用时设置的方式，还可以直接引用源码在mob.push.api.MobPushConfig设置

## 使用DEMO 

发送推送示例片段代码

```Java
 PushWork push = new PushWork(PlatEnum.all.getCode(),"test content" , PushTypeEnum.notify.getCode()) //初始化基础信息
				.buildTarget(TargetEnum._1.getCode(), null, null, null, null, null)  // 设置推送范围
				.buildAndroid("Android Title", AndroidNotifyStyleEnum.normal.getCode(), null, true, true, true) //定制android样式
				.bulidIos("ios Title", "ios Subtitle", null, 1, null, null, null, null) //定制ios设置
				.buildExtra(1, "{\"key1\":\"value\"}", 1) // 设置扩展信息
				;
		
		PushClient client = new PushClient();
		try {
			client.sendPush(push);
		} catch (ApiException e) {
			e.getStatus();	   	   //错误请求状态码
			e.getErrorCode();	       //错误状态码
			e.getErrorMessage();        //错误信息 
		}

```
