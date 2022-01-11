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

在拉代码前，git submodule init 执行后, 找到子模块 .git/config 把 autocrlf = input 这个设置，执行 git submodule update 保证 LF 拉过来后不变成 CRLF 

```ini
[core]
    autocrlf = input
```

Git 拉源码时候脚本 CRLF 换行符会导致报错，确保脚本是 LF 换行符。
编译需要 VS2013 英文版，其他语言版本会有问题，需要改脚本。

注：VSCODE 直接添加 .gitignore 忽略 /build/ 文件夹，不然太卡。

```bash
# 选中 VS 2013 （英文版，中文会报错）
# 需要下载 freetype 源码 这里使用 2.8.1 高版本（试过 2.11.1 ）的编译会报错。
bash configure --with-debug-level=release --with-jvm-variants=server --with-freetype-src=/cygdrive/g/freetype-2.8.1 --with-boot-jdk=/cygdrive/d/java/jdk1.8.0_311 --with-target-bits=32 --disable-warnings-as-errors
```

```bash
# make 的版本使用了 4.2.1 （4.3 会报错 make 4.3 breaks build）
# 单元测试文件 test_json.cpp 代码是错的，直接删除这个文件 可以通过。
make all
```

## jdk10u

```bash
# 选中 VS 2013  （英文版，中文会报错）
# 需要 jdk9 作为编译启动 JDK --with-boot-jdk
bash configure --with-debug-level=release --with-jvm-variants=server --with-freetype-src=/cygdrive/g/freetype-2.8.1 --with-boot-jdk=/cygdrive/d/java/jdk9w32 --with-target-bits=32 --disable-warnings-as-errors

# make 的版本使用了 4.2.1 （4.3 会报错 make 4.3 breaks build）
# 单元测试文件 test/hotspot/gtest/utilities/test_json.cpp 代码是错的，直接删除这个文件 可以通过。
make all
```

## jdk11u

```bash
# 配置库 freetype 这个 JDK12 以后好像就不需要设置 freetype 了。下面这个可能不需要。
export PATH=/cygdrive/d/freetype_w32:$PATH
export FREETYPE_CFLAGS=/cygdrive/d/freetype_w32/include
export FREETYPE_LIBS=/cygdrive/d/freetype_w32/lib

# 会选中 VS 2017（英文版，中文会报错）
# jdk11 开始 --with-freetype-src 参数不可用
# 需要 jdk10 作为编译启动 JDK --with-boot-jdk
bash configure --with-debug-level=release --with-jvm-variants=server --with-boot-jdk=/cygdrive/d/java/jdk10w32 --with-target-bits=32 --disable-warnings-as-errors

# 单元测试文件 test/hotspot/gtest/utilities/test_json.cpp 代码是错的，直接删除这个文件 可以通过。
make all
```

## jdk12u

```bash
# 会选中 VS 2017 （英文版，中文会报错）
# 需要 jdk11 作为编译启动 JDK --with-boot-jdk
bash configure --with-debug-level=release --with-jvm-variants=server --with-boot-jdk=/cygdrive/d/java/jdk11w32 --with-target-bits=32 --disable-warnings-as-errors

# 单元测试文件 test/hotspot/gtest/utilities/test_json.cpp 代码是错的，直接删除这个文件 可以通过。
make all
```

## jdk13u

```bash
# 会选中 VS 2017（英文版，中文会报错）
# 需要 jdk12 作为编译启动 JDK --with-boot-jdk
bash configure --with-debug-level=release --with-jvm-variants=server --with-boot-jdk=/cygdrive/d/java/jdk12w32 --with-target-bits=32 --disable-warnings-as-errors

# 单元测试文件 test/hotspot/gtest/utilities/test_json.cpp 代码是错的，直接删除这个文件 可以通过。
make all
```

## jdk14u

```bash
# 会选中 VS 2017（英文版，中文会报错）
# 需要 jdk13 作为编译启动 JDK --with-boot-jdk
bash configure --with-debug-level=release --with-jvm-variants=server --with-boot-jdk=/cygdrive/d/java/jdk13w32 --with-target-bits=32 --disable-warnings-as-errors

# 单元测试文件 test/hotspot/gtest/utilities/test_json.cpp 代码是错的，直接删除这个文件 可以通过。
make all
```

## jdk15u

```bash
# 会选中 VS 2017（英文版，中文会报错）
# 需要 jdk14 作为编译启动 JDK --with-boot-jdk
bash configure --with-debug-level=release --with-jvm-variants=server --with-boot-jdk=/cygdrive/d/java/jdk14w32 --with-target-bits=32 --disable-warnings-as-errors

# 单元测试文件 test/hotspot/gtest/utilities/test_json.cpp 代码是错的，直接删除这个文件 可以通过。
make all
```

## jdk16u
此时已切换 英文 VS 。

```bash
# 编译 32 位
# 会选中 VS 2019（英文版，中文会报错）
# 需要 jdk15 作为编译启动 JDK --with-boot-jdk
bash configure --with-debug-level=release --with-jvm-variants=server --with-boot-jdk=/cygdrive/d/java/jdk15w32 --with-target-bits=32 --disable-warnings-as-errors
```

直接从官网下载 64位 JDK15 或 16 的编译很简单，直接下面两行就通过了。

freetype 参数一直报无效，在没有指定 freetype 的情况下，编译成功目录下有 freetype.dll。

```bash
# 编译 64位
# 配置编译
bash configure --with-debug-level=release --with-jvm-variants=server --with-boot-jdk=/cygdrive/d/java/jdk-16.0.1 --disable-warnings-as-errors

# 编译
make all
```

### jdk17u

```bash
# 编译 32 位
# 会选中 VS 2019（英文版，中文会报错）
# 需要 jdk16 作为编译启动 JDK --with-boot-jdk
bash configure --with-debug-level=release --with-jvm-variants=server --with-boot-jdk=/cygdrive/d/java/jdk16w32 --with-target-bits=32 --disable-warnings-as-errors

# 
make all
```
