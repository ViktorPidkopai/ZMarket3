package ua.org.oa.podkopayv.zmarket3.json;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import ua.org.oa.podkopayv.zmarket3.model.Pet;

import java.lang.reflect.Type;

public class PetAdapter implements JsonSerializer<Pet> {

    @Override
    public JsonElement serialize(Pet pet, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", pet.getId());
        jsonObject.addProperty("name", pet.getName());
        jsonObject.addProperty("price", pet.getPrice());
        return jsonObject;
    }
}
