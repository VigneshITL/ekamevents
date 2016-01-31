import com.google.common.collect.ImmutableMap;
import com.itl.events.models.User;
import org.junit.Test;
import play.Application;
import play.Environment;
import play.Mode;
import play.inject.guice.GuiceApplicationBuilder;
import play.test.FakeApplication;
import play.test.Helpers;
import play.test.WithApplication;

import javax.inject.Inject;
import java.io.File;
import java.util.ArrayList;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.running;

public class ModelTest extends WithApplication {

//    @Inject
//    Application application;

    /*@Override
    protected FakeApplication provideFakeApplication() {
        return new FakeApplication(new java.io.File("."), Helpers.class.getClassLoader(),
                ImmutableMap.of("play.http.router", ""), new ArrayList<String>(), null);
    }*/

    @Test
    public void findById() {
       /* Application application = new GuiceApplicationBuilder()
                .in(new Environment(new File("application.conf"), this.getClass().getClassLoader(), Mode.TEST))
                .build();
*/

        User user = new User();
        user.name = "test";
        user.insert();
        User newUser = User.findByName("test");
        assertThat(newUser.name).isEqualToIgnoringCase("test");

//        running(application, new Runnable() {
//            public void run() {
//                User user = new User();
//                user.name = "test";
//                user.insert();
//                User newUser = User.findByName("test");
//                assertThat(newUser.name).isEqualToIgnoringCase("test");
//            }
//        });
    }

    @Test
    public void findById2() {
        /*Application application = new GuiceApplicationBuilder()
                .in(new Environment(new File("path/to/app"), classLoader, Mode.TEST))
                .build()*/

        User user = new User();
        user.name = "test";
        user.insert();
        User newUser = User.findByName("test");
        assertThat(newUser.name).isEqualToIgnoringCase("test");

        /*running(fakeApplication(), new Runnable() {
            public void run() {
                User user = new User();
                user.name = "test";
                user.insert();
                User newUser = User.findByName("test");
                assertThat(newUser.name).isEqualToIgnoringCase("test");
            }
        });*/
    }
}
