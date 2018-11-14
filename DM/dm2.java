import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
class Record{
int attr1;
String attr2;
}
public class Mode {
static Record[] rc=new Record[10];
public static void main(String args[]) throws FileNotFoundException,
IOException
{
BufferedReader CSV1=new BufferedReader(new
FileReader(&quot;C://Users//manvi//Desktop//missing.csv&quot;));
String data=CSV1.readLine();
data=CSV1.readLine();
int i=0;
Map&lt;String, Integer&gt; map = new HashMap&lt;String, Integer&gt;();
while(data!=null)
{
rc[i]=new Record();
String[] dataArray=data.split(&quot;,&quot;);
rc[i].attr1=Integer.parseInt(dataArray[0]);
rc[i].attr2=dataArray[1];
if (!map.containsKey(rc[i].attr2))
map.put(rc[i].attr2, 1);
else
map.put(rc[i].attr2, map.get(rc[i].attr2)+1);
System.out.println(rc[i].attr1+&quot; &quot;+rc[i].attr2);
data=CSV1.readLine();
i++;
}
//(a)for numeric attribute replacing missing value by mean
int mean=0;
System.out.println();
System.out.println(&quot;Numeric:&quot;);
for(int j=0;j&lt;i;j++)
{
if(rc[j].attr1!=-1)
mean+=rc[j].attr1;
}
mean=mean/(i);

23

System.out.println(&quot;Mean =&quot;+mean);
for(int j=0;j&lt;i;j++)
{
if((rc[j].attr1!=-1))
{ System.out.println(rc[j].attr1);}
else
{
rc[j].attr1=mean;
System.out.println(rc[j].attr1);}
}
//(b)for categorical attribute replacing missing value by mode
int max=0;
String mode=&quot;&quot;;
System.out.println();
System.out.println(&quot;Categorical:&quot;);
for (Map.Entry&lt;String, Integer&gt; entry : map.entrySet())
{
System.out.println(entry.getKey()+&quot; &quot;+entry.getValue());
if(entry.getValue()&gt;max){
max=entry.getValue();
mode=entry.getKey();
}
}
System.out.println(&quot;Mode =&quot;+mode);
for(int j=0;j&lt;i;j++)
{
if(rc[j].attr2.equals(&quot;?&quot;))
{
rc[j].attr2=mode;
System.out.println(rc[j].attr2);}
else
{ System.out.println(rc[j].attr2);
}
}
}
}
