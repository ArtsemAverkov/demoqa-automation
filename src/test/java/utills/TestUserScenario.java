package utills;

public enum TestUserScenario {
    VALID_DATA("validData"),
    INVALID_EMAIL("invalid-email"),
    LONG_USERNAME("name_max_length"),
    SMALL_USERNAME("name_min_length"),
    SPECIAL_CHARS("name_with_special_chars"),
    EMPTY_NAME("empty_name"),
    ONLY_NAME_AND_EMAIL("only_name_and_email");

    private String dataUser;

    public String getDataUser() {
        return dataUser;
    }

    TestUserScenario(String dataUser) {
        this.dataUser = dataUser;
       }

    }


