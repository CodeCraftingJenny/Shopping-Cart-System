package persistence;

import org.json.JSONObject;

// Referenced from the JsonSerialization Demo
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationD

public interface Writable {
    JSONObject toJson();
}

