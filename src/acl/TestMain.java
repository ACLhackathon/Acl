package acl;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Acl acl=Acl.getInstance();
		System.out.println(acl.Acl_list_create("ACL_A", "ALLOW"));
		System.out.println(acl.Acl_list_create("ACL_B", "ALLOW"));
		System.out.println(acl.Acl_list_create("ACL_A", "ALLOW"));
		
		acl.Acl_show_all("ACL_A");
	}

}
