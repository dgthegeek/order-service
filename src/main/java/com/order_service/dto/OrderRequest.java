package com.order_service.dto;

import java.math.BigDecimal;

public record OrderRequest(Long id, String orderNumber, String skiCode, Integer quantity, BigDecimal price) {

}
