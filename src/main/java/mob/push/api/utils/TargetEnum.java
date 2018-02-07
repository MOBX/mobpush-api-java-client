package mob.push.api.utils;

/**
 * 推送范围选项 
 * hlliu@youzu.com
 * 推送范围:1广播；2别名；3标签；4regid；5地理位置；6用户分群
 */
public enum TargetEnum {
	 
	/**
	 * 广播
	 */
	_1(1,"广播"),
	/**
	 * 别名
	 */
	_2(2,"别名"),
	/**
	 * 标签
	 */
	_3(3,"标签"),
	/**
	 * 用户RegId
	 */
	_4(4,"用户RegId"),
	/**
	 * 地理位置
	 */
	_5(5,"地理位置"),
	
	/**
	 * 用户分群
	 */
	_6(6,"用户分群");
	
	private int code;
	
	private String desc;
	
	TargetEnum(int code ,String desc){
		this.desc = desc;
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

 
}
