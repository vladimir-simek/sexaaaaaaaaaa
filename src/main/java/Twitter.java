import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@RequestScoped
@Named
public class Twitter {
    private String content;
    private String author;
    private int likes;
    private String created_at;
    private String updated_at;

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public Twitter(){

    }
    public Twitter(String content, String author, int likes) {
        this.content = content;
        this.author = author;
        this.likes = likes;
    }

    public Twitter(String content, String author, int likes, String created_at, String updated_at) {
        this.content = content;
        this.author = author;
        this.likes = likes;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
