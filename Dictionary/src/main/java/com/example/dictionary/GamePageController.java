package com.example.dictionary;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;


public class GamePageController {
    WordDictionary dictionaryList;
    @FXML
    TextField searchword;
    @FXML
    TextField word;
    @FXML
    TextField meaning;

    @FXML
    public void newword(MouseEvent event) throws IOException{
        System.out.println("new word added");
        dictionaryList =new WordDictionary();
        dictionaryList.deserializeMap();
        Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
        infoAlert.setHeaderText("NEW WORD ADDING...");
        if(word.textProperty().get().equals("") || meaning.textProperty().get().equals("")){
            infoAlert.setContentText("Enter word/meaning to be added");
            infoAlert.showAndWait();
        }
        else{
            dictionaryList.addWord(word.textProperty().get(),meaning.textProperty().get());
            dictionaryList.serializeMap();
            infoAlert.setContentText("New word Added to Dictionary");
            infoAlert.showAndWait();
        }

    }

    @FXML
    public void search(MouseEvent event) throws IOException{
        System.out.println("searching word");
        dictionaryList = new WordDictionary();
        dictionaryList.deserializeMap();
        Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
        infoAlert.setHeaderText("Search Result ");
        if(searchword.textProperty().get().equals("")){
            infoAlert.setContentText("Please Enter a word for search");
            infoAlert.showAndWait();
        }
        else if(dictionaryList.getWordList().containsKey(searchword.textProperty().get())){
            System.out.println(dictionaryList.getWordList().get(searchword.textProperty().get()));
            infoAlert.setContentText(dictionaryList.getWordList().get(searchword.textProperty().get()));
            infoAlert.showAndWait();
        }
        else{
            infoAlert.setContentText("Oops!!! The word meaning is not present in dictionary");
            infoAlert.showAndWait();
        }

    }

}
