adComment
===
insert into t_comments(article_id,user_id,content,create_time) values(#{articleId},#{userId},#{content},#{createTime})

list
===
select * from t_comments where article_id = #{articleId}

selectListByCondition
===
select 
@pageTag(){
a.id, a.user_id, a.content, a.create_time, 
b.user_name, b.nick_name, b.profile_pic
@}
from t_comments a join t_user b on a.user_id = b.id
where a.article_id = #{articleId}
@if(0!=userId){
	and a.user_id = #{userId}
@}
@pageIgnoreTag(){
order by a.create_time desc
@}
