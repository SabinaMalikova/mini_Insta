package models;

public class Post {
    private Long id;
    private String imgUrl;
    private String description;

    public Post() {
    }

    public Post(Long id, String imgUrl, String description) {
        this.id = id;
        this.imgUrl = imgUrl;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", imgUrl='" + imgUrl + '\'' +
                ", discreaption='" + description + '\'' +
                '}';
    }
}
