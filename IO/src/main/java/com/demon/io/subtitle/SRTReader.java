package com.demon.io.subtitle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SRTReader {
    public static void main(String[] args) {
        String filePath = "path/to/srt/file.srt";
        List<String> dialogues = extractDialogues(filePath);
        for (String dialogue : dialogues) {
            System.out.println(dialogue);
        }
    }

    public static List<String> extractDialogues(String filePath) {
        List<String> dialogues = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            StringBuilder dialogueBuilder = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    // Empty line indicates the end of a subtitle block
                    if (dialogueBuilder.length() > 0) {
                        dialogues.add(dialogueBuilder.toString());
                        dialogueBuilder.setLength(0);
                    }
                } else if (!isNumeric(line.trim())) {
                    // Non-numeric lines are dialogue lines
                    dialogueBuilder.append(line).append(" ");
                }
            }

            // Add the last dialogue block if any
            if (dialogueBuilder.length() > 0) {
                dialogues.add(dialogueBuilder.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dialogues;
    }

    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
