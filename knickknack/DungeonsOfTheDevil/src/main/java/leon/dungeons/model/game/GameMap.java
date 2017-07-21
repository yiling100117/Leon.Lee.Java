package leon.dungeons.model.game;

import java.util.HashMap;
import java.util.Map;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import leon.dungeons.model.abst.MapAbst;

/**
 * 
 **************************************************
 *
 * @deprecated:		地图类
 *
 *
 * @author:			Leon
 * @version:		1.0
 * @date:			2017-7-6 下午3:52:39
 * 
 **************************************************
 *
 */
public class GameMap extends MapAbst{//继承了MapAbst，为以后扩展更多的地图做准备？

	public GameMap() {}

	//提供给工厂方法使用，获取初始化GameMap的参数
	public static Map<String, Object> getArgMap(int row, int col,String mapNo) {// row:行;col:列
		Map<String, Object> result =new HashMap<String, Object>();
		Landform[][] landform = new Landform[row][col];
		for (int i = 0; i < row; i++) {// 行
			for (int j = 0; j < col; j++) {// 列
				landform[i][j] = new Landform();
			}
		}
		result.put("landform", landform);
		result.put("mapNo", mapNo);
		return result;
	}

	// 获取landform字段的真实数据代替getLandform()方法
	public Landform[][] getOriginalLandform() {
		return landform;
	}

	// 提供给mybitas使用，这样插入数据库的就是landfrom的json格式
	public String getLandform() {
		return new Gson().toJson(landform);
	}

	// 提供给mybitas使用，这样从数据库读取json也会转换回Landform类型
	public void setLandform(String mapJson) {
		Gson gson = new Gson();
		landform = gson.fromJson(mapJson, new TypeToken<Landform[][]>() {

			private static final long serialVersionUID = 1L;
		}.getType());
	}

	public String getMapNo() {
		return mapNo;
	}

	public void setMapNo(String mapNo) {
		this.mapNo = mapNo;
	}

	@Override
	public String toString() {
		StringBuffer buff = new StringBuffer("[GameMap[" + mapNo + "] start:\n");
		buff.append("	[mapArry start:\n");

		buff.append("	[landform start:\n");
		for (int i = 0; i < landform.length; i++) {
			buff.append("		");
			for (int j = 0; j < landform[i].length; j++) {
				if (j != 0) {
					buff.append(",");
				}
				buff.append(landform[i][j]);
			}
			buff.append("\n");
		}
		buff.append("	landform end]\n");
		buff.append("GameMap[" + mapNo + "] end]\n");
		return buff.toString();
	}

}
