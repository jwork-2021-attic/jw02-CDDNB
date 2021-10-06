package S191220157;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;


public class Scene {

    public static void main(String[] args) throws IOException {

        boolean[] b = new boolean[64];
        for(int i = 0; i < 64; i++) {
            b[i] = false;
        }
        int[] rand = new int[64];
        Random r = new Random();
        for(int i = 0; i < 64; i++) {
            int t = r.nextInt(64);
            while(b[t]) {
                t = r.nextInt(64);
            }
            rand[i] = t;
            b[t]=true;
        }

        Line line = new Line(64);
        for(int i = 0; i < 64; i++) {
            Goblin g = new Goblin(4*rand[i], 4*rand[i], 4*rand[i], rand[i]);
            line.put(g, i);
        }

        Snake theSnake = Snake.getTheGeezer();

        Sorter sorter = new BubbleSorter();
        //Sorter sorter = new QuickSorter();

        theSnake.setSorter(sorter);

        String log = theSnake.lineUp(line);

        BufferedWriter writer;
        writer = new BufferedWriter(new FileWriter("result.txt"));
        writer.write(log);
        writer.flush();
        writer.close();

    }

}
