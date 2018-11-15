/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Scanner;

/**
 *
 * @author Bryan
 */
public abstract class ViewStarter implements View {

    public void viewStarter() {
        //empty contructor
    }

    /**
     * Force child views to get a message
     *
     * @return
     */
    protected abstract String getMessage();

    /**
     * Force child views to get input from the user
     *
     * @return
     */
    protected abstract String[] getInputs();

    /**
     * Force child views to do an action based on user input
     *
     * @param inputs
     * @return
     */
    protected abstract boolean doAction(String[] inputs);

    /**
     * Called function to perform the work within each view
     */
    @Override
    public void displayView() {

        boolean keepGoing = true;

        while (keepGoing == true) {

            // Retrieve and print out valid messages
            String message = getMessage();
            if (message != null) {
                System.out.println(getMessage());
            }

            String[] inputs = getInputs();
            keepGoing = doAction(inputs);
        }
    }

    /**
     * Get good input from the user
     *
     * @param prompt
     * @param allowEmpty
     * @return
     */
    protected String getUserInput(String prompt, boolean allowEmpty) {

        Scanner keyboard = new Scanner(System.in);
        String input = "";
        boolean inputReceived = false;

        while (inputReceived == false) {

            System.out.println(prompt);
            input = keyboard.nextLine();

            // Make sure we avoid a null-pointer error.
            if (input == null) {
                input = "";
            }

            // Trim any trailing whitespace, including the carriage return.
            input = input.trim();

            if (input.equals("") == false || allowEmpty == true) {
                inputReceived = true;
            }
        }

        return input;
    }

    /**
     * An overloaded version of getUserInput that sets allowEmpty to false so we
     * don't have to type it ourselves.
     *
     * @param prompt
     * @return
     */
    protected String getUserInput(String prompt) {
        return getUserInput(prompt, false);
    }

    protected static void pause(int milliseconds) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException exception) {
            // do nothing
        }
    }

}