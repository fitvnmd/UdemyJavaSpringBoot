package com.project.shopapp.controllers;
import com.project.shopapp.dtos.CategoryDTO;
import com.project.shopapp.dtos.OrderDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}/orders")
public class OrderController {
    @PostMapping("")
    public ResponseEntity<?> createOrder(
            @RequestBody @Valid OrderDTO orderDTO,
            BindingResult result){
        try{
            if(result.hasErrors()){
                List<String> errorMessages = result.getFieldErrors()
                        .stream()
                        .map(FieldError::getDefaultMessage)
                        .toList();
                return ResponseEntity.badRequest().body(errorMessages);
            }
            return ResponseEntity.ok("createOrder Successfully");
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    //
    @GetMapping("/{user_id}") //Thêm biến đường dẫn "user_id
    //http://localhost:8088/api/v1/orders/4
    public ResponseEntity<?> getOrders(
            @Valid @PathVariable("user_id") Long userID) {
        try {
            return ResponseEntity.ok("Lấy ra danh sách order từ user_id");
        } catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    //
    @PutMapping("/{id}")
    //PUT http:/localhost:8088/api/v1/orders/2
    //Công việc của admin
    public ResponseEntity<String> updateOrder(
            @Valid @PathVariable long id,
            @Valid @RequestBody OrderDTO orderDTO){
        return ResponseEntity.ok("Cập nhật thông tin 1 order");
    }
    //
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(
            @Valid @PathVariable Long id){
        //xoá mềm =>> cập nhât trường active = false
        return ResponseEntity.ok("Order deleted successfully");
    }
}
