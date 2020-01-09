package GUI;

import LOGIC.MainLogic;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Tile extends StackPane {

    public int x, y;
    public boolean hasBomb;
    public boolean isOpen = false;

    private Rectangle border = new Rectangle(MainLogic.getInstance().TILE_SIZE - 2, MainLogic.getInstance().TILE_SIZE - 2);
    public Text text = new Text();

    public Tile(){ }

    public Tile(int x, int y, boolean hasBomb) {
        this.x = x;
        this.y = y;
        this.hasBomb = hasBomb;

        border.setStroke(Color.LIGHTGRAY);

        text.setFont(Font.font(18));
        text.setText(hasBomb ? "X" : "");
        text.setFill(Color.WHITE);
        text.setVisible(false);

        getChildren().addAll(border, text);

        setTranslateX(x * MainLogic.getInstance().TILE_SIZE);
        setTranslateY(y * MainLogic.getInstance().TILE_SIZE);

        setOnMouseClicked(e -> open());
    }

    public void open() {
        if (isOpen)
            return;

        isOpen = true;
        text.setVisible(true);
        MainLogic.getInstance().moves.push(this);

//        if (text.getText().isEmpty()) {
//            MainLogic.getInstance().getNeighbors(this).forEach(Tile::open);
//        }
    }

}
