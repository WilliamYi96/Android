# 详解第一组UI组件：布局管理器 #

md格式参见博客：http://blog.csdn.net/williamyi96/article/details/52222523
以下是布局管理器的层次结构：
![这里写图片描述](http://img.blog.csdn.net/20160816155234273)

##线性布局(LinearLayout)##
线性布局的最大特点是会将容器里的组件一个挨着一个地排列起来。
LinearLayout可以控制各组件横向排列，也可以控制各组件纵向排列(通过android:orientation属性控制)
以下是一个线性布局的程序实例：

```
<LinearlyLayout xmlns:android="http://schemas.android.com/apk/res/android"
	//声明各组件的排列方式是纵向排列
	android:orientation = "vertical"
	//垂直底对齐、水平居中
	android:gravity = "buttom|center_horizental"
	android:layout_width = "match_parent"
	android:layout_height = "match_parent" />
```

接下来我们添加测试用的几个按钮元素：

```
<Button
	android:id = "@+id/bni"
	android:layout_width = "wrap_content"
	android:layout_height = "wrap_content"
	android:text = "@string/bni" />
```
(注意其后要将string.xml 中的bni 的value值补齐)

**特别注意**
重点掌握android:gravity 的相关性质：(设置布局管理器内组件的对齐方式)。
其属性可以参阅官方文档，实现在工程中是很重要的环节。
基本上很多布局管理器都提供了相应的LayoutParams内部类，该内部类用于控制他们的子元素支持指定android:layout_gravity属性，该属性设置该子元素在父容器中的对齐方式。与android:layout_gravity相似的属性还有android:gravity 属性(一般容器才支持指定该属性)，android:gravity 属性用于控制它所包含的子元素的对齐方式。

##表格布局(TableLayout)##
表格布局继承了LinearLayout,因此其本质仍然是线性布局管理器。
TableLayout不需要明确声明包含有多少行、多少列，而是通过添加TableRow或者其他组件(例如Button) 来控制表格的行数和列数。
他的主要特点是可以进行子容器的拉伸、隐藏、收缩。

以下是详解程序实例：
首先我们先对整体布局进行定义(表格布局可以嵌套在线性布局中使用)

```
<!--指定第一个表格布局，指定第二列允许收缩，第三列允许拉伸-->
<TableLayout
	android:id = "@+id/TableLayout1"
	//一般将width设置为match_parent,将height设置为wrap_content
	android:layout_width = "match_parent"
	android:layout_height = "warp_content"
	android:shrinkColumns = "1"
	android:stretchColumns = "2" >
	<!--表格内容接下来进行详解-->

<!--定义第二个表格布局，指定第二列隐藏-->
<TableLayout 
	android:id = "@+id/TableLayout2"
	android:layout_width = "match_parent"
	android:layout_height = "warp_content"
	android:collapseColumns = "1" >
	<!--表格内容接下来进行详解-->

<!--定义第三个表格布局，指定第二列和第三列可以拉伸-->
<TableLayout
	android:id = "@+id/TableLayout3"
	android:layout_width = "match_parent"
	android:layout_height = "warp_content"
	android:stretchColumns = "1,2" >
	<!--表格内容接下来进行详解-->
```
以下是第一个表格布局的代码：

```
<!--直接添加按钮，它自己会占一行-->
<Button
	android:id = "@+id/ex1"
	//一般在子容器中将width和height均设置为wrap_content
	android:layout_width = "wrap_content"
	android:layout_height = "wrap_content"
	android:text = "独自一行的按钮"
	//最好将文本中的内容放入xml文件中，由于此处为简单直观，才直接在布局文件中表示出字符串

<!--添加一个表格行-->
<TableRow>
<!--为该表格行添加三个按钮-->
<Button
	android:id = "@+id/ex2"
	android:layout_width = "wrap_content"
	android:layout_height = "wrap_content"
	android:text = "普通按钮">
<Button
	android:id = "@+id/ex2"
	android:layout_width = "wrap_content"
	android:layout_height = "wrap_content"
	android:text = "收缩的按钮">
<Button
	android:id = "@+id/ex2"
	android:layout_width = "wrap_content"
	android:layout_height = "wrap_content"
	android:text = "拉伸的按钮">
</TableRow>
```
剩余的两个TableLayout是一样的，在此就不赘述了。

##帧布局(FrameLayout)##

 帧布局容器为每个加入其中的组件创建一个空白的区域(称为一帧)，每个子组件占据一帧，这些帧会根据gravity属性执行自动对齐。
 我们想要得到霓虹灯的效果，因此，首先创建帧布局容器：
 代码如下：
 

```
<?xml version="1.0" encoding="utf-8"?>
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/activity_main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context="com.example.dell1.neonlight.MainActivity">

    <!--依次定义五个TestView，先定义的TestView位于底层-->
    <TextView
        android:id="@+id/view1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:width="160pt"
        android:height="160pt"
        android:background="#f00"/>

    <TextView
        android:id="@+id/view2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:width="130pt"
        android:height="130pt"
        android:background="#f0f0"/>

    <TextView
        android:id="@+id/view3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:width="100pt"
        android:height="100pt"
        android:background="#00f"/>

    <TextView
        android:id="@+id/view4"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:width="70pt"
        android:height="70pt"
        android:background="#ff0"/>

    <TextView
        android:id="@+id/view5"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:width="40pt"
        android:height="40pt"
        android:background="#f0f"/>

</FrameLayout>


```

接下来我们要实现的是轮换改变上面帧布局中5个TextView的背景色，就会看到上面的颜色渐变地变换，就像大街上的霓虹灯一样。下面的程序在使用FrameLayout的基础上，启动一个线程来控制周期性地改变这5个TextView的背景色。
首先定义一个颜色数组以及一个存储xml中TextView的数组：

```
 private int currentColor = 0;
    //定义一个颜色数组
    final int[] colors = new int[] {
            R.color.color1,
            R.color.color2,
            R.color.color3,
            R.color.color4,
            R.color.color5,
    };
    final int[] names = new int[] {
            R.id.view1,
            R.id.view2,
            R.id.view3,
            R.id.view4,
            R.id.view5,
    };
```

接着创建一个与数组长度相同(帧数相同)的TextView,实际上得到的就是帧布局中得到五个TextView

```
TextView view = new TextView[names.length];
```
然后使用一个handler，处理新建线程中的信息，使其可以改变背景颜色

```
Handler handler = new Handler() {
	@override
	public void handleMessage(Message msg) {
		super.handleMessage(msg);
		//给予一个特殊字符串，判断消息是否来本程序
		if (msg.what == 0x123) {
			for(int i = 0; i < names.length; i++) {
				//使用循环改变五个TextView中的颜色值
				views[i].setBackgroundResource(colors[i +
				      currentColor) % names.length]);
			}
			currentColor++;
		}
	}
};
```

然后在onCreate类中先获取数组汇总的id，也就是xml中各个TextView:

```
for (int i = 0; i < names.length; i++) {
	views[i] = (TextView) findViewById(names[i]);
}
```
 
再则定义一个线程周期性地改变currentColor变量的值：

```
new Timer().schedule(new TimerTask() {
	@override
	public void run() {
		//发送一条空消息通知系统改变五个TextView组件的背景色
		handler.sendEmptyMessage(0x123);
	}, 0, 200);
}
```

##相对布局(RelativeLayout)##
相对布局是由RelativeLayout所代表的，相对布局容器内子组件的位置总是相对兄弟组件、父容器来决定的，因此这种布局称之为相对布局。
值得注意的是，如果A组件的位置是由B组件的位置来决定的，那么Android要求先定义B组件，然后再定义A组件。
**特别注意：**
许多的RelativeLayout.LayoutParams里只能设置为true or false，详情参见官方开发文档。
以下将会通过“梅花”布局效果分析相对布局的用法：
首先设置中间图片的位置：

```
<!--定义该组件位于父容器的中间-->
<TextView
	android:id = "@+id/view1"
	android:layout_width = "wrap_content"
	android:layout_height ="wrap_content"
	//图片通过android:background加载
	android:background = "@drawable/leaf"
	//控制该组件位于布局容器的中央位置
	andorid:layout_centerInParent = "true"/>
```

接着再根据上述组件利用相对位置设置其他四个leaf组件的位置：

```
<!--定义该组件位于view1组件的上方-->
    <TextView
        android:id="@+id/view2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:background="@drawable/leaf"
        android:layout_above="@+id/view1"
        android:layout_alignLeft="@+id/view1"/>
        //layout_alignLeft控制该组件与给定ID组件的左边界对其

    <!--定义该组件位于view1组件的下方-->
    <TextView
        android:id="@+id/view3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:background="@drawable/leaf"
        android:layout_below="@+id/view1"
        android:layout_alignLeft="@+id/view1"/>
        //控制该子组件与给出ID组件的左边界对齐（当然同样大小的图案也可以进行右对齐）

    <!--定义该组件位于view1组件的左侧-->
    <TextView
        android:id="@+id/view4"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:background="@drawable/leaf"
        android:layout_toLeftOf="@+id/view1"
        android:layout_alignTop="@+id/view1"/>

    <!--定义该组件位于view2组件的右侧-->
    <TextView
        android:id="@+id/view5"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:background="@drawable/leaf"
        android:layout_toRightOf="@+id/view1"
        android:layout_alignTop="@+id/view1"/>
```

##网格布局(GridLayout)##
网格布局由GridLayout代表，它是Adroid 4.0新增的布局管理器。
GridLayout作用类似于HTML中得到table标签，它将整个容器划分为$rows\times columns$ 个网格，每个网格中可以放置一个组件。
同时也正是由于网格布局与HTML的相似性，因此网格之间的span合并在此处是等同的(android:layout_columnSpan/android:layout_rowSpan).

下面就通过计算器界面的实例详解GridLayout的功能及用法：
首先设置网格布局的行数和列数：

```
android:rowCount = "6"
android:columnCount = "4"
```
再定义一个横跨四列的文本框（表示计算器的显示界面）,并设置该文本框的前景色、背景色等属性：

```
<TextView
	//此处由于文本框的默认值为0，因此height可以选用match_parent
	android:layout_width = "match_parent"
	android:layout_height = "match_parent"
	android:layout_collumnSpan = "4"
	android:textSize = "50sp"
	android:layout_marginLeft = "2pt"
	android:layout_marginRight = "2pt"
	android:padding = "3pt"
	android:layout_gravity = "right"
	android:background = "#eee" //white
	android:textColor = "#000" //black
	android:text = "0" />
```

然后再定义一个横跨四列的清除按钮：

```
<Button
	android:layout_width = "match_parent"
	android:layout_height = "wrap_content"
	android:layout_columnSpan = "4"
	android:text = "清除" />
```
接下来我们使用循环控制添加16个按钮：

```
GridLayout gridLayout;
    //定义16个按钮的文本
    String[] chars = new String[] {
            "7","8","9","÷",
            "4","5","6","×",
            "1","2","3","4",
    };
```
然后获取网格布局容器(之前已经声明gridLayout为网格容器)：

```
gridLayout = (GridLayout) findViewById(R.id.activity_main);
```

再则就是循环控制添加16个组件了：

```
for (int i = 0; i < chars.length; i++) {
            Button bn = new Button(this);
            bn.setText(chars[i]);
            //设置该按钮的字号大小
            bn.setTextSize(40);
            //设置按钮四周的空白区域(左、上、右、下)
            bn.setPadding(15,100,15,100);
            //指定该组件所在的行
            GridLayout.Spec rowSpec = GridLayout.spec(i / 4 + 2);
            //指定该组件所在的列
            GridLayout.Spec columnSpec = GridLayout.spec(i % 4);
            GridLayout.LayoutParams params = new GridLayout.LayoutParams(rowSpec, columnSpec);
            //指定该组件占满父容器
            params.setGravity(Gravity.FILL);
            gridLayout.addView(bn, params);
        }
```

##绝对布局(AbsoluteLayout) ##
绝对布局不提供任何布局机制，而是由开发人员自己通过坐标来控制组件位置，但是由于Android应用手机千差万别，屏幕大小、分辨率可能存在较大差异，因此绝对布局很难兼顾不同屏幕大小、分辨率的问题，因此，绝对布局已经过时。
考虑到上述种种，因此绝对布局没有深入地进行研究分析。

布局管理器的基本框架以及用法主要是上述这些，具体的相关操作还需要在实践中进一步加深理解。总体而言，学习完布局管理器收获相当之大。
