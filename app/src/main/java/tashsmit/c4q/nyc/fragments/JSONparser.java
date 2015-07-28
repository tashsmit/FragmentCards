package tashsmit.c4q.nyc.fragments;

/**
 * Created by c4q-tashasmith on 7/25/15.
 */
import android.content.Context;
import android.util.Log;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by c4q-Abass on 6/23/15.
 */

//JSON Reader and Writer class
public class JSONparser {
    private Context mContext;
    private String mFileName;

    public JSONparser(Context c, String f) {
        mContext = c;
        mFileName = f;
    }

    public JSONparser(){

    }

    public JSONObject parse(String webPage) {
        try {
            Log.d("$$$", webPage);
            URL url = new URL(webPage);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            String Json = readStream(connection.getInputStream());
            Log.d("|||", Json);
            JSONObject jsonObject = new JSONObject(Json);
            return jsonObject;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String readStream(InputStream in) throws IOException {
        char[] buffer = new char[1024 * 4];
        InputStreamReader reader = new InputStreamReader(in, "UTF8");
        StringWriter writer = new StringWriter();
        int n;
        while ((n = reader.read(buffer)) != -1) {
            writer.write(buffer, 0, n);
        }
        return writer.toString();
    }
}


