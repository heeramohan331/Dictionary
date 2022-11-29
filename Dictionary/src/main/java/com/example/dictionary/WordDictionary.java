package com.example.dictionary;

import java.io.*;
import java.util.HashMap;

public class WordDictionary {
    HashMap<String,String> wordList;

    WordDictionary(){
        this.wordList=new HashMap<>();
    }

    void addWord(String word, String meaning){
        wordList.put(word,meaning);
    }

    HashMap<String,String> getWordList(){
        return wordList;
    }

    void serializeMap(){
        try{
            FileOutputStream os=new FileOutputStream("dictList");
            ObjectOutputStream oos=new ObjectOutputStream(os);
            oos.writeObject(wordList);
            oos.close();
            os.close();
        }catch(IOException io){
            io.printStackTrace();
        }
    }

    void deserializeMap(){
        try{
            FileInputStream is=new FileInputStream("dictList");
            ObjectInputStream ois=new ObjectInputStream(is);
            wordList = (HashMap<String,String>)ois.readObject();
        }catch(IOException io){
            io.printStackTrace();
        }
        catch(ClassNotFoundException e){
            System.out.println("class not found");
        }
    }

}
