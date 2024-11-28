package com.example.design.srp;

public class SimpleTextEmailContent implements EmailContent {
    private String textContent;

    public SimpleTextEmailContent(String textContent) {
        this.textContent = textContent;
    }

    @Override
    public String getContent() {
        return textContent;
    }
}
