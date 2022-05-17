package com.util;

//import cn.hutool.poi.excel.ExcelReader;
//import cn.hutool.poi.excel.ExcelUtil;
//import com.jinwei.domain.ParkingspaceDomain;
//import com.jinwei.enums.ParkingspaceOwnTypeEnum;
//import com.jinwei.enums.ParkingspaceStateEnums;
//import com.jinwei.pojo.enums.ChargingPileEnums;
//import com.jinwei.pojo.enums.TypeEnums;
//import com.jinwei.pojo.enums.publishStateEnums;
//import com.jinwei.pojo.to.ParkingspaceTo;
//import com.jinwei.util.CommonUtil;
//import java.io.IOException;
//import java.math.BigDecimal;
//import java.util.List;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.multipart.MultipartFile;

/**
 * @author LYP
 * @date 2021/7/28 1:59 下午
 * excel数据信息处理类
 */
//@Component
public class ExcelService {

  //@Autowired
  //private ParkingspaceDomain parkingspaceDomain;

  //private static final Logger logger = LoggerFactory.getLogger(ExcelService.class);

  ///**
  // * @author LYP
  // * @Date: 2021/7/28
  // * @Description: 测试hutoolExcel导入数据解析
  // */
  //public Object parsingExcel(long garageId, long districtId, long operator) {
  //  try {
  //    //使用hutool工具类导入Excel文件,默认第一个sheet,从第二行开始读取数据;(第一行为标题)
  //    ExcelReader reader = ExcelUtil.getReader(file.getInputStream());
  //    List<List<Object>> read = reader.read(1);
  //    int rowsCount = reader.getSheet().getPhysicalNumberOfRows() - 1;
  //    if (rowsCount>1000){
  //      return "数据填写请保持在1000条以内";
  //    }
  //    //验证用户是否填写存在空行，影响行号提示
  //    if (read.size() != rowsCount){
  //      return "请不要空行填写！";
  //    }
  //    //读取excel中的数据，与User实体类一一对应
  //     for (int i = 0; i < read.size(); i++) {
  //       List<Object> list = read.get(i);
  //      ParkingspaceTo parkingspaceTo = new ParkingspaceTo();
  //      //判断车位编码是否为空
  //      if (!CommonUtil.isEmpty(list.get(0).toString())) {
  //        parkingspaceTo.setName(list.get(0).toString());
  //      } else {
  //        return "第"+(i+2)+"行，车位编码不可为空";
  //      }
  //
  //      //判断小区名称是否为空
  //      if (!CommonUtil.isEmpty(list.get(1).toString())) {
  //        parkingspaceTo.setDistrictName(list.get(1).toString());
  //      } else {
  //        return "第"+(i+2)+"行，小区名称不可为空";
  //      }
  //      //判断车库名称是否为空
  //      if (!CommonUtil.isEmpty(list.get(2).toString())) {
  //      parkingspaceTo.setGarageName(list.get(2).toString());
  //      } else {
  //        return "第"+(i+2)+"行，车库名称不可为空";
  //      }
  //      //验证车位性质
  //      switch (list.get(3).toString()) {
  //        case "产权车位":
  //          parkingspaceTo.setFeatures(ParkingspaceOwnTypeEnum.PROPERTY);
  //          break;
  //        case "非产权车位":
  //          parkingspaceTo.setFeatures(ParkingspaceOwnTypeEnum.NONPROPERTY);
  //          break;
  //        default:
  //          throw new IllegalStateException("未被枚举包含的值: " + list.get(3).toString());
  //      }
  //      //判断销售价格是否为空
  //      if (!CommonUtil.isEmpty(list.get(4).toString())) {
  //        parkingspaceTo.setPrice(Long.valueOf(list.get(4).toString()));
  //      } else {
  //        return "第"+(i+2)+"行，销售价格不可为空";
  //      }
  //      //验证车位类型
  //      switch (list.get(5).toString()) {
  //        case "标准车位":
  //          parkingspaceTo.setType(TypeEnums.STANDARD);
  //          break;
  //        case "小型":
  //          parkingspaceTo.setType(TypeEnums.SMALL);
  //          break;
  //        case "大型":
  //          parkingspaceTo.setType(TypeEnums.LARGE);
  //          break;
  //        case "字母":
  //          parkingspaceTo.setType(TypeEnums.LETTER);
  //          break;
  //        default:
  //          throw new IllegalStateException("车位类型未被枚举包含 " +
  //              list.get(5).toString());
  //      }
  //      //判断使用面积(车位面积)是否为空
  //      if (!CommonUtil.isEmpty(list.get(6).toString())) {
  //        parkingspaceTo.setMeasure(new BigDecimal(list.get(6).toString()));
  //      } else {
  //        return "第"+(i+2)+"行，使用面积不可为空";
  //      }
  //      //判断建筑面积是否为空
  //      if (!CommonUtil.isEmpty(list.get(7).toString())) {
  //        parkingspaceTo.setArchitectureMeasure(new BigDecimal(list.get(7).toString()));
  //      } else {
  //        return "第"+(i+2)+"行，建筑面积不可为空";
  //      }
  //      //判断车位长是否为空
  //      if (!CommonUtil.isEmpty(list.get(8).toString())) {
  //        parkingspaceTo.setHight(new BigDecimal(list.get(8).toString()));
  //      } else {
  //        return "第"+(i+2)+"行，车位长不可为空";
  //      }
  //      //判断车位宽是否为空
  //      if (!CommonUtil.isEmpty(list.get(9).toString())) {
  //        parkingspaceTo.setWidth(new BigDecimal(list.get(9).toString()));
  //      } else {
  //        return "第"+(i+2)+"行，车位宽不可为空";
  //      }
  //      //验证是否有充电桩
  //      switch (list.get(10).toString()) {
  //        case "是":
  //          parkingspaceTo.setChargingPile(ChargingPileEnums.YES);
  //          break;
  //        case "否":
  //          parkingspaceTo.setChargingPile(ChargingPileEnums.NO);
  //          break;
  //        default:
  //          throw new IllegalStateException("是否有充电桩未被枚举包含 " + list.get(10).toString());
  //      }
  //      //验证是否发布
  //      switch (list.get(11).toString()) {
  //        case "是":
  //          parkingspaceTo.setPublishState(publishStateEnums.PUBLISH)
  //              .setState(ParkingspaceStateEnums.SOLD);
  //          break;
  //        case "否":
  //          parkingspaceTo.setPublishState(publishStateEnums.SHELF)
  //              .setState(ParkingspaceStateEnums.PUBLISH);
  //          break;
  //        default:
  //          throw new IllegalStateException("是否发布未被枚举包含 " + list.get(11).toString());
  //      }
  //      //逐条存入数据库中
  //      //parkingspaceDomain
  //      //    .create(parkingspaceTo.setDistrictId(districtId).setGarageId(garageId), operator);
  //
  //    }
  //  } catch (IOException e) {
  //    e.printStackTrace();
  //  }
  //  return null;
  //}
}
