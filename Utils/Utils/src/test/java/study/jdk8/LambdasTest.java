package study.jdk8;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.junit.Test;

/**
 * 
 ********************************************************************************
 *
 * <p>函数式接口：
 * 		<p>函数式接口（functional interface 也叫功能性接口，其实是同一个东西）。简单来说，函数式接口是只包含一个方法的接口。
 *  	<p>比如Java标准库中的java.lang.Runnable和 java.util.Comparator都是典型的函数式接口。
 *  	<p>java 8提供 @FunctionalInterface作为注解,这个注解是非必须的，只要接口符合函数式接口的标准（即只包含一个方法的接口），虚拟机会自动判断，
 *  	但最好在接口上使用注解@FunctionalInterface进行声明，以免团队的其他人员错误地往接口中添加新的方法。
 *  	<p>Java中的lambda无法单独出现，它需要一个函数式接口来盛放，lambda表达式方法体其实就是函数接口的实现，下面讲到语法会讲到 。
 *  
 * <p>Lambda表达式具有下面这样的语法特征：
 * 		<p>它由三个部分组成：
 * 			<p>第一部分为一个括号内用逗号分隔的形参，参数即函数式接口里面方法的参数。
 * 			<p>第二部分为一个箭头符号：->。
 * 			<p>第三部分为方法体，可以是表达式和代码块,方法体函数式接口里面方法的实现，如果是代码块，则必须用{}来包裹起来，且需要一个return 返回值，但有个例外，若函数式接口里面方法返回值是void，则无需{}
 * 		<p>语法如下：
 * 			<p>parameter -> expression body
 * 			<p>eg:<code>MathOperation add = (int a, int b) -> a + b;</code>
 * 
 * <p>Lambda表达式的几个最重要的特征：
 * 		<p>1.可选的类型声明：			你不用去声明参数的类型。编译器可以从参数的值来推断它是什么类型。
 * 		<p>2.可选的参数周围的括号：	你可以不用在括号内声明单个参数。但是对于很多参数的情况，括号是必需的。
 * 		<p>3.可选的大括号：			如果表达式体里面只有一个语句，那么你不必用大括号括起来。
 * 		<p>4.可选的返回关键字：		如果表达式体只有单个表达式用于值的返回，那么编译器会自动完成这一步。若要指示表达式来返回某个值，则需要使用大括号。
 *
 * @author ly
 * @date 2017年5月24日 上午11:18:03 
 *
 ********************************************************************************
 *
 */
public class LambdasTest {
	
	/**
	 * 
	 ********************************************************************************
	 * 
	 * <p>KW:
	 *
	 * <p>展示Lambda表达式的几种语法方式。
	 * <p>Lambda表达式优先用于定义功能接口在行内的实现，即单个方法只有一个接口。
	 * <p>在下面的例子中，我们用了多个类型的Lambda表达式来定义MathOperation接口的操作方法。然后我们定义了GreetingService的sayMessage的实现。
	 * <p>Lambda表达式让匿名类不再需要，这位Java增添了简洁但实用的函数式编程能力。
	 * 
	 * @author ly
	 * @date 2017年5月24日 下午3:04:30 
	 * 
	 ********************************************************************************
	 *
	 */
	@Test
	public void grammarTest() {
		//带有类型声明的表达式  
		MathOperation add = (int a, int b) -> a + b;
		
		//没有类型声明的表达式  
		MathOperation sub = (a, b) -> a - b;
		
		//带有大括号，带有返回语句的表达式  
		MathOperation mul = (int a, int b) -> {
			return a * b;
		};
		
		//没有大括号和return语句的表达式  
		MathOperation div = (int a, int b) -> a / b;
		
		//没有类型声明的表达式  
		//也可以写成： (Info) ->System.out.println(Info);  
		GreetingServer printInfo = Info -> System.out.println(Info);
		
		printInfo.print("10 + 5 =" + operator(10, 5, add));
		printInfo.print("10 - 5 =" + operator(10, 5, sub));
		printInfo.print("10 * 5 =" + operator(10, 5, mul));
		printInfo.print("10 / 5 =" + operator(10, 5, div));
	}
	
	private int operator(int a, int b, MathOperation mathoperation) {
		return mathoperation.operation(a, b);
	}
	
	/**
	 * 
	 ********************************************************************************
	 * 
	 * <p>KW:
	 * 
	 * <p>使用Lambda表达式代替匿名内部类
	 * <p>Lambda表达式的作用是更简便的定义匿名内部类的方法体
	 * <p>这种方式只能使用在函数式接口上。
	 * 
	 * @author ly
	 * @date 2017年5月24日 下午3:16:53 
	 * 
	 ********************************************************************************
	 *
	 */
	@Test
	public void replaceAnonymousInnerClass() {
		runThreadUseLambda();
		runThreadUseInnerClass();
	}
	
	public void runThreadUseLambda() {
		//Runnable是一个函数接口，只包含了有个无参数的，返回void的run方法；
		//所以lambda表达式左边没有参数，右边也没有return，只是单纯的打印一句话
		new Thread(() -> System.out.println("lambda实现的线程")).start();
	}
	
	public void runThreadUseInnerClass() {
		//这种方式就不多讲了，以前旧版本比较常见的做法
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("内部类实现的线程");
			}
		}).start();
	}
	
	/**
	 * 
	 ********************************************************************************
	 * 
	 * <p>KW:
	 *
	 * <p>方法引用:(匿名内部类引用方法)
	 * <p>其实是lambda表达式的一个简化写法，所引用的方法其实是lambda表达式的方法体实现，语法也很简单，左边是容器（可以是类名，实例名），中间是"::"，右边是相应的方法名。
	 * <p>一般方法的引用格式是:
	 * 		如果是静态方法，则是ClassName::methodName。如 Object ::equals
	 * 		如果是实例方法，则是Instance::methodName。如Object obj=new Object();obj::equals;
	 * 		构造函数.则是ClassName::new
	 * 
	 * @author ly
	 * @date 2017年5月24日 下午4:09:06 
	 * 
	 ********************************************************************************
	 *
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setLayout(new FlowLayout());
		frame.setVisible(true);
		
		JButton button1 = new JButton("点击我!");
		JButton button2 = new JButton("点击我!");
		
		frame.getContentPane().add(button1);
		frame.getContentPane().add(button2);
		//这里addActionListener方法的参数是ActionListener，是一个函数式接口
		//使用lambda表达式方式
		button1.addActionListener(e -> {
			System.out.println("这里是Lambda实现方式");
		});
		//使用方法引用方式
		button2.addActionListener(LambdasTest::doSomething);
	}
	
	/**
	 * 这里是函数式接口ActionListener的实现方法
	 * @param e 
	 */
	public static void doSomething(ActionEvent e) {
		System.out.println("这里是方法引用实现方式");
	}
}

interface MathOperation {
	
	int operation(int a, int b);
}

interface GreetingServer {
	
	void print(String message);
}

class A {
	
	private int a;
	
	@Override
	public String toString() {
		return "A [a=" + a + "]";
	}
	
}