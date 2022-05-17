package com.strategy.controller;

import com.strategy.pojo.entiy.Order;
import com.strategy.pojo.response.PayResult;
import com.strategy.service.IPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LYP
 * @date 2021/12/8 3:30 PM
 * 策略模式 DEMO
 */
@RestController
public class StrategyController {

    @Autowired
    private ApplicationContext applicationContext;

    /**
     * 支付接口
     * @param amount 金额
     * @param paymentType 支付类型
     * @return PayResult
     */
    @RequestMapping("/pay")
    public PayResult pay(@RequestParam("amount") int amount,
        @RequestParam("paymentType") String paymentType) {
        Order order = new Order();
        order.setAmount(amount);
        order.setPaymentType(paymentType);

        // 根据支付类型获取对应的策略 bean
        IPayment payment = applicationContext.getBean(order.getPaymentType(), IPayment.class);

        // 开始支付
        return payment.pay(order);
    }

}
