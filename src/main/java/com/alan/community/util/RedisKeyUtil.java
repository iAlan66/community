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
    private  static final String PREFIX_FOLLOWER = "follower";
    private  static final String PREFIX_FOLLOWEE = "followee";

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

    // 某个用户关注的实体
    // followee:userId:entityType -> zset(entityId,now)
    public static String getFolloweeKey(int userId, int entityType){
        return PREFIX_FOLLOWEE + SPLIT + userId + SPLIT + entityType;
    }

    // 某个实体的粉丝
    // follower:entityType:entityId -> zset(entityId,now)
    public static String getPrefixFollowerKey(int entityType, int entityId){
        return PREFIX_FOLLOWER + SPLIT + entityType + SPLIT + entityId;
    }


}
