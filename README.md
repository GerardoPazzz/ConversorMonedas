### Conversor de Monedas
Ejercicio practico de openbootcamp de AluraLatam
- Por ahora solo disponible para las divisas (USD, PEN, CLP, BRL, ARS)
- Agregar la biblioteca GSON incluida en el directorio **lib** si es necesario.

- Proximamente nuevas mejoras ;)
 
# Modificar token si es necesario
    	public class ConsultarAPI {
        	public Moneda obtenerMoneda(String nombreMoneda) {
           	 //Configuracion de URL
            	String url_str = "https://v6.exchangerate-api.com/v6/50a3aeb9c46b9f1108f0d7ec/latest/" + nombreMoneda;

- Dentro de la variable **url_str** modificar la cadena de numeros por un token propio extraido de https://www.exchangerate-api.com/
