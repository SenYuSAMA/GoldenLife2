# 概要
## 数据获取
由于贵金属报价数据提供商限制请求次数为一天100次，为了每次获取最新的数据且能够完整的获取一天的数据，可以另起线程每15分钟发一次网络请求，获得提供商返回的JSon数据后，存储到本地数据库中，供自己的客户端将来调用。
## 服务端数据查询需求
为了客户端能直接获得解析后即可用、不用再次分类的数据，服务端的数据库查询功能应该有：①按照贵金属种类查询最新的报价、②按照贵金属种类和指定时间查询报价、③获取最新的各种贵金属报价、④获取指定贵金属种类的最新的三十条报价

## 客户端界面需求
在第一个页面，使用recyclerview展示8种不同的贵金属的简略报价信息，报价信
息需要是最新的、直观的。在点击某一个item后，可以获取到该贵金属的详细报价信息并且展示、且以折线图方式展示该贵金属近三十条最新报价信息。
# 模块分析
## 服务端
需要一个JavaBean：FinanceBean类，负责存储金融报价信息，在解析数据商提供的信息后，立刻解析为此Bean类，而且从数据库查询信息以后，也可以转化为此bean类。
需要一个DAO：FinanceDAO类，负责提供各种JDBC，通过SQL作各种查询、插入操作。
需要一个Servlet：QueryServlet，根据客户端发出的post/get请求参数，判断客户端需要执行何种查询操作，并且去调用DAO中的查询方法，将包含数据的实体类转化为Json返回给客户端。
## 客户端
需要执行避免UI卡顿的网络请求：使用OKhttp框架来发送请求，且通过AsyncTask，执行异步操作，使得网络请求处于非UI线程的子线程，防止UI卡顿。
需要一个MainActivity：包含了RecyclerView，其每个子项展示其中一个金属种类的报价信息。且每个子项都应该注册点击事件，在点击后启动popActivity。
需要一个PopActivity：其包含了一个展示详细信息的界面，和一个数据可视化界面，在MainActivity的RecyclerView点击事件后，传来相应的数据bean，且再根据bean中的种类再次去服务端请求更多数据，以展示数据可视化。
# 图
## 程序流程图
![程序流程图](https://github.com/SenYuSAMA/GoldenLife2/blob/master/1.png)
## 网络交互原理
![](https://github.com/SenYuSAMA/GoldenLife2/blob/master/2.png)
## 客户端效果图
![](https://github.com/SenYuSAMA/GoldenLife2/blob/master/3.png)
![](https://github.com/SenYuSAMA/GoldenLife2/blob/master/4.png)

