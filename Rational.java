public class Rational implements Comparable{

    private int numerator;
    private int denominator;
    
    public Rational(){
        numerator = 0;
        denominator = 1;
    }
    
    public Rational( int n, int d ){
        numerator = n;
        if ( d == 0){
            System.out.println("Error: Cannot have zero denominator");
            numerator = 0;
            denominator = 1;
        }
        else {
            denominator = d;
        }
    }

    public int getNum(){
	return numerator;
    }

    public int getDen(){
	return denominator;
    }
    
    public String toString(){
        String nr = "" + numerator;
        String dr = "" + denominator;
        return nr + "/" + dr;
    }
    
    public double floatValue(){
	double a = 1;
	a *= numerator;
        a /= denominator;
        return a;
    }
    
    public void multiply( Rational rat ){
        int a = this.getNum() * rat.getNum();
	int b = this.getDen() * rat.getDen();
	numerator = a;
	denominator = b;
    }

    public void divide( Rational rat ){
        int a = this.getNum() * rat.getDen();
	int b = this.getDen() * rat.getNum();
	numerator = a;
	denominator = b;
    }

    public int gcd(int a, int b){
	int temp;
        while(b != 0){
            temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public void add( Rational rat ){
	if (this.getDen() == rat.getDen()){
	    numerator = this.getNum() - rat.getNum();
	}
	else {
	    int den = this.getDen() * rat.getDen();
	    int num = this.getNum() * rat.getDen(); 
	    num -= rat.getNum() * this.getDen();
	    numerator = num;
	    denominator = den;
	}
    }

    public void subtract( Rational rat ){
	if (this.getDen() == rat.getDen()){
	    numerator = rat.getNum() - this.getNum();
	}
	else {
	    int den = this.getDen() * rat.getDen();
	    int num = this.getNum() * rat.getDen(); 
	    num -= rat.getNum() * this.getDen();
	    numerator = num;
	    denominator = den;
	}
    }


    public void reduce(){
	int gcd = gcd(numerator, denominator);
	numerator /= gcd;
	denominator /= gcd;
    }

    public static int gcdStatic(int a, int b){
	int temp;
        while(b != 0){
            temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public boolean equals( Rational a ){
    	reduce();
        a.reduce();
	if (numerator == a.getNum() && denominator == a.getDen()){
	    return true;
	}
	else{
	    return false;
	}
    }

    public int compareTo( Object rat ) {
    	if (!(rat instanceOf Rational)){
    		System.out.println("Error: Object not of Class Rational");
    	}
        int num;
	int ratNum;
        num = numerator * ((Rational)rat).getDen();
        ratNum = denominator * ((Rational)rat).getNum();

        return num - ratNum;

    }

}
