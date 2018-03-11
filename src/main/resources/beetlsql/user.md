getUser
===
select * from t_user where id=#{id}

addUser
===
insert into t_user (user_name,nick_name,email,mobile,password,gender,birthday,group_id) 
values(#{userName},#{nickName},#{email},#{mobile},#{password},#{gender},#{birthday},#{groupId})

listUser
===
select * from t_user

findByName
===
select count(1) from t_user where user_name=#{username}

checkLogin
===
select count(1) from t_user where user_name=#{username} and password=#{password}