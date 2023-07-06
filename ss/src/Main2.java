import java.util.*;

public class Main2 {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int v)
        {
            val = v;
            next = null;
        }
    }
    static ListNode reorder(ListNode head)
    {
        int a[] =new int[100010];
        int n = 0;
        while(head!=null)
        {
            a[++n ] =head.val;
            head=head.next;
        }
        for(int i=1;i<=n ;i +=4)
        {
            if(i+2>n)   break;
            if(i+2 == n )
            {
                int t=a[i+2];
                a[i+2] = a[i+1];
                a[i+1] = a[i];
                a[i] = t;
                continue;
            }
            int x = a[i+3];
            int y = a[i+2];
            a[i+3] = a[i+1];
            a[i+2] = a[i];
            a[i] = y;
            a[i+1] = x;
        }
        ListNode h  = new ListNode(-1);
        ListNode ans =h;
        for(int i=1;i<=n;i++)
        {
            h.next = new ListNode(a[i]);
            h=h.next;
        }
        return ans.next;
    }

    public static void main(String[] args) {
        int h,w;
        Scanner read=new Scanner(System.in);
        h=read.nextInt();
        w=read.nextInt();
        int m=read.nextInt();


    }
}
//1 3 5 4 2
// 3
// 3 1 4  2
// 1 2
// 4 6 5 1 3 2
// 3 6 5 1 4 2
//
//
// 2 1   k = 1
