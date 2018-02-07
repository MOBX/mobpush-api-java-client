package mob.push.api.utils;

/**
 * 设备系统平台
 * hlliu@youzu.com
 */
public enum PlatEnum {
	
	android(new Integer[]{1},"安卓"),
	ios(new Integer[]{2},"IOS"),
	all(new Integer[]{1,2},"全部平台") ;
	
	private Integer[] code;
	
	private String desc;
	
	PlatEnum(Integer[] code ,String desc){
		this.desc = desc;
		this.code = code;
	}

	public Integer[] getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}
 
}
