/* 
The Mother- David merlinskyYikai Wang 
APCS1 pd9 
HW43 -- This or That allitlle more stuff aswell
2015-12-08
*/ 
 
//skeleton file for class Binary 
 
public class Hexadecimal { 
    private final static String HEXDIGITS= "0123456789ABCDEF";
    public int _decNum; 
    public String _binNum; 
 
    /*===================================== 
      default constructor 
      pre:  n/a 
      post: initializes _decNum to 0, _binNum to "0" 
      =====================================*/ 
    public Hexadecimal() {  
    /****** YOUR IMPLEMENTATION HURRR ******/ 
    _decNum = 0; 
    _binNum = "0";    
    } 
 
 
    /*===================================== 
      overloaded constructor 
      pre:  n >= 0 
      post: sets _decNum to n, _binNum to equiv string of bits 
      =====================================*/ 
    public Hexadecimal( int n ) { 
    /****** YOUR IMPLEMENTATION HURRR ******/ 
    _decNum = n; 
    _binNum = decToBin( n );    
    } 
 
 
    /*===================================== 
      overloaded constructor 
      pre:  s is String representing non-negative binary number 
      post: sets _binNum to input, _decNum to decimal equiv 
      =====================================*/ 
    public Hexadecimal( String s ) { 
    /****** YOUR IMPLEMENTATION HURRR ******/ 
    _binNum = s; 
    _decNum = binToDec( s );    
    } 
 
    public int get(){return _decNum;}
    /*===================================== 
      String toString() -- returns String representation of this Object 
      pre:  n/a 
      post: returns String of 1's and 0's representing value of this Object 
      =====================================*/ 
    public String toString() {  
    /****** YOUR IMPLEMENTATION HURRR ******/ 
    return _binNum;    
    } 
 
 
    /*===================================== 
      String decToBin(int) -- converts base-10 input to binary 
      pre:  n >= 0 
      post: returns String of bits 
      eg  decToBin(0) -> "0" 
      decToBin(1) -> "1" 
      decToBin(2) -> "10" 
      decToBin(3) -> "11" 
      decToBin(14) -> "1110" 
      =====================================*/ 
    public static String decToBin( int n ) { 
    /****** YOUR IMPLEMENTATION HURRR ******/ 
    if( n > 0 ) { //if the number isn't zero, so there won't be extra 0s at the end 
    String s = ""; 
 
    while( n != 0 ) { 
        s = HEXDIGITS.charAt(n%16) + "" + s; //adds the remainders to the left side 
        n /= 16; 
    } 
    return s; 
    } 
    return "0"; 
    } 
 
    /*===================================== 
      String decToBinR(int) -- converts base-10 input to binary, recursively 
      pre:  n >= 0 
      post: returns String of bits 
      eg  decToBinR(0) -> "0" 
      decToBinR(1) -> "1" 
      decToBinR(2) -> "10" 
      decToBinR(3) -> "11" 
      decToBinR(14) -> "1110" 
      =====================================*/ 
    public static String decToBinR( int n ) {  
    /****** YOUR IMPLEMENTATION HURRR ******/ 
    if( n == 0 ) 
      { 
        return "0"; 
      } 
    return decToBinR( n / 16 ) + "" + HEXDIGITS.charAt( n % 16 );//adds remainders to the left    
    } 
 
 
    /*===================================== 
      int binToDec(String) -- converts base-10 input to binary 
      pre:  s represents non-negative binary number 
      post: returns decimal equivalent of int 
      eg   
      binToDec("0") -> 0 
      binToDec("1") -> 1 
      binToDec("10") -> 2 
      binToDec("11") -> 3 
      binToDec("1110") -> 14 
      =====================================*/ 
    public static int binToDec( String s ) { 
    /****** YOUR IMPLEMENTATION HURRR ******/ 
       int i = 0; 
       for( int n = s.length() - 1; n >= 0; --n ) { 
        int pow = s.length() - 1 - n; //for exponent 
        i+= (int) Math.pow( 16, pow ) * HEXDIGITS.indexOf(s.substring(n, n + 1 ) );//s[n] * 2^pow 
       } 
       return i; 
    } 
 
 
    /*===================================== 
      int binToDecR(String) -- converts base-10 input to binary, recursively 
      pre:  s represents non-negative binary number 
      post: returns decimal equivalent of int 
      eg   
      binToDecR("0") -> 0 
      binToDecR("1") -> 1 
      binToDecR("10") -> 2 
      binToDecR("11") -> 3 
      binToDecR("1110") -> 14 
      =====================================*/ 
    public static int  binToDecR( String s ) {  
    /****** YOUR IMPLEMENTATION HURRR ******/ 
      if( s.length() == 1 )//if it's a single digit ( 0 or 1 ) 
      { 
	  return HEXDIGITS.indexOf(s); 
      } 
      int n = s.length() - 1;//gets exponent 
      int val = HEXDIGITS.indexOf(s.substring( 0, 1 ) ); 
      return (int) Math.pow( 16, n ) * val + binToDecR( s.substring( 1 ) ); 
    } 
 
 
    /*============================================= 
      boolean equals(Object) -- tells whether 2 Objs are equivalent 
      pre:  other is an instance of class Binary 
      post: Returns true if this and other are aliases (pointers to same  
      Object), or if this and other represent equal binary values 
      =============================================*/
    public boolean equals( Object other ) {  
    /****** YOUR IMPLE*/
    return compareTo( other ) == 0;    
    } 
 
    /*============================================= 
      int compareTo(Object) -- tells which of two Binary objects is greater 
      pre:  other is instance of class Binary 
      post: Returns 0 if this Object is equal to the input Object, 
      negative integer if this<input, positive integer otherwise 
      =============================================*/
    public int compareTo( Object o ) {
	if(!(other instaceof Comparable))
            throw new ClassCastException("Error, the input is not Binary");
        if(other==null)
            throw new NullPointerException("Error, input is null");

    /****** YOUR IMPLEMENTATION HURRR ******/ 
    if ( o instanceof Hexadecimal ) {//if they are the same object 
      Hexadecimal obj = (Hexadecimal) o; 
      if( (this._decNum == obj._decNum) || (this._binNum.equals(obj._binNum)) ) { 
        return 0;//same values 
      } 
      int val = binToDec( obj._binNum ); 
      if(( this._decNum > obj._decNum ) || ( this._decNum > val )) { 
        return 1;//if the other object is bigger 
      }
      else{
	  return -1;
      }
    }
    else if (o instanceof Rational){
        Rational obj = (Rational) o;
        if( this._decNum == obj.get()){
            return 0;
        }
        if(this._decNum> obj.get()){
            return 1;
        }
        else {
            return -1;
        }
    }
    else if (o instanceof Binary){
        Binary obj = (Binary) o;
        if( this._decNum == obj.get()){
            return 0;
        }
        if(this._decNum> obj.get()){
            return 1;
        }
        else {
            return -1;
        }
    }
    return -1;
    }
    //main method for testing 
    public static void main( String[] args ) { 
 
    System.out.println(); 
    System.out.println( "Testing ..." ); 
 
    Binary b1 = new Binary(123); 
    Hexadecimal b2 = new Hexadecimal(15); 
    Hexadecimal b3 = new Hexadecimal(123); 
    Hexadecimal b4 = new Hexadecimal(31); 
 
    System.out.println( b1 );//101 
    System.out.println( b2 );//101 
    System.out.println( b3 );//101      
    System.out.println( b4 );//111        
 
    System.out.println( "\n==..." );  //should be false  //should be true 
 
    System.out.println( "\n.equals()..." );  //should be true  //should be true  //should be true 
    System.out.println( b4.equals(b2) ); //should be false  //should be false 
    System.out.println(binToDecR("3E8"));

    System.out.println( "\n.compareTo..." ); 
    System.out.println( b1.compareTo(b2) ); //should be 0 
    System.out.println( b1.compareTo(b3) ); //should be 0 
    System.out.println( b1.compareTo(b4) ); //should be neg 
    System.out.println( b4.compareTo(b1) ); //should be pos 
    
    }//end main() 
 
} //end class
