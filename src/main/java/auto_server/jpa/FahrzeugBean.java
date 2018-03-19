package auto_server.jpa;

import auto_server.ejb.Fahrzeug;

public class FahrzeugBean extends EntityBean<Fahrzeug, Long> {
    
    public FahrzeugBean(){
        super(Fahrzeug.class);
    }
    
}
