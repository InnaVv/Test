//package com.sparta.mail2;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.Data;
//import lombok.experimental.Accessors;
//import org.testng.annotations.DataProvider;
//
//import java.io.IOException;
//import java.nio.file.Paths;
//
//@Data
//@Accessors
//public class DataRead {
//
//    private static final String filePath = "src/test/resources/One.json";
//
//
//    public static class LoginData {
//
//        public String getUrl() {
//            return url;
//        }
//
//        public void setUrl(String url) {
//            this.url = url;
//        }
//
//        public String getMail() {
//            return mail;
//        }
//
//        public void setMail(String mail) {
//            this.mail = mail;
//        }
//
//        public String getPass() {
//            return pass;
//        }
//
//        public void setPass(String pass) {
//            this.pass = pass;
//        }
//
//        public String getRecipient() {
//            return recipient;
//        }
//
//        public void setRecipient(String recipient) {
//            this.recipient = recipient;
//        }
//
//        String url;
//        String mail;
//        String pass;
//        String recipient;
//    }
//
//    @DataProvider
//    public Object[][] sender() throws IOException {
//        ObjectMapper mapper = new ObjectMapper();
//        LoginData loginData = mapper.readValue(Paths.get(filePath).toFile(), LoginData.class);
//
//        Object[][] credentials = new Object[1][4];
//        credentials[0][0] = loginData.getUrl();
//        credentials[0][1] = loginData.getMail();
//        credentials[0][2] = loginData.getPass();
//        credentials[0][3] = loginData.getRecipient();
//
//        return credentials;
//
//    }
//
//}
