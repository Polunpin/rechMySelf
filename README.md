# RICH MYSELF

------------------------------------
## 1.strategy(策略模式)
>测试地址 http://localhost:8080/pay?amount=8800&paymentType=1

参考文档：
[别在再满屏的 if、else 了，试试策略模式🔗](https://www.javastack.cn/article/2021/strategy-pattern-instead-of-if-else/)

策略模式的优点：

1、干掉繁琐的 if、switch 判断逻辑；

2、代码优雅、可复用、可读性好；

3、符合开闭原则，扩展性好、便于维护；

策略模式的缺点：

1、策略如果很多的话，会造成策略类膨胀；

2、使用者必须清楚所有的策略类及其用途；