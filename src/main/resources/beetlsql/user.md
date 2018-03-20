getUser
===
select * from t_user where id=#{id}

addUser
===
insert into t_user (user_name,nick_name,email,mobile,password,gender,birthday,group_id,create_time) 
values(#{userName},#{nickName},#{email},#{mobile},#{password},#{gender},#{birthday},#{groupId},now())

listUser
===
select * from t_user

findByName
===
select count(1) from t_user where user_name=#{username}

checkLogin
===
select id,user_name,nick_name,email,mobile,gender,birthday,group_id,profile_pic,create_time 
from t_user where user_name=#{username} and password=#{password}