package utills.users;

import utills.models.UserDto;


import java.util.HashMap;
import java.util.Map;

public class ParameterResolverUser {
    public static UserDto getUser(String string) {
        Map<String, UserDto> users = new HashMap<>();

        users.put("validData", new UserDto(
                "John Doe",
                "john@example.com",
                "123 Main St",
                "456 Elm St"
        ));

        users.put("name_max_length", new UserDto(
                "A".repeat(500),
                "john@example.com",
                "123 Main St",
                "456 Elm St"
        ));

        users.put("name_min_length", new UserDto(
                "A",
                "john@example.com",
                "123 Main St",
                "456 Elm St"
        ));

        users.put("name_with_special_chars", new UserDto(
                "<script>alert(1)</script>",
                "john@example.com",
                "123 Main St",
                "456 Elm St"
        ));

        users.put("invalid-email", new UserDto(
                "John Doe",
                "invalid-email",
                "123 Main St",
                "456 Elm St"
        ));

        users.put("empty_name", new UserDto(
                "",
                "john@example.com",
                "123 Main St",
                "456 Elm St"
        ));

        users.put("only_name_and_email", new UserDto(
                "John Doe",
                "john@example.com",
                "",
                ""
        ));

        UserDto userDto = users.get(string);
        return userDto;
    }
}
