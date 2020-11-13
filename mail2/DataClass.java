package com.sparta.mail2;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.experimental.Accessors;
import org.testng.annotations.DataProvider;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

@Data
@Accessors
public class DataClass {

    private static final String path = "src/test/resources/one.json";

    @Data
    public static class LoginData {

        List <CredentialsData> cred;

    }

    @Data
    public static class CredentialsData {
        String url;
        String mail;
        String pass;
        String recipient;
    }

    static ObjectMapper mapper = new ObjectMapper();

    @DataProvider
    public Object[][] sender() throws IOException {
        LoginData loginData = mapper.readValue(Paths.get(path).toFile(), LoginData.class);
        Object[][] credentialsData = new Object[loginData.getCred().size()][1];

        for (int i = 0; i < loginData.getCred().size(); i++) {
            CredentialsData m = loginData.getCred().get(i);
            credentialsData[i][0] = m;
        }
        return credentialsData;
    }
}
