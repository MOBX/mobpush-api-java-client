/**
 * Project Name:mobpush-api-java-client
 * File Name:StatsClient.java
 * Package Name:mob.push.api.stats
 * Date: 2018年2月6日
 * Time: 上午10:45:21
 *
*/
package mob.push.api.stats;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import mob.push.api.MobPushConfig;
import mob.push.api.exception.ApiException;
import mob.push.api.model.PushWork;
import mob.push.api.model.PushStats;
import mob.push.api.utils.MobHelper;
import mob.push.api.utils.HttpUtils;
import mob.push.api.utils.MobPushResult;
 
/**
 * ClassName:StatsClient
 * 获取统计数据接口
 */
public class StatsClient {
	 
	 
	/**
	 * 获取统计数据(根据batchId查询)
	 * @param batchId
	 * @return PushStats
	 * @throws ApiException
	 */
	public PushStats getStatsByBatchId(String batchId) throws ApiException{
		if (batchId == null || "".equals(batchId.trim())) {
			throw new ApiException(MobHelper.HTTP_STATUS_400, -1, "batchId is null");
		}
		String path = MobPushConfig.statsUrl + "/stats/id/" + batchId;
		return this.pullStats(path);
	}
	
	/**
	 * 获取统计数据(根据workno查询)
	 * @param workno
	 * @return PushStats
	 * @throws ApiException
	 */
	public PushStats getStatsByWorkno(String workno) throws ApiException{
		if (workno == null || "".equals(workno.trim())) {
			throw new ApiException(MobHelper.HTTP_STATUS_400, -1, "workno is null");
		}
		String path = MobPushConfig.statsUrl + "/stats/workno/" + workno;
		return this.pullStats(path);
	}
	
	/**
	 * 拉取推送任务统计
	 * @param path
	 * @return PushStats
	 * @throws ApiException
	 */
	private PushStats pullStats(String path) throws ApiException{
		HttpUtils.GetEntity entity = new HttpUtils.GetEntity(path, MobPushConfig.appkey, MobPushConfig.appSecret, null)
				.invoke();
		MobPushResult result = null;
		if (entity.getStatusCode() == MobHelper.HTTP_STATUS_200) {
			result = JSON.toJavaObject(JSON.parseObject(entity.getResp()), MobPushResult.class);
		} else {
			result = JSON.toJavaObject(JSON.parseObject(entity.getResp()), MobPushResult.class);
			throw new ApiException(entity.getStatusCode(), result.getStatus(), result.getError());
		}
		if (result != null) {
			if (result.getRes() == null) {
				return null;
			}
			JSONObject json = (JSONObject) result.getRes();
			PushStats stats = json.toJavaObject(PushStats.class);
			return stats;
		}
		return null;
	}
	 
}
