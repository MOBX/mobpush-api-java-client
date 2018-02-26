/**
 * Project Name:Project Name:mobpush-api-java-client
 * File Name:MobPushConfig.java
 * Package Name:mob.push.api
 * Date: 2018年2月2日
 * Time: 下午6:11:51
 *
*/

package mob.push.api;
/**
 * ClassName:MobPushConfig
 * MobPush WebApi Java Client Base Config 
 */
public class MobPushConfig {
	
	/**
	 * appkey: 需要先设置此数据，怎样获取appkey请至http://www.mob.com官网
	 */
	public static String appkey ;
	
	/**
	 * appSecret: appkey对应密钥,需要先设置此数据
	 */
	public static String appSecret ;
	
	/** 
	 * baseUrl: webapi http 接口基础url
	 */
	public static final String baseUrl = "http://api.push.mob.com";
	
	/**
	 * deviceUrl: 设备操作类接口基础URL
	 */
	public static final String deviceUrl = "http://api.push.mob.com";
	
	/**
	 * pushUrl: 推送操作接口基础URL
	 */
	public static final String pushUrl = "http://api.push.mob.com";
	
	/**
	 * statsUrl: 推送任务统计接口基础URL
	 */
	public static final String statsUrl = "http://api.push.mob.com";

}

