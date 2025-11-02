package com.cs180.gui;

import javax.swing.JOptionPane;

/**
 * Main menu application for demonstrating Simple GUI concepts.
 * CS18000 Week 06: Simple GUIs
 *
 * This application demonstrates:
 * - JOptionPane with different message types
 * - showMessageDialog, showInputDialog, showConfirmDialog, showOptionDialog
 * - JFileChooser for file selection
 * - CodonExtractor practical example
 */
public class GUIDemo {

    public static void main(String[] args) {
        showWelcomeMessage();
        showMainMenu();
    }

    /**
     * Displays a welcome message.
     */
    private static void showWelcomeMessage() {
        String welcome = "Welcome to Simple GUIs Demo!\n\n" +
                "CS18000 Week 06: Simple GUIs\n\n" +
                "This application demonstrates:\n" +
                "- JOptionPane dialogs\n" +
                "- Message types and icons\n" +
                "- User input dialogs\n" +
                "- Confirmation dialogs\n" +
                "- File chooser dialogs\n" +
                "- Practical example: Codon Extractor";

        JOptionPane.showMessageDialog(null, welcome,
                "Simple GUIs Demo",
                JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Displays the main menu and handles user selection.
     */
    private static void showMainMenu() {
        boolean running = true;

        while (running) {
            String[] options = {
                    "Message Types Demo",
                    "Message Dialog Demo",
                    "Input Dialog Demo",
                    "Confirm Dialog Demo",
                    "Option Dialog Demo",
                    "File Chooser Demo",
                    "Codon Extractor",
                    "Exit"
            };

            int choice = JOptionPane.showOptionDialog(null,
                    "Select a demo to run:",
                    "Simple GUIs - Main Menu",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);

            switch (choice) {
                case 0: // Message Types Demo
                    JOptionPaneDemo.demonstrateMessageTypes();
                    break;
                case 1: // Message Dialog Demo
                    JOptionPaneDemo.demonstrateShowMessageDialog();
                    break;
                case 2: // Input Dialog Demo
                    JOptionPaneDemo.demonstrateShowInputDialog();
                    break;
                case 3: // Confirm Dialog Demo
                    JOptionPaneDemo.demonstrateShowConfirmDialog();
                    break;
                case 4: // Option Dialog Demo
                    JOptionPaneDemo.demonstrateShowOptionDialog();
                    break;
                case 5: // File Chooser Demo
                    JFileChooserDemo.demonstrateFileChooser();
                    break;
                case 6: // Codon Extractor
                    CodonExtractor.main(null);
                    break;
                case 7: // Exit
                case -1: // Dialog closed
                    int confirm = JOptionPane.showConfirmDialog(null,
                            "Are you sure you want to exit?",
                            "Exit Confirmation",
                            JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        running = false;
                        JOptionPane.showMessageDialog(null,
                                "Thank you for using Simple GUIs Demo!",
                                "Goodbye",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
