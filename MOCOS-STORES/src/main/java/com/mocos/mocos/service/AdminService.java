package com.mocos.mocos.service;

import com.mocos.mocos.dto.AdminDto;
import com.mocos.mocos.model.Admin;



public interface AdminService {
    Admin updateProduct(AdminDto productDto, Long id);
    Admin addProduct(AdminDto productDto);
}
