package com.example.server.services;

import com.example.server.dto.responses.CustomerViewResponse;
import com.example.server.entities.User;
import com.example.server.mappers.CustomerViewMapper;
import com.example.server.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void banCustomer(String user_id) {
        User user = userRepository.findById(user_id)
                .orElseThrow(() -> new RuntimeException("User not Found!"));
        user.setUserStatus(0);
    }

    @Transactional
    public void unbanCustomer(String user_id) {
        User user = userRepository.findById(user_id)
                .orElseThrow(() -> new RuntimeException("User not Found!"));
        user.setUserStatus(1);
    }

    public List<CustomerViewResponse> getCustomerHasStatus(Integer user_status) {
        List<User> customers = userRepository.findByUserStatus(user_status, List.of(1, 2));

        return customers
                .stream()
                .map(CustomerViewMapper::toViewResponse)
                .toList();
    }

}
