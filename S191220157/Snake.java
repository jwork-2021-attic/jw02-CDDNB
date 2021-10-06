package S191220157;

public class Snake {

    private static Snake theSnake;

    public static Snake getTheGeezer() {
        if (theSnake == null) {
            theSnake = new Snake();
        }
        return theSnake;
    }

    private Snake() {

    }

    private Sorter sorter;

    public void setSorter(Sorter sorter) {
        this.sorter = sorter;
    }

    public String lineUp(Line line) {

        String log = new String();

        if (sorter == null) {
            return null;
        }

        Linable[] linables = line.toArray();
        int[] ranks = new int[linables.length];

        for (int i = 0; i < linables.length; i++) {
            ranks[i] = linables[i].getValue();
        }

        sorter.load(ranks);
        sorter.sort();

        String[] sortSteps = this.parsePlan(sorter.getPlan());

        for (String step : sortSteps) {
            //System.out.println(line.toString());
            this.execute(step, line);
            System.out.println(line.toString());
            log += line.toString();
            log += "\n[frame]\n";
        }

        return log;

    }

    private String[] parsePlan(String plan) {
        return plan.split("\n");
    }

    private void execute(String step, Line line) {
        String[] couple = step.split("<->");
        line.swapPosition(Integer.parseInt(couple[0]), Integer.parseInt(couple[1]));
        //Gourd.getGourdByRank(Integer.parseInt(couple[0]))
                //.swapPosition(Gourd.getGourdByRank(Integer.parseInt(couple[1])));
    }

}
