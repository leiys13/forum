getUser
===
select * from t_user where id=#{id}

addUser
===
insert into t_user (user_name,password,real_name,email,qq,mobile,nick_name,gender,birthday) 
values(#{userName},#{password},#{realName},#{email},#{qq},#{mobile},#{nickName},#{gender},#{birthday})

listUser
===
select * from t_user

findByName
===
select count(1) from t_user where user_name=#{username}

checkLogin
===
select count(1) from t_user where user_name=#{username} and password=#{password}