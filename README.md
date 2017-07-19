# library
工具集

## 引入

请参考：
[https://jitpack.io/#fengwenyi/library/v1.0.4](https://jitpack.io/#fengwenyi/library/v1.0.4 "https://jitpack.io/#fengwenyi/library/v1.0.4")


Step 1. Add the JitPack repository to your build file

AAdd it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
Step 2. Add the dependency

	dependencies {
	        compile 'com.github.fengwenyi:library:v1.0.3'
	}


## 用法
1. UtilWenyiFeng类
- toast方法
```
name: toast
param: Context, String
```

- 检查当前网络是否可用
```
name: isNetworkAvailable
param: Context
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


3. FontImgWenyiFeng类
使用示例：
```
<TextView
	android:id="@+id/login_tip_user"
	android:layout_width="wrap_content"
	android:layout_height="match_parent"
	android:gravity="center_vertical"
	android:text="&#xf2c0;"
	android:textColor="#aaa"
	android:textSize="20sp"/>
```

```
FontImgWenyiFeng.injectFont(findViewById(R.id.login_tip_user));

```