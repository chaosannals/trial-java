# jna

类似 C# 的 DllImport 指定 动态链接库文件，函数声明匹配就可以调用。

不过目前没有找到像 DllImport 那样重命名的方式，所以函数还是与 动态链接库 的导出函数同名。

而且也和 DllImport 一样，只能处理 C 风格 ABI 的导出函数，无法处理 C++ 风格的 ABI 导出函数。

底层是动态类生成。

```bash
# 生成
gradle build
# 在 build/distributions 下可找到发布文件。
```
