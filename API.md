# API

#### 1��AppManager��
|������              |����    |����    |˵��|
|:----               |:---    |:---    |:---|
|getInstance()       |        |AppManager|��һʵ��|
|addActivity()       |Activity|       |��Activity��ӵ���ջ��|
|getCurrentActvity() |        |Activity|��ȡ��ǰActivity|
|finishCurrentActivity()|     |        |�رյ�ǰActivity|
|finishActivity()    |Activity|        |�ر�ָ��Activity|
|finishAllActivity() |        |        |�ر�����Activity|
|AppExit()           |Context |        |�˳�APP���ѹ�ʱ����appExit()���棩|
|appExit()           |Context |        |�˳�APP|

ֵ��˵�����ǣ��ر�APP������Ҫ����Ȩ�ޣ�
```
	<uses-permission android:name="android.permission.KILL_BACKGROUND_PROCESSES" />
```

#### 2��CallBackWenyiFeng�ӿ�
|������              |����    |����    |˵��|
|:----               |:---    |:---    |:---|
|onSuccess()         |T       |        |�ɹ����Զ�����������|
|onFail()            |String  |        |ʧ�ܣ�������Ϣ|

#### 3��FontImgWenyiFeng��
|������              |����    |����    |˵��|
|:----               |:---    |:---    |:---|
|injectFont()        |View    |        |static, ��ʾ����ͼƬ|
|injectFont()  |View, Typeface|        |static, ��ʾ����ͼƬ|

����ʾ����
```
	//����ͼƬ    
	FontHelper.injectFont(findViewById(R.id.fun_top_back));
```
���⣬����Ϊ���ṩ��һ������ͼƬ�����ͻ�[ͼƬ��Ӧ��](http://fontawesome.io/cheatsheet/)

#### 4��ProgressDialogWenyiFeng��
|������              |����    |����    |˵��|
|:----               |:---    |:---    |:---|
|show() |Context, String, int, boolean, boolean||static, ����˵���������ģ���ʾ���֣���ʽ�������߾��Ƿ����ȡ�������Home���Ƿ���Գ�����|
|isShoing()          |        |boolean |static, ״̬��true��ʾ��false����|
|dismiss()           |        |        |static, ȡ����ʾ|

����ʾ����
```
	ProgressDialogWenyiFeng.show(context, context.getResources().getString(R.string.progress_dialog_loading), 
	3, false, true);
```

#### 5��RegularUtilWenyiFeng��
|������       |����    |����    |˵��|
|:----        |:---    |:---    |:---|
|isUsername() |String  |boolean |static, ������֤�û������������û����������أ��Ƿ�Ϸ���|
|isPassword   |String  |boolean |static, ������֤���룬���������룩�����أ��Ƿ�Ϸ���|
|isMobile()   |String  |boolean |static, ������֤�ֻ��ţ��������ֻ��ţ������أ��Ƿ�Ϸ���|
|isEmail()    |String  |boolean |static, ������֤E-mail��������E-mail�������أ��Ƿ�Ϸ���|
|isChinese()  |String  |boolean |static, ������֤�ַ����Ƿ������ģ�������������ַ����������أ��Ƿ������ģ�|
|isIDCard()   |String  |boolean |static, ������֤���֤�ţ����������֤�ţ������أ��Ƿ�Ϸ���|
|isUrl()      |String  |boolean |static, ������֤URL��������url�������أ��Ƿ�Ϸ���|
|isIPAddr()   |String  |boolean |static, ������֤IP��ַ��������ip�������أ��Ƿ�Ϸ���|
|isNumber()   |String  |boolean |static, ������֤�Ƿ������֣������������ַ��������أ��Ƿ����֣�|
|RegularUtilWenyiFeng() |String |   |�Զ����������|
|customVerify() |String |boolean|�Զ�����֤�������������ַ����������أ��Ƿ�����������|

�Զ�����֤ʾ����
```
	String sQQ = "[1-9][0-9]{3,10}";
        RegularUtilWenyiFeng regularUtilWenyiFeng = new RegularUtilWenyiFeng(sQQ);
        String testQQ = "3232445924";
        boolean isCQQ = regularUtilWenyiFeng.customVerify(testQQ);

        System.out.print(isCQQ);
```
#### 6��UtilWebServiceWenyiFeng��
|������       |����    |����    |˵��|
|:----        |:---    |:---    |:---|
|call()       |wsdl��ַ�������ռ䣬�������ƣ��������ϣ����ݻص��ӿ�| |static, ����WebService�ӿ����ݣ��������ͼ�����ʾ������|
|setThreadSize()|int   |        |static, �����̳߳ش�С|
|setIsDotNet()|boolean |        |static, �����Ƿ��� dotNet����|

��������˵����
```
wsdl��ַ��String
�����ռ䣺String
�������ƣ�String
�������ϣ�SimpleArrayMap<String, String> 
�ص��ӿڣ�CallBackWenyiFeng<SoapObject>
```
����ʾ����

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

#### 7��UtilWenyiFeng��
|������       |����    |����    |˵��|
|:----        |:---    |:---    |:---|
|toast()      |Context, String| |static, ������ʾ�����������������ģ���ʾ���֣�, �ѹ�ʱ������ToastWenyiFeng�����ͳһ����|
|isNetworkAvailable()|Context | |static, ��⵱ǰ�����Ƿ���ã������������ģ�|
|intent()     |Context, Class<?>, boolean||static, Activity��ת�������������ģ�Ŀ��Activity���Ƿ���Ҫ�رյ�ǰActivity��|
|randomNum()  |int     |double  |static, ���������Χ[0, range), ��������Χ��|
|randomNum()  |int, int|double  |static, ���������Χ[y, x], ���������ֵ, ��Сֵ��|

ֵ��˵�����ǣ����������Ҫ����Ȩ�ޣ�
```
	<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
```

#### 8��ToastWenyiFeng��(Kotlin)
|������       |����    |����    |˵��|
|:----        |:---    |:---    |:---|
|isShow()     |        |        |��ȡ����isShow��ֵ|
|isShow()     |Boolean |        |�޸�����isShow��ֵ|
|showShort()  |Context, CharSequence||��ʱ����ʾ�ַ����ͣ������������ģ���Ϣ��|
|showShort()  |Context, Int|    |��ʱ����ʾInt�������������ģ���Ϣ��|
|showLong()   |Context, CharSequence||��ʱ����ʾ�ַ����ͣ������������ģ���Ϣ��|
|showLong()   |Context, Int|    |��ʱ����ʾInt�������������ģ���Ϣ��|
|show()       |Context, CharSequence||�Զ���ʱ����ʾ�ַ����ͣ������������ģ���Ϣ��|
|show()       |Context, Int|    |�Զ���ʱ����ʾInt�������������ģ���Ϣ��|

�ر�˵�����ǣ�
```
	����isShow���Ϊtrue��toast������Ч��
	���Ϊfalse����toast������Ч
```

Java ����ʾ����
```
       ToastWenyiFeng.Companion.isShow();
       ToastWenyiFeng.Companion.isShow(false);
```

Kotlin ����ʾ����
```
        ToastWenyiFeng.isShow
        ToastWenyiFeng.isShow(false)
```

#### 9��ColorUtilWenyiFeng��
|������       |����    |����    |˵��|
|:----        |:---    |:---    |:---|
|random()     |        |int     |static, �����ɫ, ���أ���ɫid��, APIΪ26������, ֧��͸����|
|randomRecommend()|    |int     |static, �Ƽ���ɫ��������أ���ɫid��|
|randomCustom()|int[]  |int     |static, �Զ�����ɫ�������������ɫid���飩�����أ���ɫid��|

�Զ�����ɫ����ʾ����
```
	int [] colors = {Color.parseColor("#000000"), Color.parseColor("#7F7F7F"), Color.parseColor("#880015"),
                Color.parseColor("#ED1C24"), Color.parseColor("#FF7F27"), Color.parseColor("#FFF200"),
                Color.parseColor("#22B14C"), Color.parseColor("#00A2E8"), Color.parseColor("#3F48CC"),
                Color.parseColor("#A349A4"), Color.parseColor("#B97A57"), Color.parseColor("#FFAEC9"),
                Color.parseColor("#B5E61D"), Color.parseColor("#99D9EA"), Color.parseColor("#7092BE"),
                Color.parseColor("#C8BFE7")};
        int colorId = ColorUtilWenyiFeng.randomCustom(colors);
```

#### 10��ConstantWenyiFeng��
|����         |ֵ      |˵��|
|:----        |:---    |:---|
|TAG          |FWY_TAG |���|

#### 11��FileUtilWenyiFeng��
|������       |����    |����    |˵��|
|:----        |:---    |:---    |:---|
|write()      |String, String, boolean||static�����ַ���д�뵽�ļ��У��������ļ�·����Ҫд������ַ�����д�뷽ʽ��|
|read()       |String  |String  |static����ȡ�ļ����ݣ��������ļ�·���������أ��ļ����ݣ�|