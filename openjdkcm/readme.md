# 编译 openjdk

目前 JDK 在 Windows 下编译只有 Cygwin 的比较正常。其他都不完备。

结合 configure --help 根据不同版本 OpenJDK 配置参数。

[JCef 的 OpenJDK 编译](https://bitbucket.org/chromiumembedded/java-cef/wiki/BuildingOpenJDK.md) 提及了如何编译 freetype2，只能编译低版本 JDK ，高版本参数有差异。 文档里 –-with-freetype 参数在高版本 JDK 的编译中被拆分为  --with-freetype-include --with-freetype-lib。

[官网编译 OpenJDK](http://openjdk.java.net/guide/#building-the-jdk) 文档里面参数列表只有 2 个，但是 configure --help 还是显示老的参数列表，但是很多报没有该参数。

配置时 toolchain.m4 里对应的 AC_MSG_ERROR 改成 AC_MSG_RESULT 屏蔽位数的一些报错。

编译需要相应位数的 JDK，32位就需要 32位启动 JDK ，64位需要64位。

OpenJDK16 必须 15 16 版本的JDK 且高版本有用 make 带 CONF=release 选择版本的要求。

## Cygwin

OpenJDK 要编译的 32位或64位 使用的 Cygwin 版本要对应。

```bash
# 不同版本的 cygwin 安装后执行下面命令安装依赖
setup-x86 -q -P autoconf -P make -P unzip -P zip
setup-x86_64 -q -P autoconf -P make -P unzip -P zip
```

## jdk9u

Git 拉源码时候脚本 CRLF 换行符会导致报错，确保脚本是 LF 换行符。
编译需要 VS2013 英文版，其他语言版本会有问题，需要改脚本。


## jdk16u
此时已切换 英文 VS 。
64位的编译很简单，直接下面两行就通过了。

```bash
# 配置编译
bash configure --with-debug-level=release --with-jvm-variants=server --with-boot-jdk=/cygdrive/d/java/jdk-16.0.1 --disable-warnings-as-errors

# 编译
make all
```