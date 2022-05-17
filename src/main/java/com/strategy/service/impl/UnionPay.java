package com.strategy.service.impl;

import com.strategy.pojo.response.PayResult;
import org.springframework.stereotype.Service;
import com.strategy.pojo.entiy.Order;
import com.strategy.service.IPayment;

/**
 * 银联云闪付
 * @author LYP
 */
@Service("UnionPay")
public class UnionPay implements IPayment {

    @Override
    public PayResult pay(Order order) {
        return new PayResult("云闪付支付成功");
    }

}