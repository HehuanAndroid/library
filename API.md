# API

### 1、ICallBack

回调接口。

#### 方法：

onSuccess(t : T?)
```
	成功
	参数：T(可以为空)
```

onFail(msg : String?)
```
	失败
	参数：String(可以为空)
```

下面分别给出Java和Kotlin使用示例
Java:
```
	new ICallBack<String>() {
            @Override
            public void onSuccess(@Nullable String s) {

            }

            @Override
            public void onFail(@Nullable String msg) {

            }
        };
```

Kotlin:
```
	object : ICallBack<String> {
            override fun onFail(msg: String?) {

            }

            override fun onSuccess(t: String?) {

            }
        }
```

### 2、AppManager

Activity管理工具类。

#### 静态实例化

instance
```
	通过静态实例化来实现单例模式
```

#### 方法：

addActivity(activity: Activity)
```
	将Activty添加到堆栈中
	参数：Activity
```

finishActivity(activity: Activity)
```
	关闭指定的Activity
	参数：Activity
```

finishAllActivity()
```
	关闭所有 Activity
```

appExit(context : Context)
```
	退出APP
	参数：context 上下文
```

下面为addActivity(activity: Activity)方法分别给出Java和Kotlin使用示例
Java:
```
	AppManager appManager = AppManager.Companion.getInstance();
        appManager.addActivity(this);
```

Kolin:
```
	val appManager = AppManager.instance
        appManager.addActivity(this)
```

### 3、ColorUtil

颜色工具类。

#### 方法
random() : Int
```
	随机颜色
	返回：Int
```

randomRecommend() : Int
```
	推荐颜色随机
	返回：Int
```

randomCustom(colors : IntArray) : Int
```
	自定义颜色随机
	参数：IntArray
	返回：Int
```

下面为randomCustom(colors : IntArray) : Int方法分别给出Java和Kotlin使用示例
Java:
```
	int [] colors = {Color.parseColor("#000000")};
        int randColor = ColorUtil.INSTANCE.randomCustom(colors);
```

Kotlin:
```
	val colors : IntArray = intArrayOf(Color.parseColor("#000000"))
        val randColor : Int = ColorUtil.randomCustom(colors)
```

### 4、Constant

常量。

#### 说明
TAG
```
	标记
	值：FWY_TAG
```

REGEX_USERNAME
```
	正则：用户名
	值：^[a-zA-Z]\w{5,20}$
```

REGEX_PASSWORD
```
	正则：密码
	值：^[a-zA-Z0-9]{6,20}$
```

REGEX_PHONE
```
	正则：手机号
	值：^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\D])|(18[0,5-9]))\d{8}$
```

REGEX_EMAIL
```
	正则：E-MAIL
	值：^([a-z0-9A-Z]+[-|\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\.)+[a-zA-Z]{2,}$
```

REGEX_CHINESE
```
	正则：中文
	值：^[\u4e00-\u9fa5],{0,}$
```

REGEX_ID_CARD
```
	正则：身份证号码
	值：(^\d{18}$)|(^\d{15}$)
```

REGEX_URI
```
	正则：URI
	值：http(s)?://([\w-]+\.)+[\w-]+(/[\w- ./?%&=]*)?
```

REGEX_IP
```
	正则：正则：IP
	值：(25[0-5]|2[0-4]\d|[0-1]\d{2}|[1-9]?\d)
```

REGEX_NUMBER
```
	正则：数字
	值：^[0-9]$
```

REGEX_URI
```
	正则：URI
	值：http(s)?://([\w-]+\.)+[\w-]+(/[\w- ./?%&=]*)?
```

使用示例参见正则工具类示例

### 5、FileUtil

文件工具类。

#### 方法
write(path : String, str : String, isNewMode : Boolean)
```
	将字符串写入到文件中
	参数：  path      文件位置
		str       字符串
		isNewMode 写入方式（true追加; false覆盖）
```

下面为write(path : String, str : String, isNewMode : Boolean)方法分别给出Java和Kotlin使用示例
Java:
```
	String path = "";
        String str = "";
        boolean isNewMode = true;
        FileUtil.INSTANCE.write(path, str, isNewMode);
```

Kotlin:
```
	val path : String = ""
        val str : String = ""
        val isNewMode : Boolean = true
        FileUtil.write(path, str, isNewMode)
```

### 6、FontImgUtil

字体图片工具类，简单来说，就是Android上的图片，可以用我们为你提供的字体来代替，这样，你就可以很方便的为“图片”设置样式来适配机型。

#### 方法
injectFont(rootView : View)
```
	将字体装换成对应图片
	参数：View
```

injectFont(rootView: View, tf : Typeface)
```
	将字体装换成对应图片
	参数：  View
		Typeface  字体图片
```

下面为injectFont(rootView : View)方法分别给出Java和Kotlin使用示例
Java:
```
	FontImgUtil.INSTANCE.injectFont(findViewById(R.id.tvTestFontImg));
```

Kotlin:
```
	FontImgUtil.injectFont(findViewById(R.id.tvTestFontImg))
```

### 7、MathUtil

数学工具类，在这里我们为你提供了一些常用的业务逻辑。

#### 方法
randomNum(range : Int) : Double
```
	随机数
	参数：Int
	返回：Int∈[0, range)
```

randomNum(x : Int, y : Int) : Int
```
	随机数
	参数：  x 最大值
		y 最小值
	返回：Int∈[y, x]
```

下面为randomNum(range : Int) : Double方法分别给出Java和Kotlin使用示例
Java:
```
	double randomNum = MathUtil.INSTANCE.randomNum(10);
```

Kotlin:
```
	val randomNum : Double = MathUtil.randomNum(10)
```

### 8、NetworkUtil

网络工具类，在这里我们为你提供了一些常用的网络工具类。

#### 方法
isAvailable(context: Context): Boolean
```
	检查当前网络是否可用
	参数：context 上下文
	返回：Boolean true(可用); false(不可用)
```

下面为isAvailable(context: Context): Boolean方法分别给出Java和Kotlin使用示例
Java:
```
	boolean isNetIsAvailable = NetworkUtil.INSTANCE.isAvailable(this);
```

Kotlin:
```
	val isNetIsAvailable : Boolean = NetworkUtil.isAvailable(this)
```

### 9、ProgressDialogUtil

进度对话框工具类

#### 属性
THEME_ULTIMATE
```
	太极
	值：0
```

THEME_DOT
```
	点（大）
	值：1
```

THEME_LINE
```
	圆
	值：2
```

THEME_ARC
```
	点（细）
	值：3
```

#### 方法
show(context : Context)
```
	模糊进度对话框
	参数：context 上下文
```

show(context : Context,
             msg : String,
             theme : Int,
             isCanceledOnTouchOutside : Boolean,
             isCancelable : Boolean)
```
	模糊进度对话框
	参数：  context                  上下文
		msg                      提示信息
		theme                    样式
		isCanceledOnTouchOutside 点击外边距是否可取消
		isCancelable             点击back键是否可取消
```

showIos(context: Context,
                message: CharSequence,
                isCanceledOnTouchOutside: Boolean,
                isCancelable : Boolean)
		             isCancelable : Boolean)
```
	仿IOS样式模糊进度对话框
	作者：  meihuali
	参数：  context                  上下文
		msg                      提示信息
		theme                    样式
		isCanceledOnTouchOutside 点击外边距是否可取消
		isCancelable             点击back键是否可取消
```

isShowing() : Boolean
```
	对话框的当前状态
	返回：Boolean true(显示); false(隐藏)
```

dismiss()
```
	取消对话框
```

下面为show(context : Context,
             msg : String,
             theme : Int,
             isCanceledOnTouchOutside : Boolean,
             isCancelable : Boolean)方法分别给出Java和Kotlin使用示例
Java:
```
	ProgressDialogUtil.INSTANCE.show(this, 
                "玩命加载中...", 
                ProgressDialogUtil.INSTANCE.getTHEME_ARC(), 
                false, 
                true);
```

Kotlin:
```
	ProgressDialogUtil.show(this,
                "玩命加载中...",
                ProgressDialogUtil.THEME_ARC,
                false,
                true)
```

### 10、RegularUtil

正则验证工具类

#### 方法
verify(REGEX : String, str : String) : Boolean
```
	正则验证
	参数：  REGEX 正则表达式
		str   待验证的字符串
	返回：Boolean true(待测字符串满足正则表达式); false(待测字符串不满足正则表达式)
```

###### 值得一提的是，我们在常量类中给出了一些常用的正则表达式，你可以直接拿来用。

下面通过验证密码分别给出Java和Kotlin使用示例
Java:
```
	RegularUtil.INSTANCE.verify(Constant.INSTANCE.getREGEX_PASSWORD(), "xfsy2017");
```

Kotlin:
```
	RegularUtil.verify(Constant.REGEX_PASSWORD, "xfsy2017")
```

### 11、ToastUtil

Toast工具类

#### 方法
show(context: Context, msg : CharSequence)
```
	Toast
	参数：  Context
		CharSequence 
```

show(context: Context, msg : Int)
```
	Toast
	参数：  Context
		Int
```

###### 值得一提的是，我们将Toast显示的时间长度默认为：Toast.LENGTH_SHORT。

下面为show(context: Context, msg : CharSequence)方法分别给出Java和Kotlin使用示例
Java:
```
	ToastUtil.INSTANCE.show(this, "Hello");
```

Kotlin:
```
	ToastUtil.show(this, "Hello")
```

### 12、Utils

常用工具类

#### 方法
intent(context: Context, cls: Class<*>)
```
	Activity相互跳转
	参数：  Context
		Class<*>
```

下面为intent(context: Context, cls: Class<*>)方法分别给出Java和Kotlin使用示例
Java:
```
	Utils.INSTANCE.intent(this, SecondActivity.class);
```

Koltin:
```
	Utils.intent(this, SecondActivity::class.java!!)
```


### 13、WebServiceUtil

Android请求WebService接口工具类

#### 方法
call(endPoint : String,
             namespace : String,
             method : String,
             params : SimpleArrayMap<String, String>,
             callback : ICallBack<SoapObject>)
```
	请求WebService接口
	参数：  endPoint    接口地址
		namespace   命名空间
		method      方法
		params      参数
		callback    数据回调接口
```

setThreadSize(threadSize : Int)
```
	设置线程池的大小
	参数：threadSize 新的线程池大小
```

setIsDotNet(isDotNet : Boolean)
```
	设置是否由doNet开发
	参数：isDotNet true(是); false(否) [我们默认为false]
```

下面分别给出Java和Kotlin使用示例
Java:
```
	// 创建一个对象
	WebServiceUtil webServiceUtil = new WebServiceUtil();
	// 设置是否由doNet开发
        webServiceUtil.setIsDotNet(false);
	// 设置线程池的大小
        webServiceUtil.setThreadSize(5);
        webServiceUtil.call(endPoint, namespace, method, params, new ICallBack<SoapObject>() {
            @Override
            public void onSuccess(@Nullable SoapObject soapObject) {
                
            }

            @Override
            public void onFail(@Nullable String msg) {

            }
        });
```

Kotlin:
```
	// 创建一个对象
	val webServiceUtil = WebServiceUtil()
	// 设置是否由doNet开发
        webServiceUtil.setIsDotNet(false)
	// 设置线程池的大小
        webServiceUtil.setThreadSize(5)
        webServiceUtil.call(endPoint, namespace, method, params, object : ICallBack<SoapObject> {
            override fun onSuccess(soapObject: SoapObject?) {

            }

            override fun onFail(msg: String?) {

            }
        })
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