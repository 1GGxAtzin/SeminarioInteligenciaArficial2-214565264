
import jade.core.Agent;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Atz1NNN
 */
public class OneShotAgent extends Agent{
    @Override
    protected void setup(){
        System.out.println("Agente "+getLocalName()+" activadoxdd");
        addBehaviour(new MyOneShotBehaviour());
    }
}