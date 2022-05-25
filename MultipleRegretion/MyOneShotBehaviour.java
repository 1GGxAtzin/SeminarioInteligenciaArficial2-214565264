
import jade.core.behaviours.OneShotBehaviour;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Clases.Model;
import Clases.DataSet;
/**
 *
 * @author Atz1NNN
 */
public class MyOneShotBehaviour extends OneShotBehaviour{

    @Override
    public void action() {
         DataSet dates = new DataSet();
         Model  val = new Model();
         Scanner capt = new Scanner(System.in);
         //Seteando valores de adv y sales (X) Y (Y)

         //Obteniendo valores de las sumatorias
         for(int i =0; i <dates.x1.length;++i){
             val.x1y[i] = (dates.x1[i])*(dates.y[i]);
             val.x2y[i] = (dates.x2[i])*(dates.y[i]);
             val.x1x2[i]= (dates.x1[i])*(dates.x2[i]);
             val.x21[i]=  (dates.x1[i])*(dates.x1[i]);
             val.x22[i]=  (dates.x2[i])*(dates.x2[i]);
             val.y2[i]=  (dates.y[i])*(dates.y[i]);
             
         }
         
         
         //sacando los valores
         //sumas
         for(int i=0; i<dates.x1.length; ++i){
                val.sumax1 += dates.x1[i];
                val.sumax2 += dates.x2[i];
                val.sumay += dates.y[i];
                val.sumax1y += val.x1y[i];
                val.sumax2y += val.x2y[i];
                val.sumax1x2 += val.x1x2[i];
                val.sumax21 += val.x21[i];
                val.sumax22 += val.x22[i];
                val.sumay2 += val.y2[i];
          }
        //operaciones de las determinantes
        val.determinanteS = ((dates.x1.length*val.sumax21*val.sumax22)+(val.sumax1*val.sumax1x2*val.sumax2)+(val.sumax2*val.sumax1*val.sumax1x2))-((val.sumax2*val.sumax21*val.sumax2)+(val.sumax1x2*val.sumax1x2*dates.x1.length)+(val.sumax1*val.sumax1*val.sumax22));
        val.determinanteX = (((val.sumay*val.sumax21*val.sumax22)+(val.sumax1y*val.sumax1x2*val.sumax2)+(val.sumax2y*val.sumax1*val.sumax1x2))-((val.sumax2*val.sumax21*val.sumax2y)+(val.sumax1x2*val.sumax1x2*val.sumay)+(val.sumax22*val.sumax1*val.sumax1y)));
        val.determinanteY = (((dates.x1.length*val.sumax1y*val.sumax22)+(val.sumax1*val.sumax2y*val.sumax2)+(val.sumax2*val.sumay*val.sumax1x2))-((val.sumax2*val.sumax1y*val.sumax2)+(val.sumax1x2*val.sumax2y*dates.x1.length)+(val.sumax1*val.sumay*val.sumax22)));
        val.determinanteZ = (((dates.x1.length*val.sumax21*val.sumax2y)+(val.sumax1*val.sumax1x2*val.sumay)+(val.sumax2*val.sumax1*val.sumax1y))-((val.sumay*val.sumax21*val.sumax2)+(dates.x1.length*val.sumax1x2*val.sumax1y)+(val.sumax1*val.sumax1*val.sumax2y)));
        val.resultadoX = val.determinanteX/val.determinanteS;
        val.resultadoY = val.determinanteY/val.determinanteS;
        val.resultadoZ = val.determinanteZ/val.determinanteS;
        System.out.println("B0:  "+val.resultadoX+ "  B1:  "+val.resultadoY+"  B2:  "+val.resultadoZ);
        //double res1= (val.resultadoX) + (val.resultadoY*(40))+ (val.resultadoZ*(30));
        for(int i=0 ; i<dates.x1.length;++i){
             double res1= (val.resultadoX) + (val.resultadoY*(dates.x1[i]))+ (val.resultadoZ*(dates.x2[i]));
             System.out.println("X1 : "+dates.x1[i]+ "     X2: " +dates.x2[i]+"     Y: "+res1);
         }
        /*
        
         boolean salir = false;
         do{
             System.out.println("Captura nuevo advertising...");
             int valor = capt.nextInt();
             double res = pendiente*(valor) + resultadob;
             System.out.println("El valor de las sales con respecto al advertising tecleado es: " +res);
         
       }
       while(!salir);
    */

    }
    public int onEnd(){
        myAgent.doDelete();
        return super.onEnd();
            }
    
    
}