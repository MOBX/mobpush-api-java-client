package mob.push.api.utils;

 
/**
 * Android 通知显示样式
 * @author hlliu
 * Date: 2018年2月6日
 * Time: 下午4:01:09
 */
public enum AndroidNotifyStyleEnum {
	normal(0,"普通通知"),
	bigtext(1,"BigTextStyle通知，点击后显示大段文字内容"),
	bigpicture(2,"BigPictureStyle，大图模式"),
	hangup(3,"横幅通知"); 
	
	private int code;
	
	private String desc;
	
	AndroidNotifyStyleEnum(int code ,String desc){
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
