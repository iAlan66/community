package com.alan.community.util;

/**
 * @author Alan
 * @version 1.0
 * @date 2022/10/9 11:48
 */
public class RedisKeyUtil {

    private static final String SPLIT = ":";
    private static final String PREFIX_ENTITY_LIKE = "like:entity";

    private  static final String PREFIX_USER_LIKE = "like:user";

    // 生成某个实体的赞
    // like:entity:entityType:entityId -> set(userId)
    public static String getEntityLikeKey(int entityType, int entityId){
        return PREFIX_ENTITY_LIKE + SPLIT + entityType + SPLIT + entityId;
    }

    // 生成某个人收到的所有点赞
    // like:user:userId -> int
    public static String getUserLike(int userId){
        return PREFIX_USER_LIKE + SPLIT + userId;
    }

}
