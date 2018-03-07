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