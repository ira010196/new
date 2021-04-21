package com.javarush.games.minesweeper;
import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

public class MinesweeperGame extends Game {
    private static final int SIDE = 9;
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];

    public void initialize(){
        setScreenSize(SIDE, SIDE);
        createGame();
    }
     private void createGame() {
         for (int i = 0; i < gameField.length; i++) {
             for (int j = 0; j < gameField[0].length; j++) {
                 gameField[i][j] = new GameObject(j, i);
                 setCellColor(i, j, Color.ORANGE);
             }
         }

     }

}
