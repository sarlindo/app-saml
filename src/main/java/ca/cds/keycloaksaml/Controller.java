
package ca.cds.keycloaksaml;

import org.keycloak.adapters.saml.SamlPrincipal;
import javax.servlet.http.HttpServletRequest;

public class Controller {

    public String getFirstName(HttpServletRequest req) {
        return getFriendlyAttrib(req, "givenName");
    }

    public String getLastName(HttpServletRequest req) {
        return getFriendlyAttrib(req, "surname");
    }

    public String getEmail(HttpServletRequest req) {
        return getFriendlyAttrib(req, "email");
    }

    public String getManager(HttpServletRequest req) {
        return getFriendlyAttrib(req, "manager");
    }

    public String getUsername(HttpServletRequest req) {
        return getAccount(req).getName();
    }

    private String getFriendlyAttrib(HttpServletRequest req, String attribName) {
        SamlPrincipal principal = getAccount(req);
        return principal.getAttribute(attribName);
        //return principal.getFriendlyAttribute(attribName);
    }

    private SamlPrincipal getAccount(HttpServletRequest req) {
        SamlPrincipal principal = (SamlPrincipal)req.getUserPrincipal();
        return principal;
    }

    public boolean isLoggedIn(HttpServletRequest req) {
        return getAccount(req) != null;
    }
}

