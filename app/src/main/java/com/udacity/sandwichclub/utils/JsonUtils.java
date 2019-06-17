package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich = new Sandwich();
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONObject name = jsonObject.getJSONObject("name");
            String mainName = name.getString("mainName");
            JSONArray alsoKnownAs = name.getJSONArray("alsoKnownAs");
            List<String> alsoKnownAsArray =new ArrayList<>();
            for(int i = 0; i < alsoKnownAs.length(); i++){
                alsoKnownAsArray.add(alsoKnownAs.getString(i));
            }
            String placeOrigin = jsonObject.getString("placeOfOrigin");
            String imageUrl = jsonObject.getString("image");
            String description = jsonObject.getString("description");
            sandwich.setDescription(description);
            sandwich.setImage(imageUrl);
            sandwich.setPlaceOfOrigin(placeOrigin);
            sandwich.setAlsoKnownAs(alsoKnownAsArray);
            sandwich.setMainName(mainName);



        }catch(JSONException e){
            e.printStackTrace();
        }
        return sandwich;
    }
}
