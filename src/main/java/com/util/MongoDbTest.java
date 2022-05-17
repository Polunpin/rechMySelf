package com.util;


/**
 * @author LYP
 * @date 15/6/2020 8:52 下午
 */
public class MongoDbTest {
    public static void main(String[] args) {
        //连接MongoDB服务器
        //MongoClient mongoClient = new MongoClient("127.0.0.1");
        //得到要操作的数据库
        //MongoDatabase student = mongoClient.getDatabase("student");
        //的到要操作的集合
        //MongoCollection<Document> study = student.getCollection("study");
        //封装查询条件(条件查询：name为"w"的)
//        BasicDBObject basicDBObject = new BasicDBObject("name","w");
//        查询年龄大于3的
//        BasicDBObject basicDBObject = new BasicDBObject("age",new BasicDBObject("$gt",3));
        //得到集合的所有数据
//        FindIterable<Document> documents = study.find(basicDBObject);

        //遍历数据
//        for (Document document : documents) {
//            System.out.println("姓名："+document.getString("name"));
//            System.out.println("年龄："+document.getInteger("age"));
//        }
        //添加记录

        //Map<String, Object> hashMap = new HashMap<String, Object>();
        //hashMap.put("_id",6);
        //hashMap.put("name","y");
        //hashMap.put("age",6);
        //Document document = new Document(hashMap);
        //study.insertOne(document);
        //mongoClient.close();


    }
}
