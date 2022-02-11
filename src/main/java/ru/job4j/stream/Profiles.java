package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {

    public static List<Address> collect(List<Profile> profiles) {
        return new ArrayList<>(profiles.stream()
                        .map(profile -> profile.getAddress())
                        .collect(Collectors.toList()));
    }

    public static List<Address> collectSortWithoutDuplicates(List<Profile> profiles) {
        return new ArrayList<>(Profiles.collect(profiles).stream()
                .sorted(new AddressByCity())
                .distinct()
                .collect(Collectors.toList()));
    }
}