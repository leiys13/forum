addArticle
===
insert into t_article(id,title,content,image_url,user_id,create_time,update_time,comments_num,support_num,view_num,article_theme,article_type) values(#{id},#{title},#{content},#{imageUrl},#{userId},#{createTime},#{updateTime},#{commentsNum},#{supportNum},#{viewNum},#{articleTheme},#{articleType})

getArticle
===
select * from t_article where id=#{id}

listArticle
===
select * from t_article

findByTitle
===
select count(1) from t_article where title=#{title}

delete 
===
delete from t_article where id=#{id}

selectListByCondition
===
select 
@pageTag(){
a.id, a.title, a.user_id, a.comments_num, a.support_num, a.view_num, a.article_type, a.create_time, a.update_time,
b.user_name, b.nick_name
@}
from t_article a join t_user b on a.user_id = b.id
where 1=1
@if(-1!=articleType){
	and a.article_type = #{articleType}
@}
@pageIgnoreTag(){
order by a.create_time desc
@}

selectInfoById
===
select 
a.id, a.title, a.content, a.user_id, a.comments_num, a.support_num, a.view_num, a.article_type, a.create_time, 
b.user_name, b.nick_name, b.profile_pic
from t_article a join t_user b on a.user_id = b.id
where a.id = #{id}

incrementViewNum
===
update t_article set view_num = view_num+1 where id = #{id}
