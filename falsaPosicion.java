import java.util.Scanner;
import java.text.DecimalFormat;



public class falsaPosicion{
static Scanner owl=new Scanner(System.in);
static DecimalFormat format=new DecimalFormat("0.0000");
static DecimalFormat format2=new DecimalFormat("00");


static float CalcF(float a, float b,float c, float d, float x){
  return (a*x*x*x+b*x*x+c*x+d);
}
static float Xr(float xu, float fxu, float xi, float fxi){
  return ((xu)-(((fxu)*(xi-xu))/(fxi-fxu)));
}

static void Imp (int ps, int iteU, float eaT, float a,float b,float c,float d,float xi, float xu){
  System.out.println("|  Ite |   Xi   |  f(Xi)    |   Xu   |  f(Xu)  |   Xr   |  f(Xr)  |   Ea   |");
  int co=0;
  float fxi,fxu,fxr,xrAnt,xr=0,ff,Ea=0,de=0;
  boolean pp =true,tolerancia=false,sal=false;
  if(ps!=0)
    pp=false;
  if (eaT!=0)
    tolerancia=true;
  do{
    co++;
    fxu=CalcF(a,b,c,d,xu);
    fxi=CalcF(a,b,c,d,xi);
    xrAnt=xr;
    xr=Xr(xu,fxu,xi,fxi);
    fxr=CalcF(a,b,c,d,xr);
    ff=fxi*fxr;
    if (ff<0)
      xu=xr;
    else if (ff>0)
      xi=xr;

    if(co>1)
      Ea=((Math.abs(xr-xrAnt)/xr)*100);

    System.out.println("|  "+format2.format(co)+"  | "+format.format(xi)+" | "+format.format(fxi)+" | "+format.format(xu)+" | "+format.format(fxu)+" | "+format.format(xr)+" | "+format.format(fxr)+" | "+format.format(Ea)+" |");

    if (pp==false) {
        System.out.print("Hacer otra iteracion. escriba 0 para si, 1 para no:");
          de = owl.nextInt();
      }
    if (tolerancia==true&&co>1) {
      if (eaT>Ea)
        sal=true;
      }
      else if (tolerancia==false) {
        if ((iteU==co)||(de==1))
          sal=true;
    }
  }while(sal==false);
}

  public static void main(String[] args) {
    int menu, met, iteU;
    float a=0,b=0,c=0,xi=0,xu=0,eaT,d=0;
      do {
        System.out.print("\n**CALCULO POSIBLE RAIZ DE FUNCIÓN ax³+bx²+cx+d POR FALSA POSICIÓN\n1. Dar valores a b c d.\n2. dar rango. \n3. Elegir Método de parada.\n4. salir\n  Opcion: "); menu=owl.nextInt();
        switch (menu) {
          case 1:
              System.out.print("\n  Ingrese a: ");  a=owl.nextFloat();
              System.out.print("  Ingrese b: ");  b=owl.nextFloat();
              System.out.print("  Ingrese c: ");  c=owl.nextFloat();
              System.out.print("  Ingrese d: ");  d=owl.nextFloat();
            break;
          case 2:
              System.out.print("\n  Ingrese Xi: "); xi=owl.nextFloat();
              System.out.print("  Ingrese Xu: "); xu=owl.nextFloat();
            break;
          case 3:
              System.out.print("\n  Elija el método de parada.\n"+
                               "    1. Cantidad de iteraciones.\n"+
                               "    2. Error tolerado.\n"+
                               "    3. Mostar cada una. \n "+
                               "    4. regresar. \n"+
                               "      Opción: "); met=owl.nextInt();
              switch (met) {
                //(int ps, int iteU, float eaT, float a,float b,float c,float xi, float xu)
                case 1:
                    System.out.print("\n  Ingrese la cantidad de iteraciones: "); iteU=owl.nextInt();
                    Imp(0,iteU,0,a,b,c,d,xi,xu);
                  break;
                case 2:
                	System.out.print("\n  Ingrese el error  tolerado: ");eaT=owl.nextFloat();
                	Imp(0,0,eaT,a,b,c,d,xi,xu);
                  break;
                case 3:
                	Imp(1,0,0,a,b,c,d,xi,xu);
                  break;
                case 4:
                  break;
                default:
                    System.out.println("***Ingrese una Opción valida");
                  break;
              }
            break;
          case 4:
              System.out.println(" ");
            break;
          default:
              System.out.println("***Ingrese una Opción valida");
            break;

        }
      } while (menu!=4);
  }
}
