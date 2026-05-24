package com.example.server.auth;

import com.example.server.dto.request.RegisterRequest;
import com.example.server.dto.response.TokenResponse;
import com.example.server.entities.HocVien;
import com.example.server.entities.Role;
import com.example.server.entities.UserRole;
import com.example.server.entities.Users;
import com.example.server.repositories.HocVienRepository;
import com.example.server.repositories.RoleRepository;
import com.example.server.repositories.UserRepository;
import com.example.server.repositories.UserRoleRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Service
public class AuthService {

    private static final Logger logger = Logger.getLogger(AuthService.class.getName());


    @Autowired
    private UserRepository usersRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private HocVienRepository hocVienRepository;
    @Autowired
    private JwtUtil jwt;
    @PersistenceContext
    private EntityManager entityManager;

    // login
    @Transactional
    public TokenResponse login(String email, String password) {
        Users user = usersRepository.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Người dùng không tồn tại!"));

        if (!user.getPassword().equals(password)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Mật khẩu sai!");
        }
        if (user.getTrangThai() != 2 ) {
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "Tài khoản đã bị chặn");
        }
        List<UserRole> userRoles = userRoleRepository.findByUser_UserID(user.getUserID());
        String token = jwt.generateToken(user, userRoles);

        TokenResponse tokenResponse = new TokenResponse();
        tokenResponse.setToken(token);

        return tokenResponse;
    }

    @Transactional
    public ResponseEntity<?> register(RegisterRequest request) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("proc_register_learner");

        query.registerStoredProcedureParameter("p_hoten", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_email", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_password", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_status_code", Integer.class, ParameterMode.OUT);
        query.registerStoredProcedureParameter("p_message", String.class, ParameterMode.OUT);

        query.setParameter("p_hoten", request.getHoTen());
        query.setParameter("p_email", request.getEmail());
        query.setParameter("p_password", request.getPassword());

        query.execute();

        Integer statusCode = (Integer) query.getOutputParameterValue("p_status_code");
        String message = (String) query.getOutputParameterValue("p_message");

        if (statusCode == 200) {
            return ResponseEntity.ok(Map.of("Message", message));
        } else if (statusCode == -20001) {
            throw new RuntimeException(message);
        } else {
            throw new RuntimeException("Database Error: " + message);
        }
    }

}
