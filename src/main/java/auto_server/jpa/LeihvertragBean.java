package auto_server.jpa;

import auto_server.ejb.Fahrzeug;
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

    public Leihvertrag ausleihen(Kunde kunde, Fahrzeug fahrzeug, Date beginndatum, Date enddatum) {
        Boolean ausleihenmoeglich = true;

        List<Leihvertrag> vertragezwischen = em.createQuery("SELECT l FROM Leihvertrag WHERE l.beginndatum > :kunde ORDER BY l.beginndatum").setParameter("beginndatum", beginndatum).setParameter("enddatum", enddatum).getResultList();

        if (vertragezwischen.isEmpty()) {
            List<Leihvertrag> außerhalb = em.createQuery("SELECT l FROM Leihvertrag WHERE l.kunde = :kunde ORDER BY l.beginndatum").setParameter("kunde", kunde).getResultList();
        }

        if (ausleihenmoeglich) {
            Leihvertrag leihvertrag = new Leihvertrag(kunde, fahrzeug, beginndatum, enddatum);
            return this.saveNew(leihvertrag);

        } else {

            return null;

        }
    }
}
