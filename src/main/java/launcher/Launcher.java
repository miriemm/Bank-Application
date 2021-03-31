package launcher;

import database.Boostraper;

import java.sql.SQLException;

public class Launcher {

    public static boolean BOOTSTRAP = true;

    public static void main(String[] args) {
        bootstrap();

        ComponentFactory componentFactory = ComponentFactory.instance(false);
        componentFactory.getLoginView().setVisible();
        componentFactory.getAdministratorView().setVisible();
        componentFactory.getEmployeeView().setVisible();
    }

    private static void bootstrap() {
        if (BOOTSTRAP) {
            try {
                new Boostraper().execute();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

}
