import java.io.*;
class FileCopy
{
public static void main(String args[])
{
int data;
String file1="Source.txt";
String file2="Destination.txt";
try
{
FileInputStream fis=new FileInputStream(file1);
FileOutputStream fos=new FileOutputStream(file2);
while((data=fis.read()) != -1)
{
fos.write(data);
}
}
catch (Exception FileNotFound )
{
System.out.println("File Not Found Error");
}
finally{
System.out.println("File Copied");
}
}
}
