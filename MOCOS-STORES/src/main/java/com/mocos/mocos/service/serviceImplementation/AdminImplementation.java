package com.mocos.mocos.service.serviceImplementation;

import com.mocos.mocos.dto.AdminDto;
import com.mocos.mocos.model.Admin;
import com.mocos.mocos.repository.AdminRepo;
import com.mocos.mocos.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service


public class AdminImplementation implements AdminService {
    private final AdminRepo productRepo;
    @Override
    public Admin updateProduct(AdminDto productDto, Long id) {
        Admin product = productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("product not found re-type"));
        product.setId(product.getId());
      product.setProductName(productDto.getProductName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setDuration(productDto.getDuration());

        Admin newUpdate = productRepo.save(product);
        return new Admin(newUpdate);
    }

    @Override
    public Admin addProduct(AdminDto productDto) {
        Admin adds = new Admin();
        adds.setDescription(productDto.getDescription());
        adds.setProductName(productDto.getProductName());
        adds.setPrice(productDto.getPrice());
        adds.setDuration(productDto.getDuration());
        return productRepo.save(adds);
    }
}
