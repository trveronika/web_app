package hu.unideb.inf.zoo_animals.dao.request;

public class SigninRequest {
    private String email;
    private String password;

    private SigninRequest() {
    }

    private SigninRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public static SigninRequestBuilder builder() {
        return new SigninRequestBuilder();
    }

    public static class SigninRequestBuilder {
        private String email;
        private String password;

        private SigninRequestBuilder() {
        }

        public SigninRequestBuilder email(String email) {
            this.email = email;
            return this;
        }

        public SigninRequestBuilder password(String password) {
            this.password = password;
            return this;
        }

        public SigninRequest build() {
            return new SigninRequest(email, password);
        }
    }
}
