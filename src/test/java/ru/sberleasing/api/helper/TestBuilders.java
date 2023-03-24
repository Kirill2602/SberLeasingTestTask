package ru.sberleasing.api.helper;

import ru.sberleasing.api.models.createuser.User;

public class TestBuilders {
    public static User buildUser(String firstName, String email) {
        return User.builder()
                .id(1)
                .username("TestUserName")
                .firstName(firstName)
                .lastName("TestUserLastName")
                .email(email)
                .password("Qwerty123.")
                .phone("89677776677")
                .userStatus(0).build();
    }
}
