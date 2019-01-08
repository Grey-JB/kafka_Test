package com.grey.po;

public class Count {
	private Long id;
	private String sys;
	private String broser;
	private String ipAddress;
	private String time;

	@Override
	public String toString() {
		return "Count [id=" + id + ", sys=" + sys + ", broser=" + broser + ", ipAddress=" + ipAddress + ", time=" + time
				+ "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSys() {
		return sys;
	}

	public void setSys(String sys) {
		this.sys = sys;
	}

	public String getBroser() {
		return broser;
	}

	public void setBroser(String broser) {
		this.broser = broser;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

}
