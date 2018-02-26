/**
 * Project Name:mobpush-api-java-client
 * File Name:MobPushResult.java
 * Package Name:mob.push.api.utils
 * Date: 2018年2月5日
 * Time: 下午7:46:25
 *
*/

package mob.push.api.utils;

import java.io.Serializable;

/**
 * ClassName:MobPushResult
 * TODO MobPush HTTP 接口返回数据
 * Date: 2018年2月5日
 * Time: 下午7:46:25 
 */
public class MobPushResult implements Serializable{

	/**
	 * serialVersionUID:TODO FIELD DESCRIPTION
	 */
	private static final long serialVersionUID = 7077415779567577634L;

	/**
	 * status: 接口处理状态
	 */
	private int status;
	
	/**
	 * res: 接口处理返回内容
	 */
	private Object res;
	
	/**
	 * error:接口处理错误返回信息
	 */
	private String error;
	
	public MobPushResult(){
		
	}
	
	public MobPushResult(int status, String res){
		this.status = status;
		this.res = res;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
 
	public Object getRes() {
		return res;
	}

	public void setRes(Object res) {
		this.res = res;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
 
}

