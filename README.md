# library

> 声明：这里可能会有你分享的方法，在此表示感谢。如果可能，请联系我，加上原作者信息。

每当我们开始写Android项目的时候，就会很头痛的构建各种繁琐工具类，因此在这样的背景下，Android工具类库诞生了，我们致力于构建一款强大的Android工具类库，目的是让你在写项目的时候，可以参考或者直接引入。

然后，由于作者是一个Android新手，难免会有各种BUG，但是作者会持续更新，还请多多关注。

## 工具类列表
| 类名                      | 说明|
| :--------                |      :-----|
|AppManager                |Activity管理工具类|
|CallBackWenyiFeng         |回调接口|
|FontImgWenyiFeng          |字体图片工具类|
|ProgressDialogWenyiFeng   |进度对话框工具类|
|RegularUtilWenyiFeng      |正则表达式工具类|
|UtilWebServiceWenyiFeng   |请求WebService接口工具类|
|UtilWenyiFeng             |常用工具类|



## 引入
Step 1. Add the JitPack repository to your build file

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

Step 2. Add the dependency(由于更新非常快，请特别注意版本号)

	dependencies {
	        compile 'com.github.fengwenyi:library:v1.0.9'
	}


## API

#### 1、AppManager类
|方法名               |参数     |返回    |说明|
|:----               |:---    |:---    |:---|
|getInstance()       |        |AppManager|单一实例|
|addActivity()       |Activity|       |将Activity添加到堆栈中|
|getCurrentActvity() |        |Activity|获取当前Activity|
|finishCurrentActivity()|     |        |关闭当前Activity|
|finishActivity()    |Activity|        |关闭指定Activity|
|finishAllActivity() |        |        |关闭所有Activity|
|AppExit()           |Context |        |退出APP（已过时，由appExit()代替）|
|appExit()           |Context |        |退出APP|

值得说明的是：关闭APP方法需要以下权限：
```
	<uses-permission android:name="android.permission.KILL_BACKGROUND_PROCESSES" />
```

#### 2、CallBackWenyiFeng接口
|方法名               |参数     |返回    |说明|
|:----               |:---    |:---    |:---|
|onSuccess()         |T       |        |成功，自定义数据类型|
|onFail()            |String  |        |失败，错误信息|

#### 3、FontImgWenyiFeng类
|方法名               |参数     |返回    |说明|
|:----               |:---    |:---    |:---|
|injectFont()        |View    |        |显示字体图片，static|
|injectFont()        |View, Typeface|  |显示字体图片，static|
调用示例：

```
//字体图片    FontHelper.injectFont(findViewById(R.id.fun_top_back));
```
另外，我们为你提供了一套字体图片，图片与对应码，请猛击[传送门](http://fontawesome.io/cheatsheet/)

#### 4、ProgressDialogWenyiFeng接口
|方法名               |参数     |返回    |说明|
|:----               |:---    |:---    |:---|
|show() |Context, String, int, boolean, boolean||static, 参数说明（上下文，提示文字，样式，点击外边距是否可以取消，点击Home键是否可以撤销）|
|isShoing()          |  |boolean  |static, 状态，true显示，false隐藏|
|dismiss()           |         |       |static, 取消显示|
调用示例：

```
ProgressDialogWenyiFeng.show(context, context.getResources().getString(R.string.progress_dialog_loading), 3, false, true);
```

#### 5、RegularUtilWenyiFeng类
|方法名        |参数     |返回    |说明|
|:----        |:---    |:---    |:---|
|isUsername() |String  |boolean |static, 正则验证用户名，参数（用户名），返回（是否合法）|
|isPassword   |String  |boolean |static, 正则验证密码，参数（密码），返回（是否合法）|
|isMobile()   |String  |boolean |static, 正则验证手机号，参数（手机号），返回（是否合法）|
|isEmail()    |String  |boolean |static, 正则验证E-mail，参数（E-mail），返回（是否合法）|
|isChinese()  |String  |boolean |static, 正则验证字符串是否还有中文，参数（待检测字符串），返回（是否含有中文）|
|isIDCard()   |String  |boolean |static, 正则验证身份证号，参数（身份证号），返回（是否合法）|
|isUrl()      |String  |boolean |static, 正则验证URL，参数（url），返回（是否合法）|
|isIPAddr()   |String  |boolean |static, 正则验证IP地址，参数（ip），返回（是否合法）|
|isNumber()   |String  |boolean |static, 正则验证是否是数字，参数（待测字符），返回（是否数字）|
|RegularUtilWenyiFeng() |String |   |自定义正则规则|
|customVerify() |String |boolean|自定义验证，参数（待测字符串），返回（是否满足条件）|
自定义验证示例：

```
		String sQQ = "[1-9][0-9]{3,10}";
        RegularUtilWenyiFeng regularUtilWenyiFeng = new RegularUtilWenyiFeng(sQQ);
        String testQQ = "3232445924";
        boolean isCQQ = regularUtilWenyiFeng.customVerify(testQQ);

        System.out.print(isCQQ);
```
#### 6、UtilWebServiceWenyiFeng类
|方法名        |参数     |返回    |说明|
|:----        |:---    |:---    |:---|
|call()       |wsdl地址，命名空间，方法名称，参数集合，数据回调接口| |static, 请求WebService接口数据，参数类型及调用示例见下|
|setThreadSize()|int| |static, 设置线程池大小|
|setIsDotNet()|boolean| |static, 设置是否由 dotNet开发|
参数类型说明：
```
wsdl地址：String
命名空间：String
方法名称：String
参数集合：SimpleArrayMap<String, String> 
回调接口：CallBackWenyiFeng<SoapObject>
```
调用示例：

```
	public void testWebService(String url, String namespace, String method, SimpleArrayMap<String, String> params) {
        UtilWebServiceWenyiFeng.call(url, namespace, method, params, new CallBackWenyiFeng<SoapObject>() {
            @Override
            public void onSuccess(SoapObject soapObject) {

            }

            @Override
            public void onFail(String msg) {

            }
        });
    }
```

#### 7、UtilWenyiFeng类
|方法名        |参数     |返回    |说明|
|:----        |:---    |:---    |:---|
|toast()      |Context, String| |static, 文字提示弹窗，参数（上下文，提示文字）|
|isNetworkAvailable()|Context | |static, 检测当前网络是否可用，参数（上下文）|
值得说明的是：关闭APP方法需要以下权限：
```
	<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
```

###### About me
```
WenyiFeng(xfsy2014@gmail.com)

Copyright © 2017 fengwenyi.com. All Rights Reserved.
```