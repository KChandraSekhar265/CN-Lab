import java.util.*;
public class bellmanFord{
    public static void bell(int graph[][],int src){
        int n=graph.length;
        int dist[]=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        for(int i=0;i<n-1;i++){
            for(int u=0;u<n;u++){
                for(int v=0;v<n;v++){
                    if(graph[u][v]!=0 && dist[u]!=Integer.MAX_VALUE && dist[u]+graph[u][v]<dist[v]){
                        dist[v]=dist[u]+graph[u][v];
                    }
                }
            }
        }
        for(int u=0;u<n;u++){
            for(int v=0;v<n;v++){
                if(graph[u][v]!=0 && dist[u]!=Integer.MAX_VALUE && dist[u]+graph[u][v]<dist[v]){
                    System.out.println("NEGATIVE CYCLE DETECTED");
                    return;
                }
            }
        }
        for(int i=0;i<dist.length;i++){
            System.out.println(i+"->"+dist[i]);
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int graph[][]=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                graph[i][j]=sc.nextInt();
            }
        }
        bell(graph,0);
    }
}
