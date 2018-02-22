/**
 *  ftest.java engendre par ml2java 
 */


/**
 *  de'claration de la fonction null___1
 *    vue comme la classe : MLfun_null___1
 */ 
class MLfun_null___1 extends MLfun {

  private static int MAX = 1;

  MLfun_null___1() {super();}

  MLfun_null___1(int n) {super(n);}

  public MLvalue invoke(MLvalue MLparam){
    if (MLcounter == (MAX-1)) {
      return invoke_real(MLparam);
    }
    else {
      MLfun_null___1 l = new MLfun_null___1(MLcounter+1);l.MLaddenv(MLenv,MLparam); return l;
    }
  }


  MLvalue invoke_real(MLvalue l___2) {

    { 
      MLvalue ___3;
      { 
        MLvalue ___4;
        MLvalue ___5;
        ___4=l___2;
        ___5=MLruntime.MLnil;
        ___3=MLruntime.MLequal( (MLlist )___4,(MLlist )___5);
      }
      if (((MLbool)___3).MLaccess())
        { 
          MLvalue ___6;
          ___6=MLruntime.MLtrue;
          return ___6;
        }
      else
        { 
          MLvalue ___7;
          ___7=MLruntime.MLfalse;
          return ___7;
        }
    }
  }

}
// fin de la classe MLfun_null___1


/**
 *  de'claration de la fonction g___8
 *    vue comme la classe : MLfun_g___8
 */ 
class MLfun_g___8 extends MLfun {

  private static int MAX = 1;

  MLfun_g___8() {super();}

  MLfun_g___8(int n) {super(n);}

  public MLvalue invoke(MLvalue MLparam){
    if (MLcounter == (MAX-1)) {
      return invoke_real(MLparam);
    }
    else {
      MLfun_g___8 l = new MLfun_g___8(MLcounter+1);l.MLaddenv(MLenv,MLparam); return l;
    }
  }


  MLvalue invoke_real(MLvalue x___9) {

    { 
      MLvalue ___10;
      MLvalue ___11;
      ___10=x___9;
      ___11=MLruntime.MLnil;
      return MLruntime.MLequal( (MLlist )___10,(MLlist )___11);
    }
  }

}
// fin de la classe MLfun_g___8


/**
 *  de'claration de la fonction h___12
 *    vue comme la classe : MLfun_h___12
 */ 
class MLfun_h___12 extends MLfun {

  private static int MAX = 2;

  MLfun_h___12() {super();}

  MLfun_h___12(int n) {super(n);}

  public MLvalue invoke(MLvalue MLparam){
    if (MLcounter == (MAX-1)) {
      return invoke_real(MLenv[0], MLparam);
    }
    else {
      MLfun_h___12 l = new MLfun_h___12(MLcounter+1);l.MLaddenv(MLenv,MLparam); return l;
    }
  }


  MLvalue invoke_real(MLvalue x___13, MLvalue y___14) {

    { 
      MLvalue ___15;
      MLvalue ___16;
      ___15=x___13;
      ___16=y___14;
      return MLruntime.MLlist( (MLvalue )___15,(MLlist )___16);
    }
  }

}
// fin de la classe MLfun_h___12


/**
 *  de'claration de la fonction q___17
 *    vue comme la classe : MLfun_q___17
 */ 
class MLfun_q___17 extends MLfun {

  private static int MAX = 1;

  MLfun_q___17() {super();}

  MLfun_q___17(int n) {super(n);}

  public MLvalue invoke(MLvalue MLparam){
    if (MLcounter == (MAX-1)) {
      return invoke_real(MLparam);
    }
    else {
      MLfun_q___17 l = new MLfun_q___17(MLcounter+1);l.MLaddenv(MLenv,MLparam); return l;
    }
  }


  MLvalue invoke_real(MLvalue x___18) {

    { 
      MLvalue ___19;
      MLvalue ___22;
      { 
        MLvalue ___20;
        MLvalue ___21;
        ___20=MLruntime.MLhd;
        ___21=x___18;
        ___19=((MLfun)___20).invoke(___21);
      }
      { 
        MLvalue ___23;
        MLvalue ___24;
        ___23=MLruntime.MLtl;
        ___24=x___18;
        ___22=((MLfun)___23).invoke(___24);
      }
      return MLruntime.MLpair( (MLvalue )___19,(MLlist )___22);
    }
  }

}
// fin de la classe MLfun_q___17


/**
 *  de'claration de la fonction v___25
 *    vue comme la classe : MLfun_v___25
 */ 
class MLfun_v___25 extends MLfun {

  private static int MAX = 1;

  MLfun_v___25() {super();}

  MLfun_v___25(int n) {super(n);}

  public MLvalue invoke(MLvalue MLparam){
    if (MLcounter == (MAX-1)) {
      return invoke_real(MLparam);
    }
    else {
      MLfun_v___25 l = new MLfun_v___25(MLcounter+1);l.MLaddenv(MLenv,MLparam); return l;
    }
  }


  MLvalue invoke_real(MLvalue x___26) {

    return MLruntime.MLnil;
  }

}
// fin de la classe MLfun_v___25


/**
 *  de'claration de la fonction w___27
 *    vue comme la classe : MLfun_w___27
 */ 
class MLfun_w___27 extends MLfun {

  private static int MAX = 2;

  MLfun_w___27() {super();}

  MLfun_w___27(int n) {super(n);}

  public MLvalue invoke(MLvalue MLparam){
    if (MLcounter == (MAX-1)) {
      return invoke_real(MLenv[0], MLparam);
    }
    else {
      MLfun_w___27 l = new MLfun_w___27(MLcounter+1);l.MLaddenv(MLenv,MLparam); return l;
    }
  }


  MLvalue invoke_real(MLvalue l___28, MLvalue x___29) {

    { 
      MLvalue ___30;
      { 
        MLvalue ___31;
        MLvalue ___32;
        ___31=l___28;
        ___32=MLruntime.MLnil;
        ___30=MLruntime.MLequal( (MLlist )___31,(MLlist )___32);
      }
      if (((MLbool)___30).MLaccess())
        { 
          MLvalue ___33;
          ___33=MLruntime.MLnil;
          return ___33;
        }
      else
        { 
          MLvalue ___34;
          { 
            MLvalue ___35;
            MLvalue ___36;
            ___35=x___29;
            ___36=MLruntime.MLnil;
            ___34=MLruntime.MLlist( (MLvalue )___35,(MLlist )___36);
          }
          return ___34;
        }
    }
  }

}
// fin de la classe MLfun_w___27


/**
 *  de'claration de la fonction map___37
 *    vue comme la classe : MLfun_map___37
 */ 
class MLfun_map___37 extends MLfun {

  private static int MAX = 2;

  MLfun_map___37() {super();}

  MLfun_map___37(int n) {super(n);}

  public MLvalue invoke(MLvalue MLparam){
    if (MLcounter == (MAX-1)) {
      return invoke_real(MLenv[0], MLparam);
    }
    else {
      MLfun_map___37 l = new MLfun_map___37(MLcounter+1);l.MLaddenv(MLenv,MLparam); return l;
    }
  }


  MLvalue invoke_real(MLvalue f___38, MLvalue l___39) {

    { 
      MLvalue ___40;
      { 
        MLvalue ___41;
        MLvalue ___42;
        ___41=ftest.null___1;
        ___42=l___39;
        ___40=((MLfun)___41).invoke(___42);
      }
      if (((MLbool)___40).MLaccess())
        { 
          MLvalue ___43;
          ___43=MLruntime.MLnil;
          return ___43;
        }
      else
        { 
          MLvalue ___44;
          { 
            MLvalue ___45;
            MLvalue ___50;
            { 
              MLvalue ___46;
              MLvalue ___47;
              ___46=f___38;
              { 
                MLvalue ___48;
                MLvalue ___49;
                ___48=MLruntime.MLhd;
                ___49=l___39;
                ___47=((MLfun)___48).invoke(___49);
              }
              ___45=((MLfun)___46).invoke(___47);
            }
            { 
              MLvalue ___51;
              MLvalue ___54;
              { 
                MLvalue ___52;
                MLvalue ___53;
                ___52=ftest.map___37;
                ___53=f___38;
                ___51=((MLfun)___52).invoke(___53);
              }
              { 
                MLvalue ___55;
                MLvalue ___56;
                ___55=MLruntime.MLtl;
                ___56=l___39;
                ___54=((MLfun)___55).invoke(___56);
              }
              ___50=((MLfun)___51).invoke(___54);
            }
            ___44=MLruntime.MLlist( (MLvalue )___45,(MLlist )___50);
          }
          return ___44;
        }
    }
  }

}
// fin de la classe MLfun_map___37


/**
 *  de'claration de la fonction iter___57
 *    vue comme la classe : MLfun_iter___57
 */ 
class MLfun_iter___57 extends MLfun {

  private static int MAX = 2;

  MLfun_iter___57() {super();}

  MLfun_iter___57(int n) {super(n);}

  public MLvalue invoke(MLvalue MLparam){
    if (MLcounter == (MAX-1)) {
      return invoke_real(MLenv[0], MLparam);
    }
    else {
      MLfun_iter___57 l = new MLfun_iter___57(MLcounter+1);l.MLaddenv(MLenv,MLparam); return l;
    }
  }


  MLvalue invoke_real(MLvalue f___58, MLvalue l___59) {

    { 
      MLvalue ___60;
      { 
        MLvalue ___61;
        MLvalue ___62;
        ___61=ftest.null___1;
        ___62=l___59;
        ___60=((MLfun)___61).invoke(___62);
      }
      if (((MLbool)___60).MLaccess())
        { 
          MLvalue ___63;
          ___63=MLruntime.MLnil;
          return ___63;
        }
      else
        { 
          MLvalue ___64;
          { 
            MLvalue ___65;
            MLvalue ___66;
            ___65=ftest.iter___57;
            { 
              MLvalue ___67;
              MLvalue ___68;
              ___67=f___58;
              { 
                MLvalue ___69;
                MLvalue ___70;
                ___69=MLruntime.MLtl;
                ___70=l___59;
                ___68=((MLfun)___69).invoke(___70);
              }
              ___66=((MLfun)___67).invoke(___68);
            }
            ___64=((MLfun)___65).invoke(___66);
          }
          return ___64;
        }
    }
  }

}
// fin de la classe MLfun_iter___57


/**
 *  de'claration de la fonction inter___71
 *    vue comme la classe : MLfun_inter___71
 */ 
class MLfun_inter___71 extends MLfun {

  private static int MAX = 2;

  MLfun_inter___71() {super();}

  MLfun_inter___71(int n) {super(n);}

  public MLvalue invoke(MLvalue MLparam){
    if (MLcounter == (MAX-1)) {
      return invoke_real(MLenv[0], MLparam);
    }
    else {
      MLfun_inter___71 l = new MLfun_inter___71(MLcounter+1);l.MLaddenv(MLenv,MLparam); return l;
    }
  }


  MLvalue invoke_real(MLvalue a___72, MLvalue b___73) {

    { 
      MLvalue ___74;
      { 
        MLvalue ___75;
        MLvalue ___76;
        ___75=a___72;
        ___76=b___73;
        ___74=MLruntime.MLgtint( (MLint )___75,(MLint )___76);
      }
      if (((MLbool)___74).MLaccess())
        { 
          MLvalue ___77;
          ___77=MLruntime.MLnil;
          return ___77;
        }
      else
        { 
          MLvalue ___78;
          { 
            MLvalue ___79;
            MLvalue ___80;
            ___79=a___72;
            { 
              MLvalue ___81;
              MLvalue ___86;
              { 
                MLvalue ___82;
                MLvalue ___83;
                ___82=ftest.inter___71;
                { 
                  MLvalue ___84;
                  MLvalue ___85;
                  ___84=a___72;
                  ___85=new MLint(1);
                  ___83=MLruntime.MLaddint( (MLint )___84,(MLint )___85);
                }
                ___81=((MLfun)___82).invoke(___83);
              }
              ___86=b___73;
              ___80=((MLfun)___81).invoke(___86);
            }
            ___78=MLruntime.MLlist( (MLint )___79,(MLlist )___80);
          }
          return ___78;
        }
    }
  }

}
// fin de la classe MLfun_inter___71


/**
 *  de'claration de la fonction mult___87
 *    vue comme la classe : MLfun_mult___87
 */ 
class MLfun_mult___87 extends MLfun {

  private static int MAX = 2;

  MLfun_mult___87() {super();}

  MLfun_mult___87(int n) {super(n);}

  public MLvalue invoke(MLvalue MLparam){
    if (MLcounter == (MAX-1)) {
      return invoke_real(MLenv[0], MLparam);
    }
    else {
      MLfun_mult___87 l = new MLfun_mult___87(MLcounter+1);l.MLaddenv(MLenv,MLparam); return l;
    }
  }


  MLvalue invoke_real(MLvalue x___88, MLvalue y___89) {

    { 
      MLvalue ___90;
      MLvalue ___91;
      ___90=x___88;
      ___91=y___89;
      return MLruntime.MLmulint( (MLint )___90,(MLint )___91);
    }
  }

}
// fin de la classe MLfun_mult___87


/**
 *  de'claration de la fonction umap___126
 *    vue comme la classe : MLfun_umap___126
 */ 
class MLfun_umap___126 extends MLfun {

  private static int MAX = 2;

  MLfun_umap___126() {super();}

  MLfun_umap___126(int n) {super(n);}

  public MLvalue invoke(MLvalue MLparam){
    if (MLcounter == (MAX-1)) {
      return invoke_real(MLenv[0], MLparam);
    }
    else {
      MLfun_umap___126 l = new MLfun_umap___126(MLcounter+1);l.MLaddenv(MLenv,MLparam); return l;
    }
  }


  MLvalue invoke_real(MLvalue l___127, MLvalue x___128) {

    { 
      MLvalue ___129;
      { 
        MLvalue ___130;
        MLvalue ___131;
        ___130=ftest.null___1;
        ___131=l___127;
        ___129=((MLfun)___130).invoke(___131);
      }
      if (((MLbool)___129).MLaccess())
        { 
          MLvalue ___132;
          ___132=MLruntime.MLnil;
          return ___132;
        }
      else
        { 
          MLvalue ___133;
          { 
            MLvalue ___134;
            MLvalue ___139;
            { 
              MLvalue ___135;
              MLvalue ___138;
              { 
                MLvalue ___136;
                MLvalue ___137;
                ___136=MLruntime.MLhd;
                ___137=l___127;
                ___135=((MLfun)___136).invoke(___137);
              }
              ___138=x___128;
              ___134=((MLfun)___135).invoke(___138);
            }
            { 
              MLvalue ___140;
              MLvalue ___145;
              { 
                MLvalue ___141;
                MLvalue ___142;
                ___141=ftest.umap___126;
                { 
                  MLvalue ___143;
                  MLvalue ___144;
                  ___143=MLruntime.MLtl;
                  ___144=l___127;
                  ___142=((MLfun)___143).invoke(___144);
                }
                ___140=((MLfun)___141).invoke(___142);
              }
              ___145=x___128;
              ___139=((MLfun)___140).invoke(___145);
            }
            ___133=MLruntime.MLlist( (MLvalue )___134,(MLlist )___139);
          }
          return ___133;
        }
    }
  }

}
// fin de la classe MLfun_umap___126
/**
 * 
 */
class ftest {

  static MLvalue null___1= new MLfun_null___1(1);
  static MLvalue g___8= new MLfun_g___8(1);
  static MLvalue h___12= new MLfun_h___12(2);
  static MLvalue q___17= new MLfun_q___17(1);
  static MLvalue v___25= new MLfun_v___25(1);
  static MLvalue w___27= new MLfun_w___27(2);
  static MLvalue map___37= new MLfun_map___37(2);
  static MLvalue iter___57= new MLfun_iter___57(2);
  static MLvalue inter___71= new MLfun_inter___71(2);
  static MLvalue mult___87= new MLfun_mult___87(2);
  static MLvalue i___92;
  static MLvalue l___98;
  static MLvalue fd___106;
  static MLvalue ig___108;
  static MLvalue bi___114;
  static MLvalue ik___118;
  static MLvalue b___122;
  static MLvalue umap___126= new MLfun_umap___126(2);
  static MLvalue value___146;

public static void main(String []args) {

{ 
  MLvalue ___93;
  MLvalue ___96;
  { 
    MLvalue ___94;
    MLvalue ___95;
    ___94=ftest.inter___71;
    ___95=new MLint(1);
    ___93=((MLfun)___94).invoke(___95);
  }
  ___96=new MLint(10);
  i___92=((MLfun)___93).invoke(___96);
}
{ 
  MLvalue bidon___97;
  bidon___97=MLruntime.MLlrp;
  bidon___97=MLruntime.MLprint( (MLvalue )i___92);
}
{ 
  MLvalue ___99;
  MLvalue ___104;
  { 
    MLvalue ___100;
    MLvalue ___101;
    ___100=ftest.map___37;
    { 
      MLvalue ___102;
      MLvalue ___103;
      ___102=ftest.mult___87;
      ___103=new MLint(5);
      ___101=((MLfun)___102).invoke(___103);
    }
    ___99=((MLfun)___100).invoke(___101);
  }
  ___104=i___92;
  l___98=((MLfun)___99).invoke(___104);
}
{ 
  MLvalue bidon___105;
  bidon___105=MLruntime.MLlrp;
  bidon___105=MLruntime.MLprint( (MLvalue )l___98);
}
fd___106=ftest.map___37;
{ 
  MLvalue bidon___107;
  bidon___107=MLruntime.MLlrp;
  bidon___107=MLruntime.MLprint( (MLvalue )fd___106);
}
{ 
  MLvalue ___109;
  MLvalue ___110;
  ___109=ftest.map___37;
  { 
    MLvalue ___111;
    MLvalue ___112;
    ___111=ftest.mult___87;
    ___112=new MLint(5);
    ___110=((MLfun)___111).invoke(___112);
  }
  ig___108=((MLfun)___109).invoke(___110);
}
{ 
  MLvalue bidon___113;
  bidon___113=MLruntime.MLlrp;
  bidon___113=MLruntime.MLprint( (MLvalue )ig___108);
}
{ 
  MLvalue ___115;
  MLvalue ___116;
  ___115=ig___108;
  ___116=l___98;
  bi___114=((MLfun)___115).invoke(___116);
}
{ 
  MLvalue bidon___117;
  bidon___117=MLruntime.MLlrp;
  bidon___117=MLruntime.MLprint( (MLvalue )bi___114);
}
{ 
  MLvalue ___119;
  MLvalue ___120;
  ___119=ftest.map___37;
  ___120=ftest.mult___87;
  ik___118=((MLfun)___119).invoke(___120);
}
{ 
  MLvalue bidon___121;
  bidon___121=MLruntime.MLlrp;
  bidon___121=MLruntime.MLprint( (MLvalue )ik___118);
}
{ 
  MLvalue ___123;
  MLvalue ___124;
  ___123=ik___118;
  ___124=i___92;
  b___122=((MLfun)___123).invoke(___124);
}
{ 
  MLvalue bidon___125;
  bidon___125=MLruntime.MLlrp;
  bidon___125=MLruntime.MLprint( (MLvalue )b___122);
}
{ 
  MLvalue ___147;
  MLvalue ___150;
  { 
    MLvalue ___148;
    MLvalue ___149;
    ___148=ftest.umap___126;
    ___149=b___122;
    ___147=((MLfun)___148).invoke(___149);
  }
  ___150=new MLint(10);
  value___146=((MLfun)___147).invoke(___150);
}
{ 
  MLvalue bidon___151;
  bidon___151=MLruntime.MLlrp;
  bidon___151=MLruntime.MLprint( (MLvalue )value___146);
}
}}

// fin du fichier ftest.java
