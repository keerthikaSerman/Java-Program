public class Topic {

    private String name;
    private int progress;

    public Topic(String name) {

        this.name = name;
        progress = 0;
    }

    public String getName() {
        return name;
    }

    public int getProgress() {
        return progress;
    }

    public void updateProgress(int score, int total) {

        if (total > 0) {
            progress = (score * 100) / total;
        }
    }
}