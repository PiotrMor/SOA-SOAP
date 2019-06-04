package model;

public class Avatar {
    private String avatar;
    private int id;

    public Avatar() {
    }

    public Avatar(String avatar, int id) {
        this.avatar = avatar;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
