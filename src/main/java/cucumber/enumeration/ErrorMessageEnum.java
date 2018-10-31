package cucumber.enumeration;

public enum ErrorMessageEnum {

    DURATION_MUST_BE_BETWEEN("Duration must be between %s and 900 seconds.");

    private final String text;

    ErrorMessageEnum(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

}
