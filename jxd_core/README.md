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

