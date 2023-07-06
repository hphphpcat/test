import java.util.*;
class Question1 {

    public static int get(String s)
    {
        String tt[]=s.split(":");
        int a=Integer.parseInt(tt[0]);
        int b=Integer.parseInt(tt[1]);
        return a*60+b;
    }
    public static List<String> find_meeting_slots(int m, List<List<String>> employeeSchedules) {

        List<String>ans=new ArrayList<>();
        List<int[]>res=new ArrayList<>();
        List<int[]>res2=new ArrayList<>();
        for(int i=0;i<1440;i+=15)
        {
            int last=-100;
            int pos=i+15;
            for(int j=i+15;j<=1440;j+=15)
            {
                int cnt=0;
                for(List<String> v:employeeSchedules)
                {
                    boolean flag=true;
                    for(String s:v)
                    {
                        String tt[]=s.split("-");
                        int l=get(tt[0]);
                        int r=get(tt[1]);
                        if((l>=j) || (r<=i)) continue;
                        flag=false;
                        break;
                    }
                    if(flag)    cnt++;
                 }
                if(cnt==last || last==-100) {
                    last=cnt;
                    pos=j;
                }
                else
                    break;
            }
            if(last>=2)
            res.add(new int[]{last,i,pos});
        }
        Collections.sort(res, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]!=o2[0])
                    return o2[0]-o1[0];
                if(o1[1]!=o2[1])
                    return o1[1]-o2[1];
                return o1[2]-o2[2];
            }
        });
        for(int ii=0;ii<res.size();ii++)
        {
            int tt[]=res.get(ii);
            int i=tt[1];
            int j=tt[2];
            boolean flag=true;
            for(int[]aa:res2)
            {
                int a=aa[1];
                int b=aa[2];
                if((b<=i)||(a>=j))  continue;
                flag=false;
                break;
            }
            if(flag)
            {
                if(ans.size()<m)
                {
                    ans.add(stringFormat(i,j));
                    res2.add(new int[]{tt[0],i,j});
                }
            }
        }
        if(ans.size()!=m)
        {
            List<String>tt=new ArrayList<>();
            return tt;
        }
        //00:00
        return ans;
    }

    private static String stringFormat(int start, int end){
        String s = "";
        int hour = start / 60;
        int minute = start % 60;
        if(hour < 10) s += "0";
        s += Integer.toString(hour);
        s += ":";
        if(minute == 0) s += "00";
        else s += Integer.toString(minute);
        s += "-";
        hour = end / 60;
        minute = end % 60;
        if(hour < 10) s += "0";
        s += Integer.toString(hour);
        s += ":";
        if(minute == 0) s += "00";
        else s += Integer.toString(minute);

        return s;
    }
    public static void main(String[] args){
        List<List<String>> input = new ArrayList<>();
        Scanner read=new Scanner(System.in);
        int n=read.nextInt();
        int k;
        k=read.nextInt();
        for(int i=0;i<3;i++)
        {
            List<String>tmp=new ArrayList<>();
            for(int j=0;j<k;j++)
                tmp.add(read.next());
            input.add(tmp);
        }
        System.out.println("Output is " + find_meeting_slots(2, input));

    }

}

//3
//1
//00:00-05:30
//2
//00:00-05:00
//08:00-22:00
//1
//00:00-12:30