package io.daio.databinding;

public class BindingModel implements BindingInterface {

    private String message;
    private String subtitle;

    public BindingModel(String message, String subtitle) {
        this.message = message;
        this.subtitle = subtitle;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String getSubtitle() {
        return subtitle;
    }
}
