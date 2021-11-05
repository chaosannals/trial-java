# 热加载

## hotdemo

具体实现的包

## hotlib

接口定义的包

## hotload 

加载示例

1. 通过初始化一个类加载器（URLClassLoader）把 jar 加入到加载器里面。
2. 加入的加载器无法删除 URL ，所以卸载的时候需要重新生成加载器。
