import java.util.*;
public class Main
{
  static int n;
  static int x[], y[];
  static int seen[], distance[];
  static int distance2(int i, int j)
  {
    return (x[j] - x[i])*(x[j] - x[i]) + (y[j] - y[i])*(y[j] - y[i]);
  }
  static void Prim()
  {
    distance  = new int[n];
    Arrays.fill(distance, Integer.MAX_VALUE);
    seen  = new int[n];
    int i, j, cur = 0;
    distance[cur] = 0;
    seen[cur] = 1;
    for (i = 1; i < n; i++)
    {
      for (j = 0; j < n; j++)
        if (seen[j] == 0 && distance2(cur, j) < distance[j])
          distance[j] = distance2(cur, j);
      int min = Integer.MAX_VALUE;
      for (j = 0; j < n; j++)
        if (seen[j] == 0 && distance[j] < min)
        {
          min = distance[j];
          cur = j;
        }
      seen[cur] = 1;
    }
  }
  public static void main(String[] args)
  {
    Scanner con = new Scanner(System.in);
    int tests = con.nextInt();
    while (tests-- > 0)
    {
      int s = con.nextInt();
      n = con.nextInt();
      x = new int[n];
      y = new int[n];
      for (int i = 0; i < n; i++)
      {
       x[i] = con.nextInt(); 
       y[i] = con.nextInt();
      }
      Prim();
      Arrays.sort(distance);
      System.out.printf("%.2f\n", Math.sqrt(distance[n - s]));
    }
    con.close();
  }
}