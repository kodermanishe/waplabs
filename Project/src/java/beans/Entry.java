package beans;

public class Entry {
    private int id;
    private String word;
    private String wordtype;
    private String definition;

    public Entry() {
    }

    public Entry(int id, String word, String wordtype, String definition) {
        this.id = id;
        this.word = word;
        this.wordtype = wordtype;
        this.definition = definition;
    }

    public Entry(String word, String wordtype, String definition) {
        this.id = id;
        this.word = word;
        this.wordtype = wordtype;
        this.definition = definition;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getWordtype() {
        return wordtype;
    }

    public void setWordtype(String wordtype) {
        this.wordtype = wordtype;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }
}
