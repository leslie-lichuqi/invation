package Dao;

/**
 * Invation entity. @author MyEclipse Persistence Tools
 */

public class Invation implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String weixin;
	private String tel;
	private String area;
	private String createdate;

	// Constructors

	/** default constructor */
	public Invation() {
	}

	@Override
	public String toString() {
		return "Invation [id=" + id + ", name=" + name + ", weixin=" + weixin
				+ ", tel=" + tel + ", area=" + area + ", createdate="
				+ createdate + "]";
	}

	/** full constructor */
	public Invation(String name, String weixin, String tel, String area,
			String createdate) {
		this.name = name;
		this.weixin = weixin;
		this.tel = tel;
		this.area = area;
		this.createdate = createdate;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWeixin() {
		return this.weixin;
	}

	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

}