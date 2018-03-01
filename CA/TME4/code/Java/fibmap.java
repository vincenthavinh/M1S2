/**
 *  fibmap.java engendre par ml2java 
 */


/**
 *  de'claration de la fonction fib___1
 *    vue comme la classe : MLfun_fib___1
 */ 
class MLfun_fib___1 extends MLfun {

  private static int MAX = 1;

  MLfun_fib___1() {super();}

  MLfun_fib___1(int n) {super(n);}

  public MLvalue invoke(MLvalue MLparam){
    if (MLcounter == (MAX-1)) {
      return invoke_real(MLparam);
    }
    else {
      MLfun_fib___1 l = new MLfun_fib___1(MLcounter+1);l.MLaddenv(MLenv,MLparam); return l;
    }
  }


  MLvalue invoke_real(MLvalue x___2) {

    { 
      MLvalue T___3;
      { 
        MLvalue T___4;
        MLvalue T___5;
        T___4=x___2;
        T___5=new MLint(2);
        T___3=MLruntime.MLltint( (MLint )T___4,(MLint )T___5);
      }
      if (((MLbool)T___3).MLaccess())
        { 
          MLvalue T___6;
          T___6=new MLint(1);
          return T___6;
        }
      else
        { 
          MLvalue T___7;
          { 
            MLvalue T___8;
            MLvalue T___13;
            { 
              MLvalue T___9;
              MLvalue T___10;
              T___9=fibmap.fib___1;
              { 
                MLvalue T___11;
                MLvalue T___12;
                T___11=x___2;
                T___12=new MLint(1);
                T___10=MLruntime.MLsubint( (MLint )T___11,(MLint )T___12);
              }
              T___8=((MLfun)T___9).invoke(T___10);
            }
            { 
              MLvalue T___14;
              MLvalue T___15;
              T___14=fibmap.fib___1;
              { 
                MLvalue T___16;
                MLvalue T___17;
                T___16=x___2;
                T___17=new MLint(2);
                T___15=MLruntime.MLsubint( (MLint )T___16,(MLint )T___17);
              }
              T___13=((MLfun)T___14).invoke(T___15);
            }
            T___7=MLruntime.MLaddint( (MLint )T___8,(MLint )T___13);
          }
          return T___7;
        }
    }
  }

}
// fin de la classe MLfun_fib___1


/**
 *  de'claration de la fonction map___18
 *    vue comme la classe : MLfun_map___18
 */ 
class MLfun_map___18 extends MLfun {

  private static int MAX = 2;

  MLfun_map___18() {super();}

  MLfun_map___18(int n) {super(n);}

  public MLvalue invoke(MLvalue MLparam){
    if (MLcounter == (MAX-1)) {
      return invoke_real(MLenv[0], MLparam);
    }
    else {
      MLfun_map___18 l = new MLfun_map___18(MLcounter+1);l.MLaddenv(MLenv,MLparam); return l;
    }
  }


  MLvalue invoke_real(MLvalue f___19, MLvalue l___20) {

    { 
      MLvalue T___21;
      { 
        MLvalue T___22;
        MLvalue T___23;
        T___22=l___20;
        T___23=MLruntime.MLnil;
        T___21=MLruntime.MLequal( (MLlist )T___22,(MLlist )T___23);
      }
      if (((MLbool)T___21).MLaccess())
        { 
          MLvalue T___24;
          T___24=MLruntime.MLnil;
          return T___24;
        }
      else
        { 
          MLvalue T___25;
          { 
            MLvalue T___26;
            MLvalue T___31;
            { 
              MLvalue T___27;
              MLvalue T___28;
              T___27=f___19;
              { 
                MLvalue T___29;
                MLvalue T___30;
                T___29=MLruntime.MLhd;
                T___30=l___20;
                T___28=((MLfun)T___29).invoke(T___30);
              }
              T___26=((MLfun)T___27).invoke(T___28);
            }
            { 
              MLvalue T___32;
              MLvalue T___35;
              { 
                MLvalue T___33;
                MLvalue T___34;
                T___33=fibmap.map___18;
                T___34=f___19;
                T___32=((MLfun)T___33).invoke(T___34);
              }
              { 
                MLvalue T___36;
                MLvalue T___37;
                T___36=MLruntime.MLtl;
                T___37=l___20;
                T___35=((MLfun)T___36).invoke(T___37);
              }
              T___31=((MLfun)T___32).invoke(T___35);
            }
            T___25=MLruntime.MLlist( (MLvalue )T___26,(MLlist )T___31);
          }
          return T___25;
        }
    }
  }

}
// fin de la classe MLfun_map___18
/**
 * 
 */
class fibmap {

  static MLvalue fib___1= new MLfun_fib___1(1);
  static MLvalue map___18= new MLfun_map___18(2);
  static MLvalue value___38;

public static void main(String []args) {

{ 
  MLvalue T___39;
  MLvalue T___40;
  T___39=fibmap.map___18;
  T___40=fibmap.fib___1;
  value___38=((MLfun)T___39).invoke(T___40);
}
{ 
  MLvalue bidon___41;
  bidon___41=MLruntime.MLlrp;
  bidon___41=MLruntime.MLprint( (MLvalue )value___38);
}
}}

// fin du fichier fibmap.java
