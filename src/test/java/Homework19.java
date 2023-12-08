import org.testng.annotations.Test;

public class Homework19 extends BaseTest {

    @Test
    public void deletePlaylist () throws InterruptedException {
        logIn("andrey.zlotnikov@testpro.io", "Man07hat01tan26!");
        createPlaylist("Experimental");
        deleteSelectedPlaylist("Experimental");

    }

}
