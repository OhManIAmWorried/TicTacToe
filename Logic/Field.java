package Logic;

/*Template for 3x3 5x5 and so on classes, we need to set the value of n в конструкторе and write the body of isWin to create the field*/
/*Трафарет для 3х3 5х5 итд. классов, нам необходимо установить значение n в конструкторе и написать тело isWin для создания поля*/

abstract class Field{
    static int n;                     // number of elements per side / число элементов на сторону
    static boolean element[][];       //TODO: find out what this matrix is intended to do / что она делает?
    static boolean occupancy[][];     // matrix of occupation flags / матрица заполненности клеток
    Field(int n){this.n = n;}
    static boolean getOccupancy(int pos1, int pos2){return occupancy[pos1][pos2];}
    static boolean getElement(int pos1, int pos2){return element[pos1][pos2];}
    static boolean setElement(int a, int b, boolean val)
    {
        element[a][b] = val;
        occupancy[a][b] = true;
        return true;
    }
    static boolean isFull(){
        boolean b = true;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                if (!occupancy[i][j])
                    b = false;
        return b;
    }
    static boolean isEmpty(){
        boolean b = true;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                if (occupancy[i][j])
                    b = false;
        return b;
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
        for (int i=0; i<3; i++){
            if (occupancy[i][0] && occupancy[i][1] && occupancy[i][2])
                if (element[i][0] == value && element[i][1] == value && element[i][2] == value){
                    result = true;
                    break;
                }

            if (occupancy[0][i] && occupancy[1][i] && occupancy[2][i])
                if (element[0][i] == value && element[1][i] == value && element[2][i] == value){
                    result = true;
                    break;
                }
        }

        if (occupancy[0][0] && occupancy[1][1] && occupancy[2][2])
            if (element[0][0] == value && element[1][1] == value && element[2][2] == value)
                result = true;

        if (occupancy[0][2] && occupancy[1][1] && occupancy[2][0])
            if (element[0][2] && element[1][1] && element[2][0])
                result = true;

        return result;
    }
}
