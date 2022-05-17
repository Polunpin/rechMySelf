package com.strategy.service.impl;

import org.springframework.stereotype.Service;
import com.strategy.pojo.entiy.Order;
import com.strategy.pojo.response.PayResult;
import com.strategy.service.IPayment;

/**
 * 微信支付
 * @author LYP
 */
@Service("WechatPay")
public class WechatPay implements IPayment {

    @Override
    public PayResult pay(Order order) {
        return new PayResult("微信支付成功");
    }

}