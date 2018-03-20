package auto_server.soap;

import auto_server.ejb.Fahrzeug;
import auto_server.ejb.Kunde;
import auto_server.ejb.Leihvertrag;
import auto_server.jpa.FahrzeugBean;
import auto_server.jpa.KundenBean;
import auto_server.jpa.LeihvertragBean;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(serviceName = "Auto")
public class AutoServerSoapWebservice {

    @EJB
    KundenBean kundenbean;

    @EJB
    LeihvertragBean leihvertragbean;

    @EJB
    FahrzeugBean fahrzeugbean;

    @WebMethod
    @WebResult(name = "kunde")
    public Kunde createNewKunde(@WebParam(name = "kunde") Kunde kunde) {
        return kundenbean.saveNew(kunde);
    }

    @WebMethod
    @WebResult(name = "fahrzeug")
    public Fahrzeug createNewFahrzeug(@WebParam(name = "fahrzeug") Fahrzeug fahrzeug) {
        return fahrzeugbean.saveNew(fahrzeug);
    }
/**
    @WebMethod
    @WebResult(name = "leihvertrag")
    public Leihvertrag fahrzeugAusleihen(@WebParam(name = "kunde") Kunde kunde,
                             @WebParam(name = "fahrzeug") Fahrzeug fahrzeug,
                             @WebParam(name = "beginnzeit") Date beginnzeit,
                             @WebParam(name = "endzeit") Date endzeit) {
        return leihvertragbean.ausleihen(kunde, fahrzeug, beginnzeit, endzeit);
    }
**/
    @WebMethod
    @WebResult(name = "fahrzeug")
    public List<Fahrzeug> fahrzeugAuflisten() {
        return fahrzeugbean.findAll();
    }

    @WebMethod
    @WebResult(name = "leihvertrag")
    public List<Leihvertrag> leihvertragAuflisten(@WebParam(name = "kunde") Kunde kunde) {
        return leihvertragbean.findByKundenId(kunde);
    }
}
