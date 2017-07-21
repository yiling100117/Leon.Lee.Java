package leon.lee.utlis.factory;

/**
 * <p>通用工厂类
 * <p>采用了枚举单例模式
 * 
 * @author ly
 * @date 2017年3月1日 下午4:11:59
 */
public enum CommonFactory {
	
	COMMON_FACTORY;
	
	private CommonFactory(){
		
	}
	
	/**
	 * 该方法通过传入的Class类型来创建一个对应的类型实例，如果无法创建(内部类，私有构造器等情况会返回null)
	 *
	 * @param clz 想要创建对象的Class对象
	 * @return 参数对应类型的实例
	 * @author ly
	 * @date 2017年3月1日 下午4:40:38
	 */
	public <T> T getInstance(Class<T> clz){
		T result=null;
		try {
			result = (T)clz.newInstance();
		} catch (InstantiationException e) {
			System.out.println("无法实例化类(\""+clz.getName()+"\")");
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			System.out.println("类(\""+clz.getName()+"\")的构造方法为私有状态");
			e.printStackTrace();
		}
		return result;
	}
}
