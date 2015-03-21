
public class PascalTriangle {
	public static int[][] pascalTriangle(int n){
		int[][]pt = new int[n][];
		for(int i=0;i<n;i++){
			pt[i]=new int[i+1];
			pt[i][0]=1;
			for(int j=1;j<i;j++)
				pt[i][j]=pt[i-1][j-1]+pt[i-1][j];
		pt[i][i]=1;
		}
		return pt;
	}
	public static void main(String[] args){
		int[][]pt = PascalTriangle.pascalTriangle(5);
		for(int i=0;i<5;i++){
			for(int j=0;j<i+1;j++)
				System.out.print(pt[i][j] + " ");
			System.out.println();
		}
	}
}
