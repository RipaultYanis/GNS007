/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.gns;

import static com.sun.org.apache.xerces.internal.util.FeatureState.is;
import java.awt.Insets;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author etudiant
 */
public class GNS007 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
       
        HBox nomJ = new HBox();
        nomJ.setSpacing(30);
        TextField nom = new TextField();
        nomJ.getChildren().addAll(new Label("Nom :"), nom);
       
        HBox mdpJ = new HBox();
        mdpJ.setSpacing(30);
        PasswordField mdp = new PasswordField();
        mdpJ.getChildren().addAll(new Label("MDP :"), mdp);
        
        HBox mdpCJ = new HBox();
        mdpCJ.setSpacing(30);
        PasswordField mdpC = new PasswordField();
        mdpCJ.getChildren().addAll(new Label("Confirmer MDP :"), mdpC);
        
        
       
        HBox genreJ = new HBox();
        genreJ.setSpacing(30);
        final ToggleGroup group = new ToggleGroup();
        RadioButton genre1 = new RadioButton("Homme");
        genre1.setToggleGroup(group);
        genre1.setSelected(true);

        RadioButton genre2 = new RadioButton("Femme");
        genre2.setToggleGroup(group);
        
        
        genreJ.getChildren().addAll(genre1,genre2);
        
        HBox paysJ = new HBox();
        paysJ.setSpacing(30);
        final ComboBox<String> pays = new ComboBox(); 
        pays.getItems().setAll("France", "Suisse", "Belgique", "Canada");
        pays.getSelectionModel().selectFirst();
        paysJ.getChildren().addAll(new Label("Pays :"), pays);
        
        CheckBox cgu = new CheckBox("Accepter les Condition generale d'utilisation");
        
        HBox ValiderJ = new HBox(); 
        ValiderJ.setSpacing(30);
        Button Valider = new Button();
        Button Effacer = new Button();
        
        
        Valider.setText("Valider");
        Effacer.setText("Effacer");
        
        
         ValiderJ.getChildren().addAll(Valider,Effacer);
        
         VBox root = new VBox();
         root.setSpacing(30);
         root.getChildren().addAll(new Label("Nouveau Joueur :"), nomJ,mdpJ,mdpCJ,genreJ,paysJ,cgu,ValiderJ);
        
         
         Valider.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(nom.getText().equals("")){
                        Alert alertN = new Alert(AlertType.ERROR);
                        alertN.setTitle("Error Nom");
                        alertN.setHeaderText("Your Name can't be empty");
                        alertN.showAndWait();
                    }
                else{
                   
                    if(mdp.getText().equals("")){
                        Alert alertMdp = new Alert(AlertType.ERROR);
                        alertMdp.setTitle("Error Nom");
                        alertMdp.setHeaderText("Your Password can't be empty");
                        alertMdp.showAndWait();
                        
                    }
                    else{
                        if(mdp.getText().equals(mdpC.getText())){
                    
                        String genreJoueur ;
                        Boolean cguJoueur ;
                        if(genre1.isSelected()){
                        
                            genreJoueur = genre1.getText();
                        }else{
                        
                            genreJoueur = genre2.getText();
                        }
                        cguJoueur = cgu.isSelected();
                        Joueur unJoueur = new Joueur(nom.getText(),mdp.getText(),genreJoueur,pays.getValue(),cguJoueur);
                        System.out.println(unJoueur);
                    
                     }else{
                      Alert alert = new Alert(AlertType.ERROR);
                      alert.setTitle("Error PassWord");
                      alert.setHeaderText("Your Password is not the same");
                      alert.showAndWait();
                    
                    }
                    }
                    
                }
            }
        });
        Effacer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
              mdp.setText("");
              mdpC.setText("");
              nom.setText("");
              genre1.setSelected(true);
              genre2.setSelected(false);
              
            }
        });
        
        
        Scene scene = new Scene(root, 500, 400);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
