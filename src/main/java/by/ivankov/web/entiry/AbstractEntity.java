package by.ivankov.web.entiry;

public class AbstractEntity {
    private int id;

    public int getId(int id) {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "AbstractEntity{" +
                "id=" + id +
                '}';
    }
}
