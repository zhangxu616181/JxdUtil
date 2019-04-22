## Jxd -> ViewModel使用



### 绑定ViewModel

```kotlin
bindViewModel()
```

### Data

为方便处理返回数据，自定义统一Data返回

1.自己所需要的数据

```kotlin
data class VmBean (
    var name:String,
    var uid:Int
)
```



2.ViewModel中监听的数据

```kotlin
class MyViewModel : ViewModel() {
    val mData = MutableLiveData<Data<VmBean>>()
    fun refresh(tmp: Int) {
        if (tmp % 2 == 0) {
            mData.value = Data(VmBean("Name$tmp", tmp))
        } else {
            mData.value = Data(msg = "数据错误")
        }
    }
}
```



3.使用

```kotlin
        private lateinit var mViewModel: MyViewModel
...
		mViewModel = bindViewModel()
        mViewModel.mData.observe(this, Observer<Data<VmBean>> {
            it?.data?.let { bean -> toast(bean.toString()) }
            it?.msg?.let { m -> toast(m) }
        })
...

```

