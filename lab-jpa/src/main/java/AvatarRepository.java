import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "avatar")
public class AvatarRepository implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "student_id")
    private Integer id;
    @Column(name = "avatar_Base64")
    @Lob
    private String avatar;

    @OneToOne()
    @MapsId
    private StudentRepository student;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "AvatarJPA{" +
                "id=" + id +
                ", avatar=" + avatar +
                '}';
    }
}
