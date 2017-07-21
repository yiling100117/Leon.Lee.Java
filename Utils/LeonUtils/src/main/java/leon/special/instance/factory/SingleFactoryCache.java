package leon.special.instance.factory;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * *******************************************************************************
 * <p>配合工厂方法实现生产单例对象
 * 
 * <p>只能加在类型上，使用此注解的类，在使用<code>{@link BaseFactoryMethod}</code>的时候就会产生单例对象
 * 
 * @author LeonLee
 * @date 2017年6月16日 上午11:52:52 
 * *******************************************************************************
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface SingleFactoryCache {}
