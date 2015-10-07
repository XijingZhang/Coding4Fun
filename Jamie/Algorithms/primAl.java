import java.util.*;
public class primAl {  
 static int MAXCOST = Integer.MAX_VALUE;

 public static int Prim(int graph[][], int n){
   /* lowcost[i]记录以i为终点的边的最小权值，当lowcost[i]=0时表示终点i加入生成树 */
   int lowcost[] = new int[n+1];
 
   /* mst[i]记录对应lowcost[i]的起点，当mst[i]=0时表示起点i加入生成树 */
   int mst[] = new int[n+1];
 
   int min, minid, sum = 0;
 
   /* 默认选择1号节点加入生成树，从2号节点开始初始化 */
    for (int i = 2; i <= n; i++){
	/* 最短距离初始化为其他节点到1号节点的距离 */
	lowcost[i] = graph[1][i];
 
	/* 标记所有节点的起点皆为默认的1号节点 */
	mst[i] = 1;
     }
 
    /* 标记1号节点加入生成树 */
    mst[1] = 0;
 
    /* n个节点至少需要n-1条边构成最小生成树 */
    for (int i = 2; i <= n; i++){
	min = MAXCOST;
	minid = 0;
 
       /* 找满足条件的最小权值边的节点minid */
       for (int j = 2; j <= n; j++){
	  /* 边权值较小且不在生成树中 */
	  if (lowcost[j] < min && lowcost[j] != 0){
	     min = lowcost[j];
	     minid = j;
	  }
       }
     
       /* 输出生成树边的信息:起点，终点，权值 */
	System.out.printf("%c - %c : %d\n", mst[minid] + 'A' - 1, minid + 'A' - 1, min);
 
       /* 累加权值 */
       sum += min;
 
       /* 标记节点minid加入生成树 */
       lowcost[minid] = 0;
 
       /* 更新当前节点minid到其他节点的权值 */
       for (int j = 2; j <= n; j++){
         /* 发现更小的权值 */
	  if (graph[minid][j] < lowcost[j]){
	      /* 更新权值信息 */
	      lowcost[j] = graph[minid][j];
 
	      /* 更新最小权值边的起点 */
	      mst[j] = minid;
	   }
       }
     }
     /* 返回最小权值和 */
	return sum;
   }
 
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int  cost;
    char chx, chy;
 
    /* 读取节点和边的数目 */
    int n=sc.nextInt();//节点
    int m=sc.nextInt();//边数
    int graph[][]=new int[n+1][n+1];

    /* 初始化图，所有节点间距离为无穷大 */
    for (int i = 1; i <= n; i++){
	for (int j = 1; j <= n; j++){
		graph[i][j] = MAXCOST;
	}
    }
 
    /* 读取边信息 */
    for (int k = 0; k < m; k++){
        chx=sc.next().charAt(0);
        chy=sc.next().charAt(0);
        cost=sc.nextInt();
	 int i = chx - 'A' + 1;
	 int j = chy - 'A' + 1;
	 graph[i][j] = cost;
	 graph[j][i] = cost;
     }
 
    /* 求解最小生成树 */
     cost = Prim(graph, n);
 
    /* 输出最小权值和 */
     System.out.println("Total:"+cost);
 
    }
}



