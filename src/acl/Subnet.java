package acl;

public class Subnet{
	public boolean isInIpAddressRange(String str,String des){
			String [] ips=str.split("/");
			if (ips==null) {
				return false;
			}
			else{
				if (ips.length<2) {
					return ips[0].equals(des);
				}
				else {
					String subnet=ips[1];
					int num=Integer.parseInt(subnet);
					if (num==32) {
						return ips[0].equals(des);
					}
					if (num==24) {
						String [] subips=ips[0].split("\\.");
						String [] desips=des.split("\\.");
						for (int i = 0; i < desips.length-1; i++) {
							if (!desips[i].equals(subips[i])) {
								return false;
							}
						}
						return true;
					}
					if (num==25) {
						String [] subips=ips[0].split("\\.");
						String [] desips=des.split("\\.");
						int i=0;
						for (i = 0; i < desips.length-1; i++) {
							if (!desips[i].equals(subips[i])) {
								return false;
							}
						}
						int subipnum=Integer.parseInt(desips[i]);
						if (subipnum<=127) {
							return true;
						}
					}
					return false;
				}
			}
		}
	
	public static void main(String args[]){
		Subnet s= new Subnet();
		String ipAddr="3.4.5.6";
		String subAddr="3.4.5.6/24";
		System.out.println(s.isInIpAddressRange(subAddr,ipAddr));
	}
}
