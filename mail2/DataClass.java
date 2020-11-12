package com.sparta.mail2;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.experimental.Accessors;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Data
@Accessors(chain = true)
public class DataClass {

    private static final String path = "src/test/resources/cred.json";

    public static class LoginData {
        public List<CredentialsData> getCred() {
            return cred;
        }

        List<CredentialsData> cred;
    }

    public static class CredentialsData {
        String url1;

        public String getUrl1() {
            return url1;
        }

        public String getMail1() {
            return mail1;
        }

        public String getPass1() {
            return pass1;
        }

        public String getRecipient1() {
            return recipient1;
        }

        String mail1;
        String pass1;
        String recipient1;
    }

    static ObjectMapper mapper = new ObjectMapper();

    @DataProvider
    public Object[][] sender() throws IOException {
        LoginData loginData = mapper.readValue(Paths.get(path).toFile(), LoginData.class);
        Object[][] credentialsData = new Object[loginData.getCred().size()][1];

        for (int i = 0; i < loginData.getCred().size(); i++) {
            CredentialsData m = loginData.getCred().get(i);
            CredentialsData[i][0] = m;
        }

        return credentialsData;
    }
}
