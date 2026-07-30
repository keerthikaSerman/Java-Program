import java.util.Scanner;
abstract class Shapes
{
int a,b;
abstract void printArea();
}
class Rectangle extends Shapes
{
void printArea()
{
System.out.println("Area of Rectangle="+(a*b));
}
}
class Triangle extends Shapes
{
void printArea()
{
System.out.println("Area of Triangle="+ (0.5*a*b));
}
}
class Circle extends Shapes
{
void printArea()
{
System.out.println("Area of Circle="+(3.14*a*a));
}
}
class Areamain {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
System.out.println("1.Rectangle");
System.out.println("2.Triangle");
System.out.println("3.Circle");
int choice=sc.nextInt();
switch(choice){
case 1:
 Rectangle r = new Rectangle();
 System.out.print("Enter length of rectangle: ");
 r.a = sc.nextInt();
 System.out.print("Enter breadth of rectangle: ");
 r.b = sc.nextInt();
 r.printArea();
 break;
case 2:
 Triangle t = new Triangle();
 System.out.print("Enter base of triangle: ");
 t.a = sc.nextInt();
 System.out.print("Enter height of triangle: ");
 t.b = sc.nextInt();
 t.printArea();
 break;
case 3:
 Circle c = new Circle();
 System.out.print("Enter radius of circle: ");
 c.a = sc.nextInt();
 System.out.println();
 c.printArea();
 break;

}
}
}
