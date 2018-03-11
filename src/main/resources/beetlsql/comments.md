adComment
===
insert into t_comments(article_id,user_id,content,create_time) values(#{articleId},#{userId},#{content},#{createTime})

list
===
select * from t_comments where article_id = #{articleId}