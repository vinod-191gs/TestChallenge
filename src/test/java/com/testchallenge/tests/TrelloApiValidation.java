package com.testchallenge.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class TrelloApiValidation extends TrelloApi{

    private final Properties configProp = new Properties();


    private static String key = "712215629bb3ff8346f162db933b5461";

    private static String token = "fa7c5c90fa4b6ef2719e019c72a820150350faa174b0d74d9f2774e36996a7e6";

    private static String boardUri = "https://api.trello.com/1/boards/";

    private static String listUri = "https://api.trello.com/1/lists/";

    private static String cardUri = "https://api.trello.com/1/cards";

    private static String moveAllCards = "https://api.trello.com/1/moveAllCards";

    private static final String boardId = "boardId";

    private static final String listId = "listId";

    String url = "https://api.trello.com/1/members/me/boards?" +
            "key=" + key +
            "&token=" + token ;

//    private final Map<String, String> ids = new HashMap<String, String>();
    public void setProperty(String key, String value){
        configProp.setProperty(key, value);
    }

    @Test(priority = 1)
    public void checkcardIsInProgress() {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .queryParam("key", key)
                .queryParam("token", token)
                .queryParam("name", "test_board")
                .get(cardUri);
        JsonPath res = response.getBody().jsonPath();
        Assert.assertEquals(response.getStatusCode(), 200);

        Assert.assertTrue("card is not moved to in progress", res.get("name").toString().equals("test-card"));
    }

    @Test(priority = 2)
    public void moveCardToDoneState() {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .queryParam("key", key)
                .queryParam("token", token)
                .queryParam("id", ids.get(listProgressId))
                .queryParam("idBoard", ids.get(listProgressId))
                .queryParam("idList", ids.get(listDoneId))
                .queryParam("name", "test_board")
                .post(moveAllCards);
        JsonPath res = response.getBody().jsonPath();
        Assert.assertEquals(response.getStatusCode(), 200);

        Assert.assertTrue("card is not moved to in progress", res.get("name").toString().equals("test-card"));
    }
}
