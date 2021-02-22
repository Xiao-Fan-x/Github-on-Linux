import java.util.Scanner;

public class problem_9 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        m = in.nextInt();
        n = in.nextInt();
        a = new int[n][m];
        vis = new int[n][m];

        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++) {
                a[i][j] = in.nextInt();
                sum += a[i][j];
            }
        if(sum%2==1) {
            System.out.println(0);
            return;
        }
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++) {
                vis[i][j] = 1;
                dfs(i,j,a[i][j],1);
                init();
            }
        if(ans==999999)
            System.out.println(0);
        else
            System.out.println(ans);
    }

    static int n,m,sum=0,ans=999999,q=0;
    static int[][] a;
    static int[][] vis;
    static int[] dx = new int[] {0,1,0,-1};
    static int[] dy = new int[] {1,0,-1,0};


    static void dfs(int x,int y,int now,int t) {
        if(now==sum/2) {
            int tmp;
            if(vis[0][0]==1)
                tmp = t;
            else
                tmp = m*n-t;
//			for(int i=0;i<n;i++) {
//				for(int j=0;j<m;j++)
//					System.out.print(vis[i][j]+" ");
//				System.out.println();
//			}
//			System.out.println();
            for(int i=0;i<n;i++)
                for(int j=0;j<m;j++)//判断有没剪成3部分了= =
                    if(vis[i][j]!=1) {
                        q=0;
                        dfs_check(i, j);
                        for(int ii=0;ii<n;ii++)
                            for(int jj=0;jj<m;jj++)
                                if(vis[ii][jj]==-1)
                                    vis[ii][jj] = 0;
                        if(q!=m*n-t)
                            return;
                        break;//判断一次就行了
                    }
            ans = Math.min(ans, tmp);
            return;
        }
        if(now>sum/2 || t>ans)//稍微剪剪枝
            return;
        for(int i=0;i<4;i++) {
            int j = x + dx[i];
            int k = y + dy[i];
            if(ok(j,k)) {
                vis[j][k] = 1;
                dfs(j,k,now+a[j][k],t+1);
                vis[j][k] = 0;
            }
        }
    }

    static void init() {
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                vis[i][j] = 0;
    }

    static boolean ok(int x,int y) {
        return x>=0 && x<n && y>=0 && y<m && vis[x][y]!=1;
    }

    static void dfs_check(int x,int y) {
        q++;
        vis[x][y] = -1;

        for(int i=0;i<4;i++) {
            int j = x + dx[i];
            int k = y + dy[i];
            if(j>=0 && j<n && k>=0 && k<m && vis[j][k]==0)
                dfs_check(j,k);
        }
    }

}
