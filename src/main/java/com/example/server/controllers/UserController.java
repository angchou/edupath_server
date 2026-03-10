package com.example.server.controllers;

import com.example.server.dto.requests.BlockRequest;
import com.example.server.dto.responses.BlockResponse;
import com.example.server.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/course/block/save")
    public void saveCourseBlock(@RequestBody BlockRequest blockRequest) {
        System.out.println(blockRequest.getURL());
        System.out.println(blockRequest.getText());
    }

    @GetMapping("/course/block/load")
    public ResponseEntity<BlockResponse> loadCourseBlock() {
        BlockResponse blockResponse = new BlockResponse();
        blockResponse.setURL(null);
        blockResponse.setLoaiTN(0);
        blockResponse.setText("<html dir=\"ltr\"><head></head><body contenteditable=\"true\"><p style=\"text-align: center;\"><span style=\"font-family: &quot;&quot;; font-size: xx-large; font-weight: bold;\">jfasdihfaehfuiaef</span></p><p><span style=\"font-family: &quot;&quot;; font-size: x-large;\">dfhijawehfuiaefaefhaejfhauiwehfuiawehufawef</span></p><p style=\"text-align: justify;\"><ul><li><span style=\"font-family: &quot;&quot;;\">fahdkjdf</span></li></ul></p><p><ol><li><span style=\"font-family: &quot;&quot;;\">fehdfjaheufahueif</span></li><li><span style=\"font-family: &quot;&quot;;\">fahdjf fhdkja hfjkadshfkjashdkjf hasdkjf&nbsp;</span></li></ol></p><p><span style=\"font-family: &quot;&quot;;\"><br></span></p></body></html>\n");
        blockResponse.setKhoaHoc_ID("KH001");

        return ResponseEntity.ok(blockResponse);
    }

}
