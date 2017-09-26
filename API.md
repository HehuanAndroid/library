# API

#### 1、AppManager类
|方法名              |参数    |返回    |说明|
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
|方法名              |参数    |返回    |说明|
|:----               |:---    |:---    |:---|
|onSuccess()         |T       |        |成功，自定义数据类型|
|onFail()            |String  |        |失败，错误信息|

#### 3、FontImgWenyiFeng类
|方法名              |参数    |返回    |说明|
|:----               |:---    |:---    |:---|
|injectFont()        |View    |        |static, 显示字体图片|
|injectFont()  |View, Typeface|        |static, 显示字体图片|

调用示例：
```
	//字体图片    
	FontHelper.injectFont(findViewById(R.id.fun_top_back));
```
另外，我们为你提供了一套字体图片，请猛击[图片对应码](http://fontawesome.io/cheatsheet/)

#### 4、ProgressDialogWenyiFeng类
|方法名              |参数    |返回    |说明|
|:----               |:---    |:---    |:---|
|show() |Context, String, int, boolean, boolean||static, 参数说明（上下文，提示文字，样式，点击外边距是否可以取消，点击Home键是否可以撤销）|
|isShoing()          |        |boolean |static, 状态，true显示，false隐藏|
|dismiss()           |        |        |static, 取消显示|

调用示例：
```
	ProgressDialogWenyiFeng.show(context, context.getResources().getString(R.string.progress_dialog_loading), 
	3, false, true);
```

#### 5、RegularUtilWenyiFeng类
|方法名       |参数    |返回    |说明|
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
|方法名       |参数    |返回    |说明|
|:----        |:---    |:---    |:---|
|call()       |wsdl地址，命名空间，方法名称，参数集合，数据回调接口| |static, 请求WebService接口数据，参数类型及调用示例见下|
|setThreadSize()|int   |        |static, 设置线程池大小|
|setIsDotNet()|boolean |        |static, 设置是否由 dotNet开发|

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
|方法名       |参数    |返回    |说明|
|:----        |:---    |:---    |:---|
|toast()      |Context, String| |static, 文字提示弹窗，参数（上下文，提示文字）, 已过时，交由ToastWenyiFeng类进行统一管理|
|isNetworkAvailable()|Context | |static, 检测当前网络是否可用，参数（上下文）|
|intent()     |Context, Class<?>, boolean||static, Activity跳转，参数（上下文，目标Activity，是否需要关闭当前Activity）|
|randomNum()  |int     |double  |static, 随机数，范围[0, range), 参数（范围）|
|randomNum()  |int, int|double  |static, 随机数，范围[y, x], 参数（最大值, 最小值）|

值得说明的是：检测网络需要以下权限：
```
	<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
```

#### 8、ToastWenyiFeng类(Kotlin)
|方法名       |参数    |返回    |说明|
|:----        |:---    |:---    |:---|
|isShow()     |        |        |获取属性isShow的值|
|isShow()     |Boolean |        |修改属性isShow的值|
|showShort()  |Context, CharSequence||短时间显示字符类型，参数（上下文，信息）|
|showShort()  |Context, Int|    |短时间显示Int，参数（上下文，信息）|
|showLong()   |Context, CharSequence||长时间显示字符类型，参数（上下文，信息）|
|showLong()   |Context, Int|    |长时间显示Int，参数（上下文，信息）|
|show()       |Context, CharSequence||自定义时间显示字符类型，参数（上下文，信息）|
|show()       |Context, Int|    |自定义时间显示Int，参数（上下文，信息）|

特别说明的是：
```
	属性isShow如果为true，toast方法有效，
	如果为false，则toast方法无效
```

Java 调用示例：
```
       ToastWenyiFeng.Companion.isShow();
       ToastWenyiFeng.Companion.isShow(false);
```

Kotlin 调用示例：
```
        ToastWenyiFeng.isShow
        ToastWenyiFeng.isShow(false)
```

#### 9、ColorUtilWenyiFeng类
|方法名       |参数    |返回    |说明|
|:----        |:---    |:---    |:---|
|random()     |        |int     |static, 随机颜色, 返回（颜色id）, API为26及以上, 支持透明度|
|randomRecommend()|    |int     |static, 推荐颜色随机，返回（颜色id）|
|randomCustom()|int[]  |int     |static, 自定义颜色随机，参数（颜色id数组），返回（颜色id）|

自定义颜色调用示例：
```
	int [] colors = {Color.parseColor("#000000"), Color.parseColor("#7F7F7F"), Color.parseColor("#880015"),
                Color.parseColor("#ED1C24"), Color.parseColor("#FF7F27"), Color.parseColor("#FFF200"),
                Color.parseColor("#22B14C"), Color.parseColor("#00A2E8"), Color.parseColor("#3F48CC"),
                Color.parseColor("#A349A4"), Color.parseColor("#B97A57"), Color.parseColor("#FFAEC9"),
                Color.parseColor("#B5E61D"), Color.parseColor("#99D9EA"), Color.parseColor("#7092BE"),
                Color.parseColor("#C8BFE7")};
        int colorId = ColorUtilWenyiFeng.randomCustom(colors);
```

#### 10、ConstantWenyiFeng类
|名称         |值      |说明|
|:----        |:---    |:---|
|TAG          |FWY_TAG |标记|

#### 11、FileUtilWenyiFeng类
|方法名       |参数    |返回    |说明|
|:----        |:---    |:---    |:---|
|write()      |String, String, boolean||static，将字符串写入到文件中，参数（文件路径，要写入放入字符串，写入方式）|
|read()       |String  |String  |static，读取文件内容，参数（文件路径），返回（文件内容）|