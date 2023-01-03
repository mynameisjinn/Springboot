package com.study.springboothyejin.web.controller.account;

import com.study.springboothyejin.aop.annotation.ParamsAspect;
import com.study.springboothyejin.aop.annotation.TimerAspect;
import com.study.springboothyejin.aop.annotation.ValidAspect;
import com.study.springboothyejin.service.UserService;
import com.study.springboothyejin.web.dto.CMRespDto;
import com.study.springboothyejin.web.dto.UserDto;
import com.study.springboothyejin.web.dto.UsernameDto;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;


@Slf4j
@RestController
@RequestMapping("/api/account")
public class AccountApiController {

//    private static final Logger LOG = LoggerFactory.getLogger(AccountApiController.class);

    @Autowired
    private UserService userService;

    @TimerAspect
    @ValidAspect
    @GetMapping("/username")
    public ResponseEntity<?> duplicateUsername(@Valid UsernameDto usernameDto, BindingResult bindingResult){
        log.info("로그 출력! 데이터: {}", usernameDto);
        userService.duplicateUsername(usernameDto.getUsername());
        return ResponseEntity.ok().body(new CMRespDto<>("가입 가능한 사용자이름", true));
    }

    @ParamsAspect
    @PostMapping("/user")
    public ResponseEntity<?> register(@RequestBody @Valid UserDto userDto, BindingResult bindingResult) {
        return ResponseEntity
                .created(URI.create("/account/login"))
                .body(new CMRespDto<>("회원가입 완료", null));
    }
}
