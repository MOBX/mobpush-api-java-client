package mob.push.api.utils;

 
/**
 * Android 提醒类型枚举
 * @author hlliu 
 */
public enum AndroidWarnEnum {
	
	voice("1","提示音"),
	shake("2","震动"),
	light("3","指示灯");
	
	private String code;
	private String desc;
	
	AndroidWarnEnum(String code, String desc){
		this.code = code;
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}
}
