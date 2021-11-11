package crud;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    Long id;
    static long idInc;
    StringBuilder name;

    public User(String name) {
        this.name = new StringBuilder(name);
        this.id = idInc++;
    }
}
