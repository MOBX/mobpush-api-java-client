/**
 * Project Name:mobpush-api-java-client
 * File Name:MobPushClient.java
 * Package Name:mob.push.api
 * Date: 2018年2月2日
 * Time: 下午6:11:41
 *
*/

package mob.push.api;

import java.util.List;

import mob.push.api.area.AreaClient;
import mob.push.api.device.DeviceClient;
import mob.push.api.exception.ApiException;
import mob.push.api.model.Area;
import mob.push.api.model.PushStats;
import mob.push.api.model.PushWork;
import mob.push.api.push.PushClient;
import mob.push.api.stats.StatsClient;

/**
 * ClassName:MobPushClient <br/>
 * TODO ADD DESCRIPTION
 * Date: 2018年2月2日
 * Time: 下午6:11:41
 * @author   hlliu 	 
 */
public class MobPushClient {

	PushClient _pushClient = new PushClient();
	
	StatsClient _statsClient = new StatsClient();
	
	DeviceClient _deviceClient = new DeviceClient();
	
	AreaClient _areaClient = new AreaClient();
	
	
	/**
	 * 推送接口 -- 发送推送
	 * @param pushWork
	 * @return
	 * @throws ApiException
	 */
	public String push(PushWork pushWork) throws ApiException{
		return _pushClient.sendPush(pushWork);
	}
	
	/**
	 * 推送接口 -- 查询推送 根据BatchId
	 * 根据创建id查询推送消息详情
	 * @param batchId
	 * @return
	 * @throws ApiException
	 */
	public PushWork pushById(String batchId) throws ApiException{
		return _pushClient.getPushByBatchId(batchId);
	}
	
	/**
	 * 推送接口 -- 查询推送 根据workno
	 * 根据自定义编号查询消息详情
	 * @param workno
	 * @return
	 * @throws ApiException
	 */
	public PushWork pushByWorkno(String workno) throws ApiException{
		return _pushClient.getPushByWorkno(workno);
	}
	
	/**
	 * 推送统计-- 查询推送统计
	 * 根据创建id查询推送统计
	 * @param batchId
	 * @return
	 * @throws ApiException
	 */
	public PushStats statsById(String batchId) throws ApiException{
		return _statsClient.getStatsByBatchId(batchId);
	}
	
	/**
	 * 推送统计-- 查询推送统计
	 * 根据自定义编号查询推送统计
	 * @param workno
	 * @return
	 * @throws ApiException
	 */
	public PushStats statsByWorkno(String workno) throws ApiException{
		return _statsClient.getStatsByWorkno(workno);
	}
	
	/**
	 * 查询标签
	 * 根据设备registrationId查询标签信息
	 * @param registrationId
	 * @return
	 * @throws ApiException
	 */
	public String[] tagsByRegistrationId(String registrationId) throws ApiException{
		return _deviceClient.getDeviceTags(registrationId);
	}
	
	/**
	 * 设备绑定标签
	 * @param tags
	 * @param registrationId
	 * @return
	 * @throws ApiException
	 */
	public int tagsAdd(String[] tags, String registrationId) throws ApiException{
		return _deviceClient.addDeviceTags(tags, registrationId);
	}
	
	/**
	 * 删除指定设备标签
	 * @param tags
	 * @param registrationId
	 * @return
	 * @throws ApiException
	 */
	public int tagsRemove(String[] tags, String registrationId) throws ApiException{
		return _deviceClient.removeDeviceTags(tags, registrationId);
	}
	
	/**
	 * 清除指定标签
	 * @param registrationId
	 * @return
	 * @throws ApiException
	 */
	public int tagsClean(String registrationId) throws ApiException{
		return _deviceClient.cleanDeviceTags(registrationId);
	}
	
	/**
	 * 获取指定设备别名
	 * @param registrationId
	 * @return
	 * @throws ApiException
	 */
	public String aliasByRegistrationId(String registrationId) throws ApiException{
		return _deviceClient.getDeviceAlias(registrationId);
	}
	
	/**
	 * 设备绑定别名
	 * @param alias
	 * @param registrationId
	 * @return （仅200表示成功）
	 * @throws ApiException
	 */
	public int setAlias(String alias, String registrationId) throws ApiException{
		return _deviceClient.setDeviceAlias(alias, registrationId);
	}
	
	/**
	 * 清除设备别名
	 * @param registrationId
	 * @return
	 * @throws ApiException
	 */
	public int cleanAlias(String registrationId) throws ApiException{
		return _deviceClient.cleanDeviceAlias(registrationId);
	}
	
	/**
	 * 获取地理位置列表 -- 中国下省份列表
	 * @return
	 * @throws ApiException
	 */
	public List<Area> area() throws ApiException{
		return _areaClient.getArea();
	}
	
	/**
	 * 获取地理位置列表 -- 子级列表
	 * @param parentId
	 * @return
	 * @throws ApiException
	 */
	public List<Area> area(String parentId)throws ApiException{
		return _areaClient.getArea(parentId);
	}
}

