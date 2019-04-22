### Activity跳转

1、基本跳转

```kotlin
openActivity<CoreActivity>() 
```

2、跳转后关闭当前Activity

```kotlin
openActivityFinish<CoreActivity>() 
```

3、传递参数

传递的参数可为多个，均为键值对的方式传递，

参数类型目前为基础类型和基础类型的数组，实现了Serializable或Parcelable的对象等

```kotlin
openActivity<CoreActivity>("p" to "data", "p2" to 30, "p3" to true)
```

4、使用新的任务栈开启Activity

在新的任务栈中打开Activity，启用新的任务栈或后台打开Activity时可以使用

```kotlin
newActivity<CoreActivity>() 
```



### sharedPreferences

默认情况下启用默认的sharedPreferences，默认文件名 "App_Config"，默认类型Context.MODE_PRIVATE

#### 1、保存值

键为String，值可为Int、Long、String、Float、Boolean

```kotlin
saveValue("jxd_test","APP_NAME")
```

#### 2、获取值

泛型为所需要获取的类型，参数key为String

```kotlin
getValue<String>("jxd_test")
```

#### 3、清理所有sharedPreferences数据

```kotlin
clear()
```

#### 4、移除某个key的值

```kotlin
remove("jxd_test")
```



#### 注意 

以上均为Context的扩展方法，可以在Context的子类中直接调用，若需要调用的类不是Context的子类，需要首先获取到Context对象才能使用，例如:

```kotlin
fun test(context:Context){
    context.saveValue("key","value")
}
```



#### 5、自定义初始化

想要自定义初始化sharedPreferences文件，可以调用init()方法，并设置sharedPreferences文件名和PreferencesMode类型，这个方法应尽早调用，所以最好在应用启动时调用，即在Application的onCreate()时调用最佳。当然能够保证在使用默认的文件之前调用初始化也是可以的。

```kotlin
SpUtil.init(context,configName,mode)
```

#### 6、获取SharedPreferences

如果以上自定义初始化不能满足要求，可以自己获取SharedPreferences对象做处理

```kotlin
SpUtil.getSharedPreferences(context)//返回SharedPreferences对象
```

