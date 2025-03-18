package com.order_service.dto;

import java.math.BigDecimal;

public record OrderResponse(Long id, String orderNumber, String skiCode, BigDecimal price, Integer quantity) {

}
