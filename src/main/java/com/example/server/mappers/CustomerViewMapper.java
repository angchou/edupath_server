package com.example.server.mappers;

import com.example.server.dto.responses.CustomerViewResponse;
import com.example.server.entities.User;

import java.util.List;

public class CustomerViewMapper {

    public static CustomerViewResponse toViewResponse(User user) {

        CustomerViewResponse res = new CustomerViewResponse();

        res.setUser_id(user.getUserId());
        res.setUsername(user.getUserName());
        res.setEmail(user.getUserEmail());
        res.setStatus(user.getUserStatus());
        res.setCreated_at(user.getUserCreatedAt());

        List<String> roles = user.getUserRole()
                .stream()
                .map(userRole -> userRole.getRole().getRoleName())
                .toList();

        res.setUser_role(roles);

        return res;

    }

}
