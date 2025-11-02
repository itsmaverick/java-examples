package com.cs180.gui;

import javax.swing.JOptionPane;

/**
 * Demonstrates various JOptionPane dialog types and message types.
 * Based on CS18000 Week 06: Simple GUIs
 */
public class JOptionPaneDemo {

    public static void main(String[] args) {
        demonstrateMessageTypes();
        demonstrateShowMessageDialog();
        demonstrateShowInputDialog();
        demonstrateShowConfirmDialog();
        demonstrateShowOptionDialog();
    }

    /**
     * Demonstrates all five message types with their different icons.
     */
    public static void demonstrateMessageTypes() {
        // PLAIN_MESSAGE
        JOptionPane.showMessageDialog(null,
                "Message type: PLAIN_MESSAGE (-1)",
                "PLAIN_MESSAGE",
                JOptionPane.PLAIN_MESSAGE);

        // ERROR_MESSAGE
        JOptionPane.showMessageDialog(null,
                "Message type: ERROR_MESSAGE (0)",
                "ERROR_MESSAGE",
                JOptionPane.ERROR_MESSAGE);

        // INFORMATION_MESSAGE
        JOptionPane.showMessageDialog(null,
                "Message type: INFORMATION_MESSAGE (1)",
                "INFORMATION_MESSAGE",
                JOptionPane.INFORMATION_MESSAGE);

        // WARNING_MESSAGE
        JOptionPane.showMessageDialog(null,
                "Message type: WARNING_MESSAGE (2)",
                "WARNING_MESSAGE",
                JOptionPane.WARNING_MESSAGE);

        // QUESTION_MESSAGE
        JOptionPane.showMessageDialog(null,
                "Message type: QUESTION_MESSAGE (3)",
                "QUESTION_MESSAGE",
                JOptionPane.QUESTION_MESSAGE);
    }

    /**
     * Demonstrates showMessageDialog - simplest dialog for displaying information.
     */
    public static void demonstrateShowMessageDialog() {
        // Simple message
        JOptionPane.showMessageDialog(null, "This is a simple message dialog");

        // Message with title and type
        JOptionPane.showMessageDialog(null,
                "Operation completed successfully!",
                "Success",
                JOptionPane.INFORMATION_MESSAGE);

        // Multi-line message
        String message = "This demonstrates:\n" +
                "- Line 1\n" +
                "- Line 2\n" +
                "- Line 3";
        JOptionPane.showMessageDialog(null, message, "Multi-line Message",
                JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Demonstrates showInputDialog - prompts user for input.
     */
    public static void demonstrateShowInputDialog() {
        // Simple input dialog
        String name = JOptionPane.showInputDialog("What is your name?");
        JOptionPane.showMessageDialog(null, "Hello, " + name + "!");

        // Input dialog with title
        String age = JOptionPane.showInputDialog(null,
                "What is your age?",
                "Age Input",
                JOptionPane.QUESTION_MESSAGE);

        if (age != null && !age.isEmpty()) {
            JOptionPane.showMessageDialog(null, "You are " + age + " years old.");
        }

        // Input dialog with choices (dropdown)
        String[] colors = {"Red", "Green", "Blue", "Yellow"};
        String selectedColor = (String) JOptionPane.showInputDialog(null,
                "Choose your favorite color:",
                "Color Selection",
                JOptionPane.QUESTION_MESSAGE,
                null,
                colors,
                colors[0]);

        if (selectedColor != null) {
            JOptionPane.showMessageDialog(null,
                    "You selected: " + selectedColor,
                    "Selection Result",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * Demonstrates showConfirmDialog - asks user to confirm an action.
     */
    public static void demonstrateShowConfirmDialog() {
        // YES_NO_OPTION
        int result = JOptionPane.showConfirmDialog(null,
                "Do you want to continue?",
                "Confirmation",
                JOptionPane.YES_NO_OPTION);

        String response = "";
        if (result == JOptionPane.YES_OPTION) {
            response = "You clicked YES";
        } else if (result == JOptionPane.NO_OPTION) {
            response = "You clicked NO";
        } else if (result == JOptionPane.CLOSED_OPTION) {
            response = "You closed the dialog";
        }
        JOptionPane.showMessageDialog(null, response);

        // YES_NO_CANCEL_OPTION
        result = JOptionPane.showConfirmDialog(null,
                "Save changes before closing?",
                "Save",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.WARNING_MESSAGE);

        if (result == JOptionPane.YES_OPTION) {
            response = "Saving changes...";
        } else if (result == JOptionPane.NO_OPTION) {
            response = "Discarding changes...";
        } else if (result == JOptionPane.CANCEL_OPTION) {
            response = "Operation cancelled";
        } else {
            response = "Dialog closed";
        }
        JOptionPane.showMessageDialog(null, response);

        // OK_CANCEL_OPTION
        result = JOptionPane.showConfirmDialog(null,
                "Proceed with this action?",
                "Confirm Action",
                JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Action confirmed!");
        } else {
            JOptionPane.showMessageDialog(null, "Action cancelled!");
        }
    }

    /**
     * Demonstrates showOptionDialog - most flexible dialog with custom buttons.
     */
    public static void demonstrateShowOptionDialog() {
        // Custom button options
        String[] options = {"Option A", "Option B", "Option C"};

        int choice = JOptionPane.showOptionDialog(null,
                "Choose one of the following options:",
                "Custom Options",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);

        if (choice >= 0 && choice < options.length) {
            JOptionPane.showMessageDialog(null,
                    "You selected: " + options[choice] + " (index " + choice + ")",
                    "Selection Result",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,
                    "No option selected (dialog closed)",
                    "Selection Result",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
