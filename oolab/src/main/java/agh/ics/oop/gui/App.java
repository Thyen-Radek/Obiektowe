package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;

public class App extends Application {
    AbstractWorldMap map;
    public void init() throws Exception {

        Parameters parameters = getParameters();
        List<String> argsTemp = parameters.getRaw();
        String[] args = argsTemp.toArray(new String[0]);
//        String[] arrajek = new String[]{"f", "b", "r", "l", "f", "f" ,"r", "r" ,"f" ,"f" ,"f" ,"f" ,"f", "f", "f", "f"};
        try {
            MoveDirection[] directions = new OptionsParser().parse(args);
            this.map = new GrassField(10);
            Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4)};
            IEngine engine = new SimulationEngine(directions, this.map, positions);
            engine.run();
            System.out.println(this.map);
        } catch(IllegalArgumentException ex) {
            System.out.println("Error: " +ex.getMessage());
            throw new Exception("Error: " +ex.getMessage());
        }
    }
    @Override
    public void start(Stage primaryStage){
        int width = 20;
        int height = 20;
        int x = 0;
        int y;
        int j = 1;
        MapBoundary bound = this.map.getBound();
        int min_x = bound.X_el.get(0).getPosition().x;
        int max_x = bound.X_el.get(bound.X_el.size()-1).getPosition().x;
        int min_y = bound.Y_el.get(0).getPosition().y;
        int max_y = bound.Y_el.get(bound.Y_el.size()-1).getPosition().y;
        Label label;
        GridPane grid = new GridPane();
        grid.setGridLinesVisible(true);
        label = new Label("y/x");
        GridPane.setHalignment(label, HPos.CENTER);
        grid.getColumnConstraints().add(new ColumnConstraints(width));
        grid.getRowConstraints().add(new RowConstraints(height));
        grid.add(label,0,0,1,1);
        for (int i = min_x; i <= max_x; i++){
            grid.getColumnConstraints().add(new ColumnConstraints(width));
            label = new Label(Integer.toString(i));
            GridPane.setHalignment(label, HPos.CENTER);
            grid.add(label,j,0,1,1);
            j+=1;
        }
        j = 1;
        for (int i = max_y; i >= min_y; i--){
            grid.getRowConstraints().add(new RowConstraints(height));
            label = new Label(Integer.toString(i));
            GridPane.setHalignment(label, HPos.CENTER);
            grid.add(label,0,j,1,1);
            j+=1;
        }
        for(int a = min_x; a <= max_x; a++){
            x += 1;
            y = 0;
            for (int b = max_y; b >= min_y; b--){
                y += 1;
                Object obiekt = map.objectAt(new Vector2d(a,b));
                if(obiekt != null){
                    AbstractWorldMapElement el = (AbstractWorldMapElement) obiekt;
                    label = new Label(el.toString());
                    GridPane.setHalignment(label, HPos.CENTER);
                    grid.add(label,x,y,1,1);
                }
            }
        }
        Scene scene = new Scene(grid, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
