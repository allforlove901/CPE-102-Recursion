import java.util.ArrayList;


public class FastFibComputer {

	private long[] numbers = new long[3]; 
	
	public long fib(int n){
		if (n <= 2){return 1;}
		else{
			numbers[0]=1;
			numbers[1]=1;
			numbers[2]=1;
			for(int i=3; i<=n; i++){
				numbers[2]=numbers[0]+numbers[1];
				numbers[0]=numbers[1];
				numbers[1]=numbers[2];
			}
			return numbers[2];
		}
	}
	
}
