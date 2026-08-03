import java.util.*;
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
interface Bankoperation
{
int deposit(int dep,int balance);
int withdrawalamound(int withdraw,int balance) throws InsufficientBalanceException;
int balancequiry(int balance);
}
class Checking implements Bankoperation
{
public int deposit(int dep,int balance)
{
dep = dep + balance;
return dep;
}
public int withdrawalamound(int withdraw,int balance) throws InsufficientBalanceException
{
if (withdraw > balance) {
        throw new InsufficientBalanceException("Insufficient Balance");
    }
withdraw = balance - withdraw;
return withdraw;
}
public int balancequiry(int balance)
{
return balance;
}
}
class Banking
{
public static void main(String args[]) 
{
String name;
int num,balance,choice,dep,withdraw;
Scanner sc=new Scanner(System.in);
Checking c=new Checking();
System.out.println("Account Holder Name:");
name=sc.nextLine();
System.out.println("Account Number:");
num=sc.nextInt();
sc.nextLine();
System.out.println("Initial Balance:");
balance=sc.nextInt();
sc.nextLine();
System.out.println("1.Deposit. \n2.Withdrawel. \n3.Balance Check");
choice=sc.nextInt();
try
{
if(choice==1)
{
System.out.println("Deposit Amount:");
dep = sc.nextInt();
System.out.println("Amount Deposited Successfully!");
System.out.println("Available Balance:Rs."+c.deposit(dep,balance));
}
else if(choice==2)
{
System.out.println("Withdraw Amount:");
withdraw = sc.nextInt();
System.out.println("Amound withdrawed Successfully!");
System.out.println("Available Balance:Rs."+c.withdrawalamound(withdraw,balance));
}
else if(choice==3)
{
System.out.print("Balance Amound:" + c.balancequiry(balance));
}
else
{
System.out.print("Invalid Input");
}
}
catch(InsufficientBalanceException e)
{
System.out.println("Exception: Insufficient Balance");
System.out.println("Trasaction Failed");
System.out.println("Available Balance:Rs."+balance);

}
}
}


