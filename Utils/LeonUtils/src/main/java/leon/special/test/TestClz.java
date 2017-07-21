package leon.special.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * **************************************
 * <p>测试类应该使用该注解来明确的表示它是一个测试类
 * 
 * <p>该注解可以被赋予一个字符串值，用来表示测试类中的测试方法。
 * 
 * <p>如果灭有被赋值，默认的测试方法为"testMeth"
 * 
 * @author LeonLee
 * @date 2017年6月13日 上午11:01:47 
 ***************************************
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TestClz {
	
	String value() default "testMeth";
}
