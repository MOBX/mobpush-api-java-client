package mob.push.api.utils;

/**
 * 推送消息类型
 * hlliu@youzu.com
 */
public enum PushTypeEnum {
	
	notify(1,"通知"),
	custom(2,"自定义消息") ;
	
	private Integer code;
	
	private String desc;
	
	PushTypeEnum(Integer code ,String desc){
		this.desc = desc;
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}
 
}
