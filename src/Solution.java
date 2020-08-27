
public class Solution {

	public static void main(String[] args) {
		// we assume that board is cyclic i.e. discretisation of torus
		int[][] board = { {0,1,0},{0,0,1},{1,1,1},{0,0,0}};
		int n=board.length;
		int m=board[0].length;
		
		int[][] updatedboard = new int[n][m];
		updatedboard=board;
		
		int deadNeighbours=0;
		int liveNeighbours=0;
		int deadOrAlive=0;
		
		for (int i=0;i<n;i++){
			for (int j=0;j<m;j++){
				
				deadNeighbours=computeDeadNeighbours(i,j,board);
				liveNeighbours=computeLiveNeighbours(i,j,board);
				//System.out.println(liveNeighbours);
				deadOrAlive = board[i][j];
				
				if (deadOrAlive==0 & deadNeighbours==3) updatedboard[i][j]=1;
				
				else if (deadOrAlive==1){
					if (liveNeighbours<2) updatedboard[i][j]=0;
					else if (liveNeighbours==2 || liveNeighbours==3) updatedboard[i][j]=1;
					else if (liveNeighbours>3) updatedboard[i][j]=0;
				}
				
				System.out.println(updatedboard[i][j]);
			}

		}

	}
	
	
	public static int computeLiveNeighbours(int i, int j, int[][] grid){
		int n=grid.length;
		int m=grid[0].length;
		int numberAlive=0; 
		
		for (int k=-1;k<=1;k++){
			for (int l=-1;l<=1;l++){
				if (grid[Math.floorMod(i+k,n)][Math.floorMod(j+l,m)]==1){
					numberAlive++;
				}
			}
		}
		
		if (grid[i][j]==1) numberAlive=numberAlive-1;
		
		return numberAlive;
	}
	
	public static int computeDeadNeighbours(int i, int j, int[][] grid){
		int n=grid.length;
		int m=grid[0].length;
		int numberDead=0; 
		
		for (int k=-1;k<=1;k++){
			for (int l=-1;l<=1;l++){
				if (grid[Math.floorMod(i+k,n)][Math.floorMod(j+l,m)]==0){
					numberDead++;
				}
			}
		}
		
		if (grid[i][j]==0) numberDead=numberDead-1;
		
		return numberDead;
	}

}
