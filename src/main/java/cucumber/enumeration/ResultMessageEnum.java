package cucumber.enumeration;

/**
 * Created by szhukov on 01 02 2016.
 */
public enum ResultMessageEnum {

    COMPLETED("Completed");


    private final String text;

    ResultMessageEnum(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

}
