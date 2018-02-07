/**
 * Project Name:mobpush-api-java-client
 * File Name:MobPushTest.java
 * Package Name:org.mob.push.client
 * Date: 2018年2月7日
 * Time: 下午12:31:00
 *
*/

package mob.push.client;
  
/**
 * ClassName:MobPushTest <br/>
 * PushClient TEST
 * Date: 2018年2月7日
 * Time: 下午12:31:00 
 */
public class MobPushTest {
	
	/*@Test
	public void client(){
		MobPushConfig.appkey = "moba6b6c6d6";
		MobPushConfig.appSecret = "";
		
		PushWork push = new PushWork(PlatEnum.all.getCode(),"test content" , PushTypeEnum.notify.getCode()) //初始化基础信息
				.buildTarget(TargetEnum._1.getCode(), null, null, null, null, null)  // 设置推送范围
				.buildAndroid("Android Title", AndroidNotifyStyleEnum.normal.getCode(), null, true, true, true) //定制android样式
				.bulidIos("ios Title", "ios Subtitle", null, 1, null, null, null, null) //定制ios设置
				.buildExtra(1, "{\"key1\":\"value\"}", 1) // 设置扩展信息
				;
		
		MobPushClient client = new MobPushClient();	
		try {
			String str = client.push(push);
			System.out.println(str);
		} catch (ApiException e) {
			e.getStatus();	   	   //错误请求状态码
			e.getErrorCode();	   //错误状态码
			e.getErrorMessage();   //错误信息 
		}
	}
	*/
}

