package utills;

public enum Endpoint {
    TEXT_BOX("/text-box"),
    CHECK_BOX("/checkbox"),
    RADIO_BUTTON("/radio-button");


    private final String patch;

    Endpoint(String patch) {
        this.patch = patch;
    }

    public String getPatch() {
        return TestUrls.URL_TEST + patch;
    }
}
