package com.joaoibarra.ibarragames.response.model.deprecated;

public class Box {
    String large;
    String medium;
    String small;
    String template;

    public String getLarge() {
        return large;
    }

    public String getMedium() {
        return medium;
    }

    public String getSmall() {
        return small;
    }

    public String getTemplate() {
        return template;
    }

    public String getTemplate(String width, String height) {
        return template.replace("{width}", width).replace("{height}",height);
    }
}
