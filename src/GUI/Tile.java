package GUI;

import LOGIC.MainLogic;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Tile extends StackPane {

    private int x, y;
    private boolean hasBomb;
    private boolean isOpen = false;

    private Rectangle border = new Rectangle(MainLogic.getInstance().TILE_SIZE - 2, MainLogic.getInstance().TILE_SIZE - 2);
    private Text text = new Text();

    public Tile(){ }

    public Tile(int x, int y, boolean hasBomb) {
        this.x = x;
        this.y = y;
        this.hasBomb = hasBomb;

        border.setStroke(Color.LIGHTGRAY);

        text.setFont(Font.font(18));
        text.setText(hasBomb ? "X" : "Y");
        text.setVisible(true);

        getChildren().addAll(border, text);

        setTranslateX(x * MainLogic.getInstance().TILE_SIZE);
        setTranslateY(y * MainLogic.getInstance().TILE_SIZE);
    }

}
