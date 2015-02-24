package acl;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Acl {
	private static Acl instanceAcl;
	private Hashtable<String, List<AclEntity>> hashtable;
	private boolean access;
	public static Acl getInstance(){
		if (instanceAcl==null) {
			return new Acl();
		}
		else return instanceAcl;
	}
	private Acl() {
		// TODO Auto-generated constructor stub
		hashtable=new Hashtable<>();
		access=true;
	}
	
	public boolean Acl_list_create(String name,String action){
		if (hashtable.containsKey(name)) {
			return false;
		}
		else {
			List<AclEntity> list=new ArrayList<AclEntity>();
			hashtable.put(name, list);
			return true;
		}
	}
	
	public boolean Acl_add_rule(String ACLNAME,String SRC_IP_PREFIX, String DST_IP_PREFIX, 
			String PROTO,String SRC_PORT,String DST_PORT,String PRIORITY,String ACTION){
		if (!hashtable.contains(ACLNAME)) {
			return false;
		}
		else{
			List<AclEntity> list=hashtable.get(ACLNAME);
			AclEntity aclEntity=new AclEntity(ACLNAME,SRC_IP_PREFIX, DST_IP_PREFIX, PROTO, SRC_PORT, DST_PORT, PRIORITY,ACTION);
			list.add(aclEntity);
			return true;
		}
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
