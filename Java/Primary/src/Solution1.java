import sun.security.provider.Sun;

public class Solution1 {
    int num = 0;

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };



//                ['1','1','1','1','0'],
//                ['1','1','1','1','0'],
//                ['1','1','1','1','0'],
//                ['1','1','1','1','0'];
    }
    public int numIslands(char[][] grid){

    int num = 0;
    char[][] charstr = grid;

    for (int i = 0; i <charstr.length;i++) {
        for (int j = 0; j < charstr[0].length; j++) {
            if (grid[i][j] != '0') {

            }
        }
    }
        return num;
    }

    public char[][] dfs(char[][] grid){

        for (int i = 0; i <grid.length;i++){
            for (int j = 0;j < grid[0].length;j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = (char) num;
                    dfs(grid[i][j+1]);
                    dfs(grid[i+1][j]);
                }
            }
        }
    }
}
