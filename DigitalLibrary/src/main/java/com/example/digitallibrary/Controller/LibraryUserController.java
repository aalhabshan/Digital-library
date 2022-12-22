package com.example.digitallibrary.Controller;

import com.example.digitallibrary.Dto.ApiResponse;
import com.example.digitallibrary.Model.LibraryUser;
import com.example.digitallibrary.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class LibraryUserController {
    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity get(){
        List<LibraryUser> users = userService.get();
        return ResponseEntity.status(200).body(users);
    }
    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid LibraryUser user, Errors errors){
        if (errors.hasErrors())
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        userService.add(user);
        return ResponseEntity.status(200).body(new ApiResponse("User added"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody @Valid LibraryUser user,Errors errors){
        if (errors.hasErrors())
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        userService.update(id, user);
        return ResponseEntity.status(200).body(new ApiResponse("User updated"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        userService.delete(id);
        return ResponseEntity.status(200).body(new ApiResponse("User deleted"));
    }
    @GetMapping("/check/{pass}")
    public ResponseEntity check( @RequestBody String un,  @PathVariable String pass){
        userService.check(un, pass);
        return ResponseEntity.status(200).body(new ApiResponse("correct"));
    }
    @GetMapping("/byid/{id}")
    public ResponseEntity byId(@PathVariable Integer id){
        LibraryUser user = userService.byId(id);
        return ResponseEntity.status(200).body(user);
    }

}
