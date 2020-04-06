package gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainGUI extends Application {


    public static void main(String[] args) {

        launch(args);

    }


    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("YourHealth Inc.");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);

        grid.setAlignment(Pos.CENTER);

        Label welcomeLabel = new Label("Welcome to YourHealth Inc.");
        GridPane.setConstraints(welcomeLabel, 1, 0);

        Button signUpButton = new Button("Sign Up");
        GridPane.setConstraints(signUpButton, 0, 3);

        Button signInButton = new Button("Sign In");
        GridPane.setConstraints(signInButton, 2, 3);


        grid.getChildren().addAll(welcomeLabel, signUpButton, signInButton);

        Scene welcomeScene = new Scene(grid, 500, 500);


        stage.setScene(welcomeScene);
        stage.show();


    }
}
