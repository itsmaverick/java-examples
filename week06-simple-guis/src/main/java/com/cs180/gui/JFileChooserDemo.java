package com.cs180.gui;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Demonstrates JFileChooser for file selection.
 * Based on CS18000 Week 06: Simple GUIs
 */
public class JFileChooserDemo {

    public static void main(String[] args) {
        demonstrateFileChooser();
    }

    /**
     * Demonstrates basic file chooser functionality.
     */
    public static void demonstrateFileChooser() {
        // Create a JFileChooser object
        JFileChooser fc = new JFileChooser();

        // Set the dialog title
        fc.setDialogTitle("Choose a File");

        // Show the open dialog
        int returnValue = fc.showOpenDialog(null);

        // Check if user selected a file or cancelled
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            // User selected a file
            File selectedFile = fc.getSelectedFile();

            // Display file information
            String fileInfo = "File Selected!\n\n" +
                    "File Name: " + selectedFile.getName() + "\n" +
                    "Absolute Path: " + selectedFile.getAbsolutePath() + "\n" +
                    "File Size: " + selectedFile.length() + " bytes\n" +
                    "Can Read: " + selectedFile.canRead() + "\n" +
                    "Can Write: " + selectedFile.canWrite();

            JOptionPane.showMessageDialog(null, fileInfo,
                    "File Information",
                    JOptionPane.INFORMATION_MESSAGE);

            // Ask if user wants to read the file
            int readFile = JOptionPane.showConfirmDialog(null,
                    "Would you like to read this file?",
                    "Read File",
                    JOptionPane.YES_NO_OPTION);

            if (readFile == JOptionPane.YES_OPTION) {
                readAndDisplayFile(selectedFile);
            }
        } else {
            // User cancelled the file selection
            JOptionPane.showMessageDialog(null,
                    "File selection cancelled",
                    "Cancelled",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * Reads and displays the contents of a file.
     *
     * @param file the file to read
     */
    private static void readAndDisplayFile(File file) {
        try (Scanner scanner = new Scanner(file)) {
            StringBuilder content = new StringBuilder();
            int lineCount = 0;
            int maxLines = 50; // Limit to first 50 lines

            while (scanner.hasNextLine() && lineCount < maxLines) {
                content.append(scanner.nextLine()).append("\n");
                lineCount++;
            }

            if (scanner.hasNextLine()) {
                content.append("\n... (file has more lines)");
            }

            // Display file contents
            JOptionPane.showMessageDialog(null,
                    content.toString(),
                    "File Contents (first " + maxLines + " lines)",
                    JOptionPane.PLAIN_MESSAGE);

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,
                    "Error reading file: " + e.getMessage(),
                    "File Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Demonstrates save dialog functionality.
     */
    public static void demonstrateSaveDialog() {
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Save File");

        int returnValue = fc.showSaveDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fc.getSelectedFile();
            JOptionPane.showMessageDialog(null,
                    "File would be saved as:\n" + fileToSave.getAbsolutePath(),
                    "Save Location",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Save cancelled",
                    "Cancelled",
                    JOptionPane.WARNING_MESSAGE);
        }
    }
}
