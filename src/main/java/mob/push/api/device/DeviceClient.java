/**
 * Project Name:mobpush-api-java-client
 * File Name:DeviceClient.java
 * Package Name:mob.push.api.device
 * Date: 2018年2月6日
 * Time: 上午10:45:21
 *
*/

package mob.push.api.device;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import mob.push.api.MobPushConfig;
import mob.push.api.exception.ApiException;
import mob.push.api.utils.HttpUtils;
import mob.push.api.utils.MobHelper;
import mob.push.api.utils.MobPushResult;

/**
 * ClassName:DeviceClient <br/>
 * 设备信息获取和设置，包含别名、标签
 * Date: 2018年2月6日
 * Time: 上午10:45:21
 * @author   hlliu 	 
 */
public class DeviceClient {

	/**
	 * 获取设备别名
	 * @param registrationId
	 * @return
	 * @throws ApiException
	 */
	public String getDeviceAlias(String registrationId) throws ApiException {
		if (registrationId == null || "".equals(registrationId.trim())) {
			throw new ApiException(MobHelper.HTTP_STATUS_400, -1, "registrationId is null");
		}
		String path = MobPushConfig.deviceUrl + "/alias/" + registrationId;
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
			return json.getString("alias");
		}
		return null;
	}

	/**
	 * 绑定设备别名，如果存在则覆盖原有别名
	 * @param alias
	 * @param registrationId
	 * @return
	 * @throws ApiException
	 */
	public int setDeviceAlias(String alias, String registrationId) throws ApiException {
		if (registrationId == null || "".equals(registrationId.trim())) {
			throw new ApiException(MobHelper.HTTP_STATUS_400, -1, "registrationId is null");
		}
		String path = MobPushConfig.deviceUrl + "/alias";

		JSONObject json = new JSONObject();
		json.put("registrationId", registrationId);
		json.put("alias", alias);

		HttpUtils.PostEntity entity = new HttpUtils.PostEntity(path, MobPushConfig.appkey, MobPushConfig.appSecret,
				json.toJSONString()).invoke(false);
		MobPushResult result = null;
		if (entity.getStatusCode() == MobHelper.HTTP_STATUS_200) {
			result = JSON.toJavaObject(JSON.parseObject(entity.getResp()), MobPushResult.class);
		} else {
			result = JSON.toJavaObject(JSON.parseObject(entity.getResp()), MobPushResult.class);
			throw new ApiException(entity.getStatusCode(), result.getStatus(), result.getError());
		}
		return result.getStatus();
	}
	
	/**
	 * 清空设备别名
	 * @param registrationId
	 * @return
	 * @throws ApiException
	 */
	public int cleanDeviceAlias(String registrationId) throws ApiException {
		if (registrationId == null || "".equals(registrationId.trim())) {
			throw new ApiException(MobHelper.HTTP_STATUS_400, -1, "registrationId is null");
		}
		String path = MobPushConfig.deviceUrl + "/alias";

		JSONObject json = new JSONObject();
		json.put("registrationId", registrationId);
		json.put("alias", "");

		HttpUtils.PostEntity entity = new HttpUtils.PostEntity(path, MobPushConfig.appkey, MobPushConfig.appSecret,
				json.toJSONString()).invoke(false);
		MobPushResult result = null;
		if (entity.getStatusCode() == MobHelper.HTTP_STATUS_200) {
			result = JSON.toJavaObject(JSON.parseObject(entity.getResp()), MobPushResult.class);
		} else {
			result = JSON.toJavaObject(JSON.parseObject(entity.getResp()), MobPushResult.class);
			throw new ApiException(entity.getStatusCode(), result.getStatus(), result.getError());
		}
		return result.getStatus();
	}

	/**
	 * 获取设备标签
	 * @param registrationId
	 * @return
	 * @throws ApiException
	 */
	public String[] getDeviceTags(String registrationId) throws ApiException {
		if (registrationId == null || "".equals(registrationId.trim())) {
			throw new ApiException(MobHelper.HTTP_STATUS_400, -1, "registrationId is null");
		}
		String path = MobPushConfig.deviceUrl + "/tags/" + registrationId;
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
			if (json == null) {
				return null;
			}
			JSONArray array = json.getJSONArray("tags");
			if (array == null || array.isEmpty()) {
				return null;
			}
			String[] tags = new String[array.size()];
			return array.toArray(tags);
		}
		return null;
	}

	/**
	 * 设备绑定标签
	 * @param tags
	 * @param registrationId
	 * @return
	 * @throws ApiException
	 */
	public int addDeviceTags(String[] tags, String registrationId) throws ApiException {
		if (registrationId == null || "".equals(registrationId.trim())) {
			throw new ApiException(MobHelper.HTTP_STATUS_400, -1, "registrationId is null");
		}
		if (tags == null || tags.length < 1) {
			throw new ApiException(MobHelper.HTTP_STATUS_400, -1, "tags is null");
		}
		String path = MobPushConfig.deviceUrl + "/tags";

		JSONObject json = new JSONObject();
		json.put("registrationId", registrationId);
		json.put("tags", tags);
		json.put("opType", 1);

		HttpUtils.PostEntity entity = new HttpUtils.PostEntity(path, MobPushConfig.appkey, MobPushConfig.appSecret,
				json.toJSONString()).invoke(false);
		MobPushResult result = null;
		if (entity.getStatusCode() == MobHelper.HTTP_STATUS_200) {
			result = JSON.toJavaObject(JSON.parseObject(entity.getResp()), MobPushResult.class);
		} else {
			result = JSON.toJavaObject(JSON.parseObject(entity.getResp()), MobPushResult.class);
			throw new ApiException(entity.getStatusCode(), result.getStatus(), result.getError());
		}
		return result.getStatus();
	}

	/**
	 * 删除设备制定标签
	 * @param tags
	 * @param registrationId
	 * @return
	 * @throws ApiException
	 */
	public int removeDeviceTags(String[] tags, String registrationId) throws ApiException {
		if (registrationId == null || "".equals(registrationId.trim())) {
			throw new ApiException(MobHelper.HTTP_STATUS_400, -1, "registrationId is null");
		}
		if (tags == null || tags.length < 1) {
			throw new ApiException(MobHelper.HTTP_STATUS_400, -1, "tags is null");
		}
		String path = MobPushConfig.deviceUrl + "/tags";

		JSONObject json = new JSONObject();
		json.put("registrationId", registrationId);
		json.put("tags", tags);
		json.put("opType", 2);

		HttpUtils.PostEntity entity = new HttpUtils.PostEntity(path, MobPushConfig.appkey, MobPushConfig.appSecret,
				json.toJSONString()).invoke(false);
		MobPushResult result = null;
		if (entity.getStatusCode() == MobHelper.HTTP_STATUS_200) {
			result = JSON.toJavaObject(JSON.parseObject(entity.getResp()), MobPushResult.class);
		} else {
			result = JSON.toJavaObject(JSON.parseObject(entity.getResp()), MobPushResult.class);
			throw new ApiException(entity.getStatusCode(), result.getStatus(), result.getError());
		}
		return result.getStatus();
	}

	/**
	 * 清空设备标签
	 * @param registrationId
	 * @return
	 * @throws ApiException
	 */
	public int cleanDeviceTags(String registrationId) throws ApiException {
		if (registrationId == null || "".equals(registrationId.trim())) {
			throw new ApiException(MobHelper.HTTP_STATUS_400, -1, "registrationId is null");
		}
		String path = MobPushConfig.deviceUrl + "/tags";
		JSONObject json = new JSONObject();
		json.put("registrationId", registrationId);
		json.put("opType", 3);

		HttpUtils.PostEntity entity = new HttpUtils.PostEntity(path, MobPushConfig.appkey, MobPushConfig.appSecret,
				json.toJSONString()).invoke(false);
		MobPushResult result = null;
		if (entity.getStatusCode() == MobHelper.HTTP_STATUS_200) {
			result = JSON.toJavaObject(JSON.parseObject(entity.getResp()), MobPushResult.class);
		} else {
			result = JSON.toJavaObject(JSON.parseObject(entity.getResp()), MobPushResult.class);
			throw new ApiException(entity.getStatusCode(), result.getStatus(), result.getError());
		}
		return result.getStatus();
	}

}
