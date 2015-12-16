package ua.org.oa.podkopayv.zmarket3.json;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import ua.org.oa.podkopayv.zmarket3.model.Product;

import java.lang.reflect.Type;

public class ProductAdapter implements JsonSerializer<Product> {

    @Override
    public JsonElement serialize(Product product, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", product.getId());
        jsonObject.addProperty("category", product.getCategory().getTitle());
        jsonObject.addProperty("name", product.getName());
        jsonObject.addProperty("description", product.getDescription());
        jsonObject.addProperty("price", product.getPrice());
        return jsonObject;
    }
}
