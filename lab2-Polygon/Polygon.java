import java.util.Scanner;

interface Polygon {
    double area();
    double perimeter();
}

class Triangle implements Polygon {
    double s1, s2, s3;

    Triangle(double s1, double s2, double s3) {
        this.s1 = s1; this.s2 = s2; this.s3 = s3;
    }

    public double area() {
        double s = (s1 + s2 + s3) / 2;
        return Math.sqrt(s * (s - s1) * (s - s2) * (s - s3));
    }

    public double perimeter() {
        return s1 + s2 + s3;
    }
}

class Quadrilateral implements Polygon {
    double s1, s2, s3, s4;

    Quadrilateral(double s1, double s2, double s3, double s4) {
        this.s1 = s1; this.s2 = s2; this.s3 = s3; this.s4 = s4;
    }

    public double area() {
        double s = (s1 + s2 + s3 + s4) / 2;
        return Math.sqrt((s - s1) * (s - s2) * (s - s3) * (s - s4));
    }

    public double perimeter() {
        return s1 + s2 + s3 + s4;
    }
}

class Pentagon implements Polygon {
    double s1, s2, s3, s4, s5;

    Pentagon(double s1, double s2, double s3, double s4, double s5) {
        this.s1 = s1; this.s2 = s2; this.s3 = s3; this.s4 = s4; this.s5 = s5;
    }

    public double area() {
        double s = perimeter() / 2;
        return Math.sqrt((s - s1) * (s - s2) * (s - s3) * (s - s4) * (s - s5));
    }

    public double perimeter() {
        return s1 + s2 + s3 + s4 + s5;
    }
}

class Hexagon implements Polygon {
    double s1, s2, s3, s4, s5, s6;

    Hexagon(double s1, double s2, double s3, double s4, double s5, double s6) {
        this.s1 = s1; this.s2 = s2; this.s3 = s3; this.s4 = s4; this.s5 = s5; this.s6 = s6;
    }

    public double area() {
        double s = perimeter() / 2;
        return Math.sqrt((s - s1)*(s - s2)*(s - s3)*(s - s4)*(s - s5)*(s - s6));
    }

    public double perimeter() {
        return s1 + s2 + s3 + s4 + s5 + s6;
    }
}

class Octagon implements Polygon {
    double s1, s2, s3, s4, s5, s6, s7, s8;

    Octagon(double s1, double s2, double s3, double s4, double s5, double s6, double s7, double s8) {
        this.s1 = s1; this.s2 = s2; this.s3 = s3; this.s4 = s4;
        this.s5 = s5; this.s6 = s6; this.s7 = s7; this.s8 = s8;
    }

    public double area() {
        double s = perimeter() / 2;
        return Math.sqrt((s - s1)*(s - s2)*(s - s3)*(s - s4)*(s - s5)*(s - s6)*(s - s7)*(s - s8));
    }

    public double perimeter() {
        return s1 + s2 + s3 + s4 + s5 + s6 + s7 + s8;
    }
}

class IsoscelesTriangle extends Triangle {
    IsoscelesTriangle(double equalSide, double base) {
        super(equalSide, equalSide, base);
    }
}

class EquilateralTriangle extends Triangle {
    EquilateralTriangle(double side) {
        super(side, side, side);
    }
}

class Rectangle extends Quadrilateral {
    double length, width;

    Rectangle(double length, double width) {
        super(length, width, length, width);
        this.length = length; this.width = width;
    }

    public double area() {
        return length * width;
    }
}

class Square extends Rectangle {
    Square(double side) {
        super(side, side);
    }
}

public class PolygonProj {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose a polygon:");
            System.out.println("1. Triangle");
            System.out.println("2. Isosceles Triangle");
            System.out.println("3. Equilateral Triangle");
            System.out.println("4. Quadrilateral");
            System.out.println("5. Rectangle");
            System.out.println("6. Square");
            System.out.println("7. Pentagon");
            System.out.println("8. Hexagon");
            System.out.println("9. Octagon");
            System.out.println("10. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            Polygon p = null;

            switch (choice) {
                case 1:
                    System.out.println("Enter side 1: "); double t1 = sc.nextDouble();
                    System.out.println("Enter side 2: "); double t2 = sc.nextDouble();
                    System.out.println("Enter side 3: "); double t3 = sc.nextDouble();
                    p = new Triangle(t1, t2, t3);
                    break;
                case 2:
                    System.out.println("Enter equal side: "); double eq = sc.nextDouble();
                    System.out.println("Enter base: "); double b = sc.nextDouble();
                    p = new IsoscelesTriangle(eq, b);
                    break;
                case 3:
                    System.out.println("Enter side: "); double s = sc.nextDouble();
                    p = new EquilateralTriangle(s);
                    break;
                case 4:
                    System.out.println("Enter side 1: "); double q1 = sc.nextDouble();
                    System.out.println("Enter side 2: "); double q2 = sc.nextDouble();
                    System.out.println("Enter side 3: "); double q3 = sc.nextDouble();
                    System.out.println("Enter side 4: "); double q4 = sc.nextDouble();
                    p = new Quadrilateral(q1, q2, q3, q4);
                    break;
                case 5:
                    System.out.println("Enter length: "); double l = sc.nextDouble();
                    System.out.println("Enter width: "); double w = sc.nextDouble();
                    p = new Rectangle(l, w);
                    break;
                case 6:
                    System.out.println("Enter side: "); double sq = sc.nextDouble();
                    p = new Square(sq);
                    break;
                case 7:
                    System.out.println("Enter side 1: "); double p1 = sc.nextDouble();
                    System.out.println("Enter side 2: "); double p2 = sc.nextDouble();
                    System.out.println("Enter side 3: "); double p3 = sc.nextDouble();
                    System.out.println("Enter side 4: "); double p4 = sc.nextDouble();
                    System.out.println("Enter side 5: "); double p5 = sc.nextDouble();
                    p = new Pentagon(p1, p2, p3, p4, p5);
                    break;
                case 8:
                    System.out.println("Enter side 1: "); double h1 = sc.nextDouble();
                    System.out.println("Enter side 2: "); double h2 = sc.nextDouble();
                    System.out.println("Enter side 3: "); double h3 = sc.nextDouble();
                    System.out.println("Enter side 4: "); double h4 = sc.nextDouble();
                    System.out.println("Enter side 5: "); double h5 = sc.nextDouble();
                    System.out.println("Enter side 6: "); double h6 = sc.nextDouble();
                    p = new Hexagon(h1, h2, h3, h4, h5, h6);
                    break;
                case 9:
                    System.out.println("Enter side 1: "); double o1 = sc.nextDouble();
                    System.out.println("Enter side 2: "); double o2 = sc.nextDouble();
                    System.out.println("Enter side 3: "); double o3 = sc.nextDouble();
                    System.out.println("Enter side 4: "); double o4 = sc.nextDouble();
                    System.out.println("Enter side 5: "); double o5 = sc.nextDouble();
                    System.out.println("Enter side 6: "); double o6 = sc.nextDouble();
                    System.out.println("Enter side 7: "); double o7 = sc.nextDouble();
                    System.out.println("Enter side 8: "); double o8 = sc.nextDouble();
                    p = new Octagon(o1, o2, o3, o4, o5, o6, o7, o8);
                    break;
                case 10:
                    System.out.println("Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }

            if (p != null) {
                System.out.println("Area = " + p.area());
                System.out.println("Perimeter = " + p.perimeter());
            }
        }
    }
}
