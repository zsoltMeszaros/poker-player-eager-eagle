package org.leanpoker.player;

import com.google.gson.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Player {

    private static Gson gson = new Gson();

    static final String VERSION = "1.1.2";

    public static int betRequest(JsonElement request) {

        JsonObject jsonObject = request.getAsJsonObject();

        int inAction = jsonObject.get("in_action").getAsInt();
        JsonElement self = jsonObject.get("players").getAsJsonArray().get(inAction);
        JsonArray cards = self.getAsJsonObject().get("hole_cards").getAsJsonArray();
        JsonObject[] selfCards = new JsonObject[2];
        for (int i = 0; i < selfCards.length; i++) {
            selfCards[i] = cards.get(i).getAsJsonObject();
        }




        return 0;
    }

    public static void main(String[] args) {

        String jsonString = "{\n" +
                "  \"tournament_id\":\"550d1d68cd7bd10003000003\",     // Id of the current tournament\n" +
                "\n" +
                "  \"game_id\":\"550da1cb2d909006e90004b1\",           // Id of the current sit'n'go game. You can use this to link a\n" +
                "                                                  // sequence of game states together for logging purposes, or to\n" +
                "                                                  // make sure that the same strategy is played for an entire game\n" +
                "\n" +
                "  \"round\":0,                                      // Index of the current round within a sit'n'go\n" +
                "\n" +
                "  \"bet_index\":0,                                  // Index of the betting opportunity within a round\n" +
                "\n" +
                "  \"small_blind\": 10,                              // The small blind in the current round. The big blind is twice the\n" +
                "                                                  //     small blind\n" +
                "\n" +
                "  \"current_buy_in\": 320,                          // The amount of the largest current bet from any one player\n" +
                "\n" +
                "  \"pot\": 400,                                     // The size of the pot (sum of the player bets)\n" +
                "\n" +
                "  \"minimum_raise\": 240,                           // Minimum raise amount. To raise you have to return at least:\n" +
                "                                                  //     current_buy_in - players[in_action][bet] + minimum_raise\n" +
                "\n" +
                "  \"dealer\": 1,                                    // The index of the player on the dealer button in this round\n" +
                "                                                  //     The first player is (dealer+1)%(players.length)\n" +
                "\n" +
                "  \"orbits\": 7,                                    // Number of orbits completed. (The number of times the dealer\n" +
                "                                                  //     button returned to the same player.)\n" +
                "\n" +
                "  \"in_action\": 1,                                 // The index of your player, in the players array\n" +
                "\n" +
                "  \"players\": [                                    // An array of the players. The order stays the same during the\n" +
                "      {                                           //     entire tournament\n" +
                "\n" +
                "          \"id\": 0,                                // Id of the player (same as the index)\n" +
                "\n" +
                "          \"name\": \"Albert\",                       // Name specified in the tournament config\n" +
                "\n" +
                "          \"status\": \"active\",                     // Status of the player:\n" +
                "                                                  //   - active: the player can make bets, and win the current pot\n" +
                "                                                  //   - folded: the player folded, and gave up interest in\n" +
                "                                                  //       the current pot. They can return in the next round.\n" +
                "                                                  //   - out: the player lost all chips, and is out of this sit'n'go\n" +
                "\n" +
                "          \"version\": \"Default random player\",     // Version identifier returned by the player\n" +
                "\n" +
                "          \"stack\": 1010,                          // Amount of chips still available for the player. (Not including\n" +
                "                                                  //     the chips the player bet in this round.)\n" +
                "\n" +
                "          \"bet\": 320                              // The amount of chips the player put into the pot\n" +
                "      },\n" +
                "      {\n" +
                "          \"id\": 1,                                // Your own player looks similar, with one extension.\n" +
                "          \"name\": \"Bob\",\n" +
                "          \"status\": \"active\",\n" +
                "          \"version\": \"Default random player\",\n" +
                "          \"stack\": 1590,\n" +
                "          \"bet\": 80,\n" +
                "          \"hole_cards\": [                         // The cards of the player. This is only visible for your own player\n" +
                "                                                  //     except after showdown, when cards revealed are also included.\n" +
                "              {\n" +
                "                  \"rank\": \"6\",                    // Rank of the card. Possible values are numbers 2-10 and J,Q,K,A\n" +
                "                  \"suit\": \"hearts\"                // Suit of the card. Possible values are: clubs,spades,hearts,diamonds\n" +
                "              },\n" +
                "              {\n" +
                "                  \"rank\": \"K\",\n" +
                "                  \"suit\": \"spades\"\n" +
                "              }\n" +
                "          ]\n" +
                "      },\n" +
                "      {\n" +
                "          \"id\": 2,\n" +
                "          \"name\": \"Chuck\",\n" +
                "          \"status\": \"out\",\n" +
                "          \"version\": \"Default random player\",\n" +
                "          \"stack\": 0,\n" +
                "          \"bet\": 0\n" +
                "      }\n" +
                "  ],\n" +
                "  \"community_cards\": [                            // Finally the array of community cards.\n" +
                "      {\n" +
                "          \"rank\": \"4\",\n" +
                "          \"suit\": \"spades\"\n" +
                "      },\n" +
                "      {\n" +
                "          \"rank\": \"A\",\n" +
                "          \"suit\": \"hearts\"\n" +
                "      },\n" +
                "      {\n" +
                "          \"rank\": \"6\",\n" +
                "          \"suit\": \"clubs\"\n" +
                "      }\n" +
                "  ]\n" +
                "}";


        Player.betRequest(new JsonParser().parse(jsonString));


    }

    public static void showdown(JsonElement game) {
    }
}
