package StartAtGoogle.week2.ClassesAndInterfaces;

// Tagged class - vastly inferior to a class hierarchy! (Page 109)
interface Figure {
    double area();
}


class RECTANGLE implements Figure{
    private double length;
    private double width;

    RECTANGLE(double length, double width) {
        this.width = width;
        this.length = length;
    }
    public double area(){
        return length * width;
    }
}

class CIRCLE implements Figure{
    private double radius;

    public CIRCLE(double radius) {
        this.radius= radius;
    }

    public double area() {
        return Math.PI * (radius * radius);
    }
}

class Square extends RECTANGLE{
    public Square(double length){
        super(length,length);
    }
}




