package mob.push.api.model;

import java.io.Serializable;

public class PushStats implements Serializable{
	
	private String id;

	/**
	 * 第三方ID
	 */
	private String workno;

	/**
	 * 应用APPKEY
	 */
	private String appkey;

	/**
	 * 取消推送数 – android
	 */
	private Long androidCancelNum;

	/**
	 * 取消推送数 – ios
	 */
	private Long iosCancelNum;

	/**
	 * 已完成推送数--android
	 */
	private Long androidSuccessNum;

	/**
	 * 已完成推送数--ios
	 */
	private Long iosSuccessNum;

	/**
	 * 推送目标设备数量 – android
	 */
	private Long androidDeviceNum;

	/**
	 * Androi 回执数
	 */
	private Long androidReportNum;

	/**
	 * IOS 回执数
	 */
	private Long iosReportNum;

	/**
	 * 推送目标设备数量 – ios
	 */
	private Long iosDeviceNum;

	/**
	 * 点击数量，通知消息点击数量--android
	 */
	private Long androidClickNum;

	/**
	 * 点击数量，通知消息点击数量--ios
	 */
	private Long iosClickNum;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getWorkno() {
		return workno;
	}

	public void setWorkno(String workno) {
		this.workno = workno;
	}

	public String getAppkey() {
		return appkey;
	}

	public void setAppkey(String appkey) {
		this.appkey = appkey;
	}

	public Long getAndroidCancelNum() {
		return androidCancelNum;
	}

	public void setAndroidCancelNum(Long androidCancelNum) {
		this.androidCancelNum = androidCancelNum;
	}

	public Long getIosCancelNum() {
		return iosCancelNum;
	}

	public void setIosCancelNum(Long iosCancelNum) {
		this.iosCancelNum = iosCancelNum;
	}

	public Long getAndroidSuccessNum() {
		return androidSuccessNum;
	}

	public void setAndroidSuccessNum(Long androidSuccessNum) {
		this.androidSuccessNum = androidSuccessNum;
	}

	public Long getIosSuccessNum() {
		return iosSuccessNum;
	}

	public void setIosSuccessNum(Long iosSuccessNum) {
		this.iosSuccessNum = iosSuccessNum;
	}

	public Long getAndroidDeviceNum() {
		return androidDeviceNum;
	}

	public void setAndroidDeviceNum(Long androidDeviceNum) {
		this.androidDeviceNum = androidDeviceNum;
	}

	public Long getAndroidReportNum() {
		return androidReportNum;
	}

	public void setAndroidReportNum(Long androidReportNum) {
		this.androidReportNum = androidReportNum;
	}

	public Long getIosReportNum() {
		return iosReportNum;
	}

	public void setIosReportNum(Long iosReportNum) {
		this.iosReportNum = iosReportNum;
	}

	public Long getIosDeviceNum() {
		return iosDeviceNum;
	}

	public void setIosDeviceNum(Long iosDeviceNum) {
		this.iosDeviceNum = iosDeviceNum;
	}

	public Long getAndroidClickNum() {
		return androidClickNum;
	}

	public void setAndroidClickNum(Long androidClickNum) {
		this.androidClickNum = androidClickNum;
	}

	public Long getIosClickNum() {
		return iosClickNum;
	}

	public void setIosClickNum(Long iosClickNum) {
		this.iosClickNum = iosClickNum;
	}
	
}
