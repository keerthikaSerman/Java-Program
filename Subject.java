import java.util.ArrayList;

public class Subject {

    private String name;
    private ArrayList<Topic> topics;

    public Subject(String name) {

        this.name = name;
        topics = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addTopic(Topic topic) {
        topics.add(topic);
    }

    public ArrayList<Topic> getTopics() {
        return topics;
    }
}