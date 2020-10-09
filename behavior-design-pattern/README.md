# 行为型设计模式

## 1.委派模式

允许对象组合实现与继承相同的代码重用，负责任务的调用和分配，一种特殊的静态代理模式。

角色：抽象任务角色、委派者角色、具体任务角色

可通过统一管理这些子任务的完成情况实现任务的跟进，加快任务执行的效率。但是在任务比较复杂的情况下，可能需要进行多重委派，容易造成紊乱。

## 2.模板方法模式

指定义一个操作中的算法的框架，二将一些步骤延迟到子类中，让子类不改变一个算法的结构即可重定义算法的某些特定的步骤。也相当于将各个部分当作函数抽离出来。

角色：抽象模板、具体实现

可将相同处理逻辑的代码抽离到父类中，提高代码的复用性。并将不同算法逻辑分离到不同的子类中。但是每一个抽象类都需要一个子类来是西安，由于继承关系自身的缺点，父类添加一个新的抽象方法，所有的子类都要改一遍。

## 3.策略模式

将定义算法家族分别封装起来，让它们可以互相替换。使用面向对象的继承和多态机制，从而实现同意行为在不同的场景下具备不同的实现。

角色：上下文角色、抽象策略角色、具体策略角色

避免使用多重条件语句，如if...else语句，单客户端必须知道所有的策略，并自行决定使用哪一个策略类。

## 4.责任链模式

当一个请求从链式的首端发出时，会沿着责任链预设的路径一次传递到每一个结点对象，直至被连着的某个对象处理为止。

角色：抽象处理者，具体处理者

将请求与处理解耦，具备链式传递处理请求功能，易于扩展新的请求处理类。责任链太长或者处理时间过长会影响整体性能，若结点对象存在循环引用，会造成死循环。

## 5.迭代器模式

提供一种按顺序访问集合/容器对象元素的方法，又无需暴露集合内部标识。

## 6.命令模式

## 7.