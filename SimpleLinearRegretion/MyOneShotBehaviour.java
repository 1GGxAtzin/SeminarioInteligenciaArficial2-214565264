
import jade.core.behaviours.OneShotBehaviour;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Cls.ModelB1;
import Cls.ModelB0;
import Cls.DataSet;
/**
 *
 * @author Atz1NNN
 */
public class MyOneShotBehaviour extends OneShotBehaviour{

    @Override
    public void action() {
        DataSet dates= new DataSet(); 
        
         Scanner capt = new Scanner(System.in); 
         int[ ] xy = new int[9];
         int[ ] x2 = new int[9];
         for(int i =0; i <dates.advertising.length;++i){
             xy[i] = dates.advertising[i]*dates.sales[i];
             x2[i] = dates.advertising[i]*dates.advertising[i];
         }
         ModelB1  val = new ModelB1();
         
         //sacando los valores de la ModelB1...........
         //suma xy
         for(int i=0; i<xy.length; ++i){
                val.sumaxy += xy[i]; 
          }
         //suma advertising
         for(int i=0; i<dates.advertising.length; ++i){
                 val.sumaadv += dates.advertising[i]; 
          }
         //suma sales
         for(int i=0; i<dates.sales.length; ++i){
                val.sumasales += dates.sales[i]; 
          }
         //suma x al cuadrado
        for(int i=0; i<x2.length; ++i){
                val.sumax2 += x2[i]; 
         }
        //operaciones
        
        double f = val.sumaadv*val.sumaadv;
        //resultado ModelB1
        
        double resultadop =  ((dates.sales.length)*(val.sumaxy)-(val.sumaadv)*(val.sumasales))/((dates.sales.length)*(val.sumax2)-(f)); 
         //sacando los valores de b1...........
        ModelB0 b = new ModelB0();
        for(int i=0; i<xy.length; ++i){
                b.sumaxy += xy[i]; 
            }  
        for(int i=0; i<dates.advertising.length; ++i){
                b.sumaadv += dates.advertising[i]; 
             }
        for(int i=0; i<dates.sales.length; ++i){
                b.sumasales += dates.sales[i]; 
             }
        for(int i=0; i<x2.length; ++i){
                 b.sumax2 += x2[i]; 
             }
        double resultadob = ((b.sumasales/dates.sales.length)-(resultadop)*(b.sumaadv/dates.sales.length) );
        
        System.out.println("El valor de la pendiente (B1) es: " + resultadop);
        System.out.println("El valor de B0: " + resultadob);
        
        for(int i=0 ; i<dates.sales.length;++i){
                        //Y = M(X)+B0
             double y = resultadop*(dates.advertising[i]) + resultadob;
             System.out.println("X : "+dates.advertising[i]+ "     Y: " +y);
         }
         boolean salir = false;
         do{
             System.out.println("Desea buscar dentro del advertising?");
             String newadv = capt.next();
             if(newadv.equals("SI")||newadv.equals("si") ){
             System.out.println("Captura el advertising...");
             int valor = capt.nextInt();
             double res = resultadop*(valor) + resultadob;
             System.out.println("El valor de las sales con respecto al advertising tecleado es: " +res);
         }else{
             System.out.println("ni modo :(");
         }
       }
       while(!salir);
    

    }
    public int onEnd(){
        myAgent.doDelete();
        return super.onEnd();
            }
    
    
}