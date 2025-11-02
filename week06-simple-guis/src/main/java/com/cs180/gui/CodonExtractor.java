package com.cs180.gui;

import javax.swing.JOptionPane;

/**
 * CodonExtractor - Example from CS18000 Week 06 PDF
 *
 * Reads a DNA sequence from the user and displays the codons in it.
 *
 * Definitions:
 * - DNA sequence: sequence of characters in ACGT
 * - Codon: sequence of three characters in DNA sequence
 *
 * Algorithm:
 * - Prompt user for DNA, check for valid input
 * - Break DNA into 3-character chunks, display
 * - Repeat until user indicates done
 */
public class CodonExtractor {

    public static void main(String[] args) {
        int continueProgram;

        do {
            // Read DNA sequence
            String input = JOptionPane.showInputDialog("Enter a DNA sequence");

            if (input == null) {
                // User cancelled
                break;
            }

            input = input.toUpperCase(); // Make upper case
            String message = "Do you want to continue?";

            if (isValid(input)) {
                // Check for validity
                displayCodons(input); // Find and display codons
            } else {
                message = "Invalid DNA Sequence.\n" + message;
            }

            continueProgram = JOptionPane.showConfirmDialog(null, message,
                    "Alert",
                    JOptionPane.YES_NO_OPTION);
        } while (continueProgram == JOptionPane.YES_OPTION);

        JOptionPane.showMessageDialog(null, "Thanks for using the Codon Extractor!");
    }

    /**
     * Checks if a DNA sequence is valid (contains only A, C, G, T).
     *
     * @param dna the DNA sequence to validate
     * @return true if valid, false otherwise
     */
    public static boolean isValid(String dna) {
        String validBases = "ACGT";

        for (int i = 0; i < dna.length(); i++) {
            char base = dna.charAt(i);
            if (validBases.indexOf(base) == -1) {
                return false; // base not in "ACGT"
            }
        }
        return true;
    }

    /**
     * Displays the codons extracted from a DNA sequence.
     * Codons are 3-character sequences. Incomplete codons are marked with asterisks.
     *
     * @param dna the DNA sequence to extract codons from
     */
    public static void displayCodons(String dna) {
        String message = "";

        // Get as many complete codons as possible
        for (int i = 0; i < dna.length() - 2; i += 3) {
            message += "\n" + dna.substring(i, i + 3);
        }

        // 1-2 bases might be left over
        int remaining = dna.length() % 3;
        if (remaining == 1) {
            message += "\n" + dna.substring(dna.length() - 1,
                    dna.length()) + "**";
        } else if (remaining == 2) {
            message += "\n" + dna.substring(dna.length() - 2,
                    dna.length()) + "*";
        }

        message = "dna length: " + dna.length() + "\n\nCodons: " + message;
        JOptionPane.showMessageDialog(null, message,
                "Codons in DNA",
                JOptionPane.INFORMATION_MESSAGE);
    }
}