package acl;

public class AclEntity {
	private String aclName;
	private String src_ip;
	private String dst_ip;
	private String protoco;
	private String src_port;
	private String dst_port;
	private String priority;
	private String action;

	public AclEntity(String aclName, String src_ip, String dst_ip,
			String protoco, String src_port, String dst_port, String priority,
			String action) {
		// TODO Auto-generated constructor stub
		this.aclName=aclName;
		this.src_ip=src_ip;
		this.dst_ip=dst_ip;
		this.protoco=protoco;
		this.src_port=src_port;
		this.dst_port=dst_port;
		this.priority=priority;
	}

	public String getAclName() {
		return aclName;
	}

	public void setAclName(String aclName) {
		this.aclName = aclName;
	}

	public String getSrc_ip() {
		return src_ip;
	}

	public void setSrc_ip(String src_ip) {
		this.src_ip = src_ip;
	}

	public String getDst_ip() {
		return dst_ip;
	}

	public void setDst_ip(String dst_ip) {
		this.dst_ip = dst_ip;
	}

	public String getProtoco() {
		return protoco;
	}

	public void setProtoco(String protoco) {
		this.protoco = protoco;
	}

	public String getSrc_port() {
		return src_port;
	}

	public void setSrc_port(String src_port) {
		this.src_port = src_port;
	}

	public String getDst_port() {
		return dst_port;
	}

	public void setDst_port(String dst_port) {
		this.dst_port = dst_port;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

}
