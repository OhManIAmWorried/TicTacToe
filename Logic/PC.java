package Logic;

/**
 * Created by Alex on 14.11.2016.
 */

import Graphics.Menu;

import static Logic.toPlay.getTurn;

public class PC implements Player {
    String name;

    public PC(){setName("N");}

    public void setName(String n){
        name = n;
    }

    public String getName(){
        return name;
    }

    private int[] putSomewhere(){
        int pos[] ={2, 2};
                                                        //TODO: Won't work for > 3x3, needs massive changes, also pretty weak
        int priority[][]={{6,4,6},{4,8,4},{6,4,6}};

        for(int i=0; i<3;i++)
            for(int j=0; j<3; j++) {
                for(int m=0; m<3; m++) {
                    if (Field.getElement(m, j) != getTurn() && Field.getOccupancy(m, j)) priority[i][j]++;
                    if (Field.getElement(m, j) == getTurn() && Field.getOccupancy(m, j)) priority[i][j]--;
                }

                for(int m=0; m<3; m++) {
                    if (Field.getElement(i, m) != getTurn() && Field.getOccupancy(i, m)) priority[i][j]++;
                    if (Field.getElement(i, m) == getTurn() && Field.getOccupancy(i, m)) priority[i][j]--;
                }
            }

        if (Field.getOccupancy(1, 1) && Field.getElement(1, 1) != getTurn()) {priority[0][0]++; priority[0][2]++; priority[2][0]++; priority[2][2]++;
        } else
        if (Field.getOccupancy(1, 1) && Field.getElement(1, 1) == getTurn()) {priority[0][0]--; priority[0][2]--; priority[2][0]--; priority[2][2]--;}

        if(Field.getOccupancy(2, 2) && Field.getElement(2, 2) != getTurn()) {priority[0][0]++; priority[1][1]++;
        } else
        if(Field.getOccupancy(2, 2) && Field.getElement(2, 2) == getTurn()) {priority[0][0]--; priority[1][1]--;}

        if(Field.getOccupancy(2, 0) && Field.getElement(2, 0) != getTurn()) {priority[0][2]++; priority[1][1]++;
        } else
        if(Field.getOccupancy(2, 0) && Field.getElement(2, 0) == getTurn()) {priority[0][2]--; priority[1][1]--;}

        if(Field.getOccupancy(0, 0) && Field.getElement(0, 0) != getTurn()) {priority[2][2]++; priority[1][1]++;
        } else
        if(Field.getOccupancy(0, 0) && Field.getElement(0, 0) == getTurn()) {priority[2][2]--; priority[1][1]--;}

        if(Field.getOccupancy(0, 2) && Field.getElement(0, 2) != getTurn()) {priority[2][0]++; priority[1][1]++;
        } else
        if(Field.getOccupancy(0, 2) && Field.getElement(0, 2) == getTurn()) {priority[2][0]--; priority[2][1]--;}

        for(int i=0; i<3;i++)
            for(int j=0; j<3; j++)
                if (Field.getOccupancy(i,j))
                    priority[i][j] = 0;

        int max =0;
        for(int i=0; i<3; i++)
            for(int j=0; j<3; j++)
                if (max < priority[i][j]){
                    pos[0]=i;
                    pos[1]=j;
                    max = priority[i][j];
                }

        return pos;
    }

    public void toMove(){
        int[] posYX = new int[2];
        posYX[0] = -1;
        posYX[1] = -1;
        //Menu.enableField();
        System.out.println(name + " is here");
        if (Field.isEmpty()) {
            int[][] pos = {{0,0}, {0,2}, {2,0}, {2,2}, {1,1}};
            int n = (int) Math.round(Math.random()*4);
            posYX[0] = pos[n][0];
            posYX[1] = pos[n][1];
        } else
        {
            posYX = putSomewhere();
        }
        System.out.println("I am about to place the symbol");
        Menu.getMenu().enableField();
        /*
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        Menu.getMenu().setCell(posYX[0],posYX[1]);
    }

}



/*
COMP:
private boolean checkRow(int pos1, int pos2, Field fie, boolean in)
    {	boolean b=false;
        int index = 0;
        for(int i=0; i<3; i++)
            if (fie.getElement(i, pos2)!=in && fie.getOccupancy(i, pos2))
                index++;
        if (index==2)
            b = true;

        index = 0;
        for(int i=0; i<3; i++)
            if (fie.getElement(pos1, i)!=in && fie.getOccupancy(pos1, i))
                index++;
        if (index==2)
            b = true;
        return b;
    }

    private int[] check(Field fie, boolean inde)
    {	int pos1 = -1;
        int pos2 = -1;
        boolean b=false;

        for(int i=0; i<3;i++)
            for(int j=0; j<3; j++)
            {
                if (!fie.getOccupancy(i, j))
                    if (checkRow(i,j,fie,inde))
                    {
                        b = true;
                        pos1=i; pos2=j;
                        break;
                    }
                if (b) break;
            }
        if (!b && fie.getOccupancy(1, 1) && fie.getElement(1, 1)!=inde){
            if(fie.getOccupancy(2, 2) && fie.getElement(2, 2) !=inde)
            {
                pos1=0; pos2=0; b=true;
            } else
                if(fie.getOccupancy(2, 0) && fie.getElement(2, 0) !=inde)
                {
                    pos1=0; pos2=2; b=true;
                } else
                    if(fie.getOccupancy(0, 0) && fie.getElement(0, 0) !=inde)
                {
                    pos1=2; pos2=2; b=true;
                } else
                    if(fie.getOccupancy(0, 2) && fie.getElement(0, 2) !=inde)
                    {
                        pos1=2; pos2=0; b=true;
                    }

        }
        else
            if(!b && !fie.getOccupancy(1, 1)) {
                if((fie.getOccupancy(0, 0) && fie.getElement(0, 0) !=inde && fie.getOccupancy(2, 2) && fie.getElement(2, 2) !=inde)||(fie.getOccupancy(2, 0) && fie.getElement(2, 0) !=inde && fie.getOccupancy(0, 2) && fie.getElement(0, 2) !=inde)){
                    pos1=1; pos2=1;
                }

            }
        int[] pos = {pos1, pos2};
        return pos;
    }

COMP.TOMOVE:
    	    poss=check(fie, ind);
	    	if (poss[0]<0 && poss[1]<0)
	    	{ System.out.println("No win combo for " + name);
	    		poss=check(fie, !ind);
	    		if (poss[0]<0 && poss[1]<0)
		    	{System.out.println("No protect combo for "+ name);
	    			poss = putSomewhere(fie);
		    	}
	    	}
	  */
