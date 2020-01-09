package LOGIC;

import GUI.Tile;

public class MapGenerator {

    public Tile[][] generateTileMap(int width, int height){

        Tile [][] tileMap = emptyTileMap(width,height);

        return  tileMap;
    }

    private Tile[][] emptyTileMap(int w, int h){
        Tile map[][]= new Tile[w][h];

        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                map[j][i] = new Tile();
            }
        }

        return map;
    }

    public int[][] basicMap(){

        // 7x7
        int map[][] =
                {
                        {0,0,0,1,1,0,0},
                        {0,0,2,-1,0,0,0},
                        {-1,-1,0,0,-1,2,0},
                        {3,0,1,2,-1,0,0},
                        {-1,0,0,0,1,0,0},
                        {0,-1,-1,0,0,0,-1},
                        {0,2,2,0,0,-1,2}
                };
        return map;
    }

}
