package strategy.service.impl;

import org.springframework.stereotype.Service;
import strategy.pojo.entiy.Order;
import strategy.pojo.response.PayResult;
import strategy.service.IPayment;

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