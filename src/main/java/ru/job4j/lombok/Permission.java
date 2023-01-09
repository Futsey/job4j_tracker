package ru.job4j.lombok;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@Builder(builderMethodName = "of")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Permission {

    @EqualsAndHashCode.Include
    private int id;
    private String name;
    @Singular("rules")
    @EqualsAndHashCode.Include
    private List<String> rules;

    public static void main(String[] args) {
        Permission permission = Permission.of()
                .name("god")
                .rules("не прелюбодействуй")
                .rules("не укради")
                .rules("не убивай")
                .build();
        System.out.println(permission);
    }
}
