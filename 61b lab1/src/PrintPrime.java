
public class PrintPrime {
	public static boolean isPrime(int n){
		for(int i=2;i<n;i++)
			if(n%i==0)
				return false;
		return true;
	}
	public static void printPrimes(int n){
		for(int i=2;i<n;i++)
			if(isPrime(i))
				System.out.println("The number "+i+" is a prime number");
	}
	public static void main(String[] args){
		PrintPrime.printPrimes(20);
	}
}

