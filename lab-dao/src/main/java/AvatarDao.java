import model.Avatar;

import javax.ejb.Stateless;
import java.util.logging.Logger;

@Stateless
public class AvatarDao extends AbstractDao {
    @Override
    protected Logger getLogger() {
        return Logger.getLogger(this.getClass().getName());
    }

    @SuppressWarnings("unchecked")
    @Override
    protected Class<AvatarJPA> getType() {
        return AvatarJPA.class;
    }

    public Avatar getAvatar(Integer id) {
        StudentMapper sm = new StudentMapper();

        AvatarJPA avatarRepository = this.entityManager.find(AvatarJPA.class, id);

        return sm.EntitytoDTO(avatarRepository);
    }

    public void addAvatar(Avatar avatar) {
        StudentMapper sm = new StudentMapper();

        AvatarJPA avatarRepository = sm.DTOtoEntity(avatar);

        this.create(avatarRepository);
    }
}
