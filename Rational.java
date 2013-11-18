public class Rational{

    private int numerator;
    private int denominator;
    
    public Rational(){
        numerator = 0;
        denominator = 1;
    }
    
    public Rational( int n, int d ){
        numerator = n;
        if ( denominator == 0){
            System.out.println("Error: Cannot have zero denominator");
            numerator = 0;
            denominator = 1;
        }
        else {
            denominator = d;
        }
    }
    
    

}
