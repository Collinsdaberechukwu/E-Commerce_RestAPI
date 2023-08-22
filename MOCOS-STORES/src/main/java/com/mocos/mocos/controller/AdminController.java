package com.mocos.mocos.controller;

import com.mocos.mocos.dto.AdminDto;
import com.mocos.mocos.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/upp")
public class AdminController {
    private final AdminService productService;

    @PostMapping("post")
    public ResponseEntity<AdminDto> addProduct(@RequestBody AdminDto productDto){
        productService.addProduct(productDto);
        return new ResponseEntity<>(productDto,HttpStatus.CREATED);
    }

    @PutMapping("/put/{id}")
    public  ResponseEntity<AdminDto> updateProduct(@RequestBody AdminDto productDto, @PathVariable Long id) {
    productService.updateProduct(productDto,id);
    return new ResponseEntity<>(productDto,HttpStatus.CREATED);

    }


}
