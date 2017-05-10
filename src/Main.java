import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main {

    public static class FooApp extends Application {
        private int x = 0;
        private int y = 0;

        @Override
        public void start(Stage stage) throws Exception {
            Canvas canvas = new Canvas(400, 400);
            stage.setScene(new Scene(new StackPane(canvas), 420, 420));
            stage.setOnShowing(windowEvent -> {
                final KeyFrame keyFrame = new KeyFrame(Duration.millis(10), (event) -> {
                    GraphicsContext context = canvas.getGraphicsContext2D();
                    context.setFill(Color.BLACK);

                    context.rect(x, y, 10, 10);
                    context.fill();
                    x += 10;
                    if (x >= 400) {
                        x = 0;
                        y += 10;
                    }
                });

                final Timeline timeline = new Timeline();
                timeline.setCycleCount(Timeline.INDEFINITE);
                timeline.setAutoReverse(true);
                timeline.getKeyFrames().add(keyFrame);
                timeline.play();

            });
            stage.show();
        }
    }

    public static void main(String[] args) {
        Application.launch(FooApp.class);
    }
}

