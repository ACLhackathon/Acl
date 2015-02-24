package acl;

import java.util.Hashtable;
import java.util.List;

public class Acl {
	private Hashtable<String, List<AclEntity>> hashtable;
	private boolean access;
	public Acl() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean Acl_list_create(String name,String action){
		return false;
	}
	
	public boolean Acl_add_rule(String ACLNAME,String SRC_IP_PREFIX, String DST_IP_PREFIX, 
			String PROTO,String SRC_PORT,String DST_PORT,String PRIORITY,String ACTION){
		
		return false;
	}
	public void Acl_check_packet(String ACLNAME, String SRC_IP,String DST_IP,String PROTO,String SRC_PORT,String DST_PORT){
		
	}
	public void Acl_del_rule(String ACLNAME,String PRIO){
		
	}
	public void Acl_list_delete(String NAME){
		
	}
	public void Acl_show_rules(String ACLNAME,String FILENAME){
		
	}
	public void Acl_show_all (String FILENAME){
		
	}
	
}
