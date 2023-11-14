public class prime
{
	public static void main(String[] args) {
		int a = 23871;
		int re =0;
		// int n=1;
		while(a!=0){
		    int k = a%10;
		    re = re*10+k;
		    a/=10;
		}
        System.out.println(re);
	}
}