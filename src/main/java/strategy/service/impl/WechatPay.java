package strategy.service.impl;

import org.springframework.stereotype.Service;
import strategy.pojo.entiy.Order;
import strategy.pojo.response.PayResult;
import strategy.service.IPayment;

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