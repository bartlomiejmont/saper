package GUI;

import LOGIC.MainLogic;
import LOGIC.MapGenerator;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Main extends Application {

    Scenes scenes = new Scenes();
    MapGenerator mapGenerator = new MapGenerator();


    @Override
    public void start(final Stage stage) {


//        Scene scene = menu.menuScene(stage);

        MainLogic.getInstance().primaryWindow = stage;
        MainLogic.getInstance().map=mapGenerator.basicMap();
        MainLogic.getInstance().grid=mapGenerator.generateTileMap(MainLogic.getInstance().W,MainLogic.getInstance().H);

        Scene scene = scenes.makeScene(MainLogic.getInstance().X_TILES,MainLogic.getInstance().Y_TILES);

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if(keyEvent.getCode() == KeyCode.LEFT){
                    System.out.println("undo");
                    MainLogic.getInstance().undo();
                }
                else if(keyEvent.getCode() == KeyCode.RIGHT){
                    System.out.println("redo");
                    MainLogic.getInstance().redo();
                }
            }
        });

        stage.setScene(scene);

        stage.show();


    }



    public static void main(String[] args) {
        launch();
    }


}