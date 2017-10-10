# library

声明：这里可能会有你分享的方法，在此表示感谢。如果可能，请联系我，加上原作者信息。

每当我们开始写Android项目的时候，就会很头痛的构建各种繁琐工具类，因此在这样的背景下，Android工具类库诞生了，我们致力于构建一款强大的Android工具类库，目的是让你在写项目的时候，可以参考或者直接引入。

然后，由于作者是一个Android新手，难免会有各种BUG，但是作者会持续更新，还请多多关注。

## 接口列表
| 名称                     | 说明|
|:--------                 |:-----|
|ICallBack                 |回调接口|


## 工具类列表
| 名称                     | 说明|
|:--------                 |:-----|
|AppManager                |Activity管理工具类|
|ColorUtil                 |Android颜色工具类|
|Constant                  |常量类|
|FileUtil                  |文件工具类|
|FontImgUtil               |字体图片工具类|
|MathUtil                  |数学工具类|
|NetworkUtil               |网络工具类|
|ProgressDialogUtil        |进度对话框工具类|
|RegularUtil               |正则验证工具类|
|ToastUtil                 |Toast工具类|
|Utils                     |常用工具类|
|WebServiceUtil            |Android请求WebService接口|



## 引入

Step 1. Add the JitPack repository to your build file 
```
Add it in your root build.gradle at the end of repositories:
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

Step 2. Add the dependency
```
	dependencies {
	        compile 'com.github.fengwenyi:library:171010.17'
	}
```

## 测试截图（部分）


## 版本更新说明

#### 171009.17
```
	1、重新编写新的Module
	2、重新命名
	3、将之前的JAVA全部替换成Kotlin
	4、开始加入其他人的工具类
	详情请查看API文件（API.md）
```

#### 170926.15
```
	1、新增FileUtilWenyiFeng文件工具类
	2、将API模块移到API文件
	3、删除版本引入说明信息
	4、作者信息由WenyiFeng更改为Wenyi Feng
	详情请查看API文件（API.md）
```

#### 170926.14
```
	1、在ColorUtilWenyiFeng中增加randomRecommend()方法：推荐颜色随机
	2、在ColorUtilWenyiFeng中增加randomCustom()方法：自定义颜色随机
	详情请查看API模块
```

#### 170920.13
```
	1、在UtilWenyiFeng中增加randomNum()方法
	2、增加ColorUtilWenyiFeng类
	3、增加ConstantWenyiFeng类
	详情请查看API模块
```

#### 170908.12
```
	1、在UtilWenyiFeng中增加intent()方法
	2、增加ToastWenyiFeng类
	3、将UtilWenyiFeng中toast标记已过时，但不影响使用
	详细请查看API部分
```

##### 依赖说明
|                      依赖                             |
|                     :----                             |
|com.android.support:appcompat-v7:26.1.0                |
|junit:junit:4.12                                       |
|org.jetbrains.kotlin:kotlin-stdlib-jre7:$kotlin_version|
|com.android.support:recyclerview-v7:26.1.0             |


##### jar
|                     jar                             |
|                   :----                             |
|ksoap2-android-assembly-2.4-jar-with-dependencies.jar|

------------

###### About me
```
Wenyi Feng(xfsy2014@gmail.com)

Copyright © 2017 Wenyi Feng. All Rights Reserved.
```