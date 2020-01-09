package LOGIC;

import GUI.Tile;
import javafx.scene.Group;
import javafx.stage.Window;


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
        return group;
    }


}
