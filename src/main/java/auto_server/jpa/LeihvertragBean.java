package auto_server.jpa;

import auto_server.ejb.Fahrzeug ;
import auto_server.ejb.Kunde;
import auto_server.ejb.Leihvertrag;
import java.util.Date;
import java.util.List;

public class LeihvertragBean extends EntityBean<Leihvertrag, Long> {

    public LeihvertragBean() {
        super(Leihvertrag.class);
    }

    public List<Leihvertrag> findByKundenId(Kunde kunde) {

        return em.createQuery("SELECT l FROM Leihvertrag l"
                + "    WHERE l.kunde.id = :kundenid")
                .setParameter("kundenid", kunde.getId())
                .getResultList();
    }

    
}
