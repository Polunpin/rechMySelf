package strategy.pojo.entiy;

import lombok.Data;

/**
 * 订单信息
 * @author LYP
 */
@Data
public class Order {

    /**
     * 金额
     */
    private int amount;

    /**
     * 支付类型
     */
    private String paymentType;

}