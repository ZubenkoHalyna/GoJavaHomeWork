package module8;

/**
 * Created by g.zubenko on 21.12.2016.
 */
public class User implements HasIdentification{
    private static IdProvider idProvider = UuidProvider.getInstance();
    private long id;
    private String name;

    public User(String name) {
        this.name = name;
        id = idProvider.getNewId();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        return id == user.id;

    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
