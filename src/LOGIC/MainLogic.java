package LOGIC;

import GUI.Main;
import GUI.Tile;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.stage.Window;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public final class MainLogic {

    private static MainLogic INSTANCE = new MainLogic();


    private MainLogic() {
    }

    public static MainLogic getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new MainLogic();
        }
        return INSTANCE;
    }

    public  int[][] map;

    public final int TILE_SIZE = 80;
    public final int W = 800;
    public final int H = 600;
    public Stack <Tile> moves = new Stack<Tile>();
    public Stack <Tile> undoMoves = new Stack <Tile>();

    public int X_TILES = 7;
    public int Y_TILES = 7;

    public Tile[][] grid = new Tile[X_TILES][Y_TILES];
    public  Window primaryWindow ;

    public static Group getTileMap(int w, int h){

        MapGenerator mapGenerator = new MapGenerator();


        MainLogic.getInstance().X_TILES=w;
        MainLogic.getInstance().Y_TILES=h;

        Group group = new Group();

        for(int y=0 ; y < h; y++){
            for(int x=0; x < w; x++){
                Tile tile = new Tile(x,y, mapGenerator.basicMap()[x][y] == -1);

                group.getChildren().addAll(tile);
                MainLogic.getInstance().grid[x][y] = tile;
            }
        }

        for (int y = 0; y < MainLogic.getInstance().Y_TILES; y++) {
            for (int x = 0; x < MainLogic.getInstance().X_TILES; x++) {
                Tile tile = MainLogic.getInstance().grid[x][y];

                if(MainLogic.getInstance().map[x][y]>0){
                    tile.text.setText(String.valueOf(MainLogic.getInstance().map[x][y]));
                    tile.text.setVisible(true);
                }
            }
        }

        return group;
    }


    public void redo(){
        if(MainLogic.getInstance().undoMoves.size()>0){
            Tile tile = MainLogic.getInstance().undoMoves.peek();
            if(MainLogic.getInstance().map[tile.x][tile.y] == 0){
                tile.border.setFill(null);
            }
            MainLogic.getInstance().undoMoves.pop();
            MainLogic.getInstance().moves.push(tile);
            tile.isOpen=true;
            tile.text.setVisible(true);
        }
    }

    public void undo(){
        if(MainLogic.getInstance().moves.size()>0){
            Tile tile = MainLogic.getInstance().moves.peek();
            if(MainLogic.getInstance().map[tile.x][tile.y] == 0){
                tile.border.setFill(Color.BLACK);
            }
            MainLogic.getInstance().moves.pop();
            MainLogic.getInstance().undoMoves.push(tile);
            tile.isOpen=false;
            tile.text.setVisible(false);

        }
    }


}
