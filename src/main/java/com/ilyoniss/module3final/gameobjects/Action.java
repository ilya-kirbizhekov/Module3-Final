package com.ilyoniss.module3final.gameobjects;

public class Action {
    private final String actionText;

    public Action(String actionText) {
        this.actionText = actionText;
    }

    public String getActionText() {
        return actionText;
    }

    public void performAction(){

        System.out.println("Action: " + actionText);

    }

}
