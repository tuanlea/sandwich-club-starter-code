package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject(json);

            // Use gson to deserialize?
            Sandwich sandwich = new Sandwich();

            JSONObject nameObject = jsonObject.getJSONObject("name");
            sandwich.setMainName(nameObject.getString("mainName"));
            JSONArray akaJsonArray = nameObject.getJSONArray("alsoKnownAs");
            ArrayList<String> akaList = new ArrayList<>();
            for (int i = 0; i < akaJsonArray.length(); i++) {
                akaList.add(akaJsonArray.getString(i));
            }
            sandwich.setAlsoKnownAs(akaList);

            String placeOfOrigin = jsonObject.getString("placeOfOrigin");
            sandwich.setPlaceOfOrigin(placeOfOrigin);

            String description = jsonObject.getString("description");
            sandwich.setDescription(description);

            String image = jsonObject.getString("image");
            sandwich.setImage(image);

            JSONArray ingredientsJsonArray = jsonObject.getJSONArray("ingredients");
            ArrayList<String> ingredients = new ArrayList<>();
            for (int i = 0; i < ingredientsJsonArray.length(); i++) {
                ingredients.add(ingredientsJsonArray.getString(i));
            }

            sandwich.setIngredients(ingredients);

            return sandwich;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
