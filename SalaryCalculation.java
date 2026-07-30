import java.util.Scanner;
class Employee
{
Scanner sc=new Scanner(System.in);
String emp_name,address,mail_id,mobile_no;
int emp_id;
int da,hra,pf,staffclub;
int g_salary,net_salary;
int basic_pay;
void getDetails()
{
System.out.println("Enter Employee Name:");
emp_name=sc.nextLine();
System.out.println("Enter Employee ID:");
emp_id=sc.nextInt();
sc.nextLine();
System.out.println("Enter Employee Address:");
address=sc.nextLine();
System.out.println("Enter Mail ID:");
mail_id=sc.nextLine();
System.out.println("Enter Mobile ID:");
mobile_no=sc.nextLine();
System.out.println("Enter Basic Salary:");
basic_pay=sc.nextInt();
}
void display(String designation)
{
System.out.println("Employee Payslip");
System.out.println("Designation:"+designation);
System.out.println("Employee Name:"+emp_name);
System.out.println("Employee ID:"+emp_id);
System.out.println("Employee Address:"+address);
System.out.println("Employee Mail ID"+mail_id);
System.out.println("Employee Mobile No:"+mobile_no);
System.out.println("Basic Pay:"+basic_pay);
System.out.println("Da:"+da);
System.out.println("HRA:"+hra);
System.out.println("PF:"+pf);
System.out.println("Staff Club:"+staffclub);
System.out.println("Gross Salary"+g_salary);
System.out.println("Net Salary"+net_salary);
}
}
class Programmer extends Employee
{

void Payslipcalculation()
{
da = basic_pay * 97 / 100;
hra = basic_pay * 10 / 100;
pf = basic_pay * 12 / 100;
staffclub = basic_pay * 1 / 100;
g_salary = basic_pay + da + hra;
net_salary = g_salary - pf - staffclub;
}
}
class Assistantprofessor extends Employee
{
void Payslipcalculation()
{
da = basic_pay * 110 / 100;
hra = basic_pay * 20 / 100;
pf = basic_pay * 12 / 100;
staffclub = basic_pay * 5 / 100;
g_salary = basic_pay + da + hra;
net_salary = g_salary - pf - staffclub;
}
}
class AssociateProfessor extends Employee
{
void Payslipcalculation()
{
da = basic_pay * 130 / 100;
hra = basic_pay * 30 / 100;
pf = basic_pay * 12 / 100;
staffclub = basic_pay * 10 / 100;
g_salary = basic_pay + da + hra;
net_salary = g_salary - pf - staffclub;
}
}
class Professor extends Employee
{
void Payslipcalculation()
{
da= basic_pay * 140 / 100;
hra= basic_pay * 40 / 100;
pf= basic_pay * 12 / 100;
staffclub= basic_pay * 15 / 100;
g_salary= basic_pay + da + hra;
net_salary= g_salary - pf - staffclub;
}
}
class Salaryclaculation
{
public static void main(String[] args)
{
Scanner sc=new Scanner(System.in);
System.out.println("1.PROGRAMMER");
System.out.println("2.ASSISTANT PROFESSOR");
System.out.println("3.ASSOCIATE PROFESSOR");
System.out.println("4.PROFESSOR");
System.out.println("Enter Choice:");
int choice=sc.nextInt();
switch(choice)
{
case 1:
 Programmer p = new Programmer();
 p.getDetails();
 p.Payslipcalculation();
 p.display("Programmer");
 break;
case 2:
 Assistantprofessor ap = new Assistantprofessor();
 ap.getDetails();
 ap.Payslipcalculation();
 ap.display("Assistantprofessor");
 break;
case 3:
 AssociateProfessor asp = new AssociateProfessor();
 asp.getDetails();
 asp.Payslipcalculation();
 asp.display("Assistantprofessor");
 break;
case 4:
 Professor pr = new Professor();
 pr.getDetails();
 pr.Payslipcalculation();
 pr.display("Professor");
 break;
default:
 System.out.println("Invalid Choice");
}
}
}
