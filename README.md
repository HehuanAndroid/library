# library
工具集

## 引入

请参考：
[https://jitpack.io/#fengwenyi/library/v1.0.2](https://jitpack.io/#fengwenyi/library/v1.0.2 "https://jitpack.io/#fengwenyi/library/v1.0.2")


> Step 1. Add the JitPack repository to your build file

>AAdd it in your root build.gradle at the end of repositories:
>
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
>Step 2. Add the dependency
```
>	dependencies {
>	        compile 'com.github.fengwenyi:library:v1.0.2'
>	}
```

## 用法
1. Utils类
- toast方法
```
name: toast
param: Context, String
```
2.AppManager类（管理Activity）
- 实例化
```
 getInstance
 ```

- 添加Activity
```
name: addActivity
param: Activity
```

- 获取当前Activity
```
name: getCurrentActivity
param:
```

- 关闭当前Activity
```
name: finishCurrentActivity
param:
```

- 关闭指定的Activity
```
name: finishActivity
param: Activity
```

- 关闭所有Activity
```
name: finishAllActivity
param:
```

- 退出APP
```
name: AppExit
param: Context
```

## 问题
1. 关于重名问题，会在下次更新的时候做处理