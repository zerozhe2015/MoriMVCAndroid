package com.moriarty.morimvcandroid.model.entities.textjoke;



public class RefreshJokeStyleEvent {
    private int JokeStyle;

    public RefreshJokeStyleEvent(int jokeStyle) {
        JokeStyle = jokeStyle;
    }

    public int getJokeStyle() {
        return JokeStyle;
    }

    public void setJokeStyle(int jokeStyle) {
        JokeStyle = jokeStyle;
    }
}
