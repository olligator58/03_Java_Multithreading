package Task7091;

public class Mail {
    private volatile String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
