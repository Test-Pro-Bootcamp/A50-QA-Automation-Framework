import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {

    @Test
    public void playSong() throws InterruptedException {
        logIn("andrey.zlotnikov@testpro.io", "Man07hat01tan26!");
        goToAllSongs();
        playSelectedSong("BossStatus");


    }

}
