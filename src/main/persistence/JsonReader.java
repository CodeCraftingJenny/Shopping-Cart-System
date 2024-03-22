package persistence;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;
import model.Clothing;
import model.Customer;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced from the JsonSerialization Demo
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

// Represents a reader that reads customer info from JSON data that is stored in a file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    //EFFECTS: reads customer data from file and returns it
    //throws IOException if error happens when reading data in the file
    public Customer readCustomer() throws IOException {
        String jsonData = this.readFile(this.source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return this.parseCustomer(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }
        return contentBuilder.toString();
    }

    //EFFECTS: parses JSON data that represents Customer and returns it
    private Customer parseCustomer(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        Customer customer = new Customer(name);
        addToCart(customer, jsonObject);
        return customer;
    }

    //MODIFIES: customer
    //EFFECTS: adds clothing items to Customer based on JSONObject
    private void addToCart(Customer customer, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("cart");
        for (Object json : jsonArray) {
            JSONObject nextCustomer = (JSONObject) json;
            addCustomer(customer, nextCustomer);
        }
    }

    //MODIFIES: customer
    //EFFECTS: adds an item to Customer based on JSONObject
    private void addCustomer(Customer customer, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        String colour = jsonObject.getString("colour");
        String size = jsonObject.getString("size");
        Clothing clothing = new Clothing(name, colour, size);
        customer.addToCart(clothing);
    }
}
