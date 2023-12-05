import org.testng.annotations.Test;

public class Homework17 extends BaseTest{

@Test(testName = "Add a song to the playlist", groups = "Smoke")
  public void addSongToPlaylist(){
    openWebBrowser();
    enterEmail("son.nam.kim@testpro.io");
    enterPassword("koel08/23");
    clickLoginButton();
    createPlaylist();


}
}
