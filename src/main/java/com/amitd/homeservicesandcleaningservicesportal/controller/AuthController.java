package com.amitd.homeservicesandcleaningservicesportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amitd.homeservicesandcleaningservicesportal.beans.Category;
import com.amitd.homeservicesandcleaningservicesportal.beans.Work;
import com.amitd.homeservicesandcleaningservicesportal.service.CategoryService;
import com.amitd.homeservicesandcleaningservicesportal.service.UserService;
import com.amitd.homeservicesandcleaningservicesportal.service.WorkService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private WorkService workService;

    @Autowired
    private UserService userService;

    // @Autowired
    // private JwtUtil jwtUtility;

    // @Autowired
    // private AuthenticationManager authenticationManager;

    @GetMapping("/home")
    public ResponseEntity<List<Category>> CategoryList() {
        List<Category> list = categoryService.show();
        if (list != null) {
            return ResponseEntity.ok(list);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @GetMapping("/works")
    public ResponseEntity<List<Work>> worksList() {
        List<Work> list = workService.show();
        if (list != null) {
            return ResponseEntity.ok(list);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    // @PostMapping("/register")
    // public ResponseEntity<?> addUser(@RequestBody UserDto u) {

    // u.setCreated_at(Calendar.getInstance().getTime());

    // User newUser = userService.save(u);

    // HashMap<String, Object> result = new HashMap<String, Object>();
    // result.put("status", "success");
    // result.put("data", newUser);
    // return ResponseEntity.ok(result);
    // }

    // @PostMapping("/worker/register")
    // public ResponseEntity<?> addWorker(@RequestBody UserDto userDto) {

    // userDto.setCreated_at(Calendar.getInstance().getTime());

    // User user = UserDto.toEntity(userDto);

    // user = userService.save(user);

    // HashMap<String, Object> result = new HashMap<String, Object>();
    // result.put("status", "success");
    // result.put("data", user);
    // return ResponseEntity.ok(result);
    // }

    // @PostMapping("/{user_id}/works/{work_id}")
    // public ResponseEntity<?> addWork(@PathVariable int user_id, @PathVariable int
    // work_id) {

    // User u1 = userService.findUserById(user_id);

    // System.out.println(u1);

    // Optional<Work> w = workService.findWork(work_id);
    // System.out.println(w);

    // // u1.getWorks().add(w.get());

    // userService.save(u1);

    // HashMap<String, Object> result = new HashMap<String, Object>();
    // result.put("status", "success");
    // result.put("data", u1);
    // return ResponseEntity.ok(result);
    // }

    // @PostMapping("/login")
    // public LoginResponse autheticate(@RequestBody LoginRequest jwtRequest) throws
    // Exception {
    // try {
    // authenticationManager.authenticate(
    // new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(),
    // jwtRequest.getPassword()));
    // } catch (BadCredentialsException e) {
    // throw new Exception("INVALID_CREDENTIALS", e);
    // }

    // final UserDetails userDetails =
    // service.loadUserByUsername(jwtRequest.getUsername());

    // final String token = jwtUtility.generateToken(userDetails);

    // User u = userService.findUserName(userDetails.getUsername());

    // return new LoginResponse(token, userDetails.getUsername(), u.getId(),
    // userDetails.getAuthorities());
    // }
}
