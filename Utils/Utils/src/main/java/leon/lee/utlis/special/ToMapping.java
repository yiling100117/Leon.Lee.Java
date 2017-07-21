package leon.lee.utlis.special;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ToMapping {
	
	private String						returnClause;	//返回参数
	private String						table;			//表名，对应数据库
	private String						hql;			//自定义sql语句
	private Object[]					obj;			//预编译变量
	private String						newHql	= null;
	private Map<String, Object>			field;			//预编译变量的集合，键值对的形式
	private List<Map<String, Object>>	model;			//对象转换为Map
														
	public ToMapping() {
		field = new HashMap<String, Object>();
		model = new ArrayList<Map<String, Object>>();
	}
	
	public List<Map<String, Object>> getModel() {
		return model;
	}
	
	public String getReturnClause() {
		return returnClause;
	}
	
	public ToMapping setReturnClause(String[] returnClause) {
		String clause = null;
		if (returnClause != null) {
			for (String c : returnClause) {
				clause += "," + c;
				if (returnClause[0].equals(c)) {
					clause = c;
				}
			}
		}
		this.returnClause = clause;
		return (ToMapping) this;
	}
	
	public String getHql() {
		return hql;
	}
	
	public ToMapping setHql(String hql) {
		this.hql = hql + " ";
		return (ToMapping) this;
	}
	
	public ToMapping setObj(Object[] obj) {
		this.obj = obj;
		return (ToMapping) this;
	}
	
	public String getTable() {
		return table;
	}
	
	public ToMapping setTable(String table) {
		this.table = table;
		return (ToMapping) this;
	}
	
	public Map<String, Object> getfield() {
		return field;
	}
	
	/**
	 * 转换sql语句，必须执行的方法
	 * */
	public void end() {
		newHql = hql;
		hql = "";
		ArrayList<String> arrayList = new ArrayList<String>();
		String[] str = newHql.split("[?]");
		for (String s : str) {
			arrayList.add(s);
			if (!s.equals(str[str.length - 1])) {
				int index = s.trim().lastIndexOf(" ");
				String clum = s.substring(index + 1, s.length() - 1);
				if (clum.trim().equals("like")) {
					int in = s.indexOf("like");
					clum = s.substring(0, in);
					index = clum.trim().lastIndexOf(" ");
					clum = clum.substring(index + 1, clum.length() - 1);
				}
				if (clum.indexOf(".") != -1) {
					clum = clum.split("[.]")[1];
				}
				hql += s + "#{field." + clum.trim() + "}";
				field.put(clum.trim(), obj[arrayList.indexOf(s)].equals("%null%") ? "%%" : obj[arrayList.indexOf(s)]);
			} else {
				hql += s;
			}
		}
	}
	
	/**
	 * 将任意对象转换为Map对象
	 * @param f 任意对象
	 * */
	public List<Map<String, Object>> parseMapping(Object f) {
		//对象名
		//String fName = f.getClass().getSimpleName();
		// 获取f对象对应类中的所有属性域
		Field[] fields = f.getClass().getDeclaredFields();
		//Class<?> var = f.getClass().getComponentType();
		for (int i = 0, len = fields.length; i < len; i++) {
			// 对于每个属性，获取属性名
			String varName = fields[i].getName();
			
			try {
				// 获取原来的访问控制权限
				boolean accessFlag = fields[i].isAccessible();
				// 修改访问控制权限
				fields[i].setAccessible(true);
				// 获取在对象f中属性fields[i]对应的对象中的变量
				Object o = fields[i].get(f);
				Map<String, Object> m = new HashMap<String, Object>();
				m.put("varName", varName);
				m.put("varValue", o);
				model.add(m);
				// 恢复访问控制权限
				fields[i].setAccessible(accessFlag);
				
			} catch (IllegalArgumentException ex) {
				ex.printStackTrace();
			} catch (IllegalAccessException ex) {
				ex.printStackTrace();
			}
		}
		return model;
	}
	
	/**
	 * 利用反射获取指定对象的指定属性
	 * @param obj 目标对象
	 * @param fieldName 目标属性
	 * @return 目标属性的值
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getFieldValue(Object obj, String fieldName) {
		Object result = null;
		Field field = getField(obj, fieldName);
		if (field != null) {
			field.setAccessible(true);
			try {
				result = field.get(obj);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return (T) result;
	}
	
	/**
	 * 利用反射获取指定对象里面的指定属性
	 * @param obj 目标对象
	 * @param fieldName 目标属性
	 * @return 目标字段
	 */
	private static Field getField(Object obj, String fieldName) {
		Field field = null;
		for (Class<?> clazz = obj.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
			try {
				field = clazz.getDeclaredField(fieldName);
				break;
			} catch (NoSuchFieldException e) {
				//这里不用做处理，子类没有该字段可能对应的父类有，都没有就返回null。
			}
		}
		return field;
	}
	
	/**
	 * 利用反射设置指定对象的指定属性为指定的值
	 * @param obj 目标对象
	 * @param fieldName 目标属性
	 * @param fieldValue 目标值
	 */
	public static void setFieldValue(Object obj, String fieldName, Object fieldValue) {
		Field field = getField(obj, fieldName);
		if (field != null) {
			try {
				field.setAccessible(true);
				field.set(obj, fieldValue);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 将Map转换成对象
	 * @param clazz 目标对象，例如 String.class
	 * @param map 需要转换的map
	 * */
	public static <T> T mapToModel(Class<T> clazz, Map<?, ?> map) throws Exception {
		ToMapping tm = new ToMapping();
		T s = clazz.newInstance();
		tm.parseMapping(s);
		for (Map<?, ?> m : tm.getModel()) {
			setFieldValue(s, (String) m.get("varName"), map.get(m.get("varName")));
		}
		return s;
	}
	
	/**
	 * 将List(Map)转换成List对象
	 * @param clazz 目标对象，例如 String.class
	 * @param list 需要转换的list
	 * */
	public static <T> List<T> listToModel(Class<T> clazz, List<Map<?, ?>> list) throws Exception {
		List<T> ts = new ArrayList<T>();
		for (Map<?, ?> map : list) {
			T s = mapToModel(clazz, map);
			ts.add(s);
		}
		return ts;
	}
	
}
