class Solution {
    private int[][] grid;
    private int m=0;
    private int n=0;
    public int maxAreaOfIsland(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        this.grid=grid;
        int maxArea=0;
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
        if(grid[i][j]==1){
            int area=dfs(i,j);
            maxArea=Math.max(maxArea,area);
             }
            }
          }
          return maxArea;
    }
    public int dfs(int i,int j){
        grid[i][j]=0;
        int area=1;
        int[]dirs={-1,0,1,0,-1};
        for(int k=0;k<4;++k){
            int x=i+dirs[k];
            int y=j+dirs[k+1];
            if(x>=0 && x<m && 
               y>=0 && y<n && 
               grid[x][y]==1){
                area +=dfs(x,y);
               }
               }
               return area;
    }
}
      




    
        
        
    