package GUI;

import LOGIC.MainLogic;
import LOGIC.MapGenerator;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    Scenes scenes = new Scenes();
    MapGenerator mapGenerator = new MapGenerator();


    @Override
    public void start(final Stage stage) {


//        Scene scene = menu.menuScene(stage);

        MainLogic.getInstance().map=mapGenerator.basicMap();
        MainLogic.getInstance().grid=mapGenerator.generateTileMap(MainLogic.getInstance().W,MainLogic.getInstance().H);

        Scene scene = scenes.makeScene(MainLogic.getInstance().X_TILES,MainLogic.getInstance().Y_TILES);

        stage.setScene(scene);
        stage.show();

        MainLogic.getInstance().primaryWindow = stage;

    }



    public static void main(String[] args) {
        launch();
    }


}