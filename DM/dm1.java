import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
class Records{
int attr1;
String attr2;
}
public class Prog1 {
static Records[] rc=new Records[10];

20

public static void main(String args[]) throws FileNotFoundException,
IOException
{
BufferedReader CSV=new BufferedReader(new
FileReader(&quot;C://Users//manvi//Desktop//aggregate.csv&quot;));
String data=CSV.readLine();
data=CSV.readLine();
int i=0;
System.out.println(&quot;Dataset:&quot;);
while(data!=null)
{
rc[i]=new Records();
String[] dataArray=data.split(&quot;,&quot;);
rc[i].attr1=Integer.parseInt(dataArray[0]);
rc[i].attr2=dataArray[1];
System.out.println(rc[i].attr1+&quot; &quot;+rc[i].attr2);
data=CSV.readLine();
i++;
}
//finding aggregate for numeric attribute
int aggregate =0;
for(int j=0;j&lt;i;j++)
aggregate += rc[j].attr1;
aggregate=aggregate/i;
System.out.println(&quot;Aggregate is: &quot;+aggregate);
//performing discretization for numeric attribute
int interval_size;
Scanner input=new Scanner(System.in);
System.out.println(&quot;\n Enter interval size:&quot;);
interval_size=input.nextInt();
for(int j=0;j&lt;i;j++)
{
int base=(int) (rc[j].attr1/interval_size);
System.out.println(rc[j].attr1+&quot; &quot;+rc[j].attr2+&quot;
range[&quot;+(base*interval_size)+&quot;,&quot;+(base*interval_size+interval_size)+&quot;)&quot;);
}
}
}
