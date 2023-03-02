package agh.ics.oop;

import agh.ics.oop.gui.App;
import javafx.application.Application;

import java.io.File;

public class World {
    public static void main(String[] args) {
        System.out.println(new File("input.txt").getAbsolutePath());
        System.out.println("System wystartował");
        Application.launch(App.class, args);
        System.out.println("System zakończył działanie");
    }
}