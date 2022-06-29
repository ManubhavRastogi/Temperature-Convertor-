
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.util.Optional;

public class mymain extends Application {

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("com/internshala/javafxapp/app_layout.fxml"));
        VBox rootNode = loader.load();

        MenuBar menuBar = createMenu();
        rootNode.getChildren().add(0, menuBar);
        Scene scene = new Scene(rootNode);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Hello JavaFX");
        // primaryStage.setResizable(false);
        primaryStage.show();
    }

    private MenuBar createMenu() {
        //file menu
        Menu fileMenu = new Menu("File");
        MenuItem newMenuItem = new MenuItem("New");


        newMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("New Menu item Clicked");
            }
        });

        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
        MenuItem quitMenuItem = new MenuItem("Quit");
        fileMenu.getItems().addAll(newMenuItem, separatorMenuItem, quitMenuItem);
        quitMenuItem.setOnAction(event -> {
            System.exit(0);
        });
        fileMenu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Platform.exit();
                System.exit(0);
            }
        });


        //Help- menu
        Menu helpMenu = new Menu("Help");
        final MenuItem aboutApp = new MenuItem("About");
        helpMenu.getItems().addAll(aboutApp);

        aboutApp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                aboutApp();
            }
        });

        //Menu Bar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, helpMenu);

        return menuBar;
    }

    private void aboutApp() {
        //TODO
        Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
        alertDialog.setTitle("My First desktop App");
        alertDialog.setHeaderText("Learning JavaFX");
        alertDialog.setContentText("I am just a beginner but soon i will be a pro and start developing awesome java applications");

        ButtonType yesBtn = new ButtonType("Yes");
        ButtonType noBtn = new ButtonType("No");

        alertDialog.getButtonTypes().setAll(yesBtn, noBtn);


        Optional<ButtonType> clickedBtn = alertDialog.showAndWait();
        if (clickedBtn.isPresent() && clickedBtn.get() == yesBtn) {
            System.out.println("Yes button clicked");
        } else {
            System.out.println("No Button is clicked");
        }
    }
}
