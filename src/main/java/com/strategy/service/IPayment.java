package com.strategy.service;

import com.strategy.pojo.entiy.Order;
import com.strategy.pojo.response.PayResult;

/**
 * 支付接口
 * @author LYP
 */
public interface IPayment {

    /**
     * 支付
     * @param order 订单信息
     * @return PayResult
     */
    PayResult pay(Order order);

}