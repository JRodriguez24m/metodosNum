
import java.util.*;
import java.text.DecimalFormat;
public class Biseccion {
	static Scanner owl=new Scanner(System.in);
	static DecimalFormat format=new DecimalFormat("0.0000");
	static DecimalFormat format2=new DecimalFormat("00");

	static float fx(float x,float a,float b, float c) {

		float f=0;
		return f=(float) (a*Math.pow(x,2)+(b*x)+c);

	}

	static float xr(float x1, float x2) {
		return ((x1+x2)/2);
	}



	public static void main(String[] args) {

		float a,b,c,xr = 0,Ea = 0,x1,x2,fxr,fx1,xrAnt=0,ff;

		System.out.print("\nIngrese las variables que multiplican a las constantes"
				+"\nIngrse a: ");        a=owl.nextFloat();
		System.out.print("Ingrese b: "); b=owl.nextFloat();
		System.out.print("Ingrese c: "); c=owl.nextFloat();
		System.out.print("Ingrese rango desde: "); x1=owl.nextFloat();
		System.out.print("Hasta: "); 			   x2=owl.nextFloat();

		int Noite=0;
		float eT=0;
		boolean pp= true, sal=false,tolerancia=false;

		System.out.print("condicion de paradad: \n 1. No. Iteraciones\n 2. Error tolerado \n 3. Mostrar cada uno\nOpcion: ");
		int des= owl.nextInt();
		switch (des){
			case 1:
					System.out.print("Ingrese la cantidad de Iteraciones: "); Noite=owl.nextInt();
				break;
			case 2:
					System.out.print("Ingrese el error tolerado: ");	eT=owl.nextFloat();
					tolerancia=true;
					break;
			case 3:
					pp=false;
					break;
				}

		int co=0,de=0;
		System.out.println("|  Ite |   xi   |  xu    |   xr   |  f(xi)  |  f(xr)  |   Ea   |");

		do{
			co++;
			fx1=fx(x1,a,b,c);
			xrAnt=xr;
			xr=xr(x1,x2);
			fxr=fx(xr,a,b,c);
			ff=fx1*fxr;
			if (ff<0)
				x2=xr;
			else if (ff>0)
				x1=xr;

			if(co>1)
				Ea=((Math.abs(xr-xrAnt)/xr)*100);

			System.out.println("|  "+format2.format(co)+"  | "+format.format(x1)+" | "+format.format(x2)+" | "+format.format(xr)+" | "+format.format(fx1)+" | "+format.format(fxr)+" | "+format.format(Ea)+" |");

			if (pp==false) {
					System.out.print("Hacer otra iteracion, escriba 0 para si, 1 para no:");
						de = owl.nextInt();
				}
			if (tolerancia==true&&co>1) {
				if (eT>Ea)
					sal=true;
				}
				else if (tolerancia==false) {
					if ((Noite==co)||(de==1))
						sal=true;
			}
		}while(sal==false);
	}

}
