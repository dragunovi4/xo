import game.Board;
import game.Cell;
import game.GameCondition;
import game.Mark;
import game.RandomMovePlayer;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;



/**
 * @author DavidHurst
 */
public class TicTacToe extends Application {

    private static GridPane gameBoard;

    private GameCondition gameCondition;
    private static Board board;
    private AnimationTimer gameTimer;
    private MenuBar menuBar;
    private Menu gameMenu;
    private MenuItem newGameOption;
    private BorderPane root;

    public final static class Tile extends Button {

        private final int row;
        private final int col;
        private Mark mark;

        public Tile(int initRow, int initCol, Mark initMark) {
            row = initRow;
            col = initCol;
            mark = initMark;
            initialiseTile();
        }

        private void initialiseTile() {
            this.setOnMouseClicked(e -> {
                if (!board.isCrossTurn()) {
                    board.placeMark(this.row, this.col);
                    this.update();
                }
            });
            this.setStyle("-fx-font-size:70");
            this.setTextAlignment(TextAlignment.CENTER);
            this.setMinSize(150.0, 150.0);
            this.setText("" + this.mark);
        }

        public void update() {
            this.mark = board.getMarkAt(this.row, this.col);
            this.setText("" + mark);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        root = new BorderPane();

        root.setCenter(generateGUI());
        root.setTop(initialiseMenu());

        Scene scene = new Scene(root);
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(scene);

        //runGameLoop();
        resetGame();

        primaryStage.show();
    }

    private static GridPane generateGUI() {
        gameBoard = new GridPane();
        board = new Board();
        gameBoard.setAlignment(Pos.CENTER);

        for (int row = 0; row < board.BOARD_WIDTH; row++) {
            for (int col = 0; col < board.BOARD_WIDTH; col++) {
                Tile tile = new Tile(row, col, board.getMarkAt(row, col));
                GridPane.setConstraints(tile, col, row);
                gameBoard.getChildren().add(tile);
            }
        }
        return gameBoard;
    }

    private MenuBar initialiseMenu() {
        menuBar = new MenuBar();
        gameMenu = new Menu("ХО");
        newGameOption = new MenuItem("Новая игра");

        gameMenu.getItems().add(newGameOption);
        menuBar.getMenus().add(gameMenu);
        newGameOption.setOnAction(e -> {
            resetGame();
        });
        return menuBar;
    }

    private void runGameLoop() {
        gameTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (GameCondition.isGameOver()) {
                    endGame();
                } else {
                    if (board.isCrossTurn()) {
                        playAI();
                    }
                }
            }
        };
        gameTimer.start();
    }

    private static void playAI() {
        Cell move = RandomMovePlayer.getBestMove(board);

        int row = move.getRow();
        int col = move.getCol();
        board.placeMark(row, col);
        for (Node child : gameBoard.getChildren()) {
            if (GridPane.getRowIndex(child) == row
                    && GridPane.getColumnIndex(child) == col) {
                Tile t = (Tile) child;
                t.update();
                return;
            }
        }
    }
    private void resetGame() {
        root.setCenter(generateGUI());
        runGameLoop();
    }

    private void endGame() {
        gameTimer.stop();
        Alert gameOverAlert = new Alert(AlertType.INFORMATION, "", new ButtonType("Новая игра"));
        Mark winner = GameCondition.getWinningMark();
        gameOverAlert.setTitle("Конец игры!");
        gameOverAlert.setHeaderText(null);

        if (winner == Mark.BLANK) {
            gameOverAlert.setContentText("Ничья!");
        } else {
            gameOverAlert.setContentText(winner + " победил!");
        }

        ButtonType newGameButton = new ButtonType("Новая игра");
        ButtonType exitButton = new ButtonType("Выйти");
        gameOverAlert.getButtonTypes().setAll(newGameButton, exitButton);

        gameOverAlert.setOnHidden(e -> {
            ButtonType result = gameOverAlert.getResult();
            if (result == newGameButton) {
                resetGame();
                gameOverAlert.close();
            } else if (result == exitButton) {
                Platform.exit();
            }
        });
        Platform.runLater(() -> gameOverAlert.showAndWait());
    }
}
