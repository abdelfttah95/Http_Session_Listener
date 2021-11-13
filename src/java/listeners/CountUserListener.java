package listeners;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

/**
 * Web application lifecycle listener.
 *
 * @author abdel
 */
public class CountUserListener implements HttpSessionListener {

    ServletContext ctx = null;
    static int total = 0, current = 0;

    public void sessionCreated(HttpSessionEvent e) {
        total++;
        current++;

        ctx = e.getSession().getServletContext();
        ctx.setAttribute("totalusers", total);
        ctx.setAttribute("currentusers", current);

    }

    public void sessionDestroyed(HttpSessionEvent e) {
        current--;
        ctx.setAttribute("currentusers", current);
    }
}
