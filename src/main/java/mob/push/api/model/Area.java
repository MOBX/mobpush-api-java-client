package mob.push.api.model;

/**
 * 地理位置信息
 */
public class Area{
	
	/**
	 * id: 地理位置ID
	 */
	private String id; 
	
	/**
	 * city: 城市信息
	 */
	private String city;
	
	/**
	 * country: 国家
	 */
	private String country;
	
	/**
	 * province: 省份
	 */
	private String province;
	 
	/**
	 * parentId: 上级ID 
	 */
	private String parentId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	 
}
