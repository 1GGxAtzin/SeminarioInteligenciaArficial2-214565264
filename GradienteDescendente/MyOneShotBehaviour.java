
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
    public void action() {
         DataSet dates = new DataSet();
         Model  val = new Model();
         Scanner capt = new Scanner(System.in);
         int sumax = 0;
         int sumay = 0;
         double sumatoria=0;
         double sumatoriay=0;

         //SUMATORIAS
         for(int i=0;i<dates.advertising.length;i++){
              sumax += dates.advertising[i];
              sumay += dates.sales[i];
           //   Y_pred += dates.advertising[i]+0;
         }
         double[] y_pred = new double[50];
         double[] sumatoriam = new double[50];
         double[] sumatoriac = new double[50];
         //LOSS FUNCTION
         double m=0;
         double D_m=0;
         double D_c=0;
         double c=0;
         double LR =0.0003;
         int iteraciones=1000;

         
         for (int i=0;i<iteraciones;++i){
            updateypred(y_pred,m,c);
            updatesumatoriam(y_pred,sumatoriam);
            D_m = -(2.0/(double)(dates.advertising.length))*(sumatoriam[49]);
            updatesumatoriac(y_pred,sumatoriac);
            D_c = -(2.0/(double)(dates.advertising.length)) * (sumatoriac[49]);
            m = m - LR * D_m;
            c = c - LR * D_c;
         }
            System.out.println("BETA 1:  "+m);
            System.out.println("BETA 0:  "+c);    

    }
    public double[] updateypred( double[] y_pred,double m , double c){
        DataSet dates = new DataSet();
            for(int i=0;i<dates.advertising.length;++i){
                y_pred[i]= m*dates.advertising[i]+c;
            }

    return y_pred;
    }
    public double[] updatesumatoriam( double[] y_pred,double[] sumatoriam){
        DataSet dates = new DataSet();
        double[] sumatoriaprev = new double[50];
            for(int i=0;i<dates.advertising.length;++i){
               sumatoriaprev[i] = dates.sales[i]-y_pred[i];
               sumatoriam[i]= dates.advertising[i]*sumatoriaprev[i];
               sumatoriam[49]+= sumatoriam[i];
            }
    return sumatoriam;
    }
    public double[] updatesumatoriac( double[] y_pred,double[] sumatoriac){
        DataSet dates = new DataSet();
            for(int i=0;i<dates.advertising.length;++i){
               sumatoriac[i] = dates.sales[i]-y_pred[i];     
               sumatoriac[49]+= sumatoriac[i];
            }
    return sumatoriac;
    }
    public int onEnd(){
        myAgent.doDelete();
        return super.onEnd();
            }
}
    
