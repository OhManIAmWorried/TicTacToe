package Logic;

/*Template for 3x3 5x5 and so on classes, we need to set the value of n в конструкторе and write the body of isWin to create the field*/
/*Трафарет для 3х3 5х5 итд. классов, нам необходимо установить значение n в конструкторе и написать тело isWin для создания поля*/

abstract class Field{
    static int n;                     // number of elements per side / число элементов на сторону
    static boolean element[][];       // matrix of states player1 or player2, I believe. / матрица состояний, игрок1 или игрок 2, полагаю
    static boolean occupancy[][];     // matrix of occupation flags / матрица заполненности клеток

    Field(int n){this.n = n; element = new boolean[n][n]; occupancy = new boolean[n][n];}

    static boolean getOccupancy(int y, int x){return occupancy[y][x];}

    static boolean getElement(int y, int x){return element[y][x];}

    static void setElement(int y, int x, boolean val)
    {
        element[y][x] = val;
        occupancy[y][x] = true;
    }

    static boolean isFull(){
        boolean res = true;
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                if (!occupancy[i][j]){
                    res = false;
                    break;
                }
            if (!res) break;
        }
        return res;
    }

    static boolean isEmpty(){
        boolean res = true;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++)
                if (occupancy[i][j]) {
                    res = false;
                    break;
                }
            if (res) break;
        }
        return res;
    }

    abstract boolean isWin(boolean value);
}

//----------------------------------------------------------------------------------------------------------------------
//TODO: разнести поля разной размерности по отдельным файлам в package Logic.Field

class Field3x3 extends Field{

    Field3x3(){super(3);}

    @Override
    public boolean isWin(boolean value){
        boolean result = false;

        for (int i=0; i<3; i++){                                                                    //in width
            if (occupancy[i][0] && occupancy[i][1] && occupancy[i][2])
                if (element[i][0] == value && element[i][1] == value && element[i][2] == value){
                    result = true;
                    break;
                }

            if (occupancy[0][i] && occupancy[1][i] && occupancy[2][i])                              //in height
                if (element[0][i] == value && element[1][i] == value && element[2][i] == value){
                    result = true;
                    break;
                }
        }

        if (occupancy[0][0] && occupancy[1][1] && occupancy[2][2])                                  //main diagonal
            if (element[0][0] == value && element[1][1] == value && element[2][2] == value)
                result = true;

        if (occupancy[0][2] && occupancy[1][1] && occupancy[2][0])                                  //semi diagonal
            if (element[0][2] == value && element[1][1] == value && element[2][0] == value)
                result = true;

        return result;
    }
}
