package auto_server.jpa;

import auto_server.ejb.Kunde;

public class KundenBean extends EntityBean<Kunde, Long> {
    
    public KundenBean(){
        super(Kunde.class);
    }
    
} 

