package strategy.service.impl;

import org.springframework.stereotype.Service;
import strategy.pojo.entiy.Order;
import strategy.pojo.response.PayResult;
import strategy.service.IPayment;

/**
 * 支付宝
 * @author LYP
 */
@Service("Alipay")
public class Alipay implements IPayment {

    @Override
    public PayResult pay(Order order) {
        return new PayResult("支付宝支付成功");
    }

}