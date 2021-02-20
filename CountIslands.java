class Solution { //this uses recurrsion
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0 || grid[0] == null) {
            return 0;
        }
         int n  = grid.length;
         int m = grid[0].length;
        int count = 0; //counting islands
        
        for(int i = 0; i<n; i++){
            for(int j=0; j<m; j++) {
                if(grid[i][j] == '1'){
                    dfs(grid,i,j);
                    count +=1;  
                }
            }
        }
        return count;
    }
    
    private int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    
    private void dfs(char[][] grid, int i, int j)  { //dfs recurrsive function
        
        grid[i][j] = '0';
        for(int[] dir : dirs) {
            int row = i+dir[0];
            int column = j+dir[1];
            
            if(row>=0 && row<grid.length && column>=0 && column<grid[0].length && grid[row][column] == '1') {
                dfs(grid, row, column);
            }
        }
    }
}
