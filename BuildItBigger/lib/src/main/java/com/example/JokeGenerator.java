package com.example;

import java.util.ArrayList;
import java.util.Random;

public class JokeGenerator {
    private static ArrayList<String> jokes;

    static {
        jokes = new ArrayList<>();
        jokes.add("I think that God, in creating man, somewhat overestimated his ability.");
        jokes.add("The world is a stage, but the play is badly cast.");
        jokes.add("Always forgive your enemies; nothing annoys them so much.");
        jokes.add("It is absurd to divide people into good and bad. People are either charming or tedious.");
        jokes.add("The only thing to do with good advice is pass it on. It is never any use to oneself.");
        jokes.add("Some cause happiness wherever they go; others whenever they go.");
        jokes.add("What is a cynic? A man who knows the price of everything and the value of nothing.");
        jokes.add("A little sincerity is a dangerous thing, and a great deal of it is absolutely fatal.");
        jokes.add("When I was young I thought that money was the most important thing in life; now that I am old I know that it is.");
        jokes.add("There are only two tragedies in life: one is not getting what one wants, and the other is getting it.");
        jokes.add("Work is the curse of the drinking classes.");
        jokes.add("Anyone who lives within their means suffers from a lack of imagination.");
        jokes.add("True friends stab you in the front.");
        jokes.add("All women become like their mothers. That is their tragedy. No man does. That's his.");
        jokes.add("Fashion is a form of ugliness so intolerable that we have to alter it every six months.");
        jokes.add("There is only one thing in life worse than being talked about, and that is not being talked about.");
        jokes.add("Genius is born—not paid.");
        jokes.add("Morality is simply the attitude we adopt towards people whom we personally dislike.");
        jokes.add("How can a woman be expected to be happy with a man who insists on treating her as if she were a perfectly normal human being?");
        jokes.add(" A gentleman is one who never hurts anyone’s feelings unintentionally.");
        jokes.add("My own business always bores me to death; I prefer other people’s.");
        jokes.add("The old believe everything, the middle-aged suspect everything, the young know everything.");
        jokes.add("I like men who have a future and women who have a past.");
        jokes.add("There are two ways of disliking poetry; one way is to dislike it, the other is to read Pope.");
        jokes.add("Quotation is a serviceable substitute for wit.");
    }

    public static String getJoke() {
        Random r = new Random();
        return jokes.get(r.nextInt(jokes.size()));
    }
}
