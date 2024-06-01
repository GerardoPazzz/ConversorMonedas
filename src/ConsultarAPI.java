import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ConsultarAPI {
    public Moneda obtenerMoneda(String nombreMoneda) {
        //Configuracion de URL
        String url_str = "https://v6.exchangerate-api.com/v6/50a3aeb9c46b9f1108f0d7ec/latest/" + nombreMoneda;
        // Making Request
        URL url = null;
        try {
            url = new URL(url_str);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            //Convirtiendo a JSON
            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            JsonObject jsonobj = root.getAsJsonObject();

            //Accediendo a las conversiones deseadas
            JsonObject conversion = jsonobj.getAsJsonObject("conversion_rates");
            double usd = conversion.get("USD").getAsDouble();
            double pen = conversion.get("PEN").getAsDouble();
            double brl = conversion.get("BRL").getAsDouble();
            double ars = conversion.get("ARS").getAsDouble();
            double clp = conversion.get("CLP").getAsDouble();

            Moneda moneda = new Moneda(nombreMoneda, usd, pen, brl, ars, clp);
            request.disconnect();
            return moneda;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
