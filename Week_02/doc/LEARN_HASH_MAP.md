# 学习 HashMap（JDK1.8）

## HashMap的常量属性
* `load-factor` `['fæktɚ]` `负载系数` HashMap默认的负载系数为 ***0.75***
```java
/**
 * The load factor used when none specified in constructor.
 */
static final float DEFAULT_LOAD_FACTOR = 0.75f;
```

---
* `initial-capacity` `[kə'pæsəti]` `初始容量` HashMap的初始容量为 ***16***
```java
/**
 * The default initial capacity - MUST be a power of two.
 */
static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16
```
* `max-capacity` `最大容量` HashMap的最大容量为 ***2^30***
```java
 /**
 * The maximum capacity, used if a higher value is implicitly specified
 * by either of the constructors with arguments.
 * MUST be a power of two <= 1<<30.
 */
static final int MAXIMUM_CAPACITY = 1 << 30;
``` 