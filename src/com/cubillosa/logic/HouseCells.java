package com.cubillosa.logic;

/**
 * A colony of eigth houses, represented as a cell, are arranged in a straight line.
 * Each day, every cell competes with its adjacent cells (neighbours). An integer value of 1 represents an active cell
 * and value of 0 represents an inactive cells. If both the neighbours are either active or inactive, the cell becomes
 * inactive on the next day. The two cells on the ends have a single adjacent cell, so the other adjacent cell can be assumed
 * to be always inactive. Even after updating the cell state, its previous state is considered for updating the state of the
 * other cells. The cell information of a cells should be updated simultaneously.
 *
 * @author Andres Felipe Cubillos Estrada
 * @version 1.0
 * @Email felipe.cubillos@outlook.com
 * @Purpouse :  only for practicing java problems
 */
public class HouseCells {


    int [] houses = {1,1,0,1,0,0,1,0};
    int days = 4;
    private final int INACTIVE = 0;
    private final int ACTIVE = 1;

    public int validateNeighbours(int leftNeighbour,int rightNeighbour){

        if (leftNeighbour == rightNeighbour)
            return INACTIVE;
        else
            return ACTIVE;
    }


    public int[] changeHouseStatus(int [] actualHousesStatus){

        int [] newHouseStatus = new int [8] ;

        for (int actual=0;actual<actualHousesStatus.length;actual++){
            int leftNeighbour;
            int rightNeighbour;

            //Validate the first iteration
            if (actual == 0) {
                leftNeighbour = 0;
                rightNeighbour = actualHousesStatus[actual+1];
            }
            // Validate the last iteration
            else if(actual==actualHousesStatus.length-1){
                rightNeighbour=0;
                leftNeighbour=actualHousesStatus[actual-1];
            }
            else{
                leftNeighbour=actualHousesStatus[actual-1];
                rightNeighbour=actualHousesStatus[actual+1];}

            newHouseStatus[actual] =validateNeighbours(leftNeighbour,rightNeighbour);
        }
        return newHouseStatus;
    }

    public static void main(String [] args) {

        HouseCells myHouse = new HouseCells();

        for (int i = 1; i <=myHouse.days; i++) {
            myHouse.houses = myHouse.changeHouseStatus(myHouse.houses);

            System.out.println(" Day "+i +" : ");
            for (int x : myHouse.houses)
                System.out.print(x);
                System.out.println(" ");
        }
    }
}
