@echo off

set JAVA_HOME=%~dp0jdk-16
set PATH=%JAVA_HOME%\bin;%PATH%
set JAVA_CMD=%JAVA_HOME%\bin\javaw

chcp 65001

@echo on
%JAVA_CMD% -cp ./lib/*;./build/libs/* -Dfile.encoding=UTF-8 trial.java.exe4jboot.App
