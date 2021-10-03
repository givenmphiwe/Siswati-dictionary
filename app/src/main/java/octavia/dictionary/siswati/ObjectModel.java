package octavia.dictionary.siswati;

public class ObjectModel {
    //the names in the database sql
    String word, meaning;

    public  ObjectModel(String word, String meaning){

        this.word = word;
        this.meaning = meaning;
    }
    public String getWord(){
        return word;
    }
    public String getMeaning(){
        return meaning;
    }

}
