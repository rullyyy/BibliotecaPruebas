/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author luisp
 */
@Entity
@Table(name = "valoracion_libro")
public class ValoracionLibro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "ID_SEQ")
    @Column(name = "id")
    private long id;
    @Column(name = "calificacion")
    private int calificacion;
    @Column(name = "review")
    private String review;

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public float obtieneValoracionLibro(String nombreLibro) {
        Scanner tec = new Scanner(System.in);

        final String requestURL = String.format("https://www.googleapis.com/books/v1/volumes?q=%s", nombreLibro);
        try {

            URL url = new URL(requestURL);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();

            int responseCode = httpURLConnection.getResponseCode();

            if (responseCode != 200) {
                throw new RuntimeException("Ocurrió un error, el código de respuesta no es 200");
            } else {
                StringBuilder informationString = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());
                while (scanner.hasNext()) {
                    informationString.append(scanner.nextLine());
                }

                scanner.close();
                System.out.println(informationString.toString());
                JsonParser parser = new JsonParser();
                JsonObject jsonObject = parser.parse(informationString.toString()).getAsJsonObject();
                JsonArray itemsArray = jsonObject.getAsJsonArray("items");
                JsonObject volumeInfo = itemsArray.get(0).getAsJsonObject().getAsJsonObject("volumeInfo");

                // Extracting average rating
                double averageRating = volumeInfo.getAsJsonPrimitive("averageRating").getAsDouble();

                // Printing average rating
                System.out.println("Average Rating: " + averageRating);
            }
        } catch (Exception e) {
            System.err.println(e);
        }

        return 0;
    }

}
