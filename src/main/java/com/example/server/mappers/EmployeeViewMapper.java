package com.example.server.mappers;

import com.example.server.dto.responses.EmployeeViewResponse;
import com.example.server.entities.Employee;
import com.example.server.entities.User;

import java.util.List;

public class EmployeeViewMapper {

    public static EmployeeViewResponse toViewResponse(User user) {
        EmployeeViewResponse res = new EmployeeViewResponse();

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
