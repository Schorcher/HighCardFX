package com;

import javafx.animation.FadeTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.concurrent.Worker;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/*
 * Name:        David McFall
 * Instructor:  Dr. Jones
 * Date:        3/30/15
 * Assignment:  HighCard Game
 * Purpose:
 */
public class Splash
{
    private static Pane splashLayout;
    private static ProgressBar loadProgress;
    private static Label progressText;
    private static final int SPLASH_WIDTH = 487;
    private static final int SPLASH_HEIGHT = 400;

    @SuppressWarnings("unchecked")
    public static void showSplash(final Stage initStage,Task task)
    {
        ImageView splash = new ImageView(new Image("/com/Resources/Misc/TitleScreen.jpg"));
        loadProgress = new ProgressBar();
        loadProgress.setPrefWidth(SPLASH_WIDTH + 20);
        progressText = new Label("All modules are loaded.");
        splashLayout = new VBox();
        splashLayout.getChildren().addAll(splash, loadProgress, progressText);
        progressText.setAlignment(Pos.CENTER);
        splashLayout.setEffect(new DropShadow());

        progressText.textProperty().bind(task.messageProperty());
        loadProgress.progressProperty().bind(task.progressProperty());
        task.stateProperty().addListener(new ChangeListener<Worker.State>() {
            @Override
            public void changed(ObservableValue<? extends Worker.State> observableValue,
                                Worker.State oldState, Worker.State newState) {
                if (newState == Worker.State.SUCCEEDED) {
                    loadProgress.progressProperty().unbind();
                    loadProgress.setProgress(1);
                    initStage.toFront();
                    FadeTransition fadeSplash = new FadeTransition(Duration.seconds(.2), splashLayout);
                    fadeSplash.setFromValue(1.0);
                    fadeSplash.setToValue(0.0);
                    fadeSplash.setOnFinished(evt -> initStage.hide());
                    fadeSplash.play();
                }
            }
        });
        Scene splashScene = new Scene(splashLayout);
        initStage.initStyle(StageStyle.UNDECORATED);
        final Rectangle2D bounds = Screen.getPrimary().getBounds();
        initStage.setScene(splashScene);
        initStage.setX(bounds.getMinX() + bounds.getWidth() / 2 - SPLASH_WIDTH / 2);
        initStage.setY(bounds.getMinY() + bounds.getHeight() / 2 - SPLASH_HEIGHT / 2);
        initStage.show();
    }

    @SuppressWarnings("unchecked")
    public static Task<ObservableList<String>> friendTask = new Task()
    {
        @Override
        protected ObservableList<String> call() throws InterruptedException
        {
            ObservableList<String> foundFriends =
                    FXCollections.<String>observableArrayList();
            ObservableList<String> availableFriends =
                    FXCollections.observableArrayList( "Game Engine", "User Interface", "User Controls");

            updateMessage("Loading Modules . . .");
            for (int i = 0; i < availableFriends.size(); i++)
            {
                Thread.sleep(900);
                updateProgress(i + 1, availableFriends.size());
                String nextFriend = availableFriends.get(i);
                foundFriends.add(nextFriend);
                updateMessage("Loading Modules . . . Loading " + nextFriend);
            }
            Thread.sleep(500);
            updateMessage("All Modules are loaded.");

            return foundFriends;
        }
    };
}
