package com.testchallenge.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import junit.framework.Assert;
import org.json.JSONObject;
import org.testng.annotations.Test;


public class TrelloApi {

    private final Properties configProp = new Properties();


    private static String key = "712215629bb3ff8346f162db933b5461";

    private static String token = "fa7c5c90fa4b6ef2719e019c72a820150350faa174b0d74d9f2774e36996a7e6";

    private static String boardUri = "https://api.trello.com/1/boards/";

    private static String listUri = "https://api.trello.com/1/lists/";

    private static String cardUri = "https://api.trello.com/1/cards";

    public String boardId = "boardId";

    public String listToDoId = "listToDoId";

    public String listProgressId = "listProgressId";

    public String listDoneId = "listDoneId";

    String url = "https://api.trello.com/1/members/me/boards?" +
            "key=" + key +
            "&token=" + token ;

    public Map<String, String> ids = new HashMap<String, String>();
    public void setProperty(String key, String value){
        configProp.setProperty(key, value);
    }

    public TrelloApi()
    {

        InputStream in = this.getClass().getClassLoader().getResourceAsStream("application.properties");
        System.out.println("Read all properties from file");
        try {
            configProp.load(in);
            System.out.println(configProp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    @Test(priority = 1)
//    public void lotto_resource_returns_200_with_expected_id_and_winners() {
//
//        when().
//                get(url).
//                then().
//                statusCode(200).
//                body("lotto.lottoId", equalTo(5),
//                        "lotto.winners.winnerId", hasItems(23, 54));
//
//    }

    @Test(priority = 1)
    public void createBoard() {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .queryParam("key", key)
                .queryParam("token", token)
                .queryParam("name", "test_board")
                .post(boardUri);
        JsonPath res = response.getBody().jsonPath();
        Assert.assertEquals(response.getStatusCode(), 200);
        ids.put(boardId, res.get("id").toString());
    }

    @Test(priority = 2)
    public void createToDoList() {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .queryParam("key", key)
                .queryParam("token", token)
                .queryParam("name", "Todo")
                .queryParam("idBoard", ids.get(boardId))
                .post(listUri);
        JsonPath res = response.getBody().jsonPath();
        Assert.assertEquals(response.getStatusCode(), 200);
        ids.put(listToDoId, res.get("id").toString());
    }

    @Test(priority = 3)
    public void createInProgressList() {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .queryParam("key", key)
                .queryParam("token", token)
                .queryParam("name", "Inprogress")
                .queryParam("idBoard", ids.get(boardId))
                .post(listUri);
        JsonPath res = response.getBody().jsonPath();
        Assert.assertEquals(response.getStatusCode(), 200);
        ids.put(listProgressId, res.get("id").toString());
    }

    @Test(priority = 4)
    public void createDoneList() {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .queryParam("key", key)
                .queryParam("token", token)
                .queryParam("name", "Done")
                .queryParam("idBoard", ids.get(boardId))
                .post(listUri);
        JsonPath res = response.getBody().jsonPath();
        Assert.assertEquals(response.getStatusCode(), 200);
        ids.put(listDoneId, res.get("id").toString());
    }



    @Test(priority = 5)
    public void createCard() {

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .queryParam("name", "test-card") // Cast
                .queryParam("desc", "created for testing purpose")
                .queryParam("pos", "top")
                .queryParam("due", "21/03/2020")

                .queryParam("dueComplete", false)
                .queryParam("idList", ids.get(listToDoId))
                .post(cardUri);
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

    }
}
