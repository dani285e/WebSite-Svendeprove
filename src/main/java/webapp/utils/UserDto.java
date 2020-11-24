package webapp.utils;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDto {

    @JsonProperty
    private Integer userId;
    @JsonProperty
    private String username;
    @JsonProperty
    private String token;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserDto() {
        // make Jackson happy
    }

    public UserDto(Integer userId, String username, String token) {
        this.userId = userId;
        this.username = username;
        this.token = token;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
