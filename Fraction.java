class Fraction {
   private int numerator;
   private int denominator;
   public Fraction(int num, int den){
      
       if(den==0)throw new IllegalArgumentException("Denominator is zero!");
       
       if(num<0 && den<0){
           num=num*-1;
           den=den*-1;
       }
       else if(den<0){
           den=den*-1;
           num=num*-1;
       }
       numerator=num;
       denominator=den;
       //System.out.println("Numerator: "+num+" denominator: "+den);
   }//constructor with two parameters
  public Fraction(int par){
      this(par,1);
  }//one parameter constructor
  public Fraction(){
      this(0,1);
  }//zero parameter constructor
  public int getNumerator(){
    return numerator;
  }
  public int getDenominator(){
      return denominator;
  }
  public String toString(){
      return ""+numerator+"/"+denominator;
  }
  public double toDouble(){
      return (double) numerator/denominator;
  }
  public Fraction add(Fraction other){
      int num=0;
      int den=1;
      Fraction fr=new Fraction();
    
      num=this.numerator*other.denominator+other.numerator*this.denominator;
      den=this.denominator*other.denominator;
      
      fr=new Fraction(num,den);
      fr.toLowestTerms();
      return fr;
  }
  public Fraction subtract(Fraction other){
      int num=0;
      int den=1;
    
      {
          num=this.numerator*other.denominator-other.numerator*this.denominator;
          den=this.denominator*other.denominator;
      }
      Fraction fr=new Fraction(num,den);
      fr.toLowestTerms();
      return fr;
  }
  public Fraction divide(Fraction other){
      int den= other.numerator*this.denominator;
      int num= other.denominator*this.numerator;
      if(den==0)System.out.println(other.toString()+"/"+this.toString()+" undefined");
      Fraction fr=new Fraction(num,den);
      fr.toLowestTerms();
      return fr;
  }
  public Fraction multiply(Fraction other){
      int num= this.numerator*other.numerator;
      int den= this.denominator*other.denominator;
      Fraction fr= new Fraction(num,den);
      fr.toLowestTerms();
      return fr;
  }
  public boolean equals(Fraction other){
      other.toLowestTerms();
      this.toLowestTerms(); 
      if(this.numerator==other.numerator && this.denominator==other.denominator)return true;
      return false;
  }
  public void toLowestTerms(){
      int ans=gdc(this.numerator, this.denominator);
      this.numerator/=ans;
      this.denominator/=ans;
      //System.out.println("Numerator: "+this.numerator+ " denominator: "+ this.denominator);
  }
  public static  int gdc(int num, int den){
     /*
    while a and b are not zero
    find the remainder of a divided by b
    set a to b
    set b to the remainder you found
    return a
    */
    
    int div=0;
    num=Math.abs(num);
    den=Math.abs(den);
  
    int a=num;
    int b=den;
    while(a!=0 && b!=0){
      div=a%b;
      a=b;
      b=div;
    }
    //System.out.println("gdc=: "+a);
    return a;  
  }

}