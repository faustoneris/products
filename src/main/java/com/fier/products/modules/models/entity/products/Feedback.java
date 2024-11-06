package com.fier.products.modules.models.entity.products;

public class Feedback {
    private int avaliationLevel;
    private String username;
    private String comment;

    public Feedback() {}


    public Feedback(int avaliationLevel, String username, String comment) {
        this.avaliationLevel = avaliationLevel;
        this.username = username;
        this.comment = comment;
    }

    public static Feedback of(int avaliationLevel, String username, String comment) {
        return new Feedback(avaliationLevel, username, comment);
    }

    public int getAvaliationLevel() {
        return avaliationLevel;
    }

    public String getComment() {
        return comment;
    }

    public String getUsername() {
        return username;
    }

    public void validate() {
        if (this.avaliationLevel > 5) {
            throw new Error("Feedback inválido");
        }
        if (this.comment == null || this.comment.isEmpty()) {
            throw new Error("Feedback inválido");
        }
        if (this.username == null || this.username.isEmpty()) {
            throw new Error("Usuário inválido para feedback");
        }
    }

}
