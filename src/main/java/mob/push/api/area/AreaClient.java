/**
 * Project Name:mobpush-api-java-client
 * File Name:AreaClient.java
 * Package Name:mob.push.api.area
 * Date: 2018年2月5日
 * Time: 下午7:39:59
 *
*/
package mob.push.api.area;
  
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import mob.push.api.MobPushConfig;
import mob.push.api.exception.ApiException;
import mob.push.api.model.Area;
import mob.push.api.utils.HttpUtils;
import mob.push.api.utils.MobHelper;
import mob.push.api.utils.MobPushResult;

/**
 * ClassName:AreaClient <br/>
 * TODO 获取地理位置列表信息
 * Date: 2018年2月5日
 * Time: 下午7:39:59  
 */
public class AreaClient {
	 
	/**
	 * 获取地理位置列表 -- 中国下省份列表
	 * @return
	 * @throws ApiException 
	 */
	public List<Area> getArea() throws ApiException{
		return getArea(null);
	}
	
	/**
	 * 获取地理位置列表 -- 子级列表
	 * @param parentId 如果查询最上级则传入null即可
	 * @return
	 * @throws ApiException 
	 */
	public List<Area> getArea(String parentId) throws ApiException{  
		List<Area> list = new ArrayList<Area>();
		if(parentId == null || parentId.trim().equals("")){
			parentId = "0";
		} 
		String path = MobPushConfig.baseUrl+"/area/" + parentId; 
		HttpUtils.GetEntity entity = new HttpUtils.GetEntity(path , MobPushConfig.appkey, MobPushConfig.appSecret, null).invoke();
		MobPushResult  result = null;
		if(entity.getStatusCode() == MobHelper.HTTP_STATUS_200){
			result = JSON.toJavaObject(JSON.parseObject(entity.getResp()), MobPushResult.class);  
		} else {
			result = JSON.toJavaObject(JSON.parseObject(entity.getResp()), MobPushResult.class);  
			throw new ApiException(entity.getStatusCode(), result.getStatus(), result.getError());
		} 
		if(result != null){
			 if(result.getRes() == null){
				 return list;
			 }
			 list =  JSONArray.parseArray(JSON.toJSONString(result.getRes()), Area.class);
		} 
		return list;
	} 
}

