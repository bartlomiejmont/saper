package GUI;

import LOGIC.MainLogic;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;

public class Scenes {


    public Scene makeScene(int width, int height){

        Group tileGroup;

        tileGroup=MainLogic.getInstance().getTileMap(width,height);

        return new Scene(tileGroup);

    }

    public void gameOverScene(){
        // create a alert
        Alert a = new Alert(Alert.AlertType.INFORMATION);

        a.setTitle("GameOver");
        a.setHeaderText(null);
        a.setContentText("You win!");

        // show the dialog
        a.showAndWait();

    }

}
