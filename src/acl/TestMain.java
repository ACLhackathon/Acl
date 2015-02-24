package acl;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Acl acl=Acl.getInstance();
		System.out.println(acl.Acl_list_create("ACL_A", "ALLOW"));
		System.out.println(acl.Acl_list_create("ACL_B", "ALLOW"));
		System.out.println(acl.Acl_list_create("ACL_A", "ALLOW"));
		System.out.println(acl.Acl_list_create("ACL_C", "DENY"));
		
		acl.Acl_add_rule("ACL_A", "3.4.5.0/24", "4.5.6.0/24", "TCP", "*", "12456", "100","DENY");
		acl.Acl_add_rule("ACL_B", "7.8.9.0/24", "9.10.11.0/24", "TCP", "8080", "13455", "2","ALLOW");
		acl.Acl_add_rule("ACL_C", "11.12.13.0/24", "12.13.14.0/24", "UDP", "8080", "*", "5","DENY");
		acl.Acl_add_rule("ACL_A", "3.4.5.6/32", "4.5.6.7/32", "TCP", "8080", "12456", "2","ALLOW");
		acl.Acl_add_rule("ACL_A", "*", "*", "TCP", "8080", "12456", "6","DENY");
		acl.Acl_add_rule("ACL_B", "*", "9.10.11.0/24", "TCP", "*", "*", "10","ALLOW");
		acl.Acl_add_rule("ACL_B", "192.168.3.4/32", "4.5.6.7/32", "TCP", "8080", "12456", "5","ALLOW");
		acl.Acl_add_rule("ACL_C", "192.168.0.0/24", "192.168.0.0/24", "TCP", "8080", "12456", "7","DENY");
		acl.Acl_add_rule("ACL_C", "192.168.0.0/25", "192.168.0.0/25", "TCP", "8080", "12456", "2","ALLOW");
		acl.Acl_add_rule("ACL_C", "3.4.5.6/32", "4.5.6.7/32", "*", "8080", "12456", "100","ALLOW");
		
		
		
	}

}
