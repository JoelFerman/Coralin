package coral.co.coralin;

/**
 * Created by joelferman on 4/28/16.
 */
public class DownloadGameData
{
    public String gameName;
    public int imageId;
    public int imageId2;
    public int imageId3;

    DownloadGameData(String gameName, int imageId, int imageId2, int imageId3) {
        this.gameName = gameName;
        this.imageId = imageId;
        this.imageId2 = imageId2;
        this.imageId3 = imageId3;
    }
}
