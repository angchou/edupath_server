package com.example.server.services;

import com.example.server.dto.requests.CreateEmployeeRequest;
import com.example.server.dto.requests.UpdateEmployeeRequest;
import com.example.server.dto.responses.CustomerViewResponse;
import com.example.server.dto.responses.EmployeeViewResponse;
import com.example.server.entities.Employee;
import com.example.server.entities.Role;
import com.example.server.entities.User;
import com.example.server.entities.UserRole;
import com.example.server.mappers.EmployeeViewMapper;
import com.example.server.repositories.EmployeeRepository;
import com.example.server.repositories.RoleRepository;
import com.example.server.repositories.UserRepository;
import com.example.server.repositories.UserRoleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Transactional
    public void createNewEmployee(CreateEmployeeRequest request) {
        // Validation
        if (userRepository.existsByUserEmail(request.getEmail())) {
            throw new RuntimeException("Email already Exists!");
        }

        // Create new user
        User user = new User();
        user.setUserName(request.getUsername());
        user.setUserEmail(request.getEmail());
        user.setUserPassword(request.getPassword());
        user.setUserCreatedAt(LocalDateTime.now());
        user.setUserStatus(1);

        userRepository.save(user);

        // Create new employee
        Employee employee = new Employee();
        employee.setUser(user);

        employeeRepository.save(employee);

        // Find role
        Role role = roleRepository.findByRoleName(request.getUser_role())
                .orElseThrow(() -> new RuntimeException("Role not Found!"));

        // Create new User Role
        UserRole userRole = new UserRole();
        userRole.setRole(role);
        userRole.setUser(user);

        userRoleRepository.save(userRole);
    }

    @Transactional
    public void updateEmployee(UpdateEmployeeRequest request) {
        boolean change = false;

        User user = userRepository.findById(request.getUser_id())
                .orElseThrow(() -> new RuntimeException("User not Found!"));

        if (!user.getUserName().equals(request.getNew_username())) {
            user.setUserName(request.getNew_username());
            change = true;
        }

        if (!user.getUserPassword().equals(request.getNew_password())) {
            user.setUserPassword(request.getNew_password());
            change = true;
        }

        if (!user.getUserStatus().equals(request.getNew_status())) {
            user.setUserStatus(request.getNew_status());
            change = true;
        }

        if (userRepository.existsByUserEmail(request.getNew_email())) {
            if (!change) {
                throw new RuntimeException("Email already Exists!");
            }
            if (!user.getUserEmail().equals(request.getNew_email())) {
                user.setUserEmail(request.getNew_email());
            }
        }
    }

    public List<EmployeeViewResponse> getEmployees() {
        List<User> employees = userRepository.findDistinctByUserRole_RoleRoleIdIn(
                List.of(3, 4, 5, 6)
        );

        return employees
                .stream()
                .map(EmployeeViewMapper::toViewResponse)
                .toList();
    }
}
