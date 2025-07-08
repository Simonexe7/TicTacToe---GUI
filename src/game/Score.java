package game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Score {
    private String filename;

    public Score()
    {
        this.filename = "score.txt";
    }

    protected void saveScore(int playerScore, int computerScore){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))){
            writer.write(playerScore + "\n");
            writer.write(computerScore + "\n");
        } catch (IOException e) {
            System.out.println("Gagal menyimpan skor.");
        }
    }

    protected int[] loadScore()
    {
        int[] scores = {0, 0};
        File file = new File(filename);

        if(file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line1 = reader.readLine();
                String line2 = reader.readLine();

                if (line1 != null) scores[0] = Integer.parseInt(line1.trim());
                if (line2 != null) scores[1] = Integer.parseInt(line2.trim());
            } catch (IOException | NumberFormatException e) {
                System.out.println("Gagal membaca skor, mulai dari 0.");
            }
        }

        return scores;
    }
}
