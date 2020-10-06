CRECREATE DATABASE IF NOT EXISTS blog_db;

CRECREATE USER blog_user@localhost IDENTIFIED BY 'codeup';
GRANT ALL ON blog_db.* TO blog_user@localhost;