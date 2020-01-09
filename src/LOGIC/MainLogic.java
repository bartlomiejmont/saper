package LOGIC;

import GUI.Tile;
import javafx.scene.Group;
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
    public Stack moves = new Stack();
    public Stack undoMoves = new Stack();

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

    public List<Tile> getNeighbors(Tile tile) {
        List<Tile> neighbors = new ArrayList<>();

        // ttt
        // tXt
        // ttt

        int[] points = new int[] {
                -1, -1,
                -1, 0,
                -1, 1,
                0, -1,
                0, 1,
                1, -1,
                1, 0,
                1, 1
        };

        for (int i = 0; i < points.length; i++) {
            int dx = points[i];
            int dy = points[++i];

            int newX = tile.x + dx;
            int newY = tile.y + dy;

            if (newX >= 0 && newX < X_TILES
                    && newY >= 0 && newY < Y_TILES) {
                neighbors.add(grid[newX][newY]);
            }
        }

        return neighbors;
    }


}
