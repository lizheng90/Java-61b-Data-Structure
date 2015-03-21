package hw3;

public class Solution {

	public static void smoosh(int[] ints){
		if(ints.length==0)
			System.exit(0);;
		if(ints.length==1)
			System.out.print(ints[0]);
		int countIndex=0;
		int len=ints.length;
		int[] output = new int[len];
		int i;
		for(i=0;i<len-1;i++){
			if(ints[i]!=ints[i+1]){
				output[countIndex]=ints[i];
				countIndex++;
			}
		}
		//add last element of array
		if(ints[i]!=ints[i-1]){
			output[countIndex++]=ints[i];
		}
		for(i=countIndex;i<len;i++){
			output[i]=-1;
		}
		for(i=0;i<len;i++){
			System.out.print(output[i] + " ");
		}
	}
	
	
	
	public static void main(String[] args){
		int[] a = {0,0,0,0,1,1,0,0,0,3,3,3,1,1,0};
		smoosh(a);
	}
}

