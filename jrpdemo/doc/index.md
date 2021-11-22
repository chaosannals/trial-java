# 报表模板制作

## 开发步骤

### 1. 打开 Jaspersoft Studio 切换工作目录。

![01](./images/01.png)
![02](./images/02.png)

### 2. 创建模板

![05](./images/05.png)
![06](./images/06.png)
![07](./images/07.png)
![08](./images/08.png)
![09](./images/09.png)

### 3. 配置 JSON 数据源

数据源是多行的一组数据。
下面的示例是选取了 JSON 文件的 "数据列表" 节点作为数据源。

```json
{
    "概要": {
        "标题": "一个标题",
        "时间": "2020-01-01",
        "数字": 123456
    },
    "数据列表": [
        {
            "名字": "名字A",
            "编号": "101",
            "图片": "https://www.baidu.com/img/flexible/logo/pc/result.png"
        },
        {
            "名字": "名字B",
            "编号": "102",
            "图片": "https://www.baidu.com/img/flexible/logo/pc/result.png"
        },
        {
            "名字": "名字C",
            "编号": "103",
            "图片": "https://www.baidu.com/img/flexible/logo/pc/result.png"
        }
    ]
}
```

![0301](./images/0301.png)
![0302](./images/0302.png)
![0303](./images/0303.png)
![0304](./images/0304.png)
![0305](./images/0305.png)
![0306](./images/0306.png)
![0307](./images/0307.png)
![0308](./images/0308.png)
![0309](./images/0309.png)
![0310](./images/0310.png)
![0311](./images/0311.png)
![0312](./images/0312.png)
![0313](./images/0313.png)


### 4. 添加参数

![0401](./images/0401.png)
![0402](./images/0402.png)
![0403](./images/0403.png)
