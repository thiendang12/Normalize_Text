package Model;

public class Text {

    private String originText;
    private String formatedText;

    public Text(String originText, String formatedText) {
        this.originText = originText;
        this.formatedText = formatedText;
    }

    public Text() {
    }

    public String getOriginText() {
        return originText;
    }

    public void setOriginText(String originText) {
        this.originText = originText;
    }

    public String getFormatedText() {
        return formatedText;
    }

    public void setFormatedText(String formatedText) {
        this.formatedText = formatedText;
    }

}
