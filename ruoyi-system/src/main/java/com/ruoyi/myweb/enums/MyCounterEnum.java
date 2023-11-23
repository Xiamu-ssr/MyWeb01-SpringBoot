package com.ruoyi.myweb.enums;

public enum MyCounterEnum {
    IMAGE_TEXT("image_text"),
    IMAGES("images"),
    MESSAGES("messages");


    private final String name;

    MyCounterEnum(String name){
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
