import org.apache.http.auth.Credentials;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.HttpEntity;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.MalformedURLException;

/*
 * в данной работе будут рассмотрены примеры использования метода GET с авторизацией
 * двумя разными способами
 * 1. реализация GET запроса стандартными средствами java;
 * 2. реализация GET запроса с использованием библиотеки apache http.
 * Все необходимые зависимости уже добавлены. (pom.xml, раздел dependencies)
 * */
public class HttpAuthGetExample {

    //TODO: необходимо разработать класс, имеющий два статичных метода.
    // Первый из которых осуществляет get запрос стандартными стредствами языка,
    // а второй с использование сторонней библиотеки apache.
    // Ссылка для запросов:  http://httpbin.org/basic-auth/user/passwd

    //TODO: проиициализируйте константу URL, которая будет использоваться для отправки запросов
    private final static String URL = "";
    private final static String DEFAULT_METHOD_CALL = "ВЫЗОВ МЕТОДА, НАПИСАННОГО С ИСПОЛЬЗОВАНИЕМ СТАНДАРТНЫХ КЛАССОВ";
    private final static String APACHE_METHOD_CALL = "ВЫЗОВ МЕТОДА, НАПИСАННОГО С ИСПОЛЬЗОВАНИЕМ APACHE";
    private final static String REQUEST_METHOD = "GET";
    private final static String AUTH_HEADER_NAME = "authorization";
    private final static String AUTH_HEADER_VALUE = "Basic ";
    private final static String CREDENTIALS = "user:passwd";

    public static void main(String[] args) {
        // write your code here
        get_Request_With_Autht_Using_Java_net();
        get_Request_With_Auth_Using_ApacheLibrary();

    }

    //TODO: разработайте метод, который осуществляет get запрос встроенными средствами языка
    private static void get_Request_With_Autht_Using_Java_net() {
        System.out.println(DEFAULT_METHOD_CALL + "\n");
        try {
            //TODO: создайте экземпляр класса URL используя ранее определенную константу URL
            //URL url = ;

            //TODO: создайте экземпляр класса HttpURLConnection, используя метод openConnection() класса URL
            // на ранее созданом объекте url
            // (!!! возвращаемое значение необходимо привести к типу HttpURLConnection !!!)
            //HttpURLConnection connection = ;

            //TODO: используя метод setRequestMethod(), установите метод запроса у объекта connection
            //connection./*МЕТОД УСТАНОВКИ МЕТОДА ЗАПРОСА*/;

            //TODO: используя полученные ранее навыки кодирования base64 закодируйте константу Credentials
            //String encodedCredentials = AUTH_HEADER_VALUE + /*ЗАКОДИРОВАННЫЕ В BASE64 CREDENTIALS*/;

            //TODO: добавьте хедер авторизации в ваш запрос, используя setRequestProperty(),
            // и полученную ранее строку encodedCredentials
            //connection.setRequestProperty();
            //TODO: используя метод getInputStream() из HttpURLConnection
            // создайте объект InputStream,
            // после чего на его основе создайте объект InputStreamReader
            // и конвертируйте его в BufferedReader
            //InputStream inputStream = ;
            //InputStreamReader inputStreamReader = ;
            //BufferedReader bufferedReader = ;

            //TODO: подготовьте строку и StringBuilder с помощью которых будете считывать ответ
            // (для этого раскоментируйте строки ниже)
            //String line;
            //StringBuilder response = new StringBuilder();

            //TODO: используя методы BufferedReadep.readLine() и StringBuilder.append()
            // считайте содержимое ответа
            //while (/*УСЛОВИЕ ВЫХОДА ИЗ ЦИКЛА -> bufferedReader.readLine = null*/) {
            //    //TODO: иплементируйте алгоритм считывания здесь
            //}

            /*
            * так как ответ приходит в виде json, целесообразно будет
            * использовать библиотеку для работы с ним, данная библиотека
            * уже добавлена в зависимостях в pom.xml
            * */

            //TODO: создайте экземпляр JSONObject, в качестве параметра
            // используйте полученную ранее строку
            //JSONObject jsonObject = new JSONObject(response.toString());

            //TODO: используя метод get(String property_name) из класса JSONObject
            // попробуйте получить значения таких полей как: authenticated и user
            //System.out.println(jsonObject.get(""));
            //System.out.println(jsonObject.get(""));


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //TODO: подробно разберите описанный ниже пример,
    // прочитайте информацию об использованных в нем методах и классах в документации
    private static void get_Request_With_Auth_Using_ApacheLibrary() {
        System.out.println(APACHE_METHOD_CALL + "\n");
        CredentialsProvider provider = new BasicCredentialsProvider();
        provider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials("user", "passwd"));
        CloseableHttpClient client = HttpClientBuilder.create().setDefaultCredentialsProvider(provider).build();
        HttpGet request = new HttpGet("http://httpbin.org/basic-auth/user/passwd");
        try {
            CloseableHttpResponse response = client.execute(request);
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
