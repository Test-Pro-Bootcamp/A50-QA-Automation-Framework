import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {

    @Test
    public void playSong() throws InterruptedException {
        logIn("demo@class.com", "te$t$tudent");
        goToAllSongs();
        playSelectedSong("BossStatus");

    }

}