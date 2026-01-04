public class Book {
    @SuppressWarnings("FieldMayBeFinal")
    private int id;
    @SuppressWarnings("FieldMayBeFinal")
    private String title;
    private boolean issued;

    public Book(int id, String title, boolean issued) {
        this.id = id;
        this.title = title;
        this.issued = issued;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isIssued() {
        return issued;
    }

    public void setIssued(boolean issued) {
        this.issued = issued;
    }

    @Override
    public String toString() {
        return id + "," + title + "," + issued;
    }
}