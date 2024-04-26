# ThreadLocal

## 什么是ThreadLocal

ThreadLocal是一种隔离机制，保障多线程情况下对**共享变量**访问的安全性。

隔离机制是怎么进行的：**当前线程**访问共享变量时，ThreadLocal都会拷贝共享变量副本（ThreadLocalMap）放到当前线程中（查看set方法源码），当前线程就对共享变量副本做操作，这就避免了多线程对共享变量的竞争。

## 与Synchronized的关系与区别

关系：共享变量进行安全性访问机制

区别：

Synchronized是对共享变量加一个独占锁，同一时刻只有一个线程可以访问共享变量。

ThreadLocal是把共享变量在每个线程中都存放一个副本，每个线程只访问自己内部共享变量副本。

## ThreadLocal的使用

```java
 * @author 公众号：程序员老猫
 * @date 2024/2/1 22:58
 */
public class DateFormatTest {

    private static final ThreadLocal<SimpleDateFormat> dateFormatThreadLocal =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    public static Date parse(String dateString) {
        Date date = null;
        try {
            date = dateFormatThreadLocal.get().parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 20; i++) {
            executorService.execute(()->{
                System.out.println(parse("2024-02-01 23:34:30"));
            });
        }
        executorService.shutdown();
    }
}
```

## ThreadLocal使用场景

### 1、保存线程上下文信息，在任意需要的地方可以获取

因为ThreadLocal是把变量副本放到当前线程中，所以在当前线程流转的代码中任意地方获取。

![image-20240417225240346](/Users/wendongchao/Desktop/ThreadLocal.assets/image-20240417225240346.png)

### 2、数据库连接池使用

* 为了把同一个数据库连接分享给同一线程中多个Dao操作，保证事务的控制。
* 线程隔离，不同线程拿到不同的数据库连接信息，保证事务的安全。

![image-20240417225739873](/Users/wendongchao/Desktop/ThreadLocal.assets/image-20240417225739873.png)

![img](/Users/wendongchao/Desktop/ThreadLocal.assets/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBASmF2YeWQjuerr-S9leWTpQ==,size_20,color_FFFFFF,t_70,g_se,x_16.png)

# ThreadLocal原理

```java

static class ThreadLocalMap {
        
        private static final int INITIAL_CAPACITY = 16; //初始化容量
        private Entry[] table; //ThreadLocalMap数据真正存储在table中
        private int size = 0; //ThreadLocalMap条数
        private int threshold; // 默认为0,达到这个大小，则扩容
        //类Entry的实现
        static class Entry extends WeakReference<ThreadLocal<?>> {
            Object value;
            Entry(ThreadLocal<?> k, Object v) {
                super(k);
                value = v;
            }
        }
        //构造函数
        ThreadLocalMap(ThreadLocal<?> firstKey, Object firstValue) {
            table = new Entry[INITIAL_CAPACITY]; //初始化table数组，INITIAL_CAPACITY默认值为16
            int i = firstKey.threadLocalHashCode & (INITIAL_CAPACITY - 1); //key和16取得哈希值
            table[i] = new Entry(firstKey, firstValue);//创建节点，设置key-value
            size = 1;
            setThreshold(INITIAL_CAPACITY); //设置扩容阈值
        }
    }
```



### set方法

```java
    public void set(T value) {
        Thread t = Thread.currentThread();// 当前线程
        ThreadLocalMap map = getMap(t);
        if (map != null) {
            map.set(this, value);// this表示当前ThreadLocal对象，value存储值
        } else {
            createMap(t, value);// 为当前线程创建ThreadLocalMap对象
        }
    }

    ThreadLocalMap getMap(Thread t) {
        return t.threadLocals;// 当前线程的ThreadLocalMap对象
    }
		
    private void set(ThreadLocal<?> key, Object value) {
      			// 简化代码
            Entry[] tab = table;
            int len = tab.length;
            int i = key.threadLocalHashCode & (len-1);
            tab[i] = new Entry(key, value);// value对象最终会放到Entry
     }
   void createMap(Thread t, T firstValue) {
     		// ThreadLocal创建了一个ThreadLocalMap对象放到了当前线程中
        t.threadLocals = new ThreadLocalMap(this, firstValue);
    }
```

### get方法

```java
    public T get() {
        //1、获取当前线程
        Thread t = Thread.currentThread();
        //2、获取当前线程的ThreadLocalMap
        ThreadLocalMap map = getMap(t);
        //3、如果map数据不为空，
        if (map != null) {
            //3.1、获取threalLocalMap中存储的值
            ThreadLocalMap.Entry e = map.getEntry(this);
            if (e != null) {
                @SuppressWarnings("unchecked")
                T result = (T)e.value;
                return result;
            }
        }
        //如果是数据为null，则初始化，初始化的结果，TheralLocalMap中存放key值为threadLocal，值为null
        return setInitialValue();
    }
 
 
private T setInitialValue() {
        T value = initialValue();
        Thread t = Thread.currentThread();
        ThreadLocalMap map = getMap(t);
        if (map != null)
            map.set(this, value);
        else
            createMap(t, value);
        return value;
    }

```

### remove方法

```java
 public void remove() {
         ThreadLocalMap m = getMap(Thread.currentThread());
         if (m != null)
             m.remove(this);
  }
```



# 高并发下ThreadLocal会导致内存泄露，什么原因导致的？如何避免

### 内存泄露原因

### 如何避免



# 总结

https://blog.csdn.net/CSDN2497242041/article/details/120192343

https://juejin.cn/post/7330845506414313512?utm_source=gold_browser_extension#heading-6