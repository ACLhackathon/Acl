package acl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class Acl {
	private static final byte[] FileOutputStream = null;
	private static Acl instanceAcl;
	private Map<String, List<AclEntity>> hashtable;
	private boolean access;

	public static Acl getInstance() {
		if (instanceAcl == null) {
			return new Acl();
		} else
			return instanceAcl;
	}

	private Acl() {
		// TODO Auto-generated constructor stub
		hashtable = new Hashtable<String, List<AclEntity>>();
		access = true;
	}

	public boolean Acl_list_create(String name, String action) {
		if (hashtable.containsKey(name)) {
			return false;
		} else {
			List<AclEntity> list = new ArrayList<AclEntity>();
			this.hashtable.put(name, list);
			return true;
		}
	}


	public boolean Acl_add_rule(String ACLNAME, String SRC_IP_PREFIX,
			String DST_IP_PREFIX, String PROTO, String SRC_PORT,
			String DST_PORT, String PRIORITY, String ACTION) {
		if (!hashtable.containsKey(ACLNAME)) {
			return false;
		} else {
			List<AclEntity> list = hashtable.get(ACLNAME);
			AclEntity aclEntity = new AclEntity(ACLNAME, SRC_IP_PREFIX,
					DST_IP_PREFIX, PROTO, SRC_PORT, DST_PORT, PRIORITY, ACTION);
			for (AclEntity temp : list) {
				if (temp.getAclName()==ACLNAME && temp.getProtoco()==PROTO) {
					if (temp.getSrc_ip()==SRC_IP_PREFIX && temp.getSrc_port()==SRC_PORT
							&& temp.getDst_ip()==DST_IP_PREFIX && temp.getDst_port()==DST_PORT) {
						return false;
					}
				}
			}
			list.add(aclEntity);
			
			hashtable.put(ACLNAME, list);
			return true;
		}
	}

	public String Acl_check_packet(String ACLNAME, String SRC_IP,String DST_IP,String PROTO,String SRC_PORT,String DST_PORT){
		List<AclEntity> entities=hashtable.get(ACLNAME);
		for (AclEntity aclEntity : entities) {
			if ( aclEntity.isInIpAddressRange(aclEntity.getSrc_ip(), SRC_IP)
				  &&aclEntity.isInIpAddressRange(aclEntity.getDst_ip(), DST_IP))
				  {
				if (aclEntity.getSrc_port()=="*" && aclEntity.getDst_port()=="*") {
					return aclEntity.getAction();
				}
				else if (aclEntity.getSrc_port()=="*") {
					if (aclEntity.getDst_port().equals(DST_PORT)) {
						return aclEntity.getAction();
					}
				}
				else if (aclEntity.getDst_port()=="*") {
					if (aclEntity.getSrc_port().equals(SRC_PORT)) {
						return aclEntity.getAction();
					}
				}
				else {
					if (aclEntity.getSrc_port().equals(SRC_PORT)
							&& aclEntity.getDst_port().equals(DST_PORT)) {
						return aclEntity.getAction();
					}
				}
				
			}
		}
		return "false";
	}

	public void toString(AclEntity entity) {
		System.out.println(entity.getAclName() + ", " + entity.getSrc_ip()
				+ "," + entity.getDst_ip() + ", " + entity.getProtoco() + ", "
				+ entity.getSrc_port() + ", " + entity.getDst_port());
		}

	public void Acl_del_rule(String ACLNAME,String PRIO){
		if (hashtable.containsKey(ACLNAME)) {
			List<AclEntity> entities = hashtable.get(ACLNAME);
			for (AclEntity entity: entities) {
				if (entity.getPriority() == PRIO) {
					entities.remove(entity);
				}
			}
		}
	}
	public void Acl_list_delete(String NAME){
		if(hashtable.containsKey(NAME)) {
			hashtable.remove(NAME);
		}
	}
	public void Acl_show_rules(String ACLNAME,String FILENAME) throws IOException{
		
		List<AclEntity> entities = hashtable.get(FILENAME);
		File file = new File("out.txt");
		BufferedWriter output = new BufferedWriter(new FileWriter(file));
		for (AclEntity entity: entities) {
			String str = entity.getAclName() + ", " + entity.getSrc_ip() + "," + entity.getDst_ip()
					 + ", " + entity.getProtoco() + ", " +  entity.getSrc_port()  + ", " +  entity.getDst_port()
						+ entity.getAction();

	        output.write(str);
		}
		output.close();
	}
	public void Acl_show_all (String FILENAME){
		List<AclEntity> entities = hashtable.get(FILENAME);
		
		print(entities);
	}
	public void print(List<AclEntity> entities) {
		for (AclEntity entity: entities) {
		System.out.println(entity.getAclName() + ", " + entity.getSrc_ip() + "," + entity.getDst_ip()
				 + ", " + entity.getProtoco() + ", " +  entity.getSrc_port()  + ", " +  entity.getDst_port()
				+ entity.getAction());
		}
	}

}
