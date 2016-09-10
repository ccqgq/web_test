package com.qgq.web.vo;

public class Cus_msg {
	private Integer id;
	//客户编号
	private String cus_id;
	//客户姓名
	private String name;
	//客户等级
	private String level;
	//所 属区域
	private String area;
	private Integer u_id;
	private String cus_dept;
	//客户所属行业
	private String cus_industy;
	//客户性质
	private String cus_type;
	public Cus_msg(Integer id, String cus_id, String name, String level,
			String area, Integer u_id, String cus_dept, String cus_industy,
			String cus_type) {
		super();
		this.id = id;
		this.cus_id = cus_id;
		this.name = name;
		this.level = level;
		this.area = area;
		this.u_id = u_id;
		this.cus_dept = cus_dept;
		this.cus_industy = cus_industy;
		this.cus_type = cus_type;
	}
	public Cus_msg() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCus_id() {
		return cus_id;
	}
	public void setCus_id(String cus_id) {
		this.cus_id = cus_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public Integer getU_id() {
		return u_id;
	}
	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}
	public String getCus_dept() {
		return cus_dept;
	}
	public void setCus_dept(String cus_dept) {
		this.cus_dept = cus_dept;
	}
	public String getCus_industy() {
		return cus_industy;
	}
	public void setCus_industy(String cus_industy) {
		this.cus_industy = cus_industy;
	}
	public String getCus_type() {
		return cus_type;
	}
	public void setCus_type(String cus_type) {
		this.cus_type = cus_type;
	}
	@Override
	public String toString() {
		return "Cus_msg [id=" + id + ", cus_id=" + cus_id + ", name=" + name
				+ ", level=" + level + ", area=" + area + ", u_id=" + u_id
				+ ", cus_dept=" + cus_dept + ", cus_industy=" + cus_industy
				+ ", cus_type=" + cus_type + "]";
	}
	
	
}
