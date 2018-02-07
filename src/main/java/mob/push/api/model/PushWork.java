/**
 * Project Name:mobpush-api-java-client
 * File Name:PushWork.java
 * Package Name:mob.push.api.model
 * Date: 2018年2月6日
 * Time: 下午3:49:05
 *
*/

package mob.push.api.model;

import mob.push.api.utils.AndroidNotifyStyleEnum;
import mob.push.api.utils.MobHelper;
import mob.push.api.utils.TargetEnum;

/**
 * ClassName:PushWork <br/>
 * MobPush 推送实体
 * Date: 2018年2月6日
 * Time: 下午3:49:05
 * @author   hlliu 	 
 */
public class PushWork {

	/**
	 * id: MobPush 生产唯一编号
	 */
	public String id;

	/**
	 * appkey: 应用APPKEY
	 */
	public String appkey;

	/**
	 * workno:调用方提供的唯一编号，需要在当前appkey下唯一不可重复
	 */
	public String workno;

	/**
	 * plats：接受平台，1、android ； 2、ios ；如包含ios和android则为[1,2]
	 */
	public Integer[] plats;

	/**
	 * iosProduction:plat = 2下，0测试环境，1生产环境，默认1
	 */
	public Integer iosProduction = 1;

	/**
	 * target:推送范围:1广播；2别名；3标签；4regid；5地理位置;6用户分群
	 * TargetEnum
	 */
	public Integer target;

	/**
	 * tags:设置推送标签集合["tag1","tag2"]，target=2则必选
	 */
	public String[] tags;

	/**
	 * alias: 设置推送别名集合["alias1","alias2"]，target=3则必选
	 */
	public String[] alias;

	/**
	 * registrationIds:设置推送Registration Id集合["id1","id2"]，target=4则必选
	 */
	public String[] registrationIds;

	/**
	 * city: 推送地理位置(城市)，target=5则必选
	 */
	public String city;

	/**
	 * block: 用户分群ID，target=6则必选
	 */
	public String block;

	/**
	 * content: 推送内容
	 */
	public String content;

	/**
	 * unlineTime: 离线时间为0，或者在1~10天以内，单位天， 默认1天
	 */
	public Integer unlineTime = 1;

	/**
	 * type: 推送类型：1通知；2自定义
	 * PushTypeEnum
	 */
	public Integer type;

	/**
	 * extras:附加字段键值对的方式，扩展数据 json
	 */
	public String extras;

	/**
	 * 推送任务状态：0删除；1创建中；2正在发送；3部分发送完成；4发送完成；5发送失败；6停止发送； WorkDetailStatusEnum
	 */
	private Integer status;

	/**
	 * 是否重新发送,true是，默认false否
	 */
	private Boolean repate;
  
	/**
	 * 通知标题
	 */
	private String androidTitle;

	/**
	 * 显示样式标识
	 */
	private Integer androidstyle = AndroidNotifyStyleEnum.normal.getCode();

	/**
	 * content:样式具体内容： 0、默认通知无； 1、长内容则为内容数据； 2、大图则为图片地址； 3、横幅则为多行内容
	 */
	private String[] androidContent;

	/**
	 * warn:  提醒类型： 提示音； 
	 */
	private Boolean androidVoice;

	/**
	 * androidShake:震动
	 */
	private Boolean androidShake;

	/**
	 * androidLight:指示灯
	 */
	private Boolean androidLight;

	/**
	 * 标题- 不填写则为应用名称
	 */
	private String iosTitle;

	/**
	 * 副标题
	 */
	private String iosSubtitle;

	/**
	 * APNs通知，通过这个字段指定声音。默认为default，即系统默认声音。 如果设置为空值，则为静音。
	 * 如果设置为特殊的名称，则需要你的App里配置了该声音才可以正常。
	 */
	private String iosSound = "default";

	/**
	 * 可直接指定 APNs 推送通知的 badge，直接展示在桌面应用图标的右上角，含义是应用未读的消息数。也支持如 +12，-3 等运算操作，
	 * 会针对每一个用户当前的 badge 做单独的运算，例：接受者 A，B 的角标分别为 1 和 2，那么推送 +2 后 A的角标变为 3，B 的角标变为 4。默认值为 1。
	 */
	private Integer iosBadge = 1;

	/**
	 * 只有IOS8及以上系统才支持此参数推送
	 */
	private String iosCategory;

	/**
	 * 如果只携带content-available: 1,不携带任何badge，sound 和消息内容等参数，
	 * 则可以不打扰用户的情况下进行内容更新等操作即为“Silent Remote Notifications”。
	 */
	private Integer iosSlientPush;

	private Integer iosContentAvailable;

	/**
	 * 需要在附加字段中配置相应参数
	 */
	private Integer iosMutableContent;
	
	public PushWork(){
		
	}
	
	public PushWork(Integer[] plats,String content,Integer type){
		this.plats = plats;
		this.content = content;
		this.type = type;
	}
	
	public PushWork(String workno, Integer[] plats,String content,Integer type){ 
		this.workno = workno;
		this.plats = plats;
		this.content = content;
		this.type = type;
	}
	 
	public PushWork(String appkey, String workno, Integer[] plats,String content,Integer type){
		this.appkey = appkey;
		this.workno = workno;
		this.plats = plats;
		this.content = content;
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAppkey() {
		return appkey;
	}

	public void setAppkey(String appkey) {
		this.appkey = appkey;
	}

	public String getWorkno() {
		return workno;
	}

	public void setWorkno(String workno) {
		this.workno = workno;
	}

	public Integer[] getPlats() {
		return plats;
	}

	public void setPlats(Integer[] plats) {
		this.plats = plats;
	}

	public Integer getIosProduction() {
		return iosProduction;
	}

	public void setIosProduction(Integer iosProduction) {
		this.iosProduction = iosProduction;
	}

	public Integer getTarget() {
		return target;
	}

	public void setTarget(Integer target) {
		this.target = target;
	}

	public String[] getTags() {
		return tags;
	}

	public void setTags(String[] tags) {
		this.tags = tags;
	}

	public String[] getAlias() {
		return alias;
	}

	public void setAlias(String[] alias) {
		this.alias = alias;
	}

	public String[] getRegistrationIds() {
		return registrationIds;
	}

	public void setRegistrationIds(String[] registrationIds) {
		this.registrationIds = registrationIds;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getBlock() {
		return block;
	}

	public void setBlock(String block) {
		this.block = block;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getUnlineTime() {
		return unlineTime;
	}

	public void setUnlineTime(Integer unlineTime) {
		this.unlineTime = unlineTime;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getExtras() {
		return extras;
	}

	public void setExtras(String extras) {
		this.extras = extras;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Boolean getRepate() {
		return repate;
	}

	public void setRepate(Boolean repate) {
		this.repate = repate;
	} 
	
	public String getAndroidTitle() {
		return androidTitle;
	}

	public void setAndroidTitle(String androidTitle) {
		this.androidTitle = androidTitle;
	}

	public Integer getAndroidstyle() {
		return androidstyle;
	}

	public void setAndroidstyle(Integer androidstyle) {
		this.androidstyle = androidstyle;
	}

	public String[] getAndroidContent() {
		return androidContent;
	}

	public void setAndroidContent(String[] androidContent) {
		this.androidContent = androidContent;
	}

	public Boolean getAndroidVoice() {
		return androidVoice;
	}

	public void setAndroidVoice(Boolean androidVoice) {
		this.androidVoice = androidVoice;
	}

	public Boolean getAndroidShake() {
		return androidShake;
	}

	public void setAndroidShake(Boolean androidShake) {
		this.androidShake = androidShake;
	}

	public Boolean getAndroidLight() {
		return androidLight;
	}

	public void setAndroidLight(Boolean androidLight) {
		this.androidLight = androidLight;
	}

	public String getIosTitle() {
		return iosTitle;
	}

	public void setIosTitle(String iosTitle) {
		this.iosTitle = iosTitle;
	}

	public String getIosSubtitle() {
		return iosSubtitle;
	}

	public void setIosSubtitle(String iosSubtitle) {
		this.iosSubtitle = iosSubtitle;
	}

	public String getIosSound() {
		return iosSound;
	}

	public void setIosSound(String iosSound) {
		this.iosSound = iosSound;
	}

	public Integer getIosBadge() {
		return iosBadge;
	}

	public void setIosBadge(Integer iosBadge) {
		this.iosBadge = iosBadge;
	}

	public String getIosCategory() {
		return iosCategory;
	}

	public void setIosCategory(String iosCategory) {
		this.iosCategory = iosCategory;
	}

	public Integer getIosSlientPush() {
		return iosSlientPush;
	}

	public void setIosSlientPush(Integer iosSlientPush) {
		this.iosSlientPush = iosSlientPush;
	}

	public Integer getIosContentAvailable() {
		return iosContentAvailable;
	}

	public void setIosContentAvailable(Integer iosContentAvailable) {
		this.iosContentAvailable = iosContentAvailable;
	}

	public Integer getIosMutableContent() {
		return iosMutableContent;
	}

	public void setIosMutableContent(Integer iosMutableContent) {
		this.iosMutableContent = iosMutableContent;
	}
	
	/**
	 * 设置扩展信息
	 * @param unlineTime
	 * @param extras
	 * @param iosProduction
	 * @return
	 */
	public PushWork buildExtra(Integer unlineTime,String extras,Integer iosProduction){
		if(unlineTime != null)
			this.unlineTime = unlineTime;
		if(MobHelper.isNotBlank(extras))
			this.extras = extras;
		if(iosProduction != null)
			this.iosProduction = iosProduction;
		return this;
	}
	 
	/**
	 * 设置推送范围
	 * @param target
	 * @param tags
	 * @param alias
	 * @param registrationIds
	 * @param city
	 * @param block
	 * @return
	 */
	public PushWork buildTarget(Integer target, String[] tags,String[] alias,String[] registrationIds,String city,String block){
		if(target == null || target.intValue() == TargetEnum._1.getCode()){
			this.target = target;
			return this;
		}
		if(target.intValue() == TargetEnum._2.getCode() && alias != null){
			this.alias = alias;
		}else if(target.intValue() == TargetEnum._3.getCode() && tags != null){
			this.tags = tags;
		}if(target.intValue() == TargetEnum._4.getCode() && registrationIds != null){
			this.registrationIds = registrationIds;
		}if(target.intValue() == TargetEnum._5.getCode() && MobHelper.isNotBlank(city)){
			this.city = city;
		}if(target.intValue() == TargetEnum._6.getCode() && MobHelper.isNotBlank(block)){
			this.block = block;
		}
		return this;
	}

	/**
	 * 设置Android信息
	 * @param androidTitle
	 * @param androidstyle
	 * @param androidContent
	 * @param androidVoice
	 * @param androidShake
	 * @param androidLight
	 * @return
	 */
	public PushWork buildAndroid(String androidTitle, Integer androidstyle, String[] androidContent,
			Boolean androidVoice, Boolean androidShake, Boolean androidLight) {
		if (MobHelper.isNotBlank(androidTitle))
			this.androidTitle = androidTitle;
		if (androidstyle != null)
			this.androidstyle = androidstyle;
		if (androidContent != null)
			this.androidContent = androidContent;
		if (androidVoice != null)
			this.androidVoice = androidVoice;
		if (androidShake != null)
			this.androidShake = androidShake;
		if (androidLight != null)
			this.androidLight = androidLight;
		return this;
	}

	/**
	 * 设置IOS信息
	 * @param iosTitle
	 * @param iosSubtitle
	 * @param iosSound
	 * @param iosBadge
	 * @param iosCategory
	 * @param iosSlientPush
	 * @param iosContentAvailable
	 * @param iosMutableContent
	 * @return
	 */
	public PushWork bulidIos(String iosTitle, String iosSubtitle, String iosSound, Integer iosBadge, String iosCategory,
			Integer iosSlientPush, Integer iosContentAvailable, Integer iosMutableContent) {
		if (MobHelper.isNotBlank(iosTitle))
			this.iosTitle = iosTitle;
		if (MobHelper.isNotBlank(iosSubtitle))
			this.iosSubtitle = iosSubtitle;
		if (MobHelper.isNotBlank(iosSound))
			this.iosSound = iosSound;
		if (iosBadge != null)
			this.iosBadge = iosBadge;
		if (MobHelper.isNotBlank(iosCategory))
			this.iosCategory = iosCategory;
		if (iosSlientPush != null)
			this.iosSlientPush = iosSlientPush;
		if (iosContentAvailable != null)
			this.iosContentAvailable = iosContentAvailable;
		if (iosMutableContent != null)
			this.iosMutableContent = iosMutableContent;
		return this;
	}
}
