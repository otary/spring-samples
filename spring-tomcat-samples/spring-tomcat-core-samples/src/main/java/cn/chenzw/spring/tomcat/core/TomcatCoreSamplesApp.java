package cn.chenzw.spring.tomcat.core;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.springframework.util.Base64Utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class TomcatCoreSamplesApp {

    public static void main(String[] args) throws LifecycleException {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(9080);
        // tomcat.setBaseDir(docBase);
        tomcat.getHost().setAutoDeploy(true);


        String contextPath = "/samples";
        StandardContext context = new StandardContext();
        context.setPath(contextPath);
        context.addLifecycleListener(new Tomcat.FixContextListener());
        tomcat.getHost().addChild(context);

        // http://localhost:9090/samples/home
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setPort(9090);
        /*
        Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
        protocol.setKeystorePass("123456");
        protocol.setKeystoreFile("e:/tmp/ssl/boot.keystore");
        protocol.setKeyAlias("mykey");
        protocol.setSSLEnabled(true);
        */
        tomcat.getService().addConnector(connector);

        Tomcat.addServlet(context, "homeServlet", new HttpServlet() {
            private static final long serialVersionUID = 6396960531546939242L;

            @Override
            protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                this.doPost(req, resp);
            }

            @Override
            protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                // dosth....
                resp.getWriter().write("homepage");
            }
        });
        context.addServletMappingDecoded("/home", "homeServlet");

        // tomcat.addServlet(contextPath, "basicAuthServlet", new BaiscAuth());
        // context.addServletMappingDecoded("/basicAuth", "basicAuthServlet");
        // tomcat.addServlet(contextPath, "digestAuthServlet", new DigestAuthServlet());
        // context.addServletMappingDecoded("/digestAuth", "digestAuthServlet");
        tomcat.start();
        tomcat.getServer().await();
    }

    /**
     * basic认证
     */
    private static class BaiscAuth extends HttpServlet {
        private static final long serialVersionUID = 583077505324468374L;

        private boolean checkIsExistsUserSession(HttpServletRequest request) {
            HttpSession session = request.getSession();
            return !(session.getAttribute("user") == null);
        }

        private String[] getAuthUsernameAndPassword(HttpServletRequest request) {
            String authorization = request.getHeader("authorization");
            if (authorization == null || "".equals(authorization)) {
                return null;
            }
            String userAndPwdKeyPair = new String(
                    Base64Utils.decodeFromString(authorization.split(" ")[1]));
            return userAndPwdKeyPair.split(":");
        }

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                throws ServletException, IOException {
            this.doPost(req, resp);
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp)
                throws ServletException, IOException {
            resp.setCharacterEncoding("utf-8");
            resp.setHeader("Content-Type", "text/html; charset=utf-8");

            PrintWriter out = resp.getWriter();
            if (checkIsExistsUserSession(req)) {
                // 已认证成功
                out.println("登陆成功!");
            } else {
                String[] usernameAndPassword = getAuthUsernameAndPassword(req);
                if (usernameAndPassword == null) {
                    resp.setStatus(401);
                    resp.setHeader("www-authenticate",
                            "Basic realm=\"personal\"");
                    out.println("对不起,你没有访问权限！");
                } else if (usernameAndPassword.length < 2) {
                    resp.setStatus(401);
                    resp.setHeader("www-authenticate",
                            "Basic realm=\"personal\"");
                    out.println("账号或密码不正确！");
                } else {
                    // 进行账号密码验证
                    if ("abc".equals(usernameAndPassword[0])
                            && "123".equals(usernameAndPassword[1])) {
                        req.getSession().setAttribute("user",
                                usernameAndPassword[0]);
                        out.println("登陆成功");
                    } else {
                        resp.setStatus(401);
                        resp.setHeader("www-authenticate",
                                "Basic realm=\"personal\"");
                        out.println("账号或密码不正确！");
                    }
                }

            }
        }
    }

    /**
     * digest认证
     */
    private static class DigestAuthServlet extends HttpServlet {

        private static final long serialVersionUID = -8577123761134326070L;

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                throws ServletException, IOException {

            this.doPost(req, resp);
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp)
                throws ServletException, IOException {
            resp.setStatus(401);
            resp.setHeader("Cache-Control", "no-store");
            resp.setDateHeader("Expires", 0);
            resp.setHeader(
                    "www-authenticate",
                    "Digest Realm=\"test\", nonce=\""
                            + "aaa"
                            + "\", qop=\"auth\"");

            System.out.println(req.getHeader("authorization"));
        }

    }

}
