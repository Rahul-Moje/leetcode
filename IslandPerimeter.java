package main.java.com.leetcode;

public class IslandPerimeter {
    public static void main(String[] args) {
        //int[][] grid = new int[][]{{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        int[][] grid = new int[][]{{0,1,0},{1,1},{0,0}};
        int perimeter = islandPerimeter(grid);
        System.out.println(perimeter);
    }

    private static int islandPerimeter(int[][] grid) {
        int i,j,perimeter = 0,nextI,nextJ;
        for(i=0;i<grid.length;i++){
            for(j=0;j<grid[i].length;j++){
                if(grid[i][j] == 1){
                    //First check for left side
                    nextJ = j-1;
                    if(nextJ < 0 || grid[i][nextJ] == 0)
                        perimeter++;
                    //Then check for right side
                    nextJ = j+1;
                    if(nextJ == grid[i].length || grid[i][nextJ] == 0)
                        perimeter++;
                    //Then check above
                    nextI = i-1;
                    if(nextI < 0 || grid[nextI][j] == 0)
                        perimeter++;
                    //Finally check below
                    nextI = i+1;
                    if(nextI == grid.length || grid[nextI][j] == 0)
                        perimeter++;
                }
            }
        }
        return perimeter;
    }
}
