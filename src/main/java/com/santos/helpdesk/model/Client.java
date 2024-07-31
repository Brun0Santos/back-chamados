package com.santos.helpdesk.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class Client extends Person {
    private List<Called> called = new ArrayList<>();
}
